--Table creation statements
CREATE TABLE MEMBER
(
  ID              INTEGER                 PRIMARY KEY,
  FIRST_NAME      VARCHAR(100)            NOT NULL,
  LAST_NAME       VARCHAR(100)            NOT NULL,
  EMAIL_ID        VARCHAR(100)            NOT NULL,
  PASSWORD        VARCHAR(100)            NOT NULL,	
)

CREATE TABLE MEMBER_PROPERTY
(
  ID              INTEGER                 PRIMARY KEY,
  MEMBER_ID	  INTEGER                    NOT NULL,
  PROPERTY_ID     INTEGER                    NOT NULL,
  PROPERTY_VALUE  VARCHAR(4000)
)

CREATE TABLE ITEM_TYPE
(
  ID           INTEGER                    PRIMARY KEY,
  TYPE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)              NOT NULL  
)

CREATE TABLE ROLE
(
  ID           INTEGER                       PRIMARY KEY,
  ROLE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)               NOT NULL
)

CREATE TABLE FEATURE
(
  ID           INTEGER                       PRIMARY KEY,
  FEATURE      VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)               NOT NULL
)

CREATE TABLE ROLE_FEATURE
(
  ID           INTEGER                       PRIMARY KEY,
  ROLE_ID      INTEGER                       NOT NULL,
  FEATURE_ID   INTEGER                       NOT NULL, 
  ALLOWED      CHAR(1)			     NOT NULL
)

CREATE TABLE MEMBER_ROLE
(
  ID           INTEGER                       PRIMARY KEY,
  MEMBER_ID    INTEGER                       NOT NULL,
  ROLE_ID      INTEGER                       NOT NULL
)

CREATE TABLE TRANSACTION_TYPE
(
  ID          INTEGER                      PRIMARY KEY,
  TYPE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)               NOT NULL
)


CREATE TABLE ITEM
(
  ID            INTEGER                      PRIMARY KEY,
  NAME          VARCHAR(150)              NOT NULL,
  DESCRIPTION   VARCHAR(1000)             NOT NULL,
  ITEM_TYPE_ID  INTEGER                      NOT NULL
)


CREATE TABLE CATEGORY
(
  ID           INTEGER                       PRIMARY KEY,
  NAME         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)               NOT NULL
)

CREATE TABLE PROPERTY
(
  ID           INTEGER                       PRIMARY KEY,
  CATEGORY_ID  INTEGER                       NOT NULL,
  NAME         VARCHAR(100)               NOT NULL,
  DESCRIPTION  VARCHAR(1000)              NOT NULL,
  DATA_TYPE    VARCHAR(100)
)

CREATE TABLE ITEM_PROPERTY
(
  ID              INTEGER                    PRIMARY KEY,
  ITEM_ID         INTEGER                    NOT NULL,
  PROPERTY_ID     INTEGER                    NOT NULL,
  PROPERTY_VALUE  VARCHAR(4000)
)

CREATE TABLE ITEM_INSTANCE_TRANSACTION_PROPERTY
(
  ID             		       INTEGER	PRIMARY KEY,
  ITEM_INSTANCE_TRANSACTION_ID         INTEGER  NOT NULL,
  PROPERTY_ID     INTEGER              NOT NULL,
  PROPERTY_VALUE  VARCHAR(4000)
)



CREATE TABLE Book
(
  isbn         VARCHAR(100)               NOT NULL,
  title        VARCHAR(250)               NOT NULL,                
  author       VARCHAR(250)               NOT NULL,
  publisher    VARCHAR(250)               NOT NULL,
  releaseDate  DATE  
)

CREATE TABLE ITEM_TYPE_PROPERTY
(
  ITEM_TYPE_ID  INTEGER                      NOT NULL,
  PROPERTY_ID   INTEGER                      NOT NULL,
  MANDATORY     VARCHAR(1)
)
   
CREATE TABLE ITEM_INSTANCE
(
  ID       INTEGER                           PRIMARY KEY,
  ITEM_ID  INTEGER                           NOT NULL
)

CREATE TABLE ITEM_INSTANCE_TRANSACTION
(
  ID                INTEGER                  PRIMARY KEY,
  ITEM_INSTANCE_ID  INTEGER                  NOT NULL,
  TRANSACTION_ID       INTEGER                  NOT NULL
)

