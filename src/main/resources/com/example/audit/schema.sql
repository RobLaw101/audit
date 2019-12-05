CREATE TABLE AUDIT_LOG (
  user_id INT NOT NULL,
  ts INT NOT NULL,
  class_name VARCHAR(100) NOT NULL,
  class_method VARCHAR(100) NOT NULL,
  is_write BOOLEAN DEFAULT false,
  PRIMARY KEY (user_id, ts));