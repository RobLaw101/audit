package com.example.audit.service;

import java.util.List;

public interface AuditService <T> {

    List <T> findById (Long userID);

    void persistLog (T log);
}
