package com.Hikerent.dto.request;


import com.Hikerent.enums.Role;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {


    private String username;

    private String email;

    private String password;

    private Role role;


}