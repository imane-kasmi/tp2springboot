package org.example.tp2springboot.service;

import org.example.tp2springboot.model.Task;
import org.example.tp2springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository ;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public  Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    public Task updateTask(Long id, Task updatedTask){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
