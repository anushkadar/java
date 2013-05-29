/*
 * (C) Copyright 2009-2010 Direct FN Technologies Limited. All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * Direct FN Technologies and constitute a TRADE SECRET of Direct FN Technologies Limited.
 *
 * Direct FN Technologies Limited retains all title to and intellectual property rights
 * in these materials.
 */
package org.me.builder;

import java.math.BigInteger;
import java.util.Random;


/**
 * org.me.builder.RandomNumber
 */
public class RandomNumber {
    public static void main(String args[]) {
        short s;
        int i;
        byte b;
        long l;

        BigInteger big;
        log(String.valueOf(BigInteger.probablePrime(5, new Random(50))));


        Random randomGenerator = new Random();
        for (int idx = 1; idx <= 10; ++idx) {
            int randomInt = randomGenerator.nextInt(100);
            log("Generated : " + randomInt);
        }

        double douRandom = Math.random();
        log(String.valueOf(douRandom));
    }

    private static void log(String aMessage) {
        System.out.println(aMessage);
    }


}
