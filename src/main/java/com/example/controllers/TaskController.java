package com.example.controllers;

import com.example.entities.Tasks;
import com.example.exception.TaskException;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api")
public class TaskController {
    @Autowired
    private TaskService taskService;


    @PostMapping("/tasks")
    public ResponseEntity<Tasks> createTasks(@RequestBody Tasks task){
        Tasks tasks = taskService.createTask(task);
        return new ResponseEntity<>(tasks, HttpStatus.CREATED);

    }
    @GetMapping("/tasks")
    public ResponseEntity<List<Tasks>> getTasks(){
        List<Tasks> tasksList = taskService.getTasks();
        return new ResponseEntity<>(tasksList,HttpStatus.FOUND);

    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable int id , @RequestBody
                                            Tasks tasks) throws TaskException {
        Tasks t1 = taskService.updateTaskById(id,tasks);
        return new ResponseEntity<>(t1,HttpStatus.OK);
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Tasks> deleteTask(@PathVariable int id) throws TaskException {
        Tasks t1 = taskService.deleteTaskByid(id);
        return new ResponseEntity<>(t1,HttpStatus.GONE);
    }
    @GetMapping("/task/status")
    public ResponseEntity<List<Tasks>> getTaskBystatusAndPriority(@RequestParam("status") String status ,@RequestParam("priority") String priority
    ) throws TaskException {
        List<Tasks> t1 = taskService.getTaskByStatus(status,priority);
        return new ResponseEntity<>(t1,HttpStatus.FOUND);
    }
    @GetMapping("/task/priority")
    public ResponseEntity<List<Tasks>> getTaskByPriority(@RequestParam("priority") String priority
    ) throws TaskException {
        List<Tasks> t1 = taskService.getTaskByPriority(priority);
        return new ResponseEntity<>(t1,HttpStatus.FOUND);
    }

    @GetMapping("/task/title")
    public ResponseEntity<List<Tasks>> getTaskBytitle(@RequestParam("title") String title
    ) throws TaskException {
        List<Tasks> t1 = taskService.getTaskByTitle(title);
        return new ResponseEntity<>(t1,HttpStatus.FOUND);
    }

    @GetMapping("/task/dueDate")
    public ResponseEntity<List<Tasks>> getTaskByDueDate(@RequestParam("duedate") String dueDate
    ) throws TaskException {
        List<Tasks> t1 = taskService.getTaskByDueDate(dueDate);
        return new ResponseEntity<>(t1,HttpStatus.FOUND);
    }
}
