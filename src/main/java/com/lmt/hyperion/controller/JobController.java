package com.lmt.hyperion.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class JobController {

    private final JobLauncher jobLauncher;
    private final Job regionJob;
    private final Job countryJob;
    private final Job cedantJob;
    private final Job groupCedantJob;
    private final Job branchJob;
    private final Job caseNotLifePremiumJob;
    private final Job slipsPremiumJob;

    public JobController(JobLauncher jobLauncher, Job regionJob, Job countryJob, Job cedantJob, Job groupCedantJob, Job branchJob, Job caseNotLifePremiumJob, Job slipsPremiumJob) {
        this.jobLauncher = jobLauncher;
        this.regionJob = regionJob;
        this.countryJob = countryJob;
        this.cedantJob = cedantJob;
        this.groupCedantJob = groupCedantJob;
        this.branchJob = branchJob;
        this.caseNotLifePremiumJob = caseNotLifePremiumJob;
        this.slipsPremiumJob = slipsPremiumJob;
    }

    @GetMapping( "/update-data")
    public BatchStatus runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String , JobParameter> parameters = new HashMap<>();
        parameters.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parameters);
        JobExecution jobExecution = jobLauncher.run(regionJob, jobParameters);
        while (jobExecution.isRunning()){
            log.info(".........");
        }
        log.info("End......Region");
        JobExecution jobExecutionCountry = jobLauncher.run(countryJob, jobParameters);
        while (jobExecutionCountry.isRunning()){
            log.info(".........");
        }
        log.info("End......Country");

        JobExecution jobExecutionGroupCedant = jobLauncher.run(groupCedantJob, jobParameters);
        while (jobExecutionGroupCedant.isRunning()){
            log.info(".........");
        }
        log.info("End......GroupCedant");

        JobExecution jobExecutionCedant = jobLauncher.run(cedantJob, jobParameters);
        while (jobExecutionCedant.isRunning()){
            log.info(".........");
        }
        log.info("End......Cedant");

        JobExecution jobExecutionBranch = jobLauncher.run(branchJob, jobParameters);
        while (jobExecutionBranch.isRunning()){
            log.info(".........");
        }
        log.info("End......Branch");

        JobExecution jobExecutionCaseNotLifePremium = jobLauncher.run(caseNotLifePremiumJob, jobParameters);
        while (jobExecutionCaseNotLifePremium.isRunning()){
            log.info(".........");
        }
        log.info("End......CaseNotLifePremium");


        JobExecution jobExecutionSlipsPremium = jobLauncher.run(slipsPremiumJob, jobParameters);
        while (jobExecutionSlipsPremium.isRunning()){
            log.info(".........");
        }
        log.info("End......SlipsPremium");


        return  jobExecutionSlipsPremium.getStatus();
    }
}
