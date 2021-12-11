package com.epam.cube.repository;

import com.epam.cube.CubeObservable;

public class IdSpecification implements Specification {

    private final Integer id;

    public IdSpecification(final Integer id){
        this.id = id;
    }

    @Override
    public boolean specified(CubeObservable cube) {
        return cube.getId().equals(id);
    }
}
