package com.recruitment.service;

import com.recruitment.dto.response.TaskResponse;
import com.recruitment.entity.TaskEntity;
import com.recruitment.entity.UserEntity;
import com.recruitment.exception.CustomBadRequestException;
import com.recruitment.exception.CustomNotFoundException;
import com.recruitment.file.FileSaver;
import com.recruitment.mapper.TaskMapper;
import com.recruitment.repository.TaskRepository;
import com.recruitment.repository.TokenRepository;
import com.recruitment.repository.UserRepository;
import com.recruitment.util.CurrentUser;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    private final TokenRepository tokenRepository;

    private final FileSaver fileSaver;

    private final UserRepository userRepository;

    public List<TaskResponse> getTask(String token) {
        UserEntity user = new CurrentUser(tokenRepository).currentUser(token);
        var tasks = taskRepository.findByUser(user);
        return taskMapper.toResponse(tasks);
    }

    public String saveAnswer(MultipartFile file, Long id, String token) {
        UserEntity currentUser = new CurrentUser(tokenRepository).currentUser(token);
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("Task Not Found"));
        if (task.getUser().getId() != currentUser.getId()) {
            throw new IllegalArgumentException();
        }
        if (task.getAnswerUrl() != null) {
            fileSaver.deleteFile(task.getAnswerUrl());
        }
        String path = "\\task-answer\\";

        String filePath = fileSaver.saveAndGetPath(file, path);
        task.setAnswerUrl(filePath);
        taskRepository.save(task);
        return filePath;
    }

    public void createTask(MultipartFile file, Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("User not found"));

        if (file == null) {
            throw new CustomBadRequestException("File must not be null");
        }
        String path = "\\task\\";
        String filePath = fileSaver.saveAndGetPath(file, path);
        TaskEntity taskEntity = TaskEntity.builder()
                .taskUrl(filePath)
                .user(user)
                .build();
        taskRepository.save(taskEntity);
    }
}
