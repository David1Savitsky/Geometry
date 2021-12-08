package com.epam.cube.repository;

import com.epam.cube.CubeIdentifiable;

public class IdSpecification implements Specification {

    private final Integer id;

    public IdSpecification(final Integer id){
        this.id = id;
    }

    @Override
    public boolean specified(CubeIdentifiable cube) {
        return cube.getId().equals(id);
    }
}
