package com.example.audit.persistence;

import com.example.audit.model.AuditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLAuditDAOImpl implements AuditDAO <AuditLog> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MySQLAuditDAOImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(AuditLog log) {
        jdbcTemplate.update(
                "insert into AUDIT_LOG (user_id, ts, class_name, class_method, is_write) values(?,?,?,?,?)",
                log.getUserId(), log.getTs(), log.getClassName(), log.getClassMethod(), log.getIsWrite());
    }

    @Override
    public List<AuditLog> findByUserID(Long userId) {
        return jdbcTemplate.query(
                "select * from AUDIT_LOG where USER_ID = ?",
                new Object[]{userId},
                (rs, rowNum) ->
                        new AuditLog(
                                rs.getLong("user_id"),
                                rs.getLong("ts"),
                                rs.getBoolean("is_write"),
                                rs.getString("class_name"),
                                rs.getString("class_method")
                        )
        );
    }
}
