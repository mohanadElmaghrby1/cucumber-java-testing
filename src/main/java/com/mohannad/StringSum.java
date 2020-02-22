package com.mohannad;

import com.mohannad.exceptions.AhmedMisbahException;

/**
 * created by mohannad  on 09/02/20
 */
public class StringSum {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }


    public static long sum(String firstNumber , String secondNumber)throws AhmedMisbahException {

        if ( !firstNumber.matches("\\d+") || !secondNumber.matches("\\d+")){
            throw new AhmedMisbahException("this is not a number");
        }

        long num1 = Long.parseLong(firstNumber);
        long num2 = Long.parseLong(secondNumber);
        if (num1 <0 || num2 <0) {
            throw new AhmedMisbahException("this is not a number");
        }

        long result = num1+num2;
        return result;
    }
}
