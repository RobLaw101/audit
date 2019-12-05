package com.example.audit.model;

    public class AuditLog {

        private Long userId;
        private Long ts;
        private Boolean isWrite;
        private String className;
        private String classMethod;

        public AuditLog (Long userId, Long ts, Boolean write, String className, String classMethod) {
            this.userId = userId;
            this.ts = ts;
            this.isWrite = write;
            this.className = className;
            this.classMethod = classMethod;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getTs() {
            return ts;
        }

        public void setTs(Long ts) {
            this.ts = ts;
        }

        public Boolean getIsWrite() {
            return isWrite;
        }

        public void setIsWrite(Boolean write) {
            this.isWrite = write;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getClassMethod() {
            return classMethod;
        }

        public void setClassMethod(String classMethod) {
            this.classMethod = classMethod;
        }
}
