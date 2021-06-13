package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Human {
    public String firstName;
    public String lastName;
    public String experience;
    public Double salary;
    public String[] skillset = {"Java", "HTML", "SQL", "CSS", "JavaScript", "WordPress", "Pretashop", "Python", "C++", "Excell", "Vue", "Angular", "Mandarin (wow)"};

    public Human(String firstName, String lastName, String experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
    }

    public void setSalary(Double salary) {
        if (salary <= 0) {
            try {
                throw new Exception("Musisz coś płacić swoim pracownikom");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Wypłata Twojego pracownika to: " + salary);
        this.salary = salary;
    }

    public void shuffleList() {
        List<String> shuffledStringList = new ArrayList<String>(Arrays.asList(skillset));
        List<String> properShuffledSkillsList = new ArrayList<>(4);
        int counter = 0;
        while (counter < 4) {
            Random rand = new Random();
            int index = rand.nextInt(shuffledStringList.size());
            counter++;
            properShuffledSkillsList.add(shuffledStringList.get(index));
            shuffledStringList.remove(shuffledStringList.get(index));
        }
        System.out.println("Wylosowane umiejętności Twojego pracownika to: " + properShuffledSkillsList);
    }
}
