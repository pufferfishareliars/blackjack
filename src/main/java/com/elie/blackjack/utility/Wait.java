package com.elie.blackjack.utility;

public class Wait {
    public static void oneSec() {
        try {
            Thread.currentThread().sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitSec(long s) {
        try {
            Thread.currentThread().sleep(s * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
