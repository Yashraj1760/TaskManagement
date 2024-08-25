package com.example.service;

import com.example.entities.Tasks;
import com.example.exception.TaskException;
import com.example.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskdao;

    public Tasks createTask(Tasks task){
        Tasks t1 = taskdao.save(task);
        return t1;
    }

    public List <Tasks> getTasks(){
        List<Tasks> t1 = taskdao.findAll();
        return t1;
    }

    public Tasks updateTaskById(int id,Tasks task) throws TaskException {
        Optional<Tasks> t1 = taskdao.findById(id);
        if (t1.isPresent()){
            Tasks existTask = t1.get();
            existTask.setTitle(task.getTitle());
            existTask.setDescription(task.getDescription());
            existTask.setStatus(task.getStatus());
            existTask.setPriority(task.getPriority());
            existTask.setDue_date(task.getDue_date());
            return taskdao.save(existTask);

        }else {
            throw new TaskException("task does not exists");
        }

    }
     public Tasks deleteTaskByid(int id) throws TaskException {
        Optional<Tasks> t1 = taskdao.findById(id);
        if (t1.isPresent()) {
            taskdao.delete(t1.get());
            return t1.get();
        }else {
            throw new TaskException("task does not exists");
        }
     }

     public List<Tasks> getTaskByStatus(String status , String priority) throws TaskException {
        List<Tasks >t1 = taskdao.findTasksByStatus(status , priority );
        if (!t1.isEmpty()){
            return t1;
        }else{
            throw new TaskException("task does not exist with this status");
        }
     }
    public List<Tasks> getTaskByPriority(String priority) throws TaskException {
        List<Tasks> t1 = taskdao.findTasksByPriority(priority);
        if (!t1.isEmpty()){
            return t1;
        }else{
            throw new TaskException("task does not exist with this priority");
        }
    }

    public List<Tasks> getTaskByTitle(String title) throws TaskException {
        List<Tasks> t1 = taskdao.findTasksByPriority(title);
        if (!t1.isEmpty()){
            return t1;
        }else{
            throw new TaskException("task does not exist with this title");
        }
    }
    public List<Tasks> getTaskByDueDate(String duedate) throws TaskException {
        List<Tasks> t1 = taskdao.findTasksByDueDate(duedate);
        if (t1.isEmpty()){
            return  t1 ;
        }else{
            throw new TaskException("task does not exist with this DueDate");
        }
    }


}
