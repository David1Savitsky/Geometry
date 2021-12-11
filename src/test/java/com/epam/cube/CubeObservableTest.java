package com.epam.cube;

import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class CubeObservableTest {

    public static final double EPSILON = 0.00000000001;

    @Test
    public void testNotifyObserversShouldChangeParametersWhenDataChanged(){
        //given
        CubeObservable cube = new CubeObservable(1, new Point(1,2,3), 4);
        CubeStore store = CubeStore.getInstance();
        cube.attach(store);

        //when
        cube.setSide(2);

        //then
        Map<Integer, Parameters> parameters = store.getParameters();
        Parameters firstParameter = parameters.get(1);
        Assert.assertEquals(8, firstParameter.getVolume(), EPSILON);
        Assert.assertEquals(24, firstParameter.getSurfaceArea(), EPSILON);
    }

}
