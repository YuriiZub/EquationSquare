package test.squareequation;

import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.dto.EquationDTO;
import com.squareequantion.service.solution.EquationSolutionImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for main functionality
 *
 * @author Yurii Zub
 * @date Created on 5/3/2019.
 * @version 1.2.0
 */
public class EquationSolutionImplTest {

    private EquationSolutionImpl mySolution;
    private EquationDTO inputDto;
    private EquantionsEntity expectedCalculationResults;

    @Before
    public void setEntityParam() {
        inputDto = new EquationDTO();
        expectedCalculationResults = new EquantionsEntity();
        mySolution = new EquationSolutionImpl();
    }

    @Test
    public void calculateEquation() throws Exception {

        /*Test for receiving only one result*/
        enterTestData(0, 1, 2, 1, 0, -1, 0.0, 1);
        assertEquals(expectedCalculationResults, mySolution.calculateEquation(inputDto));

        /*Test for receiving two result*/
        enterTestData(0, 1, 6, 1, 32, -5.82842712474619, -0.1715728752538097, 2);
        assertEquals(expectedCalculationResults, mySolution.calculateEquation(inputDto));
    }

    @Test(expected = Exception.class)
    public void testFirstParamIsZeroException() throws Exception{
        enterTestData(4, 0, 1, 1, 0, 0.0, 0.0, -1);
        mySolution.calculateEquation(inputDto);
    }

    @Test(expected = Exception.class)
    public void testDiscriminanteLessZeroException() throws Exception{
        enterTestData(3, 1, 1, 1, -3, 0.0, 0.0, 0);
        mySolution.calculateEquation(inputDto);
    }

        private void enterTestData(int iD, double a, double b, double c, double D, double X1, double X2, int success) {

        expectedCalculationResults.setId(iD);
        expectedCalculationResults.setParamA(a);
        expectedCalculationResults.setParamB(b);
        expectedCalculationResults.setParamC(c);
        expectedCalculationResults.setDiscriminant(D);
        expectedCalculationResults.setFirstResult(X1);
        expectedCalculationResults.setSecondResult(X2);
        expectedCalculationResults.setSuccessResult(success);

        inputDto.setId(iD);
        inputDto.setParamA(a);
        inputDto.setParamB(b);
        inputDto.setParamC(c);
    }

}