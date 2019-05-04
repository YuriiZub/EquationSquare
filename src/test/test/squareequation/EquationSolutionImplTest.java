package test.squareequation;

import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.EquationSolutionImpl;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Test for main functionality
 *
 * @author Yurii Zub
 * @date Created on 5/3/2019.
 */
public class EquationSolutionImplTest {

    private EquationSolutionImpl mySolution;//Solution entity for testing
    private EquantionsEntity myEntity;//Entity for testing
    private EquantionsEntity myCompareEntity;//Etity with expected parameters

    @Before
    public void setEntityParam() {
        myEntity = new EquantionsEntity();
        myCompareEntity = new EquantionsEntity();
        mySolution = new EquationSolutionImpl();

    }

    @Test
    public void setResult() throws Exception {
        mySolution.setResult(myEntity);
        assertEquals(mySolution.getResult(), myEntity);
    }

    /**
     * Test for result of calculation
     * @throws Exception
     */
    @Test
    public void doSolution() throws Exception {

        /*Test for receiving only one result*/
        enterData(1, 1, 2, 1, 0, -1, 0.0, 1);
        /*Set result and do calculation*/
        mySolution.setResult(myEntity);
        mySolution.doSolution();
        assertEquals(myCompareEntity, myEntity);

        /*Test for receiving two result*/
        enterData(2,1,6,1,32,-5.82842712474619,-0.1715728752538097,2);
        /*Set result and do calculation*/
        mySolution.setResult(myEntity);
        mySolution.doSolution();
        assertEquals(myCompareEntity, myEntity);

       /*Test for receiving no result with Discriminant < 0*/
        enterData(3, 1, 1, 1, -3, 0.0, 0.0, 0);
        /*Set result and do calculation*/
        mySolution.setResult(myEntity);
        mySolution.doSolution();
        assertEquals(myCompareEntity, myEntity);

        /*Test for receiving no result when first parameter == 0*/
        enterData(4, 0, 1, 1, 0, 0.0, 0.0, -1);
        /*Set result and do calculation*/
        mySolution.setResult(myEntity);
        mySolution.doSolution();
        assertEquals(myCompareEntity, myEntity);

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
        myCompareEntity.setId(iD);
        myCompareEntity.setParamA(a);
        myCompareEntity.setParamB(b);
        myCompareEntity.setParamC(c);
        myCompareEntity.setDiscriminant(D);
        myCompareEntity.setFirstResult(X1);
        myCompareEntity.setSecondResult(X2);
        myCompareEntity.setSuccessResult(success);

        /*Enter data  for actual Entity*/
        myEntity.setId(iD);
        myEntity.setParamA(a);
        myEntity.setParamB(b);
        myEntity.setParamC(c);

    }

}