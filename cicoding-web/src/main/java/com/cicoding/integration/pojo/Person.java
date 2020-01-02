package com.cicoding.integration.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(fluent = true,chain = true)
public class Person implements Serializable {

    private String name = "jack";

    private int age = 10;

    private String nickName;

}
