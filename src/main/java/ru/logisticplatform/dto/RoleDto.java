package ru.logisticplatform.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.modelmapper.ModelMapper;
import ru.logisticplatform.model.user.Role;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO class for user requests by USER_ROLE
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDto {

    private Long id;
    private String name;

    public static Role toRole(RoleDto roleDto){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(roleDto, Role.class);
    }

    public static RoleDto fromRole(Role role) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(role, RoleDto.class);
    }

    public static List<RoleDto> fromRole(List<Role> roles){
        return roles.stream().map(entity -> fromRole(entity)).collect(Collectors.toList());
    }
}