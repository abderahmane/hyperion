package com.lmt.hyperion.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BatchJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Begining of job  " + jobExecution.getJobInstance().getJobName() + " at " + jobExecution.getStartTime());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String exitCode = jobExecution.getExitStatus().getExitCode();
        log.info("End of job  " + jobExecution.getJobInstance().getJobName() + " at " + jobExecution.getEndTime() + " with status " + exitCode);

    }
}
