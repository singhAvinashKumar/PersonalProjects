package com.appservice.user.model.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

public class CustomResponseBody {
    Logger logger = LoggerFactory.getLogger(CustomResponseBody.class);
    private UUID txId;
    private Date timeStamp;
    private UUID correlationId;
    private Body body;
    private Status status;


    public CustomResponseBody(UUID txId, Date timeStamp, UUID correlationId, Status status, String operation) {
        logger.info("Created CustomResponseBody : ");
        this.txId = txId;
        this.timeStamp = timeStamp;
        this.correlationId = correlationId;
        this.status = status;
        this.operation = operation;
    }

    public CustomResponseBody(UUID txId, Date timeStamp, UUID correlationId, Body body, Status status, String operation) {
        logger.info("Created CustomResponseBody : Inside body");
        this.txId = txId;
        this.timeStamp = timeStamp;
        this.correlationId = correlationId;
        this.body = body;
        this.status = status;
        this.operation = operation;
    }

    private String operation;

    public UUID getTxId() {
        return txId;
    }

    public void setTxId(UUID txId) {
        this.txId = txId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
