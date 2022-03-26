package com.tuyennguyen.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String fullName;

    private String username;

    private String password;

    @ElementCollection
    @CollectionTable(name = "tbl_user_role", joinColumns = @JoinColumn(columnDefinition = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

}
