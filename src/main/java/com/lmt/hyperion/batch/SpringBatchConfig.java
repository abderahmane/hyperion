package com.lmt.hyperion.batch;

import com.lmt.hyperion.dao.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final ItemReader<Region> regionItemReader;

    private final ItemProcessor<Region, Region> regionItemProcessor;

    private final BatchJobListener batchJobListener;

    @Autowired
    private ItemReader<Country> countryItemReader;

    @Autowired
    private ItemProcessor<Country, Country> countryItemProcessor;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ItemReader<Cedant> cedantItemReader;

    @Autowired
    private ItemProcessor<Cedant, Cedant> cedantItemProcessor;

    @Autowired
    private CedantRepository cedantRepository;

    @Autowired
    private ItemReader<GroupCedant> groupCedantItemReader;

    @Autowired
    private ItemProcessor<GroupCedant, GroupCedant> groupCedantItemProcessor;

    @Autowired
    private GroupCedantRepository groupCedantRepository;

    @Autowired
    private ItemReader<Branch> branchItemReader;

    @Autowired
    private ItemProcessor<Branch, Branch> branchItemProcessor;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ItemReader<CaseNotLifePremium> caseNotLifePremiumItemReader;

    @Autowired
    private ItemProcessor<CaseNotLifePremium, CaseNotLifePremium> caseNotLifePremiumItemProcessor;

    @Autowired
    private CaseNotLifePremiumRepository caseNotLifePremiumRepository;

    @Autowired
    private ItemReader<SlipsPremium> slipsPremiumItemReader;

    @Autowired
    private ItemProcessor<SlipsPremium, SlipsPremium> slipsPremiumItemProcessor;

    @Autowired
    private SlipsPremiumRepository slipsPremiumRepository;

    public SpringBatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<Region> regionItemReader,
                             ItemProcessor<Region, Region> regionItemProcessor ,
                             BatchJobListener batchJobListener) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.regionItemReader = regionItemReader;
        this.regionItemProcessor = regionItemProcessor;
        this.batchJobListener = batchJobListener;
    }

    @Bean
    public Job regionJob(){
        Step step = stepBuilderFactory.get("ETL-regions")
                .<Region, Region>chunk(100)
                .reader(regionItemReader)
                .processor(regionItemProcessor)
                .writer(new SqlItemWriter<Region>(regionRepository))
                .build();
        return jobBuilderFactory.get("Job-Regions")
                .listener(batchJobListener)
                .start(step).build();
    }

    @Bean
    public Job countryJob(){
        Step step = stepBuilderFactory.get("ETL-countries")
                .<Country, Country>chunk(100)
                .reader(countryItemReader)
                .processor(countryItemProcessor)
                .writer(new SqlItemWriter<Country>(countryRepository))
                .build();
        return jobBuilderFactory.get("Job-Countries")
                .listener(batchJobListener)
                .start(step).build();
    }


    @Bean
    public Job cedantJob(){
        Step step = stepBuilderFactory.get("ETL-cedants")
                .<Cedant, Cedant>chunk(100)
                .reader(cedantItemReader)
                .processor(cedantItemProcessor)
                .writer(new SqlItemWriter<Cedant>(cedantRepository))
                .build();
        return jobBuilderFactory.get("Job-Cedants")
                .listener(batchJobListener)
                .start(step).build();
    }

    @Bean
    public Job groupCedantJob(){
        Step step = stepBuilderFactory.get("ETL-groupCedants")
                .<GroupCedant, GroupCedant>chunk(100)
                .reader(groupCedantItemReader)
                .processor(groupCedantItemProcessor)
                .writer(new SqlItemWriter<GroupCedant>(groupCedantRepository))
                .build();
        return jobBuilderFactory.get("Job-GroupCedants")
                .listener(batchJobListener)
                .start(step).build();
    }

    @Bean
    public Job branchJob(){
        Step step = stepBuilderFactory.get("ETL-branchs")
                .<Branch, Branch>chunk(100)
                .reader(branchItemReader)
                .processor(branchItemProcessor)
                .writer(new SqlItemWriter<Branch>(branchRepository))
                .build();
        return jobBuilderFactory.get("Job-Branchs")
                .listener(batchJobListener)
                .start(step).build();
    }

    @Bean
    public Job caseNotLifePremiumJob(){
        Step step = stepBuilderFactory.get("ETL-caseNotLifePremiums")
                .<CaseNotLifePremium, CaseNotLifePremium>chunk(100)
                .reader(caseNotLifePremiumItemReader)
                .processor(caseNotLifePremiumItemProcessor)
                .writer(new SqlItemWriter<CaseNotLifePremium>(caseNotLifePremiumRepository))
                .build();
        return jobBuilderFactory.get("Job-CaseNotLifePremiums")
                .listener(batchJobListener)
                .start(step).build();
    }

    @Bean
    public Job slipsPremiumJob(){
        Step step = stepBuilderFactory.get("ETL-slipsPremiums")
                .<SlipsPremium, SlipsPremium>chunk(100)
                .reader(slipsPremiumItemReader)
                .processor(slipsPremiumItemProcessor)
                .writer(new SqlItemWriter<SlipsPremium>(slipsPremiumRepository))
                .build();
        return jobBuilderFactory.get("Job-SlipsPremiums")
                .listener(batchJobListener)
                .start(step).build();
    }

}
