package com.cydeo.tests.day_09_javafaker_testbase_driverUtilis;

public class Singleton {
    //Create private Constructor
    private Singleton(){}

    //Create private static String
    //Prevent access and provide a getter method
    private static String word;

    //This utility method will return the "word" in thw way we want  to return
    public static String getWord(){

        if (word == null){
            System.out.println("First time call. Word object is null. " +
                    "\nAssigning value to it now");

            word = "Something";
        }else{
            System.out.println("Word alread has value");
        }

        return word;
    }


}
