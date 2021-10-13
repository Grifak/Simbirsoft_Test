package com.example.simbirsoft_test.service;

import com.example.simbirsoft_test.dto.WordResponseDto;
import com.example.simbirsoft_test.model.Word;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Vadim
 * @version 1.0
 * Interface for working with {@link Word}
 */
public interface WordService {
    /**
     * Create words by link
     * @param link to read the page
     * @return true if created, false if not created
     */
    List<WordResponseDto> createWords(String link);

    /**
     * Download file with all records in the database
     * @param servletResponse from controller
     * @return true if downloaded, false if not downloaded
     */
    boolean downloadFile(HttpServletResponse servletResponse);

    /**
     * Delete all words
     * @return list with deleted words
     */
    List<WordResponseDto> deleteAllWords();
}
