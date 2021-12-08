package com.epam.cube.logic;

import com.epam.cube.data.DataReader;
import com.epam.cube.entity.Cube;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private final DataReader reader;
    private final CubeValidator validator;
    private final CubeCreator creator;

    public static final Logger LOGGER = Logger.getLogger(Director.class);

    public Director(DataReader reader, CubeValidator validator, CubeCreator creator){
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
        LOGGER.info("Class Director was initialized");
    }

    public List<Cube> read(String filePath) throws DataException{
        List<Cube> cubes = new ArrayList<>();
        List<String> lines = reader.read(filePath);

        for (String line : lines){
            if (validator.isValidLine(line)){
                Cube cube = creator.create(line);
                cubes.add(cube);
            }
        }

        return cubes;
    }
}
