# async-http-client-usage

Usage demo of [Async Http Client](https://github.com/AsyncHttpClient/async-http-client) with continuations (through Java 8 [CompletableFuture&lt;T>](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html))

Simple use:

```java
try(AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient()) {
            asyncHttpClient
                    .prepareGet("http://www.example.com/")
                    .execute()
                    .toCompletableFuture()
                    .thenApply(Response::getResponseBody)
                    .thenAccept(System.out::println)
                    .join();
        }
```
