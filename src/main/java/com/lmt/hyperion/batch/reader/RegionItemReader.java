package com.lmt.hyperion.batch.reader;

import com.lmt.hyperion.dao.Region;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class RegionItemReader extends JsonItemReader<Region> {

    private  static String PATH = "Region.json";

    public RegionItemReader() {
        this.setName("RegionJsonItemReader");
        this.setResource(new FileSystemResource(PATH));
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(Region.class));
        this.setStrict(false);
    }
}
