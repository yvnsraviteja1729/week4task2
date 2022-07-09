package com.mycompany.ems.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 // * @Data is a convenient shortcut annotation that bundles the features of
 // * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;
    @Column(name = "empname")
    private String empName;
    @Column(name = "empcontact")
    private long empContact;
    @Column(name = "empdepartment")
    private String empDepartment;
    @Column(name = "empemail")
    private String empEmail;
    @Column(name = "empaddress")
    private String empAddress;
    @Column(name = "emprole")
    private String empRole;

//    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "employee")
//    private Login login;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Timesheet> timesheet = new ArrayList<>();

    //
//
//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Timesheet> timesheet = new ArrayList<>();
//    public Employee(String empName, long empContact, String empDepartment, String empEmail, String empAddress, String empRole, Login login) {
//        this.empName = empName;
//        this.empContact = empContact;
//        this.empDepartment = empDepartment;
//        this.empEmail = empEmail;
//        this.empAddress = empAddress;
//        this.empRole = empRole;
//        this.login = login;
//    }
    public Employee(String empName, long empContact, String empDepartment, String empEmail, String empAddress, String empRole) {
        this.empName = empName;
        this.empContact = empContact;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.empRole = empRole;
    }

}
