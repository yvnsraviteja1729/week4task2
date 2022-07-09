package com.mycompany.ems.controllers;
import com.mycompany.ems.models.Employee;
import com.mycompany.ems.services.EmployeeService;
import com.mycompany.ems.services.LoginService;
import com.mycompany.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private LoginService loginService;
    @GetMapping("/employee")
    List<Employee> findAll() {
        return employeeService.listEmployees();
    }

    @PostMapping("/employee")
    Employee create(@RequestBody Employee emp)
    {   if(emp.getEmpName().isEmpty())
        throw new ValidationException("Input Fields are empty");
        else
        employeeService.addEmployee(emp);
        return emp;
    }

    @GetMapping("/getemployee/{id}")
    Employee getEmployeee(@RequestBody int id)
    {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employee")
    Employee updateEmp(@RequestBody Employee emp)
    {  if(employeeService.existById(emp.getEmpID()))
        employeeService.updateEmployee(emp);
        else
        throw new ValidationException("Employee does not exist with that employee id");
    return emp;
    }

    @DeleteMapping("/employee/{id}")
    void delete(@PathVariable Integer id)
    {if(employeeService.existById(id))
    {try {
        List<Integer> ls=timesheetService.gettsidByempId(id);
        for (int i=0;i<ls.size();i++) {
            timesheetService.deleteTimesheet(ls.get(i));
        }
        int lgid=loginService.deleteLogin(Integer.toString(id));
        loginService.deleteLogin(lgid);
    }catch (Exception e)
    {}

        employeeService.deleteEmployee(id);
    }
    else
        throw new ValidationException("Employee does not exist with that employee id");
    }

    @GetMapping("/getrole")
    String getEmpRole(@RequestParam(value = "empID", required = false) int empID)
    {return employeeService.getRole(empID).get(0).getEmpRole();}

    @GetMapping("/getname")
    List<Employee> getEmpName(String empName)
    {   return employeeService.searchEmployee(empName);}

}