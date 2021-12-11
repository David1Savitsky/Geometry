package com.epam.cube.repository;

import com.epam.cube.CubeObservable;

public interface Specification {

    boolean specified(CubeObservable cube);

}
