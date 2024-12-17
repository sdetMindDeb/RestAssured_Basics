package APITest.Day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class fakerLibraryDataGenerate {

    @Test
    void testGenerateRandomData(){
        Faker faker=new Faker();
        String fullname=faker.name().fullName();
        String firstName=faker.name().firstName();

        //Like this we can generate random data.
        //Refer session 7: 59 min
    }
}
