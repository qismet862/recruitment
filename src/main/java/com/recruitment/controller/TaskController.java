package com.recruitment.controller;

import com.recruitment.dto.response.TaskResponse;
import com.recruitment.service.TaskService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    ResponseEntity<List<TaskResponse>> getTask(@RequestHeader(name = "Authorization", required = false) String token) {
        var responseList = taskService.getTask(token);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> saveAnswer(@RequestPart("file") MultipartFile file,
                                      @PathVariable Long id,
                                      @RequestHeader(name = "Authorization", required = false) String token) {
        taskService.saveAnswer(file, id, token);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.saveAnswer(file, id, token));
    }

    @PostMapping("{id}")
    ResponseEntity<Void> createTask(@RequestPart("file") MultipartFile file,
                                    @PathVariable Long id) {
        taskService.createTask(file, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
