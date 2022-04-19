package com.company.service.user;

import com.company.model.User;
import com.company.service.IServiceGeneric;

import java.lang.ref.SoftReference;

public interface IUserService extends IServiceGeneric<User> {
    boolean existedByUsername(String username);
    boolean checkLogin(String username, String password);
    User findByUsername(String username);
}
