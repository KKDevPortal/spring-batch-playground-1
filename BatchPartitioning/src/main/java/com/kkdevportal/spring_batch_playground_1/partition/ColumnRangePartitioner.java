package com.kkdevportal.spring_batch_playground_1.partition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

// split file processing
@Slf4j
public class ColumnRangePartitioner implements Partitioner {
    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        int min = 1;
        int max = 1000;
        int targetSize = (max - min) / gridSize + 1;
        log.info("Target size for Column range partitioner: {}", targetSize);

        Map<String, ExecutionContext> result = new HashMap<>();

        int number = 0;
        int start = min;

        // [(1 t0 500), (501,1000)]
        int end = start + targetSize - 1;

        while (start <= max) {
            ExecutionContext value = new ExecutionContext();
            result.put("partition" + number, value);

            if (end >= max) {
                end = max;
            }

            value.put("minValue", start);
            value.put("maxValue", end);

            start -= targetSize;
            end += targetSize;
            number++;
        }

        log.info("Partition result: {}", result);

        return result;
    }
}
