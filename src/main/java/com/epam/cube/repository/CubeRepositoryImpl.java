package com.epam.cube.repository;

import com.epam.cube.CubeIdentifiable;
import com.epam.cube.entity.Cube;

import java.util.*;

public class CubeRepositoryImpl  implements CubeRepository{

    private Map<Integer, CubeIdentifiable> store = new HashMap<>();

    @Override
    public void add(CubeIdentifiable cube) {
        Integer cubeId = cube.getId();
        store.put(cubeId, cube);
    }

    @Override
    public void delete(CubeIdentifiable cube) {
        Integer cubeId = cube.getId();
        store.remove(cubeId, cube);
    }

    @Override
    public void update(CubeIdentifiable cube) {
        Integer cubeId = cube.getId();
        store.put(cubeId, cube);
    }

    @Override
    public List<CubeIdentifiable> query(final Specification specification) {
        List<CubeIdentifiable> cubes = new ArrayList<>();
        for(CubeIdentifiable cube : store.values()){
            if (specification.specified(cube)){
                cubes.add(cube);
            }
        }
        return cubes;
    }

    @Override
    public List<CubeIdentifiable> sort(final Comparator<CubeIdentifiable> comparator) {
        List<CubeIdentifiable> result = new ArrayList<>(store.values());
        result.sort(comparator);
        return result;
    }
}
