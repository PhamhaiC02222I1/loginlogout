package com.company.view;

import com.company.controler.UserControler;
import com.company.dto.SignInDTO;
import com.company.service.user.UserServiceIMPL;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    UserControler userControler = new UserControler();

    public LoginView() {
        System.out.println("Login form");
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        SignInDTO signInDTO = new SignInDTO(username, password);
        if (userControler.login(signInDTO)) {
            new ProfileView();
        } else {
            System.err.println("Login failed! please check username or password");
            new LoginView();
        }
    }
}
