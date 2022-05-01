package com.epam.cube.repository;

import com.epam.cube.CubeObservable;
import com.epam.cube.entity.Point;

public class FirstQuadrantSpecification implements Specification {

    @Override
    public boolean specified(CubeObservable cube) {
        Point startingPoint = cube.getStartingPoint();
        return startingPoint.getXCoordinate() > 0
                && startingPoint.getYCoordinate() > 0
                && startingPoint.getZCoordinate() > 0;
    }
}
