package com.epam.cube.repository;

import com.epam.cube.CubeIdentifiable;
import com.epam.cube.logic.CubeCalculator;

public class SurfaceAreaRangeSpecification implements Specification{

    private final Integer surfaceAreaMin;
    private final Integer surfaceAreaMax;

    public SurfaceAreaRangeSpecification(Integer surfaceAreaMin, Integer surfaceAreaMax) {
        this.surfaceAreaMin = surfaceAreaMin;
        this.surfaceAreaMax = surfaceAreaMax;
    }

    @Override
    public boolean specified(CubeIdentifiable cube) {
        CubeCalculator calculator = new CubeCalculator();

        Integer surfaceArea = (int)calculator.calculateSurfaceArea(cube);
        return surfaceArea > surfaceAreaMin && surfaceArea < surfaceAreaMax;
    }
}
