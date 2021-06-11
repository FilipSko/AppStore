package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boss implements Skills {
    String firstName;
    String lastName;
    Double cash;
    String[] skills = {"Java", "HTML", "SQL", "CSS", "JavaScript", "WordPress", "Pretashop"};
    List<String> mySkills = Arrays.asList(skills);
    ArrayList<String> skillsList = new ArrayList<String>(mySkills);

    public Boss(String firstName, String lastName, Double cash) {
        this.skillsList = new ArrayList<>(mySkills);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
    }

    public String toString() {
        return "Osoba " + firstName + " " + lastName + " \nUmiejętności: " +
                String.join(", ", skillsList) + " \nBudżet: " + cash;
    }
}
