package com.mycompany.ems.controllers;

import com.mycompany.ems.models.Employee;
import com.mycompany.ems.models.Timesheet;
import com.mycompany.ems.services.EmployeeService;
import com.mycompany.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping("/timesheet")
    public List<Timesheet> listAllTimesheet() {
        return timesheetService.listTimesheet();
    }

    @GetMapping("/gettimesheets/{timesheedid}")
    public List<Timesheet> getAllTimesheet(@PathVariable int timesheedid) {
        return timesheetService.getTimesheet(timesheedid);
    }


    @PostMapping("/timesheet")
    public Timesheet create(@RequestBody Timesheet timesheet) {

        timesheetService.addTimesheet(timesheet);
        return timesheet;
    }

    @PutMapping("/timesheet")
    Timesheet updateTimesheet(@RequestBody Timesheet timesheet)
    {
        timesheetService.updateTimesheet(timesheet);
        return timesheet;
    }

    @DeleteMapping("/timesheet/{timesheedid}")
    public void deleteTimesheet(@PathVariable int timesheedid)
    {
        timesheetService.deleteTimesheet(timesheedid);
    }
}
