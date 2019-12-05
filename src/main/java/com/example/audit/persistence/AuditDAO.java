package com.example.audit.persistence;

import java.util.List;

public interface AuditDAO <T> {

    void save(T t);

    List <T> findByUserID (Long userId);
}
