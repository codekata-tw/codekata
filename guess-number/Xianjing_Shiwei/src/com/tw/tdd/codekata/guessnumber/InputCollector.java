package com.tw.tdd.codekata.guessnumber;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 12-5-14
 * Time: 上午7:43
 * To change this template use File | Settings | File Templates.
 */
public class InputCollector {
    public String guess() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
