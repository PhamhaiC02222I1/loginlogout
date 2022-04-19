package com.company.view;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
public Main(){
if (UserPrincipalIMPL.userPrincipalList.size()==0){
    new LoginView();

}
    List<UserPrincipal> userPrincipalList= UserPrincipalIMPL.userPrincipalList;
//    if (userPrincipalList.size()==0){
//        new Main();
//    }
   boolean checklogin=false;
    Set<Role> roleSet=userPrincipalList.get(0).getRoleSet();
    List<Role> roleList=new ArrayList<>(roleSet);
//        System.out.println("rolelist===-==="+roleList);
    boolean checkAdmin=roleList.get(0).getName()== RoleName.ADMIN;
    if (userPrincipalList.size()!=0){
        checklogin=true;
    }else  checklogin=false;
    Scanner scanner=new Scanner(System.in);
    System.out.println("=============Form Register Login==============");
    if (checklogin){
        System.out.println("3. Show List Role");
//        System.out.println("4. ListUserView");
        System.out.println("5. Profile");

        if (checkAdmin){
            System.out.println("4. LIST USER");
        }
    }else {
        System.out.println("1. Register");
        System.out.println("2. Login");
    }


    System.out.println("Enter number: ");
    int chooseMenu=scanner.nextInt();
    switch (chooseMenu){
        case 1:
            new RegisterView().register();
            break;
        case 2:
            new LoginView();
            break;
        case 3:
            new RoleView().showListRole();
            break;
        case 4:
          if (checkAdmin){
              new ListUserView();
          }else {
              System.out.println("Khong du quyen truy cap");
              new Main();
          }


        case 5:
            new ProfileView();
            break;
    }

}
    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
