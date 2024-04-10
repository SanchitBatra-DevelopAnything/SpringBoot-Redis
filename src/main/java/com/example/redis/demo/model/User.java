package com.example.redis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
//@Data handles all , getters setters equalsAndHashCode @TOsTRING ETC
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    //serialize hoga cuz we need to store it in redis , and redis cant understand direct java objects.
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;
}
