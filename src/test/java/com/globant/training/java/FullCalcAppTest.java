package com.globant.training.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FullCalcAppTest {

    @InjectMocks
    FullCalcApp fullCalcApp;

    @Mock
    CalculatorService calcService;

    @Test
    void add() {
        Mockito.when(calcService.add(10.0, 20.0))
                .thenReturn(30.00);

        Mockito.when(calcService.add(15.0, 20.0))
                .thenReturn(35.00);

        Assertions.assertEquals(fullCalcApp.add(10.0,20.0), 30.0);
        Assertions.assertEquals(fullCalcApp.add(10.0,20.0), 30.0);
        Assertions.assertEquals(fullCalcApp.add(15.0,20.0), 35.0);

        Mockito.verify(calcService, Mockito.atLeast(2))
                .add(10.0, 20.0);
        Mockito.verify(calcService, Mockito.atLeastOnce())
                .add(15.0, 20.0);
        Mockito.verify(calcService, Mockito.times(1))
                .add(15.0, 20.0);
        Mockito.verify(calcService, Mockito.never()).multiply(1.0,3.0);
    }

    @Test
    @DisplayName("Inorder --> order of method calls")
    void subtract() {

        Mockito.when(calcService.add(10.0, 20.0))
                .thenReturn(30.00);
        Mockito.when(calcService.subtract(10.0, 20.0))
                .thenReturn(10.00);


        Assertions.assertEquals(fullCalcApp.add(10.0, 20.0),30.0);
        Assertions.assertEquals(fullCalcApp.subtract(10.0, 20.0),10.0);

        InOrder inOrder = Mockito.inOrder(calcService);
        inOrder.verify(calcService).add(10.0,20.0);
        inOrder.verify(calcService).subtract(10.0,20.0);
    }

    @Test
    void multiply() {
        Mockito.when(calcService.multiply(10.0, 20.0))
                .thenAnswer(new Answer<Double>() {
                    @Override
                    public Double answer(InvocationOnMock invocationOnMock) throws Throwable {
                        return 20.0;
                    }
                });

        Assertions.assertEquals(fullCalcApp.multiply(10.0, 20.0), 20.0);
    }

    @Test
    void divide() {
        Mockito.doThrow(new IllegalArgumentException("Division by zero"))
                .when(calcService)
                .divide(0,0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> fullCalcApp.divide(0, 0));
    }

    @Test
    void spyTest() {
        fullCalcApp = new FullCalcApp();
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        calcService = Mockito.spy(calculatorService);
        fullCalcApp.setCalculatorService(calcService);

        Assertions.assertEquals(30.0, fullCalcApp.add(10.0, 20.0));
    }

    @Test
    void resetMockTest(){
        Mockito.when(calcService.add(10.0, 20.0))
                .thenReturn(30.00);

        Assertions.assertEquals(fullCalcApp.add(10.0,20.0), 30.0);

        Mockito.reset(calcService);

        Assertions.assertEquals(0.0, fullCalcApp.add(10.0,20.0));
    }

    @Test
    void bdd() {
        BDDMockito.given(calcService.add(20.0, 10.0)).willReturn(30.0);

        double result = calcService.add(20.0, 10.0);

        Assertions.assertEquals(30.0, result);
    }

    @Test
    void timeOutTest() {
        BDDMockito.given(calcService.add(20.0, 10.0)).willReturn(30.0);

        double result = calcService.add(20.0, 10.0);

        Assertions.assertEquals(30.0, result);

        Mockito.verify(calcService, Mockito.timeout(1))
                .add(20.0, 10.0);
    }
}