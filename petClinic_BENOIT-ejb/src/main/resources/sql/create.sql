CREATE TABLE ANIMAL (ID VARCHAR(36), BIRTH_DATE BLOB, BREED VARCHAR(50), NICKNAME VARCHAR(50), PICTURE BLOB, OWNER_ID VARCHAR(36), PRIMARY KEY (ID));
CREATE TABLE OWNER (ID VARCHAR(36), EMAIL VARCHAR(50), FIRST_NAME VARCHAR(50), NAME VARCHAR(50), PHONE VARCHAR(50), PRIMARY KEY (ID));
ALTER TABLE ANIMAL ADD CONSTRAINT FK_ANIMAL_OWNER_ID FOREIGN KEY (OWNER_ID) REFERENCES OWNER (ID);
