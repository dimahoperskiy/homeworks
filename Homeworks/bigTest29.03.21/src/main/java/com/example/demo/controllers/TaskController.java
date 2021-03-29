package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.services.TaskService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/api/tasks")
    public ResponseEntity<?> create(@RequestBody Task task) {
//        userService.findById(task.getUserId()).map(user -> {
//            List<Task> list = user.getTaskList();
//            list.add(task);
//            user.setTaskList(list);
//            userService.create(user);
//            return 1;
//        });
        task.setUser(userService.findById(task.getUser_id()).orElseThrow());
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> findAll() {
        final List<Task> taskList = taskService.findAll();

        return taskList != null && !taskList.isEmpty()
                ? new ResponseEntity<>(taskList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable(name = "id") Long id) {
        final Optional<Task> task = taskService.findById(id);

        return task.isPresent()
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
