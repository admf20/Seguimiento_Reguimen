package com.example.Seguimiento_Reguimen.mapper;

import com.example.Seguimiento_Reguimen.model.UserEntity;
import com.example.Seguimiento_Reguimen.model.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //recibo entidad y retorno DTO
    UserDTO EntityaDTO(UserEntity userEntity);

    //recibo DTO y retorno entidad
    UserEntity DTOaEntity(UserDTO userDTO);

    //recibo entidad y retorno List<UserDTO>
    UserDTO toListDTO(UserEntity userEntity);

}
