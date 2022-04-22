package com.company.view;

import com.company.controler.RoleControler;

import java.util.Scanner;

public class RoleView {
    Scanner scanner = new Scanner(System.in);
    RoleControler roleControler = new RoleControler();

    public void showListRole() {
        System.out.println(roleControler.showListRole());
        System.out.println("Enter quit to come back menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
}
