package com.lmt.hyperion.batch.reader;

import com.lmt.hyperion.dao.Cedant;
import com.lmt.hyperion.dao.Country;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CedantItemReader extends JsonItemReader<Cedant> {

    private  static String PATH = "Cedant.json";

    public CedantItemReader() {
        this.setName("CedantJsonItemReader");
        this.setResource(new FileSystemResource(PATH));
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(Cedant.class));
        this.setStrict(false);
    }
}
