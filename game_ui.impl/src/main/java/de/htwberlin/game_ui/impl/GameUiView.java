package de.htwberlin.game_ui.impl;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GameUiView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String askForListAction(){
        System.out.println("Was möchten Sie tun?");
        System.out.println("--eins = Neue Liste anlegen");
        Scanner scanner = new Scanner(System. in);
        String input = scanner. nextLine();

        return input;
    }

    public String askSomething(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System. in);
        String input = scanner. nextLine();

        return input;
    }

}
