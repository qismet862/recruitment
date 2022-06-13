package com.recruitment.controller;

import com.recruitment.dto.response.TechnologyResponse;
import com.recruitment.service.TechnologyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/technologies")
@RequiredArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;

    @GetMapping
    public ResponseEntity<List<TechnologyResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(technologyService.getAll());
    }

}
