package com.epam.cube.data;

import com.epam.cube.logic.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final DataReader reader = new DataReader();

    @Test
    public void testReadShouldReturnArrayWhenPathValid() throws DataException{
        //given
        String path = "src\\main\\resources\\Data.txt";
        List<String> expectedLines = Arrays.asList("1.0 -5.4 3.1 4.2", "2.3 -3.3 1.1 1.2", "-5.0 1.6 -3.2 4.7");

        //when
        List<String> linesRead = reader.read(path);

        //then
        Assert.assertEquals(expectedLines, linesRead);
    }

    @Test(expected = DataException.class)
    public void testReadShouldNotReadWhenPathInvalid() throws Exception {
        //given
        String path = "NotExistedPath";

        //when
        List<String> linesRead = reader.read(path);
    }
}
