package com.epam.cube.logic;

import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class CubeValidator {

    private static final String CUBE_REG_EXPR = "((-)?\\d+\\.\\d+ ){3}\\d+\\.\\d+";
    public static final Logger LOGGER = Logger.getLogger(CubeValidator.class);

    public boolean isValidLine(String line){
        LOGGER.info("Data have been validated");
        return Pattern.matches(CUBE_REG_EXPR, line);
    }
}
