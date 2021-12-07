package de.htwberlin.game_ui.impl;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GameUiView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int askForAction() {
        System.out.println("Was möchten Sie tun?");
        System.out.println("1 = Vokabelverwaltung öffnen");
        System.out.println("2 = Userverwaltung öffnen");
        System.out.println("3 = Spiel aus bestehenden Vokabeln starten");
        System.out.println("4 = App sofort beenden");
        int input = askSomethingInt("Was möchten Sie tun?");

        return input;
    }

    public int askForListAction() {
        System.out.println("Was möchten Sie tun?");
        System.out.println("1 = Alle Vokabellisten anzeigen");
        System.out.println("2 = Vokabeln für bestehende Liste anzeigen (Input: ID)");
        System.out.println("3 = Neue Vokabelliste hinzufügen");
        System.out.println("4 = Vokabeln manuell zu bestehender Liste hinzufügen");
        System.out.println("5 = Textfiles zur bestehenden Vokabelliste hinzufügen");
        System.out.println("6 = Bestehende Vokabelliste löschen");
        System.out.println("7 = Ins App Menü zurückkehren");
        System.out.println("8 = App sofort beenden");
        int input = askSomethingInt("Was möchten Sie tun?");

        return input;
    }

    public String askSomethingString(String message) {
        String input = null;
        boolean rightTypOfAnswer = true;

        while (rightTypOfAnswer) {
            try {
                System.out.println(message);
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
                rightTypOfAnswer = false;

            } catch (Exception e) {
                System.out.println("Dies war leider kein String.");
                rightTypOfAnswer = true;
            }
        }

        return input;
    }

    public int askSomethingInt(String message) {
        int input = 0;
        boolean rightTypOfAnswer = true;

        while (rightTypOfAnswer) {
            try {
                System.out.println(message);
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                rightTypOfAnswer = false;

            } catch (Exception e) {
                System.out.println("Dies war leider keine Zahl.");
                rightTypOfAnswer = true;
            }

        }
        return input;
    }

    public long askSomethingLong(String message) {

        Long input = 0L;
        boolean rightTypOfAnswer = true;

        while (rightTypOfAnswer) {
            try {
                System.out.println(message);
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLong();
                rightTypOfAnswer = false;

            } catch (Exception e) {
                System.out.println("Dies war leider keine Zahl.");
                rightTypOfAnswer = true;
            }

        }
        return input;
    }

}
