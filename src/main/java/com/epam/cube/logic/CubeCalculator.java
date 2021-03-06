package com.epam.cube.logic;

import com.epam.cube.entity.Axes;
import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;

public class CubeCalculator {

    public boolean isCube(Point startingPoint, double side){
        return side > 0;
    }

    public double calculateSurfaceArea(Cube cube){
        double side = cube.getSide();
        final int sidesNumber = 6;

        return sidesNumber * side * side;
    }

    public double calculateVolume(Cube cube){
        double side = cube.getSide();

        return Math.pow(side, 3);
    }

    public boolean isBaseOnCoordinatePlane(Cube cube){
        Point startingPoint = cube.getStartingPoint();
        final int coordinateOrigin = 0;

        return startingPoint.getXCoordinate() == coordinateOrigin
               || startingPoint.getYCoordinate() == coordinateOrigin
               || startingPoint.getZCoordinate() == coordinateOrigin;
    }

    public double calculateRatioVolumes(Cube cube, Axes plane){
        Point startingPoint = cube.getStartingPoint();
        double startCoordinate = 1;
        double endCoordinate = 1;
        double side = cube.getSide();

        switch (plane) {
            case XY:
                double zCoordinate = startingPoint.getZCoordinate();
                startCoordinate = Math.abs(zCoordinate);
                endCoordinate = side - startCoordinate;
                break;
            case XZ:
                double yCoordinate = startingPoint.getYCoordinate();
                startCoordinate = Math.abs(yCoordinate);
                endCoordinate = side - startCoordinate;
                break;
            case YZ:
                double xCoordinate = startingPoint.getXCoordinate();
                startCoordinate = Math.abs(xCoordinate);
                endCoordinate = side - startCoordinate;
                break;
        }

        if (Double.compare(startCoordinate, endCoordinate) == 1){
            return startCoordinate / endCoordinate;
        }
        return endCoordinate / startCoordinate;
    }

}
