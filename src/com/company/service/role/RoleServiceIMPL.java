package com.company.service.role;

import com.company.model.Product;
import com.company.model.ProductCategory;
import com.company.model.Role;
import com.company.model.RoleName;
import com.company.config.ConfigReadAndWriteFile;

import java.util.List;

public class RoleServiceIMPL implements IRoleService{
    public static String Path= ConfigReadAndWriteFile.Path+"role.txt";
    public static List<Role> roleList=new ConfigReadAndWriteFile<Role>().readFile(Path);


    @Override
    public List<Role> findAll() {
        if (roleList.size()>=3){
            return roleList;
        }else {
            roleList.add(new Role(1,RoleName.USER));
            roleList.add(new Role(2,RoleName.PM));
            roleList.add(new Role(3,RoleName.ADMIN));
        }
        new ConfigReadAndWriteFile<Role>().writeFile(Path,roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
roleList.add(role);
    }

    @Override
    public Role findById(int id) {
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
    public Role findProductByName(String name) {
        return null;
    }

    @Override
    public Role findByName(RoleName name) {
        for (int i = 0; i <roleList.size(); i++) {
            if (name==roleList.get(i).getName()){
                return roleList.get(i);
            }
        }
        return null;
    }
}
