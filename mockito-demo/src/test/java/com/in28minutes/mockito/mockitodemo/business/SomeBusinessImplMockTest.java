package com.in28minutes.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl business;

    @Test
    void findTheGreatestFromAllData() {

        //DataService dataServiceMock = mock(DataService.class);
//        dataServiceMock.retrieveAllData() => new int[]{25, 15, 5}
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[]{25, 15, 5});
        //SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        assertEquals(25, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_OneValue() {

       // DataService dataServiceMock = mock(DataService.class);
//        dataServiceMock.retrieveAllData() => new int[]{25, 15, 5}
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[]{35});
       // SomeBusinessImpl business = new SomeBusinessImpl(dataServiceMock);
        assertEquals(35, business.findTheGreatestFromAllData());
    }
}
