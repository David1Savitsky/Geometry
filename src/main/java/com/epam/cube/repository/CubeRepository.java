package com.epam.cube.repository;

import com.epam.cube.CubeObservable;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository {

    void add(CubeObservable cube);
    void delete(CubeObservable cube);
    void update(CubeObservable cube);

    List<CubeObservable> query(final Specification specification);
    List<CubeObservable> sort(Comparator<CubeObservable> comparator);
}
