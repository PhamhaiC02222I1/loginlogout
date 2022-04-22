package com.company.service.user;

import com.company.model.Product;
import com.company.model.ProductCategory;
import com.company.model.User;
import com.company.config.ConfigReadAndWriteFile;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    public static String PathUser = ConfigReadAndWriteFile.Path + "user.txt";
    public static List<User> userList = new ConfigReadAndWriteFile<User>().readFile(PathUser);

    @Override
    public User findByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())) {
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeFile(PathUser, userList);
        return userList;
    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(User user) {

        userList.add(user);
    }

    @Override
    public User findById(int id) {
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
    public User findProductByName(String name) {
        return null;
    }
}
