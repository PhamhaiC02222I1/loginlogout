package com.company.service.userprincipal;

import com.company.config.ConfigReadAndWriteFile;
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


}
