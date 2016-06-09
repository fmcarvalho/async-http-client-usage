package app;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import java.io.IOException;

/**
 * @author Miguel Gamboa
 *         created on 09-06-2016
 */
public class Program {
    public static void main(String[] args) throws IOException {
        try(AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient()) {
            asyncHttpClient
                    .prepareGet("http://www.example.com/")
                    .execute()
                    .toCompletableFuture()
                    .thenApply(Response::getResponseBody)
                    .thenAccept(System.out::println)
                    .join();
        }
    }
}
