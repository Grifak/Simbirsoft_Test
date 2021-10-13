package com.example.simbirsoft_test.mapper;

import com.example.simbirsoft_test.dto.WordResponseDto;
import com.example.simbirsoft_test.model.Word;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;


class WordMapperTest {
    private WordMapper mapper = Mappers.getMapper(WordMapper.class);

    @Test
    void htmlToEntity() {
        String html = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "    <title>Блоки</title>" +
                "    <meta charset=\"utf-8\">" +
                "</head>" +
                "<body>" +
                "    <div>Первый блок текста</div>" +
                "    <div>Второй блок текста</div>" +
                "</body>" +
                "</html>";

        List<Word> entities = mapper.htmlToEntity(html);

        Assert.assertNotNull(entities);
        Assert.assertEquals(4, entities.size());
        Assert.assertEquals("Первый", entities.get(0).getWord());
        Assert.assertEquals(1, entities.get(0).getCnt());
        Assert.assertEquals("Второй", entities.get(1).getWord());
        Assert.assertEquals(1, entities.get(1).getCnt());
        Assert.assertEquals("блок", entities.get(2).getWord());
        Assert.assertEquals(2, entities.get(2).getCnt());
        Assert.assertEquals("текста", entities.get(3).getWord());
        Assert.assertEquals(2, entities.get(3).getCnt());
    }

    @Test
    void entityToResponseDto() {
        Word entity = Word.builder()
                .Id(1L)
                .word("TEST")
                .cnt(5)
                .build();

        WordResponseDto responseDto = mapper.entityToResponseDto(entity);

        Assert.assertNotNull(responseDto);
        Assert.assertEquals("TEST", responseDto.getWord());
    }
}