package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String matchingPassword;
}
