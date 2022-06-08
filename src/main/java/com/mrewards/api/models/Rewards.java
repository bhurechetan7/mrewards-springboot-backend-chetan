package com.mrewards.api.models;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rewards")
public class Rewards {
    String employee_id;
    String gift_card_type;
    String gift_card_status;
    String reason;
    Date date_of_transaction;
    int amount;
    String custom_message;
    String comments;
    Date  redeemed_date;
}