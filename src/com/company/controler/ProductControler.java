package com.company.controler;

import com.company.model.Product;
import com.company.model.ProductCategory;
import com.company.service.Product.IProductServiceIMPL;
import com.company.service.Product.ProductServiceIMPL;

import java.util.List;

public class ProductControler {
    IProductServiceIMPL productServiceIMPL=new ProductServiceIMPL();
    public List<Product> showListProduct(){
        return productServiceIMPL.findAll();
    }
    public void creatProduct(Product product){
        productServiceIMPL.save(product);
    }
    public void findProductByCatagoryName(String name){
        productServiceIMPL.findByCatagoryName(name);
    }
    public void findProductByPrice1(){
        productServiceIMPL.findProductByPrice1();
    }
    public void findProductByPrice2(){
        productServiceIMPL.findProductByPrice2();
    }
    public void findProductByPrice3(){
        productServiceIMPL.findProductByPrice3();
    }
    public void deleteById(int id){
        productServiceIMPL.deleteById(id);
    }
    public void editById(Product product){
        productServiceIMPL.editById(product);
    }
    public  void sortByName(){
        productServiceIMPL.sortByName();
    }
    public void sortByPrice(){
        productServiceIMPL.sortByPrice();
    }
    public Product findById(int id){
        return productServiceIMPL.findById(id);
    }

    public Product findProductByName(String name) {
        return productServiceIMPL.findProductByName(name);
    }
}
