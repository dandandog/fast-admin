package pers.dandandog.admin.model.params;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginParams implements Serializable {

    private String username;

    private String password;

    private boolean rememberMe;

}