CREATE TABLE ITEM_INSTANCE_TRANSACTION_PROPERTY
(
  ID            		INTEGER    PRIMARY KEY,
  ITEM_INSTANCE_TRANSACTION_ID  INTEGER    NOT NULL,
  PROPRETY_ID		        INTEGER    NOT NULL,
  PROPRETY_VALUE	        VARCHAR(4000) NOT NULL
)

CREATE TABLE TRANSACTION_HISTORY
(
  ID                     INTEGER             PRIMARY KEY,
  PARENT_TRANSACTION_ID  INTEGER,
  CHILD_TRANSACTION_ID   INTEGER,
  FIRST                  VARCHAR(1),
  LAST                   VARCHAR(1)
)

--Sequences
create sequence member_id_seq as bigint start with 100 increment by 1;
create sequence member_property_id_seq as bigint start with 100 increment by 1;
create sequence item_type_id_seq as bigint start with 100 increment by 1;
create sequence role_id_seq as bigint start with 100 increment by 1;
create sequence feature_id_seq as bigint start with 100 increment by 1;
create sequence role_feature_id_seq as bigint start with 100 increment by 1;
create sequence member_role_id_seq as bigint start with 100 increment by 1;
create sequence transaction_type_id_seq as bigint start with 100 increment by 1;
create sequence item_id_seq as bigint start with 100 increment by 1;
create sequence transaction_type_id_seq as bigint start with 100 increment by 1;
create sequence category_id_seq as bigint start with 100 increment by 1;
create sequence property_id_seq as bigint start with 100 increment by 1;
create sequence item_property_id_seq as bigint start with 100 increment by 1;
create sequence item_instance_id_seq as bigint start with 100 increment by 1;
create sequence item_instance_property_id_seq as bigint start with 100 increment by 1;


--Foriegn Keys for the tables
ALTER TABLE PROPERTY ADD FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID)
ALTER TABLE ITEM_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY (ID)
ALTER TABLE ITEM_PROPERTY ADD FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID)
ALTER TABLE ITEM ADD FOREIGN KEY(ITEM_TYPE_ID) REFERENCES ITEM_TYPE(ID)
ALTER TABLE ITEM_TYPE_PROPERTY ADD FOREIGN KEY (ITEM_TYPE_ID) REFERENCES ITEM_TYPE (ID)
ALTER TABLE ITEM_INSTANCE ADD FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID)
ALTER TABLE ITEM_INSTANCE_PROPERTY ADD FOREIGN KEY (ITEM_INSTANCE_ID) REFERENCES ITEM_INSTANCE (ID)
ALTER TABLE ITEM_INSTANCE_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY(ID)
ALTER TABLE ITEM_INSTANCE_TRANSACTION ADD FOREIGN KEY (ITEM_INSTANCE_ID) REFERENCES ITEM_INSTANCE(ID)
ALTER TABLE ITEM_INSTANCE_TRANSACTION ADD FOREIGN KEY (TRANSACTION_ID) REFERENCES TRANSACTION_TYPE(ID)
ALTER TABLE ITEM_INSTANCE_TRANSACTION_PROPERTY ADD FOREIGN KEY (ITEM_INSTANCE_TRANSACTION_ID) REFERENCES ITEM_INSTANCE_TRANSACTION(ID) 
ALTER TABLE ITEM_INSTANCE_TRANSACTION_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY(ID) 
ALTER TABLE MEMBER_PROPERTY ADD FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(ID) 
ALTER TABLE MEMBER_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY(ID) 
ALTER TABLE MEMBER_ROLE ADD FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(ID) 
ALTER TABLE MEMBER_ROLE ADD FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ID) 
ALTER TABLE ROLE_FEATURE ADD FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ID) 
ALTER TABLE ROLE_FEATURE ADD FOREIGN KEY (FEATURE_ID) REFERENCES FEATURE(ID) 
ALTER TABLE TRANSACTION_HISTORY ADD FOREIGN KEY (PARENT_TRANSACTION_ID) REFERENCES ITEM_INSTANCE_TRANSACTION (ID)
ALTER TABLE TRANSACTION_HISTORY ADD FOREIGN KEY (CHILD_TRANSACTION_ID) REFERENCES ITEM_INSTANCE_TRANSACTION (ID)

--indexes for table TODO this needs to be added based on queries created for access


--Views required by the querying layer
