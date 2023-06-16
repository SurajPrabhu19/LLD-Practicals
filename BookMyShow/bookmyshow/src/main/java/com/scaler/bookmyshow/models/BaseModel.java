package com.scaler.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass // this helps us Map the Basemodel attrbs to Child classes
public class BaseModel {
    @Id
    // @Column(name = "identity") // by default the name of table is basically Id
    // but you can override column name
    // using the @Column
    private long id;
}
