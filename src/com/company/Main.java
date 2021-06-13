package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Jesteś szefem firmy IT. Poniżej znajdują się dane o Twojej osobie");

        Boss me = new Boss();

        System.out.println(me);
        System.out.println("Może teraz wylosować projekt. Do Twojej dyspozycji są tylko projekty łatwe oraz średnie, ze względu na brak odpowiedniego doświadczenia.");
        me.chooseProject();
        System.out.println("Twój projekt został wylosowany");
        me.hire(me);


    }
}
