package com.epam.cube.repository;

import com.epam.cube.CubeObservable;

import java.util.*;

public class CubeRepositoryImpl  implements CubeRepository{

    private Map<Integer, CubeObservable> store = new HashMap<>();

    @Override
    public void add(CubeObservable cube) {
        Integer cubeId = cube.getId();
        store.put(cubeId, cube);
    }

    @Override
    public void delete(CubeObservable cube) {
        Integer cubeId = cube.getId();
        store.remove(cubeId, cube);
    }

    @Override
    public void update(CubeObservable cube) {
        Integer cubeId = cube.getId();
        store.put(cubeId, cube);
    }

    @Override
    public List<CubeObservable> query(final Specification specification) {
        List<CubeObservable> cubes = new ArrayList<>();
        for(CubeObservable cube : store.values()){
            if (specification.specified(cube)){
                cubes.add(cube);
            }
        }
        return cubes;
    }

    @Override
    public List<CubeObservable> sort(final Comparator<CubeObservable> comparator) {
        List<CubeObservable> result = new ArrayList<>(store.values());
        result.sort(comparator);
        return result;
    }
}
