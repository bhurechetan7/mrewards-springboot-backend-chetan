package com.mrewards.api.controllers;

import com.mrewards.api.models.Tremendous;
import com.mrewards.api.services.TremendousServiceImpl;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/tremendous")
public class TremendousController {

    @Autowired
    TremendousServiceImpl service ;

    @GetMapping("/")
    public ResponseEntity<List<Tremendous>> getAllTremendousData(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTremendousData());

    }

}
