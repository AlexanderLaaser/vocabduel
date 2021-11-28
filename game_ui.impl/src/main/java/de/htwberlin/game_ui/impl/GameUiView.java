package de.htwberlin.game_ui.impl;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GameUiView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int askForAction(){
        System.out.println("Was möchten Sie tun?");
        System.out.println("1 = Vokabelverwaltung öffnen");
        System.out.println("2 = Spiel aus bestehenden Vokabeln starten");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        return input;
    }

    public int askForListAction(){
        System.out.println("Was möchten Sie tun?");
        System.out.println("1 = Alle Vokabellisten anzeigen");
        System.out.println("2 = Vokabeln für bestehende Liste anzeigen (Input: ID)");
        System.out.println("3 = Neue Vokabelliste hinzufügen");
        System.out.println("4 = Vokabeln manuell zu bestehender Liste hinzufügen");
        System.out.println("5 = Textfiles zur bestehenden Vokabelliste hinzufügen");
        System.out.println("6 = Bestehende Vokabelliste löschen");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        return input;
    }

    public String askSomethingString(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System. in);
        String input = scanner.nextLine();
        return input;
    }

    public int askSomethingInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System. in);
        int input = scanner.nextInt();

        return input;
    }

    public long askSomethingLong(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System. in);
        Long input = scanner.nextLong();

        return input;
    }



}
