package com.library.online_library.service;

import javax.servlet.http.HttpSession;

import com.library.online_library.model.StoreException;
import com.library.online_library.model.User;
import com.library.online_library.model.UserRole;

public interface UserService {

    public User login(UserRole role, String email, String password, HttpSession session) throws StoreException;

    public String register(UserRole role, User user) throws StoreException;

    public boolean isLoggedIn(UserRole role, HttpSession session);

    public boolean logout(HttpSession session);

}