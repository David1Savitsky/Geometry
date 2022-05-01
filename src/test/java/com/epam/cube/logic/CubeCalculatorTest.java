package com.epam.cube.logic;

import com.epam.cube.entity.Axes;
import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeCalculatorTest {

    private static final double EPSILON = 0.0000000001;

    @Test
    public void testCalculateVolumeShouldCalculateWhenCubeValid(){
        //given
        Cube cube = new Cube(new Point(0, 0, 0), 4);
        CubeCalculator calculator = new CubeCalculator();

        //when
        double volume = calculator.calculateVolume(cube);

        //then
        Assert.assertEquals(64, volume, EPSILON);
    }

    @Test
    public void testIsCubeShouldReturnTrueWhenCubeValid(){
        //given
        CubeCalculator calculator = new CubeCalculator();

        //when
        boolean isCube = calculator.isCube(new Point(-5, 3, 0), 2);

        //then
        Assert.assertTrue(isCube);
    }

    @Test
    public void testIsCubeShouldReturnFalseWhenCubeNotValid(){
        //given
        CubeCalculator calculator = new CubeCalculator();

        //when
        boolean isCube = calculator.isCube(new Point(-5, 3, 0), 0);

        //then
        Assert.assertFalse(isCube);
    }

    @Test
    public void testCalculateSurfaceAreaShouldCalculateWhenCubeValid(){
        //given
        Cube cube = new Cube(new Point(-5, 4, 0), 3);
        CubeCalculator calculator = new CubeCalculator();

        //when
        double area = calculator.calculateSurfaceArea(cube);

        //then
        Assert.assertEquals(54, area, EPSILON);
    }

    @Test
    public void testIsBaseOnCoordinatePlaneShouldReturnTrueWhenBaseOnPlane(){
        //given
        Cube cube = new Cube(new Point(-5, 0, 1), 3);
        CubeCalculator calculator = new CubeCalculator();

        //when
        boolean isOnCoordinatePlane = calculator.isBaseOnCoordinatePlane(cube);

        //then
        Assert.assertTrue(isOnCoordinatePlane);
    }

    @Test
    public void testIsBaseOnCoordinatePlaneShouldReturnFalseWhenBaseNotOnPlane(){
        //given
        Cube cube = new Cube(new Point(-5, 7, 3), 10);
        CubeCalculator calculator = new CubeCalculator();

        //when
        boolean isOnCoordinatePlane = calculator.isBaseOnCoordinatePlane(cube);

        //then
        Assert.assertFalse(isOnCoordinatePlane);
    }

    @Test
    public void testCalculateRatioVolumesShouldCalculateWhenPlaneXY(){
        //given
        Cube cube = new Cube(new Point(-5, 7, -4), 10);
        Axes axis = Axes.XY;
        CubeCalculator calculator = new CubeCalculator();

        //when
        double ratio = calculator.calculateRatioVolumes(cube, axis);

        //then
        Assert.assertEquals(1.5, ratio, EPSILON);
    }

    @Test
    public void testCalculateRatioVolumesShouldCalculateWhenPlaneXZ(){
        //given
        Cube cube = new Cube(new Point(-5, -5, -4), 10);
        Axes axis = Axes.XZ;
        CubeCalculator calculator = new CubeCalculator();

        //when
        double ratio = calculator.calculateRatioVolumes(cube, axis);

        //then
        Assert.assertEquals(1, ratio, EPSILON);
    }

    @Test
    public void testCalculateRatioVolumesShouldCalculateWhenPlaneYZ(){
        //given
        Cube cube = new Cube(new Point(-3, -3, -4), 12);
        Axes axis = Axes.YZ;
        CubeCalculator calculator = new CubeCalculator();

        //when
        double ratio = calculator.calculateRatioVolumes(cube, axis);

        //then
        Assert.assertEquals(3, ratio, EPSILON);
    }

}
