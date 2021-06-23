package com.spring.project.bookforest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(length = 45, unique = true)
    private String email;

    private String name;
    private String password;
    private String phoneNumber;
    private String uClass = "WELCOME";
    private int purchaseAmount = 0;

    private String addr1;
    private String addr2;
    private String addrCode;

    @Column(columnDefinition = "TINYINT")
    private int admin = 0;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "TINYINT")
    private int deactivate = 0;

    @Builder
    public User(String email, String name, String password,String phoneNumber){
        this.email=email;
        this.name=name;
        this.password=password;
        this.phoneNumber=phoneNumber;

        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    public void updateInfo(String password,String phoneNumber, String addr1, String addr2, String addrCode){
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.addrCode = addrCode;
        this.updatedAt = LocalDateTime.now();
    }

    public void userClass(){
        switch ((int)this.purchaseAmount/100000){
            case 0:
                this.uClass = "WELCOME";
                break;
            case 1:
                this.uClass = "SILVER";
                break;
            case 2:
                this.uClass = "GOLD";
                break;
            case 3:
                this.uClass = "VIP";
                break;
            default:
                this.uClass = "VVIP";
                break;
        }
        this.updatedAt = LocalDateTime.now();
    }
}
