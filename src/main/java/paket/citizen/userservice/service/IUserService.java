package paket.citizen.userservice.service;

import org.springframework.http.ResponseEntity;
import paket.citizen.userservice.model.AuthRequest;
import paket.citizen.userservice.model.UsersEntity;

public interface IUserService {

    public ResponseEntity<UsersEntity> registerUser(AuthRequest authRequest);

    public ResponseEntity<AuthRequest> loginUser(AuthRequest authRequest);

}
