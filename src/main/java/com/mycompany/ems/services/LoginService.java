package com.mycompany.ems.services;

import com.mycompany.ems.models.Login;

public interface LoginService {

    void addLogin(Login login);

    void deleteLogin(int empId);

    boolean checkLogin(String loginusername,String loginpassword);

    public int deleteLogin(String empId);
}
