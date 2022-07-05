package com.lmt.hyperion.batch.reader;

import com.lmt.hyperion.dao.CaseNotLifePremium;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CaseNotLifePremiumItemReader extends JsonItemReader<CaseNotLifePremium> {

    private  static String PATH = "CaseNotLifePremium.json";

    public CaseNotLifePremiumItemReader() {
        this.setName("CaseNotLifePremiumJsonItemReader");
        this.setResource(new FileSystemResource(PATH));
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(CaseNotLifePremium.class));
        this.setStrict(false);
    }
}
