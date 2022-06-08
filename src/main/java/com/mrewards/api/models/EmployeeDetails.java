package com.mrewards.api.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name="employee_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDetails {

    String employeeId;

    String firstName;
    String lastName;
    String designation;
    Timestamp dateOfJoining;
    String emailId;
    String team;
    String department;
    String practice;
    String last_issued_reward;

    public Map<String,Object> createHashMap(){
        Map<String,Object> hash = new HashMap<>();
        hash.put("employee_id",this.employeeId);
        hash.put("first_name",this.firstName);
        hash.put("last_name",this.lastName);
        hash.put("designation",this.designation);
        hash.put("date_of_joining",this.dateOfJoining);
        hash.put("email_id",this.emailId);
        hash.put("team",this.team);
        hash.put("department",this.department);
        hash.put("practice",this.practice);
        hash.put("last_issued_reward",this.last_issued_reward);
        return hash;
    }

//    public String getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(String employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    public Timestamp getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(Timestamp dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public String getTeam() {
//        return team;
//    }
//
//    public void setTeam(String team) {
//        this.team = team;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getPractice() {
//        return practice;
//    }
//
//    public void setPractice(String practice) {
//        this.practice = practice;
//    }
//
//    public String getLast_issued_reward() {
//        return last_issued_reward;
//    }
//
//    public void setLast_issued_reward(String last_issued_reward) {
//        this.last_issued_reward = last_issued_reward;
//    }
}
