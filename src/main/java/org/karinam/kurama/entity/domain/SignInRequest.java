package org.karinam.kurama.entity.domain;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;

    private String password;
}