package APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class rateLimitHandle {

    /*
    Rate limiting in API testing ensures you don't exceed the number of allowed requests to an API within a specific time frame.

    Handling rate limiting in API tests using Rest Assured involves several steps to ensure your tests respect the API's rate limits and handle responses appropriately. Here are some strategies you can use:

    1.Check Rate Limit Headers: Most APIs provide rate limit information in the response headers.
     Look for headers like X-RateLimit-Limit, X-RateLimit-Remaining, and X-RateLimit-Reset.
      You can use these headers to determine how many requests you can make and when to pause.

    2.Implement Retry Logic: If you hit the rate limit, the API will typically return a 429 Too Many Requests status code.
     Implement a retry mechanism that waits for the time specified in the Retry-After header before making another request.

    3.Use a Rate Limiting Library: Consider using a library that handles rate limiting for you.
     Libraries like resilience4j can help manage retries and backoff strategies.

    4.Throttling Requests: Introduce delays between requests to avoid hitting the rate limit.
     You can use Thread.sleep() in your test code to pause between requests.*/

    @Test
    public void rateLimitTest(){
        for (int i = 0; i < 100; i++) {
            Response response = RestAssured.get("https://api.example.com/data");
            int statusCode = response.getStatusCode();

            if (statusCode == 429) {
                int retryAfter = Integer.parseInt(response.getHeader("Retry-After"));
                try {
                    Thread.sleep(retryAfter * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // Process the response
                System.out.println(response.getBody().asString());
            }
        }
    }
}
