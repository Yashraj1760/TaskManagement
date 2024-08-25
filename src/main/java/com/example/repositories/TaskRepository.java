package com.example.repositories;

import com.example.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Tasks,Integer> {

    @Query("Select t from Tasks t where t.status=?1 ")
    public List<Tasks> findTasksByStatus(String status ,String priority );

    @Query("Select t from Tasks t where t.priority=?1")
    public List<Tasks> findTasksByPriority(String priority);

    @Query("Select t from Tasks t where t.title=?1")
    public List<Tasks> findTasksByTitle(String title);

    @Query("Select t from Tasks t where t.due_date=?1")
    public List<Tasks> findTasksByDueDate(String dueDate);

}
