package com.company.view;

import com.company.controler.ProductCategoryControler;
import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.userprincipal.UserPrincipalIMPL;
import sun.awt.geom.AreaOp;

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
   boolean checklogin=false;
    Set<Role> roleSet=userPrincipalList.get(0).getRoleSet();
    List<Role> roleList=new ArrayList<>(roleSet);

    boolean checkAdmin=roleList.get(0).getName()== RoleName.ADMIN;
    boolean checkAdmin1=roleList.get(0).getName()== RoleName.PM;
    if (userPrincipalList.size()!=0){
        checklogin=true;
    }else  checklogin=false;
    Scanner scanner=new Scanner(System.in);
    System.out.println("=============Form User Login==============");
    if (checklogin){
        System.out.println("3. Show List Role");
        System.out.println("4. Profile");
        System.out.println("5. SORT PRODUCT BY PRICE");
        System.out.println("6. FIND PRODUCT BY NAME");
        System.out.println("7. CREAT BUYPRODUCT");
        System.out.println("8. Find PRODUCT By CATAROGYNAME");
        System.out.println("9. Find PRODUCT By Price");
        System.out.println("10. SHOW PRODUCT WITH THE BEST SELLING");



        if (checkAdmin||checkAdmin1){
            System.out.println("====================PRODUCT MANAGE ADMIN===================");
            System.out.println("11. LIST USER VIEW");
            System.out.println("12. ADD PRODUCT");
            System.out.println("13. SHOW LIST PRODUCT");
            System.out.println("14. DELETE PRODUCT BY ID");
            System.out.println("15. EDIT PRODUCT BY ID");
            System.out.println("16. SORT PRODUCT BY NAME");
            System.out.println("17. ADD PRODUCTCATAGORY ");
            System.out.println("18. SHOWLIST PRODUCTCATAGORY ");
            System.out.println("19. DELETE PRODUCTCATAGORY ");
            System.out.println("20. EDIT PRODUCTCATAGORY BY ID");
            System.out.println("21. SHOWLIST BUYPRODUCT");
            System.out.println("22. Exit");
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
            new ProfileView();
            break;

        case 5:
            new ProductView().sortByPrice();
            break;

        case 6:
            new ProductView().findProductByName();
            break;

        case 7:
            new BuyProductView().createBuyProduct();
            break;

        case 8:
            new ProductView().findProductByCatarogyName();
            break;
        case 9:
            new ProductView().findProductByPriceFrom();
            break;

        case 10:
            new BuyProductView().productBest();
            break;

        case 11:
            if (checkAdmin||checkAdmin1){
                new ListUserView();
            }else {
                System.out.println("Khong du quyen truy cap");
                new Main();
            }
        case 12:
            new ProductView().createProduct();
            break;

        case 13:
            new ProductView().showListProduct();
            break;

        case 14:
            new ProductView().formDelete();
            break;

        case 15:
            new ProductView().editById();
            break;

        case 16:
            new ProductView().sortByName();
            break;

        case 17:
            new ProductCategoryView().formCreateProductCatagory();
            break;
        case 18:
            new ProductCategoryView().showProductByCatagoruName();
//new ProductCategoryControler().showListProductCategory();
//            break;
//            new ProductCategoryView().formListProductCategory();
//            break;

        case 19:
            new ProductCategoryView().formDeleteProductCatagory();
            break;
        case 20:
            new ProductCategoryView().editById();
            break;
        case 21:
            new BuyProductView().showListBuyProduct();
            break;
        case 22:
            new ProfileView();
            break;
    }

}
    public static void main(String[] args) {
	// write your code here
//        new RegisterAndLoginView();
        new Main();
    }
}
