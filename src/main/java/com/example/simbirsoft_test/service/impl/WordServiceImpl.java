package com.example.simbirsoft_test.service.impl;

import com.example.simbirsoft_test.csv.CsvWriter;
import com.example.simbirsoft_test.dto.WordResponseDto;
import com.example.simbirsoft_test.exception.DataBaseEmptyException;
import com.example.simbirsoft_test.exception.HtmlReaderIOException;
import com.example.simbirsoft_test.mapper.WordMapper;
import com.example.simbirsoft_test.model.Word;
import com.example.simbirsoft_test.repository.WordRepository;
import com.example.simbirsoft_test.service.WordService;
import com.example.simbirsoft_test.util.HtmlReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WordServiceImpl implements WordService {
    private final HtmlReader htmlReader;
    private final WordMapper wordMapper;
    private final WordRepository repository;
    private final CsvWriter csvWriter;

    @Transactional
    @Override
    public List<WordResponseDto> createWords(String link) {
        String strHtml = htmlReader.readHTML(link);

        List<Word> entities = wordMapper.htmlToEntity(strHtml);
        entities.stream()
                .forEach(e -> repository.save(e));

        List<WordResponseDto> responseDtos = entities.stream()
                .map(e -> wordMapper.entityToResponseDto(e))
                .collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public Boolean downloadFile(HttpServletResponse servletResponse) {
        List<Word> entities = repository.findAll();
        if(entities.isEmpty())
            throw new DataBaseEmptyException();

        csvWriter.taskToCsv(entities, servletResponse);
        return true;
    }

    @Override
    public List<WordResponseDto> deleteAllWords() {
        List<Word> entities = repository.findAll();
        repository.deleteAll();

        return entities.stream()
                .map(e -> wordMapper.entityToResponseDto(e))
                .collect(Collectors.toList());
    }
}
