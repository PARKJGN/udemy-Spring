package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
    @Test
    void test(){
        boolean test = todos.contains("AWS");

        assertTrue(test, "Something went wrong");
    }
}
