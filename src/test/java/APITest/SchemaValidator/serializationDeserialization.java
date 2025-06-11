package APITest.SchemaValidator;

//POJO--Serialisation---JSON----Deserialization--->JSON


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;


public class serializationDeserialization {

    //POJO To JSON--->Serialisation
    @Test
    void convertPojoToJson() throws JsonProcessingException {
        //created java object
        POJO_Student student=new POJO_Student();

        student.setJob("Trainee");
        student.setName("Tester");

        //convert java object to json object

        ObjectMapper objectMapper= new ObjectMapper();
        String studentData=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(studentData);
    }

    //JSON to POJO--->DeSerialisation
    @Test
    void convertJsonToPOJO() throws JsonProcessingException {
        String studentJsonData="{\n" +
                "  \"name\" : \"Tester\",\n" +
                "  \"job\" : \"Trainee\"\n" +
                "}";

        //Json data--->POJO Object

        ObjectMapper objectMapper=new ObjectMapper();
        POJO_Student PJS=objectMapper.readValue(studentJsonData,POJO_Student.class);
        System.out.println(PJS.getJob()+"  "+PJS.getName());
    }
}
