package ru.kot1a.examples.spring.kafka.stream.configuration;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;
import ru.kot1a.examples.spring.kafka.stream.configuration.entity.UserEventCount;
import ru.kot1a.examples.spring.kafka.stream.dto.UserEvent;

import java.time.Duration;

@Configuration
public class KafkaStreamConfiguration {

    private static final Duration WINDOW_SIZE = Duration.ofSeconds(10);

    @Bean
    public KStream<String, UserEvent> userEventStream(StreamsBuilder builder) {

        // Читаем входной топик
        KStream<String, UserEvent> source = builder.stream(
                "user-message",
                Consumed.with(Serdes.String(), userEventSerde())
        );

        // Ключуем по userId
        KStream<String, UserEvent> byUser = source
                .selectKey((key, val) -> val.getUserId().toString());

        // ADD_FRIEND
        aggregateByEvent(
                byUser,
                "ADD_FRIEND",
                "t-add-friend",
                false
        );

        // SEND_MESSAGE
        aggregateByEvent(
                byUser,
                "SEND_MESSAGE",
                "t-send-message",
                false
        );

        // CHANGE_PASSWORD (alarm)
        aggregateByEvent(
                byUser,
                "CHANGE_PASSWORD",
                "alarm-message",
                true
        );

        return source;
    }

    /**
     * Универсальная агрегация по event + userId за 10 секунд
     */
    private void aggregateByEvent(
            KStream<String, UserEvent> stream,
            String eventType,
            String outputTopic,
            boolean alarmOnly
    ) {

        stream
                // фильтрация по типу события
                .filter((key, val) -> eventType.equals(val.getEvent()))

                // группируем по userId
                .groupByKey(Grouped.with(Serdes.String(), userEventSerde()))

                // окно в 10 секунд
                .windowedBy(TimeWindows.ofSizeWithNoGrace(WINDOW_SIZE))

                // считаем события
                .count(Materialized.as(eventType.toLowerCase() + "-store"))

                // для alarm-message пропускаем только count > 2
                .toStream()
                .filter((windowedKey, count) -> !alarmOnly || count > 2)

                // приводим к финальному формату
                .map((windowedKey, count) ->
                        KeyValue.pair(
                                windowedKey.key(),
                                new UserEventCount(
                                        Long.valueOf(windowedKey.key()),
                                        count
                                )
                        )
                )

                // отправляем в нужный топик
                .to(
                        outputTopic,
                        Produced.with(
                                Serdes.String(),
                                userEventCountSerde()
                        )
                );
    }

    // Serde для UserEvent
    private Serde<UserEvent> userEventSerde() {
        return new JsonSerde<>(UserEvent.class);
    }

    // Serde для результата
    private Serde<UserEventCount> userEventCountSerde() {
        return new JsonSerde<>(UserEventCount.class);
    }
}
