package com.epam.cube.logic;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

public class CubeValidatorTest {
    @Test
    public void testIsValidLineShouldReturnTrueWhenLineValid(){
        //given
        CubeValidator validator = new CubeValidator();
        String validLine = "-3.0 6.5 -2.1 3.5";

        //when
        boolean isValid = validator.isValidLine(validLine);

        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenLineInvalid(){
        //given
        CubeValidator validator = new CubeValidator();
        String invalidLine = "3.0 6.5 -2.1 -3.5";

        //when
        boolean isValid = validator.isValidLine(invalidLine);

        //then
        Assert.assertFalse(isValid);
    }

}
