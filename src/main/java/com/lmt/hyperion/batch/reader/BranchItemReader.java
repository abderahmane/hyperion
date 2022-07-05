package com.lmt.hyperion.batch.reader;

import com.lmt.hyperion.dao.Branch;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class BranchItemReader extends JsonItemReader<Branch> {

    private  static String PATH = "Branch.json";

    public BranchItemReader() {
        this.setName("BranchJsonItemReader");
        this.setResource(new FileSystemResource(PATH));
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(Branch.class));
        this.setStrict(false);
    }
}
