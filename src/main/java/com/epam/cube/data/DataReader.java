package com.epam.cube.data;

import com.epam.cube.logic.DataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> read(String path) throws DataException {
        List<String> result = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            while((line = reader.readLine()) != null){
                result.add(line);
            }
            LOGGER.info("Data from file has read");

        } catch (FileNotFoundException e){
            LOGGER.warn("Caught " + e.getMessage());
            throw new DataException("Could not find the file", e);
        } catch (IOException e){
            LOGGER.warn("Caught " + e.getMessage());
            throw new DataException("I/O Exception");
        } finally{
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                     LOGGER.warn("Caught " + e.getMessage());
                     throw new DataException("I/O Exception");
                }
            }
        }

        return result;
    }

}
