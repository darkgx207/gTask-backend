package online.dg7.gTaskAPI.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import online.dg7.gTaskAPI.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
    @Query("FROM Tasks u WHERE u.id = :id")
    public Task getTask(int id);
}
