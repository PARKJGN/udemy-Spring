package org.example;

public class MyMath {

    public int calculateSum(int[] numbers){
        int sum = 10;
        for(int number:numbers){
            sum+=number;
        }
        return sum;
    }
}
