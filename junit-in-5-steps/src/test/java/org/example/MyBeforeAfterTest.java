package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("BeforeEach");
    }

    private  MyMath math = new MyMath();
    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }

    @AfterEach
    void afterEach(){
        System.out.println("AfterEach");
    }
}