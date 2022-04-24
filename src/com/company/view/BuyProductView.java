package com.company.view;

import com.company.controler.BuyProductControler;
import com.company.controler.ProductCategoryControler;
import com.company.controler.ProductControler;
import com.company.model.BuyProduct;
import com.company.model.Product;
import com.company.model.ProductCategory;
import com.company.service.BuyProduct.BuyProductServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class BuyProductView {
    Scanner scanner=new Scanner(System.in);
    BuyProductControler buyProductControler=new BuyProductControler();
    BuyProduct buyProduct=new BuyProduct();
    ProductControler productControler=new ProductControler();
    ProductCategoryControler productCategoryControler=new ProductCategoryControler();
    List<BuyProduct> buyProductList= BuyProductServiceIMPL.buyProductList;

    public void createBuyProduct()  {
        while (true){
            int count;
            if(BuyProductServiceIMPL.buyProductList.size()==0){
                count = 1;
            } else {
                count = buyProductList.get(buyProductList.size()-1).getCount()+1;
            }
            System.out.println("Enter the so luong mua: ");
            int amount=Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the ngay mua BuyProduct: ");
            String ngMua=scanner.nextLine();

            System.out.println("Enter the Id Product: ");
            int idProduct =Integer.parseInt(scanner.nextLine());
            Product product=new ProductControler().findById(idProduct);
            BuyProduct buyProduct=new BuyProduct(count,ngMua,amount,product);

            buyProductControler.creatBuyProduct(buyProduct);
            System.out.println(buyProductControler.showList());
//            double total=amount*price;
//            buyProductControler.showList();
//            System.out.println("Total is: "+total);
            System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
            String backMenu = scanner.nextLine();
            if(backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }

    }
    public void productBest(){
        System.out.println("Show Product with the best selling");
        buyProductControler.bestProduct();
//        System.out.println(buyProductControler.showList());
        System.out.println("Enter any key to continue create Product or Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }

    }

    public void showListBuyProduct()  {
        System.out.println(buyProductControler.showList());
        System.out.println("Enter QUIT to come back menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }


}
