package online.dg7.gTaskAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import online.dg7.gTaskAPI.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
