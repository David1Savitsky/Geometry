package com.epam.cube.logic;

import com.epam.cube.dataread.DataReader;
import com.epam.cube.entity.Cube;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private DataReader reader;
    private CubeValidator validator;
    private CubeCreator creator;

    public static final Logger LOGGER = Logger.getLogger(Director.class);

    public Director(DataReader reader, CubeValidator validator, CubeCreator creator){
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
        LOGGER.info("Class Director was initialized");
        LOGGER.lo
    }

    public List<Cube> read(String filePath) throws Exception{
        List<Cube> cubes = new ArrayList<Cube>();
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
