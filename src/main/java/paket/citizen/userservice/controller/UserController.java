package paket.citizen.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import paket.citizen.userservice.model.AuthRequest;
import paket.citizen.userservice.model.UsersEntity;
import paket.citizen.userservice.service.IUserService;

@RestController
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/registerUser")
    public ResponseEntity<UsersEntity> registerUser(@RequestBody AuthRequest authRequest) {
        return iUserService.registerUser(authRequest);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<AuthRequest> loginUser(@RequestBody AuthRequest authRequest) {
        return iUserService.loginUser(authRequest);
    }

}
