package paket.citizen.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paket.citizen.userservice.model.UsersEntity;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UsersEntity, String> {

    public Optional<UsersEntity> findByPhoneNo(String phoneNo);

}
