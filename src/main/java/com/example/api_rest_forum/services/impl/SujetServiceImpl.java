package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Sujet;
import com.example.api_rest_forum.repository.SujetRepository;
import com.example.api_rest_forum.services.SujetService;
import com.example.api_rest_forum.services.dto.SujetDTO;
import com.example.api_rest_forum.services.mappers.SujetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final SujetMapper sujetMapper;
    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        Sujet sujet = sujetMapper.toEntity(sujetDTO);
        sujet = sujetRepository.save(sujet);
        return sujetMapper.toDto(sujet);
    }

    @Override
    public List<SujetDTO> findAll(SujetDTO sujetDTO) {
        return sujetRepository.findAll().stream().map(sujet -> {
            return sujetMapper.toDto(sujet);
        }).toList();
    }

    @Override
    public Optional<SujetDTO> findOne(Long id) {
        return sujetRepository.findById(id).map(sujet -> {
            return sujetMapper.toDto(sujet);
        });
    }
}
