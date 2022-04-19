package com.company.service.role;

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
    public Role findByName(RoleName name) {
        for (int i = 0; i <roleList.size(); i++) {
            if (name==roleList.get(i).getName()){
                return roleList.get(i);
            }
        }
        return null;
    }
}
