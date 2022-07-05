package com.lmt.hyperion.batch.reader;

import com.lmt.hyperion.dao.SlipsPremium;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class SlipsPremiumItemReader extends JsonItemReader<SlipsPremium> {

    private  static String PATH = "SlipsPremium.json";

    public SlipsPremiumItemReader() {
        this.setName("SlipsPremiumJsonItemReader");
        this.setResource(new FileSystemResource(PATH));
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(SlipsPremium.class));
        this.setStrict(false);
    }
}
