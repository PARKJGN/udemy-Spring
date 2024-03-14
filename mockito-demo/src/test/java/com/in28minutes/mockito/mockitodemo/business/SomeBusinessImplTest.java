package com.in28minutes.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllData() {
        DataService dataServiceStub = new DataServiceStub();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(25, result);
    }
}

class DataServiceStub implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 15, 5};
    }
}
class DataServiceStub2 implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 15, 5};
    }
}