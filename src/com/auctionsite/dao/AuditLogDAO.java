package com.auctionsite.dao;

import com.auctionsite.model.AuditLog;

public interface AuditLogDAO {
    void logAction(AuditLog auditLog);
}
