package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human {
    public String firstName;
    public String lastName;
    public String experience;
    public Double salary;
    String[] skillset = {"Java", "HTML", "SQL", "CSS", "JavaScript", "WordPress", "Pretashop", "Python", "C++", "Excell", "Vue", "Angular", "Mandarin (wow)"};
    List<String> employeeSkill = Arrays.asList(skillset);
    ArrayList<String> employeeSkillsList = new ArrayList<String>(employeeSkill);

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


}
