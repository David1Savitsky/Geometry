package com.epam.cube.repository;

import com.epam.cube.CubeIdentifiable;
import com.epam.cube.entity.Cube;

public interface Specification {

    boolean specified(CubeIdentifiable cube);

}
