package com.recruitment.service;

import com.recruitment.dto.response.TechnologyResponse;
import com.recruitment.mapper.TechnologyMapper;
import com.recruitment.repository.TechnologyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    private final TechnologyMapper technologyMapper;

    public List<TechnologyResponse> getAll() {
        var technologies = technologyRepository.findAll();
        return technologyMapper.toTechnologyResponse(technologies);
    }
}

