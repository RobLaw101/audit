package com.example.audit.controller;

import com.example.audit.model.AuditLog;
import com.example.audit.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {

    private final AuditService<AuditLog> service;

    @Autowired
    public AuditController (AuditService<AuditLog> service) {
        this.service = service;
    }

    @RequestMapping(path ="/users/{userId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List <AuditLog> getLogsById(@PathVariable String userId) {
        return service.findById(Long.valueOf(userId));
    }

    @RequestMapping(value = "/persistLog", consumes = "application/json", method = RequestMethod.POST)
    ResponseEntity<Object> saveRecord(@RequestBody AuditLog newLog) {
        service.persistLog(newLog);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/audit/users")
                .path("/{id}")
                .buildAndExpand(newLog.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
