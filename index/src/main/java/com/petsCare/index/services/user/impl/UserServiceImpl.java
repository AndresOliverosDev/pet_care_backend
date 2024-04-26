package com.petsCare.index.services.user.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petsCare.index.dto.user.UserAddDTO;
import com.petsCare.index.models.UserEntity;
import com.petsCare.index.models.rol.RolEntity;
import com.petsCare.index.repositories.rol.RolRepository;
import com.petsCare.index.repositories.user.UserRepository;
import com.petsCare.index.services.user.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public ResponseEntity<String> userAdd(UserAddDTO userDTO) {
        try {
            Set<RolEntity> existingRoles = new HashSet<>();
            for (String rolName : userDTO.getRoles_names()) {
                RolEntity existingRol = rolRepository.findByName(rolName);
                if (existingRol != null) {
                    existingRoles.add(existingRol);
                } else {
                    // Si alguno de los roles no existe, retornar una respuesta de error
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("El Rol ingresado '" + rolName + "' no existe en la base de datos");
                }
            }

            // Crear el usuario después de verificar todos los roles
            UserEntity user = new UserEntity();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEnable(userDTO.isEnable());
            user.setAccountNoExpired(userDTO.isCredentialNoExpired());
            user.setAccountNoLocked(userDTO.isAccountNoLocked());
            user.setCredentialNoExpired(userDTO.isCredentialNoExpired());
            user.setNames(userDTO.getNames());
            user.setSurnames(userDTO.getSurnames());
            user.setAddress(userDTO.getAddress());
            user.setPhone(userDTO.getPhone());
            user.setRoles(existingRoles);

            userRepository.save(user);
            return ResponseEntity.ok("El usuario " + userDTO.getNames() + " se creó correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario");
        }
    }

}
