package com.scaler.splitwise.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Group extends BaseModel {
    private String grpName;
    private String description;
    private double amount;

    private Date createdAt;
    // 1G can_be_created_by 1U
    // 1U can_create mG
    @ManyToOne
    private User createdBy;

    // 1Grp can_have mParti
    // 1parti can_be_present mGrps
    @ManyToMany
    private List<User> participants;

    // 1G can_have mAdmins
    // 1Admin can_be_present mGrp
    @ManyToMany
    private List<User> admins;

    // 1G -> mE
    // 1E -> 1G;
    @OneToMany
    private List<Expense> expenses;

    //
}
