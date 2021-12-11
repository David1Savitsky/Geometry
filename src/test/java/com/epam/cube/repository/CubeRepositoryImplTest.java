package com.epam.cube.repository;

import com.epam.cube.CubeObservable;
import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CubeRepositoryImplTest{

    private final CubeObservable cubeFirst = new CubeObservable(1,
            new Point(1, 2, 3), 7);
    private final CubeObservable cubeSecond = new CubeObservable(2,
            new Point(3, 4, 5), 6);

    @Test
    public void ITQueryShouldReturnCubesWhenSurfaceAreaInGivenRange(){
        //given
        final CubeRepository repository = new CubeRepositoryImpl();
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        CubeObservable cube = Mockito.mock(CubeObservable.class);
        SurfaceAreaRangeSpecification specification = Mockito.mock(SurfaceAreaRangeSpecification.class);
        Mockito.when(specification.specified(cubeFirst)).thenReturn(false);
        Mockito.when(specification.specified(cubeSecond)).thenReturn(true);
        List<CubeObservable> expectedQuery = Arrays.asList(cubeSecond);

        //when
        List<CubeObservable> actualQuery = repository.query(specification);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void ITQueryShouldReturnCubesWhenIdMatches(){
        //given
        final CubeRepository repository = new CubeRepositoryImpl();
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        IdSpecification specification = Mockito.mock(IdSpecification.class);
        Mockito.when(specification.specified(cubeFirst)).thenReturn(false);
        Mockito.when(specification.specified(cubeSecond)).thenReturn(true);
        List<CubeObservable> expectedQuery = Arrays.asList(cubeSecond);

        //when
        List<CubeObservable> actualQuery = repository.query(specification);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void ITQueryShouldReturnCubesWhenInFirstQuadrant(){
        //given
        final CubeRepository repository = new CubeRepositoryImpl();
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        FirstQuadrantSpecification specification = Mockito.mock(FirstQuadrantSpecification.class);
        Mockito.when(specification.specified(cubeFirst)).thenReturn(true);
        Mockito.when(specification.specified(cubeSecond)).thenReturn(true);
        List<CubeObservable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);

        //when
        List<CubeObservable> actualQuery = repository.query(specification);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void ITQueryShouldNotReturnCubesWhenDoesNotFitSpecification(){
        //given
        final CubeRepository repository = new CubeRepositoryImpl();
        repository.add(cubeFirst);
        repository.add(cubeSecond);
        Specification specification = Mockito.mock(Specification.class);
        Mockito.when(specification.specified(cubeFirst)).thenReturn(false);
        Mockito.when(specification.specified(cubeSecond)).thenReturn(false);
        List<CubeObservable> expectedQuery = new ArrayList<>();

        //when
        List<CubeObservable> actualQuery = repository.query(specification);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void ITSortShouldSortDataBySideWhenDataIsValid(){
        //given
        final CubeRepository repository = new CubeRepositoryImpl();
        repository.add(cubeSecond);
        repository.add(cubeFirst);
        Comparator<CubeObservable> comparatorBySide = Mockito.mock(Comparator.class);
        Mockito.when(comparatorBySide.compare(cubeFirst, cubeSecond)).thenReturn(1);
        List<CubeObservable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);

        //when
        List<CubeObservable> actualQuery = repository.sort(comparatorBySide);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void ITSortShouldSortDataByIdWhenDataIsValid(){
        //given
        final CubeRepository repository = new CubeRepositoryImpl();
        repository.add(cubeSecond);
        repository.add(cubeFirst);
        Comparator<CubeObservable> comparatorById = Mockito.mock(Comparator.class);
        Mockito.when(comparatorById.compare(cubeFirst, cubeSecond)).thenReturn(1);
        List<CubeObservable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);

        //when
        List<CubeObservable> actualQuery = repository.sort(comparatorById);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void ITSortShouldSortDataWhenDataIsValid(){
        //given
        final CubeRepository repository = new CubeRepositoryImpl();
        repository.add(cubeSecond);
        repository.add(cubeFirst);
        Comparator<CubeObservable> comparator = Mockito.mock(Comparator.class);
        Mockito.when(comparator.compare(cubeSecond, cubeFirst)).thenReturn(1);
        List<CubeObservable> expectedQuery = Arrays.asList(cubeFirst, cubeSecond);

        //when
        List<CubeObservable> actualQuery = repository.sort(comparator);

        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }
}