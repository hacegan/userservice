package paket.citizen.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import paket.citizen.userservice.dao.IUserRepository;
import paket.citizen.userservice.model.AuthRequest;
import paket.citizen.userservice.model.UsersEntity;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public ResponseEntity<UsersEntity> registerUser(AuthRequest authRequest) {

        Optional<UsersEntity> usersEntity = userRepository.findByPhoneNo(authRequest.getUsername());

        if (usersEntity.isPresent()) {//Kayıt var zaten kayıtlı diye dön
            return ResponseEntity
                    .badRequest().body(usersEntity.get());
        } else {//Kayıt yok ekleme yap

            usersEntity = Optional.of(new UsersEntity());
            usersEntity.get().setPhoneNo(authRequest.getUsername());
            usersEntity.get().setPassword(authRequest.getPassword());

            userRepository.save(usersEntity.get());

            return ResponseEntity.ok(usersEntity.get());
        }

    }

    @Override
    public ResponseEntity<AuthRequest> loginUser(AuthRequest authRequest) {

        Optional<UsersEntity> usersEntity = userRepository.findByPhoneNo(authRequest.getUsername());

        if (usersEntity.isPresent()) {//Kayıt varsa token al
            return ResponseEntity
                    .ok(authRequest);
        } else {//Kayıt yok dön
            return ResponseEntity
                    .badRequest().body(authRequest);
        }
    }
}
