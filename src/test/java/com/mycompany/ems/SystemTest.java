package com.mycompany.ems;

import com.mycompany.ems.models.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class SystemTest {
    @Test
    public void testCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();
//        URI url=
        String url = "http://localhost:8080/employee";
        Employee employee=new Employee("abc",764673,"dept","email","address","Admin");
//        employee.setEmpID(10);
//        Friend friend = new Friend("Gordon", "Moore");
        ResponseEntity<Employee> entity
                = restTemplate.postForEntity(url, employee, Employee.class);
        System.out.println("1234");
        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains(
                "abc");
        System.out.println(employee.getEmpID());
        int size=restTemplate.getForObject(url, Employee[].class).length;
        restTemplate.delete(url + "/" + entity.getBody().getEmpID());
        Assertions.assertThat(restTemplate.getForObject(url, Employee[].class).length==size-1);
//        Assertions.assertThat(restTemplate.getForObject(url,
//                Employee[].class)).isEmpty();
    }

}
