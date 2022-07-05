package com.lmt.hyperion.batch.reader;

import com.lmt.hyperion.dao.Country;
import com.lmt.hyperion.dao.GroupCedant;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class GroupCedantItemReader extends JsonItemReader<GroupCedant> {

    private  static String PATH = "GroupCedant.json";

    public GroupCedantItemReader() {
        this.setName("GroupCedantJsonItemReader");
        this.setResource(new FileSystemResource(PATH));
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(GroupCedant.class));
        this.setStrict(false);
    }
}
