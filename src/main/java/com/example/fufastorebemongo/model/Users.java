package com.example.fufastorebemongo.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "users")
@Data
@AllArgsConstructor
// @NoArgsConstructor
// @Builder
public class Users implements UserDetails {

    @Id
    private ObjectId id = new ObjectId();
    private String name;
    private String username;
    private String email;
    private String password;
    private String phone;
    private Boolean isActive = true;
    private String role;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((GrantedAuthority) () -> "ROLE_" + role);
    }

}
