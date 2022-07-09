package com.mycompany.ems.controllers;

import com.mycompany.ems.models.Employee;
import com.mycompany.ems.models.Login;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController employeeController;
    @Autowired
    LoginController loginController;
    @Autowired
    TimesheetController timesheetController;

    @Test
    public void testCreateReadDelete(){
        List<Employee> employees=employeeController.findAll();
        int size=employees.size();
        Employee employee=new Employee("abc",764673,"dept","email","address","Admin");
        Employee employeeResult=employeeController.create(employee);
         employees=employeeController.findAll();

        Assertions.assertThat(employees).last().hasFieldOrPropertyWithValue("empName","abc");
        Assertions.assertThat(employeeController.findAll().size()==size+1);
        employeeController.delete(employeeResult.getEmpID());
    }

    @Test
    public void testLoginCreateCheckDelete(){
        Employee employee=new Employee("abc",764673,"dept","email","address","Admin");
        Login login=new Login();
        login.setEmpID(Integer.toString(1));
        login.setLoginUsername("ravi");
        login.setLoginPassword("ravi");
        login.setLoginStatus("non");
        login.setEmployee(employee);
        employee.setEmpID(1);
        System.out.println(login);
        Login loginresult=loginController.create(login);
        Assertions.assertThat(loginController.checkLogin("ravi","ravi"));
        loginController.deleteLogin(loginresult.getLoginid());
    }
}
