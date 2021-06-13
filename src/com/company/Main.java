package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Boss me = new Boss("Filip", "Skośkiewicz", 10000.0);
        System.out.println(me);

        me.chooseProject();
    }
}
