package com.mycompany.ems.controllers;


import com.mycompany.ems.models.Login;
import com.mycompany.ems.models.Timesheet;
import com.mycompany.ems.services.LoginService;
import com.mycompany.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public Login create(@RequestBody Login login) {
        login.setEmpID(Integer.toString(login.getEmployee().getEmpID()));
        loginService.addLogin(login);
        return login;
    }

    @GetMapping("/checklogin")
    public boolean checkLogin(@RequestParam(value = "first", required = false) String loginusername,
                              @RequestParam(value = "last", required = false) String loginpassword)
    {return loginService.checkLogin(loginusername,loginpassword);}


    @DeleteMapping("/dellogin/{id}")
    public void deleteLogin(@PathVariable int id)
    {
        loginService.deleteLogin(id);
    }
}
