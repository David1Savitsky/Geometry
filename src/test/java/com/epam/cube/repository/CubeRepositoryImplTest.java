package com.epam.cube.repository;

import com.epam.cube.CubeIdentifiable;
import com.epam.cube.entity.Cube;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CubeRepositoryImplTest{

    private final CubeRepository repository = new CubeRepositoryImpl();
    private final CubeIdentifiable cubeFirst = new CubeIdentifiable(1,
            new Point(1, 2, 3), 7);
    private final CubeIdentifiable cubeSecond = new CubeIdentifiable(2,
            new Point(3, 4, 5), 6);

    @Test
    public void testQueryShouldReturnCubesWhenSurfaceAreaInGivenRange(){
        //given
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        List<CubeIdentifiable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);

        //when
        List<CubeIdentifiable> actualQuery = repository.query(new SurfaceAreaRangeSpecification(95, 217));

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldReturnCubesWhenIdMatches(){
        //given
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        List<CubeIdentifiable> expectedQuery = Arrays.asList(cubeSecond);

        //when
        List<CubeIdentifiable> actualQuery = repository.query(new IdSpecification(2));

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldReturnCubesWhenInFirstQuadrant(){
        //given
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        List<CubeIdentifiable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);

        //when
        List<CubeIdentifiable> actualQuery = repository.query(new FirstQuadrantSpecification());

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldNotReturnCubesWhenDoesNotFitSpecification(){
        //given
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        Specification specification = Mockito.mock(Specification.class);
        Mockito.when(specification.specified(cubeFirst)).thenReturn(false);
        Mockito.when(specification.specified(cubeSecond)).thenReturn(false);
        List<CubeIdentifiable> expectedQuery = new ArrayList<>();

        //when
        List<CubeIdentifiable> actualQuery = repository.query(specification);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testSortShouldSortDataBySideWhenDataIsValid(){
        //given
        repository.add(cubeSecond);
        repository.add(cubeFirst);
        Comparator<CubeIdentifiable> comparatorBySide = Comparator.comparing(CubeIdentifiable::getSide);
        List<CubeIdentifiable> expectedQuery = Arrays.asList(cubeSecond, cubeFirst);


        //when
        List<CubeIdentifiable> actualQuery = repository.sort(comparatorBySide);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testSortShouldSortDataByIdWhenDataIsValid(){
        //given
        repository.add(cubeSecond);
        repository.add(cubeFirst);
        Comparator<CubeIdentifiable> comparatorById = Comparator.comparing(CubeIdentifiable::getId);
        List<CubeIdentifiable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);


        //when
        List<CubeIdentifiable> actualQuery = repository.sort(comparatorById);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testSortShouldSortDataWhenDataIsValid(){
        //given
        repository.add(cubeSecond);
        repository.add(cubeFirst);
        Comparator<CubeIdentifiable> comparator = Mockito.mock(Comparator.class);
        Mockito.when(comparator.compare(cubeSecond, cubeFirst)).thenReturn(1);
        List<CubeIdentifiable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);

        //when
        List<CubeIdentifiable> actualQuery = repository.sort(comparator);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }
}