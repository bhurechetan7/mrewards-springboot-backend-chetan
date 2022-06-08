package com.mrewards.api.repository;




import com.mrewards.api.models.Recipient;
import com.mrewards.api.models.Tremendous;

import java.util.ArrayList;
import java.util.List;

public class Data {


    public static List<Tremendous> tremendous() {

        List<Tremendous> tlist = new ArrayList<Tremendous>();
        tlist.add(new Tremendous(1, 11, "June-25-2022", "35$", "Email", "Submitted", new Recipient("Sharukh", "sharukh@gmail.com", "2343432343")));
        tlist.add(new Tremendous(2, 22, "July-25-2022", "35$", "Email", "Submitted", new Recipient("Salman", "salman@gmail.com", "2343432343")));
        tlist.add(new Tremendous(3, 33, "August-25-2022", "35$", "Email", "Submitted", new Recipient("Govinda", "govinda@gmail.com", "2343432343")));
        tlist.add(new Tremendous(4, 44, "September-25-2022", "35$", "Email", "Submitted", new Recipient("Mithun", " mithun@gmail.com", "2343432343")));
        tlist.add(new Tremendous(5, 55, "November-25-2022", "35$", "Email", "Submitted", new Recipient("Bobby", "bobby@gmail.com", "2343432343")));
        tlist.add(new Tremendous(6, 66, "December-25-2022", "35$", "Email", "Submitted", new Recipient("Mahesh", "mahesh@gmail.com", "2343432343")));
        return tlist;
    }
}