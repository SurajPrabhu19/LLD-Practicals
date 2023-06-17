package com.scaler.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass // this helps us Map the Basemodel attrbs to Child classes
@Getter
@Setter
public class BaseModel {
    // @Column(name = "identity") // by default the name of table is basically Id
    // but you can override column name
    // using the @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
