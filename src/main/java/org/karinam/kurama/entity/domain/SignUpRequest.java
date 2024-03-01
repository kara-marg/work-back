package org.karinam.kurama.entity.domain;

import lombok.Data;

@Data
public class SignUpRequest {

    private String username;

    private String email;

    private String password;
}
