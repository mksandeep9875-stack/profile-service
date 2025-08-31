package com.menon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
@Getter
@Setter
@ToString
public class Profile
{
    @Id
    String phone;
    String firstname;
    String lastname;
    String email;
    String address;
    String city;
    String state;

}
