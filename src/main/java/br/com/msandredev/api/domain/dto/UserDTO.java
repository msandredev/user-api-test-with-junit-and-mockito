package br.com.msandredev.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter @Getter
@AllArgsConstructor
@N
public class UserDTO {
    private Integer id;
    private String fullName;
    private String email;
    private String password;
}
