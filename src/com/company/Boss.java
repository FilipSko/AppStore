package com.company;

import com.company.projects.ChooseProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Boss implements ChooseProject {
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

    public static String choose(File f) throws FileNotFoundException {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for (Scanner sc = new Scanner(f); sc.hasNext(); ) {
            ++n;
            String line = sc.nextLine();
            if (rand.nextInt(n) == 0)
                result = line;
        }

        return result;
    }

    @Override
    public void chooseProject() throws FileNotFoundException {
        File easyProjects = new File("C://Users/Asiana/Desktop/Studia/WSB/AppStore/src/com/company/easyProjectList.txt");
        File mediumProjects = new File("C://Users/Asiana/Desktop/Studia/WSB/AppStore/src/com/company/mediumProjectList.txt");

        System.out.println("Z bazy danych zostanie wylosowany projekt. Określ poziom trudności: e - łatwy, m - średni, h - trudny: ");
        Scanner answer = new Scanner(System.in);
        String user_answer = answer.nextLine();

        if (user_answer.equals("e")) {
            String result = null;
            Random rand = new Random();
            int n = 0;
            for (Scanner scan = new Scanner(easyProjects); scan.hasNext(); ) {
                ++n;
                String line = scan.nextLine();
                if (rand.nextInt(n) == 0)
                    result = line;
            }
            System.out.println(result);
        }
        if (user_answer.equals("m")) {
            String result = null;
            Random rand = new Random();
            int n = 0;
            for (Scanner scan = new Scanner(mediumProjects); scan.hasNext(); ) {
                ++n;
                String line = scan.nextLine();
                if (rand.nextInt(n) == 0)
                    result = line;
            }
            System.out.println(result);
        }
        if (user_answer.equals("h")) {
            System.out.println("Nie jesteś wystarczająco doświadczony, aby realizować trudny projekt.");
        }
    }
}
