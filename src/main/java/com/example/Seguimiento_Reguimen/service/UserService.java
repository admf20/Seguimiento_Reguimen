package com.example.Seguimiento_Reguimen.service;

import com.example.Seguimiento_Reguimen.mapper.UserMapper;
import com.example.Seguimiento_Reguimen.model.UserEntity;
import com.example.Seguimiento_Reguimen.model.dto.UserDTO;
import com.example.Seguimiento_Reguimen.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    //todos los usuarios
    public List<UserDTO> getAllUser() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toListDTO)
                .collect(Collectors.toList());
    }

    //usuarios por ID
    public UserDTO getUserById(Long id){
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: ".concat(id.toString())));
        return userMapper.EntityaDTO(user);
    }

    //crear un usuario
    public UserDTO createdUser(UserDTO userDTO){
        //validamos el email
        if (userRepository.existsByEmail(userDTO.getEmail())){
            throw new RuntimeException("Email ya existe, valide otro");
        }
        /* EXPLICACIÓN DE DERECHA A IZQUIERDA
          1. convertimos de DTO a entidad
          2. guardamos el dato que convertimos, recuerde que el "save" nos retorna una entidad
          3. convertimos de entidad a DTO
          **/
        return userMapper.EntityaDTO(
                userRepository.save(userMapper.DTOaEntity(userDTO))
        );
    }

    //actualizar un usuario
    public UserDTO updatedUser(Long id, UserDTO userDetails){

        UserEntity user_updated = userRepository.findById(id)
                .map(UserDB -> {
                    if(!UserDB.getEmail().equals(userDetails.getEmail()) && userRepository.existsByEmail(userDetails.getEmail())){
                        throw new RuntimeException("usuario existe con el email: ".concat(userDetails.getEmail()));
                    }

                    UserDB.setUsername(userDetails.getUsername());
                    UserDB.setEmail(userDetails.getEmail());
                    UserDB.setPassword(userDetails.getPassword());
                    return userRepository.save(UserDB);
                })
                .orElseThrow(() -> new RuntimeException("usuario que desea actualizar no existe"));
        return userMapper.EntityaDTO(user_updated);
    }

    //eliminar un usuario
    public void deletedUser(Long id){
        UserEntity userDeleted = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("el usuario que desea eliminar no existe"));
        userRepository.delete(userDeleted);
    }
}
