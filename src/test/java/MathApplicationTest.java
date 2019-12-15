import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class MathApplicationTest {

    @Test
    void addTest(){
        CalculatorService calcService = mock(CalculatorService.class);
        final MathApplication mathApplication = new MathApplication();
        mathApplication.setCalculatorService(calcService);
        when(calcService.add(10.0,20.0)).thenReturn(30.00);
        when(calcService.subtract(20.0,12.0)).thenReturn(8.0);
        doThrow(new ArithmeticException("Cannot expressed")).when(calcService).divide(1,0);
        assertEquals(30.0,mathApplication.add(10.0,20.0));
        assertEquals(8.0,mathApplication.subtract(20.0,12.0));
        assertThrows(ArithmeticException.class,() -> mathApplication.divide(1,0));
        verify(calcService,times(1)).add(10.0, 20.0);
        verify(calcService).subtract(20.0,12.0);
        verify(calcService, Mockito.never()).subtract(1,0);

        then(calcService).should(times(1)).divide(1,0);
        then(calcService).should(times(1)).subtract(20.0,12.0);

        //add the behavior to add numbers
        when(calcService.multiply(20.0,10.0)).thenAnswer(new Answer<Object>() {

            @Override
            public Double answer(InvocationOnMock invocation) throws Throwable {
                //get the arguments passed to mock
                Object[] args = invocation.getArguments();

                //get the mock
                Object mock = invocation.getMock();

                //return the result
                return 30.0;
            }
        });

        //test the add functionality
        assertEquals(mathApplication.multiply(20.0, 10.0),30.0,0);
    }

}