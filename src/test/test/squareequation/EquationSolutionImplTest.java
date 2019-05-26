package test.squareequation;

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
 */
public class EquationSolutionImplTest {

    private EquationSolutionImpl mySolution;//Solution entity for testing
    private EquationDTO realDto;// real DTO
    private EquationDTO expectedDto;//expected DTO

    @Before
    public void setEntityParam() {
        realDto = new EquationDTO();
        expectedDto = new EquationDTO();
        mySolution = new EquationSolutionImpl();

    }

    /**
     * Test for result of calculation
     *
     * @throws Exception
     */
    @Test
    public void doSolution() throws Exception {

        /*Test for receiving only one result*/
        enterData(1, 1, 2, 1, 0, -1, 0.0, 1);
        assertEquals(expectedDto, mySolution.doSolution(realDto));

        /*Test for receiving two result*/
        enterData(2, 1, 6, 1, 32, -5.82842712474619, -0.1715728752538097, 2);
        assertEquals(expectedDto, mySolution.doSolution(realDto));

       /*Test for receiving no result with Discriminant < 0*/
        enterData(3, 1, 1, 1, -3, 0.0, 0.0, 0);
        assertEquals(expectedDto, mySolution.doSolution(realDto));

        /*Test for receiving no result when first parameter == 0*/
        enterData(4, 0, 1, 1, 0, 0.0, 0.0, -1);
        assertEquals(expectedDto, mySolution.doSolution(realDto));
    }

    /**
     * Method for entering data during the test
     *
     * @param iD      iD of solution
     * @param a       first source parameter
     * @param b       second source parameter
     * @param c       third source parameter
     * @param D       Discriminant
     * @param X1      First result
     * @param X2      Second result
     * @param success Sucess flag of calculation 0 - are no results
     */
    private void enterData(int iD, double a, double b, double c, double D, double X1, double X2, int success) {
         /*Enter data for expected entity*/
        expectedDto.setId(iD);
        expectedDto.setParamA(a);
        expectedDto.setParamB(b);
        expectedDto.setParamC(c);
        expectedDto.setDiscriminant(D);
        expectedDto.setFirstResult(X1);
        expectedDto.setSecondResult(X2);
        expectedDto.setSuccessResult(success);

        /*Enter data  for actual Entity*/
        realDto.setId(iD);
        realDto.setParamA(a);
        realDto.setParamB(b);
        realDto.setParamC(c);

    }

}