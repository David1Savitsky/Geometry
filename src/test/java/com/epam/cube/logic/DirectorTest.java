package com.epam.cube.logic;

import com.epam.cube.dataread.DataReader;
import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Dot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DirectorTest {

    public static final String FIRST_VALID_LINE = "2.1 3.3 -4.8. 3.0";
    public static final String SECOND_VALID_LINE = "3.3 -1.2 -9.4 2.2";
    public static final String FIRST_INVALID_LINE = "2.1z 3.3 -4.8. 3.0";
    public static final String SECOND_INVALID_LINE = "2.1 3.3 -4.8. -3.0";
    public static final Cube FIRST_VALID_CUBE = new Cube(
            new Dot(2.1, 3.3, -4.8), 3);
    public static final Cube Second_VALID_CUBE = new Cube(
            new Dot(3.3, -1.2, -9.4), 2.2);
    public static final String FILE_PATH = "filePath";

    @Test
    public void testReadShouldReturnListWhenDataAreValid() throws Exception{
        //given
        List<String> linesRead = Arrays.asList(FIRST_VALID_LINE, SECOND_VALID_LINE);

        CubeValidator validator = Mockito.mock(CubeValidator.class);
        Mockito.when(validator.isValidLine(FIRST_VALID_LINE)).thenReturn(true);
        Mockito.when(validator.isValidLine(SECOND_VALID_LINE)).thenReturn(true);

        CubeCreator creator = Mockito.mock(CubeCreator.class);
        Mockito.when(creator.create(FIRST_VALID_LINE)).thenReturn(FIRST_VALID_CUBE);
        Mockito.when(creator.create(SECOND_VALID_LINE)).thenReturn(Second_VALID_CUBE);

        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(FILE_PATH)).thenReturn(linesRead);

        Director director = new Director(reader, validator, creator);
        List<Cube> cubesExpected = Arrays.asList(FIRST_VALID_CUBE, Second_VALID_CUBE);

        //when
        List<Cube> cubesMade = director.read(FILE_PATH);

        //then
        Assert.assertEquals(cubesExpected, cubesMade);
    }

    @Test
    public void testReadShouldNotReturnListWhenDataAreInvalid() throws Exception{
        //given
        List<String> linesRead = Arrays.asList(FIRST_INVALID_LINE, SECOND_INVALID_LINE, FIRST_VALID_LINE);

        CubeValidator validator = Mockito.mock(CubeValidator.class);
        Mockito.when(validator.isValidLine(FIRST_INVALID_LINE)).thenReturn(false);
        Mockito.when(validator.isValidLine(SECOND_INVALID_LINE)).thenReturn(false);
        Mockito.when(validator.isValidLine(FIRST_VALID_LINE)).thenReturn(true);

        CubeCreator creator = Mockito.mock(CubeCreator.class);
        Mockito.when(creator.create(FIRST_VALID_LINE)).thenReturn(FIRST_VALID_CUBE);

        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(FILE_PATH)).thenReturn(linesRead);

        Director director = new Director(reader, validator, creator);
        List<Cube> cubesExpected = Arrays.asList(FIRST_VALID_CUBE);

        //when
        List<Cube> cubesMade = director.read(FILE_PATH);

        //then
        Assert.assertEquals(cubesExpected, cubesMade);
    }

}
