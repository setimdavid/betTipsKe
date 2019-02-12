package com.websystique.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "log_kopo_request")
public class KopoRequest {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "service_name")
    private String serviceName;
    @Basic
    @Column(name = "business_number")
    private String businessNumber;
    @Basic
    @Column(name = "transaction_reference")
    private String transactionReference;
    @Basic
    @Column(name = "internal_transaction_id")
    private Double internalTransactionId;
    @Basic
    @Column(name = "transaction_timestamp")
    private String transactionTimestamp;
    @Basic
    @Column(name = "transaction_type")
    private String transactionType;
    @Basic
    @Column(name = "account_number")
    private String accountNumber;
    @Basic
    @Column(name = "sender_phone")
    private String senderPhone;
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
    @Column(name = "amount")
    private Double amount;
    @Basic
    @Column(name = "currency")
    private String currency;
    @Basic
    @Column(name = "kopo_signature")
    private String kopoSignature;
    @Basic
    @Column(name = "transaction_status")
    private Integer transactionStatus;
    @Basic
    @Column(name = "payment_type")
    private String paymentType;
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
    @Basic
    @Column(name = "response_status")
    private String responseStatus;
    @Basic
    @Column(name = "response_desciption")
    private String responseDesciption;
    @Basic
    @Column(name = "response_subscriber_message")
    private String responseSubscriberMessage;

}
