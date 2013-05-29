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

/**
 * org.me.builder.Primes
 */
class Primes {
    private int start;         // no default
    public int count = 100;    // default value


    Primes(int sta) { // constructor with one arg
        start = 0;
    }

    private boolean isPrime(int p) {

        if (p < 5)
            if (p <= 0 || p == 1 || p == 4)
                return false;
            else
                return true;
        else {
            int i;

            for (i = 2; i < (p / 2); i++) {
                if (i * (p / i) == p) return (false);
            }

            return (true);
        }
    }

    public int Generate(int i) {  // make primes
        int sta = 0;
        int cnt = count;
        int idx = 0;

        while (sta < 100) {
            if (isPrime(sta)) {
                log(sta);
                idx++;
                if (idx == i)
                    return sta;
            }
            sta++;
        }
        return sta;
    }


    public static void main(String args[]) {
        Primes primes = new Primes(200);
        //log(primes.isPrime(0));
        log(primes.Generate(24));


    }

    public static void log(Object msg) {
        System.out.println(msg.toString());
    }
}

