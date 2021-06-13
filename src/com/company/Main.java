package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Boss me = new Boss();
        System.out.println(me);
        Human employee = new Human("łukasz", "Wawrzyniec", "best");

        me.hire(me, employee);
        employee.setSalary(1600.0);
        me.chooseProject();
    }
}
