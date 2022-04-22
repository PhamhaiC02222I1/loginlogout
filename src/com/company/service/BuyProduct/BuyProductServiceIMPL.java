package com.company.service.BuyProduct;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.BuyProduct;
import com.company.model.Product;
import com.company.model.ProductCategory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuyProductServiceIMPL implements IBuyProductServiceIMPL{
    public static String PATH=ConfigReadAndWriteFile.Path+"buy.txt";
    public static  List<BuyProduct> buyProductList=new ConfigReadAndWriteFile<BuyProduct>().readFile(PATH);


    @Override
    public List<BuyProduct> findAll() {
        new ConfigReadAndWriteFile<BuyProduct>().writeFile(PATH,buyProductList);
        return buyProductList;
    }

    @Override
    public void save(BuyProduct buyProduct) {buyProductList.add(buyProduct);

    }

    @Override
    public BuyProduct findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void editById(ProductCategory productCategory) {

    }

    @Override
    public void editById(Product product) {

    }

    @Override
    public void sortByName() {

    }

    @Override
    public void sortByPrice() {
        Collections.sort(buyProductList, new Comparator<BuyProduct>() {
            @Override
            public int compare(BuyProduct o1, BuyProduct o2) {
                if (o1.getAmount()> o2.getAmount()){
                    return -1;
                }
                return 1;
            }

        });

    }

    @Override
    public BuyProduct findProductByName(String name) {
        return null;
    }
}
