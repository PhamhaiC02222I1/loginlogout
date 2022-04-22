package com.company.service.ProductCategory;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Product;
import com.company.model.ProductCategory;
import com.company.service.Product.ProductServiceIMPL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ProductCategoryServiceIMPL implements IProductCategoryServiceIMPL {
//    public static String PATH = "C:\\Users\\ASUS\\Downloads\\MD2-Read-File-Generic-Multiple-master\\MD2-Read-File-Generic-Multiple-master\\src\\com\\company\\data\\product.txt";
    public static String PATH1 = ConfigReadAndWriteFile.Path+"productcatagory.txt";

    public static List<ProductCategory> productCategoryList = new ConfigReadAndWriteFile<ProductCategory>().readFile(PATH1);


    @Override
    public List<Product> findbyNameCatarogy(String name) {

        List<Product> productList=new ArrayList<>();
        for (int i = 0; i < new ProductServiceIMPL().findAll().size(); i++) {
            if (name.equals(new ProductServiceIMPL().findAll().get(i).getProductCategory().getName())){

                productList.add(new ProductServiceIMPL().findAll().get(i));
            }
        }
        return productList;
    }

    @Override
    public List<ProductCategory> findAll() {
        new ConfigReadAndWriteFile<ProductCategory>().writeFile(PATH1, productCategoryList);
        return productCategoryList;
    }

    @Override
    public ProductCategory findByCatarogyName(String name) {
        for (int i = 0; i < productCategoryList.size(); i++) {
            if (productCategoryList.get(i).getName().equalsIgnoreCase(name)){
                return productCategoryList.get(i);
            }
        }
        return null;
    }

    @Override
    public void save(ProductCategory productCategory) {
        productCategoryList.add(productCategory);

    }

    @Override
    public ProductCategory findById(int id) {
        for (int i = 0; i < productCategoryList.size(); i++) {
            if (id == productCategoryList.get(i).getId()) {
                return productCategoryList.get(i);
            }
        }

        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productCategoryList.size(); i++) {
            if (id == productCategoryList.get(i).getId()) {
                productCategoryList.remove(productCategoryList.get(i));
            }
        }


    }

    @Override
    public void editById(ProductCategory productCategory) {
        for (int i = 0; i < productCategoryList.size(); i++) {
            if (productCategory.getId()==productCategoryList.get(i).getId()){
                productCategoryList.get(i).setName(productCategory.getName());
            }
        }
    }

    @Override
    public void editById(Product product) {

    }


    @Override
    public void sortByName() {
//        Collections.sort(productCategoryList, new Comparator<ProductCategory>() {
//            @Override
//
//            public int compare(ProductCategory o1, ProductCategory o2) {
//                return o1.getName().compareToIgnoreCase(o2.getName());
//            }
//
//
//        });

    }

    @Override
    public void sortByPrice() {

    }

    @Override
    public ProductCategory findProductByName(String name) {
        return null;
    }

}