package com.company.view;

import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalIMPL;

import java.util.List;
import java.util.Scanner;

public class ProfileView {
    Scanner scanner=new Scanner(System.in);
    List<UserPrincipal> userPrincipalList=UserPrincipalIMPL.userPrincipalList;
    UserPrincipalIMPL userPrincipalIMPL=new UserPrincipalIMPL();
    public ProfileView(){
        if (userPrincipalList.size()!=0){
            System.out.println("Welcome "+userPrincipalList.get(0).getName());
            System.out.println("1. Log Out");
        }else {
            System.out.println("Please login again!");

        }
        System.out.println("2. Back to menu");
        int chooseProfile=scanner.nextInt();
        switch (chooseProfile){
            case 1:lofOut();
                new RegisterAndLoginView();
            case 2:
                new Main();


        }
        String backMenu=scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public void lofOut(){
        UserPrincipalIMPL.userPrincipalList.clear();
        userPrincipalIMPL.findAll();

    }
}
