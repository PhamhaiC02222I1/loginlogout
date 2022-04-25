package com.company.controler;

import com.company.dto.SignInDTO;
import com.company.dto.SignUpDTO;
import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.User;
import com.company.model.UserPrincipal;
import com.company.service.role.RoleServiceIMPL;
import com.company.service.user.UserServiceIMPL;
import com.company.service.userprincipal.UserPrincipalIMPL;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;

public class UserControler {
    UserServiceIMPL userServiceIMPL=new UserServiceIMPL();
    RoleServiceIMPL roleServiceIMPL=new RoleServiceIMPL();
    UserPrincipalIMPL userPrincipalIMPL=new UserPrincipalIMPL();
    public void register(SignUpDTO signUpDTO){
        int id;
        if (UserServiceIMPL.userList.size()==0){
            id=1;
        }else {
            id=UserServiceIMPL.userList.get(UserServiceIMPL.userList.size()-1).getId()+1;

        }
        Set<String> strRole=signUpDTO.getStrRole();
        Set<Role> roleSet=new HashSet<>();
        strRole.forEach(role ->{
            switch (role){
                case "admin":
                    Role adminRole=roleServiceIMPL.findByName(RoleName.ADMIN);
                    roleSet.add(adminRole);
                    break;
                case "pm":
                    Role pmRole=roleServiceIMPL.findByName(RoleName.PM);
                    roleSet.add(pmRole);
                    break;
                case "user":
                    Role userRole=roleServiceIMPL.findByName(RoleName.USER);
                    roleSet.add(userRole);
                    break;
            }
    });
        User user=new User(id, signUpDTO.getName(), signUpDTO.getUsername(), signUpDTO.getPassword(), roleSet);
       userServiceIMPL.save(user);
       userServiceIMPL.findAll();
}
public boolean login(SignInDTO signInDTO){
        if (userServiceIMPL.checkLogin(signInDTO.getName(), signInDTO.getPassword())){
            User user=userServiceIMPL.findByUsername(signInDTO.getName());
            UserPrincipal userPrincipal=new UserPrincipal(user.getId(), user.getName(), user.getUsername(), user.getPassword(),user.getRoleset());
            userPrincipalIMPL.save(userPrincipal);
            userPrincipalIMPL.findAll();

            return true;
        }else return false;


}
}
