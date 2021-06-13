package com.company;

import com.company.projects.ChooseProject;
import com.company.projects.Hire;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Boss implements ChooseProject, Hire {
    public final String firstName = "Filip";
    public final String lastName = "Skośkiewicz";
    public Double cash = 10000.0;
    String[] skills = {"Java", "HTML", "SQL", "CSS", "JavaScript", "WordPress", "Pretashop"};
    List<String> mySkills = Arrays.asList(skills);
    ArrayList<String> skillsList = new ArrayList<String>(mySkills);

    public String toString() {
        return "Osoba " + firstName + " " + lastName + " \nUmiejętności: " +
                String.join(", ", skillsList) + " \nBudżet: " + cash;
    }

    @Override
    public void chooseProject() throws IOException {
        File easyProjects = new File("C://Users/Asiana/Desktop/Studia/WSB/AppStore/src/com/company/easyProjectList.txt");
        File mediumProjects = new File("C://Users/Asiana/Desktop/Studia/WSB/AppStore/src/com/company/mediumProjectList.txt");

        System.out.println("Z bazy danych zostanie wylosowany projekt. Określ poziom trudności: e - łatwy, m - średni, h - trudny: ");
        Scanner answer = new Scanner(System.in);
        String user_answer = answer.nextLine();
        List<String> easyDetails = new ArrayList<>();
        List<String> mediumDetails = new ArrayList<>();

        if (user_answer.equals("e")) {
            String result = null;
            Random rand = new Random();
            int n = 0;
            for (Scanner scan = new Scanner(easyProjects); scan.hasNext(); ) {
                ++n;
                String line = scan.nextLine();
                if (rand.nextInt(n) == 0)
                    result = line;
                easyDetails.add(result);
            }
            System.out.println("Twój projekt to:\n" + result);
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
                mediumDetails.add(result);
            }
            System.out.println("Twój projekt to:\n" + result);
        }
        if (user_answer.equals("h")) {
            System.out.println("Nie jesteś wystarczająco doświadczony, aby realizować trudny projekt.");
        }
    }

    @Override
    public void hire(Boss boss, Human employee) throws Exception {
        System.out.println("Czy na pewno chcesz zatrudnić " + employee.firstName + " " + employee.lastName + " w swojej firmie?");
        Scanner answer = new Scanner(System.in);
        String user_answer = answer.nextLine();
        if (user_answer.equals("tak")) {
            if (boss.cash < 2000.0) {
                throw new Exception("Nie stać Cię na nowego pracownika");
            }
            if (employee.experience == "best") {
                System.out.println("Zdecydowałeś się na zatrudnienie!");
                System.out.println("The most expensive employee, but he does everything on time without single mistake");
                System.out.println("Imię: " + employee.firstName + "\nNazwisko: " + employee.lastName + "\nDoświadczenie: " + employee.experience);
                boss.cash -= 2000.0;
                System.out.println("Twój obecny stan konta to: " + boss.cash);

            }
            if (employee.experience == "average") {
                System.out.println("Average guy, 10% chance that you will need to correct what he did.");
                System.out.println("Imię: " + employee.firstName + "\nNazwisko: " + employee.lastName + "\nDoświadczenie: " + employee.experience);
                boss.cash -= 1500.0;
                System.out.println("Twój obecny stan konta to: " + boss.cash);

            }
            if (employee.experience == "smartass") {
                System.out.println("The chipest choice you could make. 20% chance of delay and mistake.");
                System.out.println("Imię: " + employee.firstName + "\nNazwisko: " + employee.lastName + "\nDoświadczenie: " + employee.experience);
                boss.cash -= 1000.0;
                System.out.println("Twój obecny stan konta to: " + boss.cash);
            }
        }
        if (answer.equals("nie")) {
            System.out.println("Nie zdecydowałeś się na zatrudnienie nowego pracownika");
        }
    }
}
