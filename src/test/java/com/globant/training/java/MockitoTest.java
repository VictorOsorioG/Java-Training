package com.globant.training.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    Portafolio portafolio;
    StockService stockService;

    @BeforeEach
    void setUp() {
        portafolio = new Portafolio();
        stockService = Mockito.mock(StockService.class);
        portafolio.setStockService(stockService);
    }

    @Test
    void test() {
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);
        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portafolio.setStocks(stocks);

        Mockito.when(stockService.getPrice(googleStock))
                .thenReturn(50.00);
        Mockito.when(stockService.getPrice(microsoftStock))
                .thenReturn(1000.00);

        double value = portafolio.getMarketValue();

        Assertions.assertEquals(100500.0, value);
    }

}
