# spring-batch-playground-1


## Project Structure
```
spring-batch-lab
│
├── config
│   └── BatchConfig.java
│
├── model
│   └── Customer.java
│
├── processor
│   └── CustomerProcessor.java
│
├── repository
│   └── CustomerRepository.java
│
├── resources
│   └── customers.csv
│
└── SpringBatchLabApplication.java
```

----

## Verify Batch Tables
- Start the app and open:
> http://localhost:8080/h2-console

- JDBC URL:
> jdbc:h2:mem:batchdb

- Then run:
> SHOW TABLES;

- You should see:
> BATCH_JOB_INSTANCE
>
> BATCH_JOB_EXECUTION
>
> BATCH_STEP_EXECUTION

---

## CSV → Database Batch Processor
- Flow of the batch job:
```
customers.csv
     ↓
ItemReader (reads CSV)
     ↓
ItemProcessor (process/transform data)
     ↓
ItemWriter (write to DB)
     ↓
Database Table: CUSTOMER
```

- Example CSV:
```
id,name,email
1,John,john@gmail.com
2,Alice,alice@gmail.com
3,Bob,bob@gmail.com
```
---

## Chunk Processing
- This line:
> chunk(3, transactionManager)

- Means:
```
Read 3 records
Process 3 records
Write 3 records
Commit transaction
```
- Example:
```
CSV has 10 rows.

Execution:

1-3 → commit
4-6 → commit
7-9 → commit
10 → commit

This is why Spring Batch is memory efficient.
```

## Architecture:
```
Job
 └── Step
      └── Chunk
           ├── ItemReader
           ├── ItemProcessor
           └── ItemWriter
```

