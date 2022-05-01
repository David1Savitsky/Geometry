package com.epam.cube.logic;

import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeCreatorTest {

    @Test
    public void testCreateShouldCreateBallWhenDataValid(){
        //given
        CubeCreator creator = new CubeCreator();
        Cube cube = new Cube(new Point(2, 4, 5), 3);
        String inputLine = "2.0 4.0 5.0 3.0";

        //when
        Cube createdCube = creator.create(inputLine);

        //then
        Assert.assertEquals(cube, createdCube);
    }

    @Test
    public void testCreateShouldCreateBallWhenDataInvalid(){
        //given
        CubeCreator creator = new CubeCreator();
        Cube cube = new Cube(new Point(2, 4, 5), -3);
        String inputLine = "2.0 4.0 5.0 -3.0";

        //when
        Cube createdCube = creator.create(inputLine);

        //then
        Assert.assertEquals(cube, createdCube);
    }

}
