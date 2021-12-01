package com.epam.cube.logic;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Dot;
import org.apache.log4j.Logger;

public class CubeCreator {

    public static final Logger LOGGER = Logger.getLogger(CubeCreator.class);

    public Cube create(String inputLine){

        String[] dividedLines = inputLine.split(" ");
        double xCoordinate = Double.parseDouble(dividedLines[0]);
        double yCoordinate = Double.parseDouble(dividedLines[1]);
        double zCoordinate = Double.parseDouble(dividedLines[2]);
        double side = Double.parseDouble(dividedLines[3]);

        LOGGER.info("Cube created");

        return new Cube(new Dot(xCoordinate, yCoordinate, zCoordinate), side);
    }
}
