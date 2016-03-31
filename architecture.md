
+---------+        +---------+                +-------------+         +-----------+
| Browser |<------>| Gateway +---REST Call--->| Microservice|<------->| Database  |
+---------+        |         |<---------------|             |         |- Foo Table|
                   |         +--+             | App1        |         |- Bar Table|
                   |         |  | Circuit     | - Foo entity|         +-----------+
                   |         |<-+ Breaker     | - Bar entity|
                   +---------+                +-------------+
