package com.mrewards.api.controllers;


import com.mrewards.api.models.EmployeeDetails;
import com.mrewards.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("allEmployees")
    public List<EmployeeDetails> getAllEmployees(){
        try {
            return service.getAllEmployees();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("allEmployees/filter")
    @ResponseBody
    public List<EmployeeDetails> getEmployees(@RequestParam(value = "first_name",required = false) String firstname,
                                              @RequestParam(value = "last_name",required = false) String lastname,
                                              @RequestParam(value = "department",required = false) String department,
                                              @RequestParam(value = "team",required = false) String team,
                                              @RequestParam(value = "practice",required = false) String practice,
                                              @RequestParam(value = "gift_card_type",required = false) String gift_card_type,
                                              @RequestParam(value = "status",required = false) String status)
    {
        try {
            return service.getEmployees(firstname,lastname,department,team,practice,gift_card_type,status);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @PostMapping("addEmployee")
    public  EmployeeDetails addNewEmployee(@RequestBody EmployeeDetails details){
        return service.addNewEmployee(details);
    }
}
