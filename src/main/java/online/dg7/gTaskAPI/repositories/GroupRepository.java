package online.dg7.gTaskAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import online.dg7.gTaskAPI.models.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {
    
}
