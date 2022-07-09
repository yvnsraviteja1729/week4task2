package com.mycompany.ems.repositories;

import com.mycompany.ems.models.Login;
import com.mycompany.ems.models.Timesheet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoginRepository extends CrudRepository<Login,Integer> {
    @Query("SELECT s FROM Login s WHERE s.loginUsername=?1 AND s.loginPassword=?2")
    public List<Login> checkLogin(String loginusername,String loginpassword);

    @Query("SELECT s FROM Login s WHERE s.empID=?1")
    public Login deleteLogin(String empId);
}
