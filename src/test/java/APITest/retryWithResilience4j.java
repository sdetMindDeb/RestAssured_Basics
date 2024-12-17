package APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import java.time.Duration;
import java.util.function.Supplier;

public class retryWithResilience4j {

    @Test
    void retryWithResilience(){
                // Create a RetryConfig with custom settings
                RetryConfig config = RetryConfig.custom()
                        .maxAttempts(3)
                        .waitDuration(Duration.ofSeconds(2))
                        .build();

                // Create a RetryRegistry and a Retry instance
                RetryRegistry registry = RetryRegistry.of(config);
                Retry retry = registry.retry("myRetry");

                // Define a Supplier for the RestAssured call
                Supplier<Response> restAssuredCall = () -> RestAssured.get("https://api.example.com/endpoint");

                // Decorate the Supplier with Retry
                Supplier<Response> retryableCall = Retry.decorateSupplier(retry, restAssuredCall);

                // Execute the call
                Response response = retryableCall.get();

                // Print the response
                response.then().log().all();
            }

}
