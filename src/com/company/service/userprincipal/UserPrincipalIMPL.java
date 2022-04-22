package com.company.service.userprincipal;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Product;
import com.company.model.ProductCategory;
import com.company.model.UserPrincipal;

import java.util.List;

public class UserPrincipalIMPL implements IUserprincipamService {
    public static String PATH= ConfigReadAndWriteFile.Path+"userprincipal.txt";
    public static List<UserPrincipal> userPrincipalList=new ConfigReadAndWriteFile<UserPrincipal>().readFile(PATH);

    @Override
    public List<UserPrincipal> findAll() {
        new ConfigReadAndWriteFile<UserPrincipal>().writeFile(PATH,userPrincipalList);

        return userPrincipalList;
    }
    @Override
    public void save(UserPrincipal userPrincipal) {
        userPrincipalList.clear();
        userPrincipalList.add(userPrincipal);
    }

    @Override
    public UserPrincipal findById(int id) {
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

    }

    @Override
    public UserPrincipal findProductByName(String name) {
        return null;
    }


}
