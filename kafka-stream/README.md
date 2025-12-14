# kafka-stream

Примеры использования Kafka Streams

### Скрипт для создания топика user-message

<code>kafka-topics --bootstrap-server localhost:9092 --create --if-not-exists --topic user-message --partitions 1 --replication-factor 1</code>

### Тестовые данные Kafka для отправки в user-message

{"messageId": "c0737002-234d-46b6-92fa-35ddccb86786","event": "ADD_FRIEND","description": "User added a new friend","userId": 101}<br>
{"messageId": "8b4f4120-d972-4836-ae1e-792144809bd9","event": "SEND_MESSAGE","description": "User sent a message","userId": 102}<br>
{"messageId": "4f106ba5-cb98-481a-a77c-c4e011f41624","event": "CHANGE_PASSWORD","description": "User changed password","userId": 101}<br>
{"messageId": "1314e50f-9c47-4734-9bfc-372f1e8d01ca","event": "ADD_FRIEND","description": "User added a friend via app","userId": 101}<br>
{"messageId": "d1745e77-e481-4347-ad29-8863cd7908c4","event": "SEND_MESSAGE","description": "User sent a private message","userId": 101}<br>
{"messageId": "c706a579-14a5-4e5e-94bb-b4ef477621b4","event": "CHANGE_PASSWORD","description": "User updated password","userId": 101}<br>
{"messageId": "1991cae5-4049-40a1-b308-e9fdd795348c","event": "ADD_FRIEND","description": "Friend request sent","userId": 102}<br>
{"messageId": "aa339866-410b-49e3-85f5-bbcb8ab3daff","event": "SEND_MESSAGE","description": "User sent a chat message","userId": 102}<br>
{"messageId": "749d177b-7a42-4062-bd36-ab65e99854e5","event": "CHANGE_PASSWORD","description": "Password reset","userId": 102}<br>
{"messageId": "2907adf3-5d90-491a-9db4-1ae20f26b2b7","event": "ADD_FRIEND","description": "Added friend via mobile","userId": 110}<br>
{"messageId": "c07742ad-794c-4523-9aab-cdbd0353fa7b","event": "ADD_FRIEND","description": "User added a new friend","userId": 105}<br>
{"messageId": "6ae7d9b3-f352-4110-a4a3-1362fe2ecdf4","event": "SEND_MESSAGE","description": "User sent a message","userId": 105}<br>
{"messageId": "48e45cc4-7d8e-48ce-b305-9e83d5e8f485","event": "CHANGE_PASSWORD","description": "User changed password","userId": 105}<br>
{"messageId": "89b64b62-32d4-428b-b7f7-5ea526e919e9","event": "ADD_FRIEND","description": "User added a friend via app","userId": 105}<br>
{"messageId": "38f59be8-7e16-44f2-86fd-5ef7d7bfb654","event": "SEND_MESSAGE","description": "User sent a private message","userId": 105}<br>
{"messageId": "a8c32ce6-401b-47af-a0ba-36a896f490c1","event": "CHANGE_PASSWORD","description": "User updated password","userId": 105}<br>
{"messageId": "bbd84d25-e94b-4a5c-8cef-a0f909a1ff4a","event": "ADD_FRIEND","description": "Friend request sent","userId": 105}<br>
{"messageId": "69c9cf4e-4c0d-4182-8a23-6d3ff04d56b0","event": "SEND_MESSAGE","description": "User sent a chat message","userId": 105}<br>
{"messageId": "36758ab1-0105-4c05-906e-996c5c53e36b","event": "CHANGE_PASSWORD","description": "Password reset","userId": 105}<br>
{"messageId": "6917ede2-f62d-40ee-888b-0acbdede514d","event": "ADD_FRIEND","description": "Added friend via mobile","userId": 105}<br>