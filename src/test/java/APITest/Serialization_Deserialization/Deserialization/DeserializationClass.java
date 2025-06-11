package APITest.Serialization_Deserialization.Deserialization;

import APITest.Serialization_Deserialization.Serialization.profileDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class DeserializationClass {

    @Test
    void deserializationTest() throws JsonProcessingException {
        String requestBody="{\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"email\":\"johndoe@example.com\",\n" +
                "        \"age\": \"30\",\n" +
                "        \"isActive\": \"true\",\n" +
                "        \"hobbies\": [\n" +
                "            \"reading\",\n" +
                "            \"travelling\",\n" +
                "            \"swimming\"\n" +
                "        ],\n" +
                "        \"addressDetails\": {\n" +
                "            \"city\": \"New York\",\n" +
                "            \"state\": \"NY\",\n" +
                "            \"street\": \"123 Main St\",\n" +
                "            \"zip\": \"10001\"\n" +
                "        }\n" +
                "    }";

        ObjectMapper objectMapper = new ObjectMapper();
        profileDetails pfd = objectMapper.readValue(requestBody, profileDetails.class);

        System.out.println("Age: " + pfd.getAge());
        System.out.println("hobbies: " + pfd.getHobbies());
        System.out.println("Street: " + pfd.getAddressDetails().getStreet());
    }
}
