package com.example.simbirsoft_test.util;

import com.example.simbirsoft_test.exception.HtmlReaderIOException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class HtmlReader {
    public String readHTML(String link){
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(link);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String strHtml = null;
            while ((strHtml = reader.readLine()) != null) {
                builder.append(strHtml);
            }

            reader.close();
        }
        catch (IOException e){
            throw new HtmlReaderIOException();
        }
        return builder.toString();
    }
}
