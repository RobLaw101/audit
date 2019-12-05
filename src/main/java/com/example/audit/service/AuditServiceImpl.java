package com.example.audit.service;

import com.example.audit.model.AuditLog;
import com.example.audit.persistence.AuditDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService <AuditLog> {

    private final AuditDAO <AuditLog> dao;

    @Autowired
    public AuditServiceImpl (AuditDAO <AuditLog> dao) {
        this.dao = dao;
    }

    @Override
    public List <AuditLog> findById (Long userID) {
        return dao.findByUserID(userID);
    }

    @Override
    public void persistLog (AuditLog log) {
        dao.save(log);
    }
}
