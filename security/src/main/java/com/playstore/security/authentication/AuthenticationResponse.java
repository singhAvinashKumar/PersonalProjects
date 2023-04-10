package com.playstore.security.authentication;

import java.util.Date;
import java.util.UUID;

public class AuthenticationResponse {
    private UUID txId;
    private Date timeStamp;
    private UUID correlationId;
    private Body body;

    public AuthenticationResponse(){

    }
    public AuthenticationResponse(UUID txId, Date timeStamp, UUID correlationId, Body body, String operationName) {
        this.txId = txId;
        this.timeStamp = timeStamp;
        this.correlationId = correlationId;
        this.body = body;
        this.operationName = operationName;
    }
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

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    private String operationName;


}
