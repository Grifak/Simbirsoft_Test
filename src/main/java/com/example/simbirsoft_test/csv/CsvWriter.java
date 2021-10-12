package com.example.simbirsoft_test.csv;

import com.example.simbirsoft_test.exception.CsvIOException;
import com.example.simbirsoft_test.model.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CsvWriter {
    @Value("${csv.filename}")
    private String filename;

    /**
     * Convert entities to csv files
     * @param entities list with entities
     * @param response httpServletresponse from controller
     * @throws CsvIOException if problems with IO streams
     */
    public void taskToCsv(List<Word> entities, HttpServletResponse response) {
        response.setCharacterEncoding("Windows-1251");
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", String.format("attachment; filename=%s", filename));

        try {
            ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
            String[] csvHeader = {"id", "word", "cnt"};
            String[] nameMapping = {"id", "word", "cnt"};

            csvWriter.writeHeader(csvHeader);

            for (Word entity : entities) {
                csvWriter.write(entity, nameMapping);
            }

            csvWriter.close();
        } catch (IOException e) {
            throw new CsvIOException();
        }
    }
}
