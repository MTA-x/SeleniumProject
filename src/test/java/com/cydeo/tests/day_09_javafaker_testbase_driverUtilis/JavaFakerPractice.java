package com.cydeo.tests.day_09_javafaker_testbase_driverUtilis;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){
        //Creating Faker Object to reach methods
        Faker faker = new Faker();

        //First Name
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        //Last Name
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        //Full Name
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        //Generate random numbers in the format we want to get
        System.out.println("faker.numerify(\"###-###-#####-###\") = "
                + faker.numerify("###-###-#####-###"));
                                            //XXX-XXX-XXXX-XXX

        System.out.println("faker.numerify(\"312-###-####\") = "
                + faker.numerify("312-###-####"));
                                            //312-XXX-XXXX

        //Returns random letters where we pass "?"
        System.out.println("faker.letterify(\"???-???\") = "
                + faker.letterify("???-???"));


        //Returns random letters and nums
        System.out.println("faker.bothify(\"##?-##?#-#?#?-##??\") = "
                + faker.bothify("##?-##?#-#?#?-##??"));
                                      //S1

        //Returns random creadit card number
        System.out.println("faker.finance().creditCard() = "
                + faker.finance().creditCard());

        System.out.println("faker.finance().creditCard() = "
                + faker.finance().creditCard().replaceAll("-" , ""));
                                               //Removes "-"

        System.out.println("faker.chuckNorris().fact() = "
                + faker.chuckNorris().fact().replaceAll("Chuck Norris" , "Muhtar"));
    }
}
