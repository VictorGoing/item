package com.example.item.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String userLogin;
    private String userPassword;
}
