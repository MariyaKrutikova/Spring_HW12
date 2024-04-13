package com.example.SpringIntegrationGoFHW12.repositories;

import com.example.SpringIntegrationGoFHW12.models.Task;
import com.example.SpringIntegrationGoFHW12.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
   List<Task> findByStatus(TaskStatus status);
}
