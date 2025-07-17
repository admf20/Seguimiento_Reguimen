package com.example.Seguimiento_Reguimen.controller;

import com.example.Seguimiento_Reguimen.model.dto.UserDTO;
import com.example.Seguimiento_Reguimen.service.UserService;
import com.example.Seguimiento_Reguimen.util.ApiRespose;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiRespose<List<UserDTO>>> getAllUser(){
        List<UserDTO> users = userService.getAllUser();

        ApiRespose<List<UserDTO>> response = new ApiRespose<>(
                HttpStatus.OK.value(),
                "usuarios obtenidos",
                users
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiRespose<UserDTO>> getUserById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id);

        ApiRespose<UserDTO> response = new ApiRespose<>(
                HttpStatus.OK.value(),
                "usuario obtenido",
                userService.getUserById(id)
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiRespose<UserDTO>> createdUser(@Valid @RequestBody UserDTO new_userDTO){
        LOG.info("DTO recibido: {}", new_userDTO); // Ver qué llega
        UserDTO USER = userService.createdUser(new_userDTO);

        ApiRespose<UserDTO> response = new ApiRespose<>(
                HttpStatus.CREATED.value(),
                "usuario creado correctamente",
                USER
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiRespose<UserDTO>> updatedUser(@Valid @RequestBody UserDTO user_detailsDTO, @PathVariable Long id){
        ApiRespose<UserDTO> response = new ApiRespose<>(
                HttpStatus.OK.value(),
                "usuario actualizado",
                userService.updatedUser(id, user_detailsDTO)
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiRespose<Void>> deletedUser(@PathVariable Long id){
        userService.deletedUser(id);
        ApiRespose<Void> response = new ApiRespose<>(
                HttpStatus.NO_CONTENT.value(),
                "usuario eliminado",
                null
        );
        return ResponseEntity.ok(response);
    }
}
