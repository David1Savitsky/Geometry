package com.epam.cube.repository;

import com.epam.cube.CubeIdentifiable;
import com.epam.cube.logic.CubeCalculator;

public class SurfaceAreaRangeSpecification implements Specification{

    private final Integer surfaceAreaMin;
    private final Integer surfaceAreaMax;
    private final CubeCalculator calculator;

    public SurfaceAreaRangeSpecification(Integer surfaceAreaMin, Integer surfaceAreaMax, CubeCalculator calculator) {
        this.surfaceAreaMin = surfaceAreaMin;
        this.surfaceAreaMax = surfaceAreaMax;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(CubeIdentifiable cube) {
        //CubeCalculator calculator = new CubeCalculator();

        Integer surfaceArea = (int)calculator.calculateSurfaceArea(cube);
        return surfaceArea > surfaceAreaMin && surfaceArea < surfaceAreaMax;
    }
}
