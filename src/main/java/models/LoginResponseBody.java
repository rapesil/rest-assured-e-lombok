package models;

import lombok.Data;

@Data
public class LoginResponseBody {

    private String message;
    private String authorization;
}
