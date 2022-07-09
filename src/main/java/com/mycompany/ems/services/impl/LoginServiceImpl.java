package com.mycompany.ems.services.impl;

import com.mycompany.ems.models.Login;
import com.mycompany.ems.repositories.LoginRepository;
import com.mycompany.ems.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository loginRepository;
    @Override
    public void addLogin(Login login) {
        loginRepository.save(login);
    }

    @Override
    public void deleteLogin(int loginId) {
       loginRepository.deleteById(loginId);
    }

    @Override
    public boolean checkLogin(String loginusername, String loginpassword) {
        if(loginRepository.checkLogin(loginusername,loginpassword).size()==1)
            return true;
        else
           return false;
    }

    @Override
    public int deleteLogin(String empId) {
        return loginRepository.deleteLogin(empId).getLoginid();
    }
}
