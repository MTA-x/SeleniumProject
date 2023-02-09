package com.cydeo.tests.day_08_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("ALL")
public class ReadingProperties {

    @Test
    public void reading_properties_test() throws IOException {
        //Create the object of properties
        Properties properties = new Properties();

        //Open the file in java memory
        FileInputStream fileInputStream = new FileInputStream("configuration.properties");
                                                                    //CONTENT ROOT
        //Load the properties object using FileInputStream
        properties.load(fileInputStream);

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
    }
}
