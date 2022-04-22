package com.company.service.Product;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Product;
import com.company.model.ProductCategory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductServiceIMPL implements IProductServiceIMPL {


    public static String PATH = ConfigReadAndWriteFile.Path + "product.txt";
    public static List<Product> productList = new ConfigReadAndWriteFile<Product>().readFile(PATH);

    @Override
    public List<Product> findAll() {
        new ConfigReadAndWriteFile<Product>().writeFile(PATH, productList);
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return productList.get(i);
            }
        }
        return null;
    }


    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(productList.get(i));
            }

        }
    }

    @Override
    public void editById(ProductCategory productCategory) {

    }


    @Override
    public Product findProductByName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equalsIgnoreCase(name)) {
                return productList.get(i);
            }
        }
        return null;
    }


    @Override
    public void sortByPrice() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                }
                return 1;
            }
        });
    }

    @Override
    public void sortByName() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    @Override
    public void editById(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                productList.get(i).setName(product.getName());
                productList.get(i).setProductFrom(product.getProductFrom());
                productList.get(i).setPrice(product.getPrice());
            }
        }

    }

    @Override
    public Product findByCatagoryName(String name) {
        for (int i = 0; i < productList.size(); i++) {
//
            if (name.equals(productList.get(i).getProductCategory().getName())) {


                System.out.println(productList.get(i));
            }

        }  return null;
    }

//    @Override
//    public Product findByCatagoryName(ProductCategory productCategory) {
//        int dem=0;
//        System.out.println("So luong san pham trong danh sach: "+dem);
//        for (int i = 0; i < productList.size(); i++) {
//
//            if (productCategory.getName().equals(productList.get(i).getProductCategory().getName())) {
//                dem++;
//
//                System.out.println(productList.get(i));
//            }
//        }
//        return null;
//    }

    @Override
    public Product findProductByPrice1() {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() < 5000 && productList.get(i).getPrice() > 0) {
                System.out.println(productList.get(i));

            }


        }  return null;
    }

    @Override
    public Product findProductByPrice2() {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() > 5000 && productList.get(i).getPrice() < 10000 ) {
                System.out.println(productList.get(i));
            }
        }
        return null;
    }

    @Override
    public Product findProductByPrice3() {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() > 10000) {
                System.out.println(productList.get(i));
            }
        }
        return null;
    }
}








