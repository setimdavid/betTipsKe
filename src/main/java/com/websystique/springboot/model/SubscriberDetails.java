package com.websystique.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "dat_subscriber_details")
public class SubscriberDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "middle_name")
    private String middleName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "email_address")
    private String emailAddress;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "jackpot_status")
    private Integer jackpotStatus;
    @Basic
    @Column(name = "jackpot_end_date")
    private Date jackpotEndDate;
    @Basic
    @Column(name = "daily_status")
    private Integer dailyStatus;
    @Basic
    @Column(name = "daily_end_date")
    private Date dailyEndDate;
    @Basic
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Basic
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic
    @Column(name = "modified_date")
    private Timestamp modifiedDate;
    @Basic
    @Column(name = "modified_by")
    private Integer modifiedBy;

}
