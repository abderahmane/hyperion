package com.lmt.hyperion.batch.reader;

import com.lmt.hyperion.dao.Country;
import com.lmt.hyperion.dao.Region;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CountryItemReader extends JsonItemReader<Country> {

    private  static String PATH = "Country.json";

    public CountryItemReader() {
        this.setName("CountryJsonItemReader");
        this.setResource(new FileSystemResource(PATH));
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(Country.class));
        this.setStrict(false);
    }
}
