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
        return firstName + " " + lastName + " \nUmiejętności: " +
                String.join(", ", skillsList) + " \nBudżet: " + cash + " zł";
    }

    @Override
    public void chooseProject() throws IOException {
        File easyProjects = new File("C://Users/Asiana/Desktop/Studia/WSB/AppStore/src/com/company/easyProjectList.txt");
        File mediumProjects = new File("C://Users/Asiana/Desktop/Studia/WSB/AppStore/src/com/company/mediumProjectList.txt");

        System.out.println("Określ poziom trudności: e - łatwy, m - średni: ");
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
    }

    @Override
    public void hire(Boss boss) throws Exception {
        Human bestEmployee = new Human("Łukasz", "Wawrzyniec", "best");
        Human averageEmployee = new Human("Mikołaj", "Śmieszek", "average");
        Human smartassEmployee = new Human("Damian", "Niski", "smartass");

        System.out.println("Możesz teraz zatrudnić jednego pracownika. Masz do wyboru pracownika najlepszego, średniego lub mądralę.\nNajlepszy: 2000.0 zł miesięcznie. Zero błędów zero spóźnień.\nŚredni: 1500.0 zł miesięcznie. 10% szans na błędy.\nMądrala: 1000.0 zł miesięcznie. 20% szans na błędy i 20% szans na spóźnienie.");
        System.out.println("Wpisz 'best' 'average' lub 'smartass' by dokonać wyboru: ");
        Scanner employeeChoice = new Scanner(System.in);
        String user_employeeChoice = employeeChoice.nextLine();
        if (user_employeeChoice.equals("best")) {
            if (boss.cash < 2000.0) {
                throw new Exception("Nie stać Cię na nowego pracownika");
            }
            System.out.println("Zdecydowałeś się na zatrudnienie!");
            System.out.println("The most expensive employee, but he does everything on time without single mistake");
            System.out.println("Imię: " + bestEmployee.firstName + "\nNazwisko: " + bestEmployee.lastName + "\nDoświadczenie: " + bestEmployee.experience);
            boss.cash -= 2000.0;
            System.out.println("Twój obecny stan konta to: " + boss.cash);
            bestEmployee.setSalary(2000.0);
            bestEmployee.shuffleList();
        }
        if (user_employeeChoice.equals("average")) {
            if (boss.cash < 1500.0) {
                throw new Exception("Nie stać Cię na nowego pracownika");
            }
            System.out.println("Zdecydowałeś się na zatrudnienie!");
            System.out.println("Average guy, 10% chance that you will need to correct what he did.");
            System.out.println("Imię: " + averageEmployee.firstName + "\nNazwisko: " + averageEmployee.lastName + "\nDoświadczenie: " + averageEmployee.experience);
            boss.cash -= 1500.0;
            System.out.println("Twój obecny stan konta to: " + boss.cash);
            averageEmployee.setSalary(1500.0);
            bestEmployee.shuffleList();
        }
        if (user_employeeChoice.equals("smartass")) {
            if (boss.cash < 1000.0) {
                throw new Exception("Nie stać Cię na nowego pracownika");
            }
            System.out.println("The chipest choice you could make. 20% chance of delay and mistake.");
            System.out.println("Imię: " + smartassEmployee.firstName + "\nNazwisko: " + smartassEmployee.lastName + "\nDoświadczenie: " + smartassEmployee.experience);
            boss.cash -= 1000.0;
            System.out.println("Twój obecny stan konta to: " + boss.cash);
            smartassEmployee.setSalary(1000.0);
            bestEmployee.shuffleList();
        }
    }
}
