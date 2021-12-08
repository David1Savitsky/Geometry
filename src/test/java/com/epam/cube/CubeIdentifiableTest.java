package com.epam.cube;

import com.epam.cube.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeIdentifiableTest {

    @Test
    public void testNotifyObserversShouldChangeParametersWhenDataChanged(){
        //given
        CubeIdentifiable cube = new CubeIdentifiable(1, new Point(1,2,3), 4);
        CubeStore store = CubeStore.getInstance();
        cube.attach(store);

        //when
        cube.setSide(2);

        //then
        Assert.assertEquals(8, store.getParameters().get(1).getVolume(), 0.00000000001);
        Assert.assertEquals(24, store.getParameters().get(1).getSurfaceArea(), 0.00000000001);
    }

}
