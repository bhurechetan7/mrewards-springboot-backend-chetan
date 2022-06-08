package com.mrewards.api.services;

import com.mrewards.api.models.EmployeeDetails;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Component
public class EmployeeService {
    BigQuery query;
    TableId tableId;

    public EmployeeService(){
        String path = "C:/Users/jaimi/OneDrive/Desktop/Miracle soft/mrewards-projects-70cbe837eb83.json";
        GoogleCredentials credentials = null;
        try (FileInputStream serviceAccountStream = new FileInputStream(path)) {
            credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        query = BigQueryOptions.newBuilder().setCredentials(credentials).setProjectId("mrewards-projects").build().getService();
        tableId= TableId.of("mRewards_DB", "employee_details");
    }

    public List<EmployeeDetails> getAllEmployees() throws InterruptedException {
        final String GET_ALL_EMPLOYEES = "SELECT * FROM `mrewards-projects.mRewards_DB.employee_details`;";
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(GET_ALL_EMPLOYEES).build();
        TableResult result = query.query(queryConfig);
        List<EmployeeDetails> allEmployees = new ArrayList<>();
        for(FieldValueList row:result.iterateAll()){
            allEmployees.add(makeEmployeeModel(row));
        }
        return allEmployees;
    }


    public List<EmployeeDetails> getEmployees(String firstname,String lastname, String department, String team, String practice,
                                              String gift_card_type, String status) throws InterruptedException{
        int flag = 0;
        String GET_ALL_EMPLOYEES = "SELECT * FROM `mrewards-projects.mRewards_DB.employee_details`  where ";

        if(firstname!=null){
            GET_ALL_EMPLOYEES += "first_name = '"+firstname+"'";
            flag = 1;
        }

        if(lastname!=null){
            if(flag == 1)
                GET_ALL_EMPLOYEES += " or ";
            GET_ALL_EMPLOYEES += "last_name = '"+lastname + "'";
            flag = 1;
        }

        if(department!=null){
            if(flag == 1)
                GET_ALL_EMPLOYEES += " or ";
            GET_ALL_EMPLOYEES += "department = "+department;
            flag = 1;
        }


        if(team!=null){
            if(flag == 1)
                GET_ALL_EMPLOYEES += " or ";
            GET_ALL_EMPLOYEES += " team = "+team;
            flag = 1;
        }


        if(practice!=null){
            if(flag == 1)
                GET_ALL_EMPLOYEES += " or ";
            GET_ALL_EMPLOYEES += "practice = "+practice;
            flag = 1;
        }


        if(gift_card_type!=null){
            if(flag == 1)
                GET_ALL_EMPLOYEES += " or ";
            GET_ALL_EMPLOYEES += "gift_card_type = "+gift_card_type;
            flag = 1;
        }


        if(status == "Active" || status == "Redeemed" || status == "PartiallyRedeemed"){
            if(flag == 1)
                GET_ALL_EMPLOYEES += " and ";
            GET_ALL_EMPLOYEES += "status = "+status;
        }
        GET_ALL_EMPLOYEES += ";";
        System.out.println(GET_ALL_EMPLOYEES);
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(GET_ALL_EMPLOYEES).build();
        TableResult result = query.query(queryConfig);
        List<EmployeeDetails> allEmployees = new ArrayList<>();
        for(FieldValueList row:result.iterateAll()){
            allEmployees.add(makeEmployeeModel(row));
        }
        return allEmployees;
    }

    private EmployeeDetails makeEmployeeModel(FieldValueList row){
        EmployeeDetails employee = new EmployeeDetails();
        employee.setEmployeeId(row.get("employee_id").getStringValue());
        employee.setFirstName(row.get("first_name").getStringValue());
        employee.setLastName(row.get("last_name").getStringValue());
        employee.setDepartment(row.get("department").getStringValue());
        employee.setDateOfJoining(new Timestamp(row.get("date_of_joining").getTimestampValue()));
        employee.setDesignation(row.get("designation").getStringValue());
        employee.setEmailId(row.get("email_id").getStringValue());
        employee.setPractice(row.get("practice").getStringValue());
        employee.setTeam(row.get("team").getStringValue());
        if(!row.get("last_issued_reward").isNull())
            employee.setLast_issued_reward(row.get("last_issued_reward").getStringValue());
        return employee;
    }

    public EmployeeDetails addNewEmployee(EmployeeDetails details){
        try {
            InsertAllResponse response = query.insertAll(InsertAllRequest.newBuilder(tableId).addRow(details.createHashMap()).build());
            if (response.hasErrors()) {
                // If any of the insertions failed, this lets you inspect the errors
                for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
                    System.out.println("Response error: \n" + entry.getValue());
                }
            }
            System.out.println("Rows successfully inserted into table");
        }catch (BigQueryException e){
            System.out.println("Insert operation not performed \n" + e.toString());
        }
        return details;
    }
}
