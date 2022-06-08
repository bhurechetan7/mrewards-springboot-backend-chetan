package com.mrewards.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transactions")
public class Transactions {
    @Id
    String adminId;
    Date issuedDate;
    int amount;
    String title;
    String status;
    String issuedTo;
}

