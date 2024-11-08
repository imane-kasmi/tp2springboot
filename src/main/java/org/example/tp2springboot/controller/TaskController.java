package org.example.tp2springboot.controller;

import org.example.tp2springboot.model.Task;
import org.example.tp2springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    @PutMapping("/{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task updatedTask){
        return taskService.updateTask(id,updatedTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id){
         taskService.deleteTask(id);
    }

}
