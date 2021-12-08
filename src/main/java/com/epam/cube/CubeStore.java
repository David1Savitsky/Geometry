package com.epam.cube;

import com.epam.cube.logic.CubeCalculator;

import java.util.HashMap;
import java.util.Map;

public class CubeStore implements Observer{

    private static CubeStore instance;

    private final Map<Integer, Parameters> parameters = new HashMap<>();
    private final CubeCalculator calculator = new CubeCalculator();

    private CubeStore() {};

    public Map<Integer, Parameters> getParameters() {
        return parameters;
    }

    public void update(CubeIdentifiable cube){
        double volume = calculator.calculateVolume(cube);
        double surfaceArea = calculator.calculateSurfaceArea(cube);

        Integer cubeId = cube.getId();
        parameters.put(cubeId, new Parameters(volume, surfaceArea));
    }

    public static CubeStore getInstance(){
        if (instance == null){
            instance = new CubeStore();
        }
        return instance;
    }

}
