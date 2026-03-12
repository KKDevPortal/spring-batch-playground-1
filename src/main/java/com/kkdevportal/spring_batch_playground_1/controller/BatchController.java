package com.kkdevportal.spring_batch_playground_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController {
    private final JobLauncher jobLauncher;
    private final Job job;

    @PostMapping("/batch/run")
    public String runBatchJob() throws Exception {

        JobParameters params = new JobParametersBuilder()
                .addLong("runId", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(job, params);

        return "Batch Job Started";
    }
}
