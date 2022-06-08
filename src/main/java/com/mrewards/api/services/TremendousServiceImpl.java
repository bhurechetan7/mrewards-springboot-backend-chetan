package com.mrewards.api.services;

import com.mrewards.api.models.Tremendous;
import com.mrewards.api.repository.Data;

import java.util.List;
@org.springframework.stereotype.Service
public class TremendousServiceImpl implements TremendousService {


    @Override
    public List<Tremendous> getTremendousData() {

        Data data = new Data();
        List<Tremendous> d = data.tremendous();

        return d;


    }
}
