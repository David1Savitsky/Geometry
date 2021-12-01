package com.epam.cube.dataread;

import com.epam.cube.logic.Director;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> read(String path) throws Exception{
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){

            String line;
            while((line = reader.readLine()) != null){
                result.add(line);
            }
            LOGGER.info("Data from file has read");

        } catch (FileNotFoundException e){
            LOGGER.error("Could not find the file", e);
            throw new Exception("Could not find the file", e);
        }

        return result;
    }

}
