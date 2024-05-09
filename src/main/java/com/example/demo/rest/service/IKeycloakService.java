package com.example.demo.rest.service;


import com.example.demo.dto.UserDTO;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IKeycloakService {

    List<UserRepresentation> findAllUsers();
    List<UserRepresentation> searchUserByUsername(String username);
    String createUser(UserDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
    //String login(String username, String password);
    ResponseEntity<Object> loginUser(UserDTO userDTO);
}