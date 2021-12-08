package com.epam.cube.repository;

import com.epam.cube.CubeIdentifiable;
import com.epam.cube.entity.Cube;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository {

    void add(CubeIdentifiable cube);
    void delete(CubeIdentifiable cube);
    void update(CubeIdentifiable cube);

    List<CubeIdentifiable> query(final Specification specification);
    List<CubeIdentifiable> sort(Comparator<CubeIdentifiable> comparator);
}
