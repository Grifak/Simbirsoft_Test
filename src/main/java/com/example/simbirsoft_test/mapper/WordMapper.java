package com.example.simbirsoft_test.mapper;

import com.example.simbirsoft_test.model.Word;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vadim
 * @version 1.0
 * Mapper for {@link Word}
 */
@Component
public class WordMapper {
    /**
     * Create entities from html string
     * @param strHtml string with html
     * @return list with entities
     */
    public List<Word> htmlToEntity(String strHtml){
        List<Word> entities = new ArrayList<>();
        Document doc = Jsoup.parse(strHtml);
        String[] words = doc.body().text().split("[.,:;()\\[\\]'\\\\\\/!\\?\\s\"]+");

        Map<String, Integer> mapWords = new HashMap<>();
        for(String word: words){
            if(!mapWords.containsKey(word)){
                mapWords.put(word, 1);
            }
            else{
                mapWords.put(word, mapWords.get(word) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry: mapWords.entrySet()){
            Word entity = Word.builder()
                    .word(entry.getKey())
                    .cnt(entry.getValue())
                    .build();

            entities.add(entity);
        }

        return entities;
    }
}
