package com.app.easy2excel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document(collection = "User")
@Getter
@Setter
@ToString
public class User {
    @Id
    private int id;
    private String name;
    private String email;

}
