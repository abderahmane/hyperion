package com.lmt.hyperion.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SqlItemWriter<T> implements ItemWriter<T> {
    private JpaRepository jpaRepository;

    public SqlItemWriter(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void write(List<? extends T> list) {
        jpaRepository.saveAll(list);
    }
}
