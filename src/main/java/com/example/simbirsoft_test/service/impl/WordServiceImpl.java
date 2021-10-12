package com.example.simbirsoft_test.service.impl;

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

@RequiredArgsConstructor
@Service
public class WordServiceImpl implements WordService {
    private final HtmlReader htmlReader;
    private final WordMapper wordMapper;
    private WordRepository repository;

    @Transactional
    @Override
    public Boolean createWords(String link) {
        String strHtml = htmlReader.readHTML(link);

        List<Word> entities = wordMapper.htmlToEntity(strHtml);
        entities.stream()
                .forEach(e -> repository.save(e));

        return true;
    }

    @Override
    public Boolean downloadFile(HttpServletResponse servletResponse) {
        return null;
    }
}
