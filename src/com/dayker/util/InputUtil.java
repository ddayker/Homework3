package com.dayker.util;

import java.util.Scanner;

public class InputUtil {

    public static int enterInteger() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        String string;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("--> ");
                string = scanner.nextLine();
                number = Integer.parseInt(string);
                if (number >= 0) {
                    flag = true;
                } else {
                    System.out.println("Error. You need to enter a non-negative integer.");
                }

            } catch (Exception e) {
                System.out.println("Error. You need to enter a integer.");
            }
        }
        return number;
    }
}
