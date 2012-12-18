--Script for db set up in hsqldb
CREATE TABLE TRANSACTION_TYPE
(
  ID          INTEGER                      PRIMARY KEY,
  TYPE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)               NOT NULL
)


CREATE TABLE TRANSACTION_HISTORY
(
  ID                     INTEGER             PRIMARY KEY,
  TRANSACTION_ID        INTEGER             NOT NULL,
  PARENT_TRANSACTION_ID  INTEGER,
  CHILD_TRANSACTION_ID   INTEGER,
  FIRST                  VARCHAR(1),
  LAST                   VARCHAR(1)
)

CREATE TABLE PROPERTY
(
  ID           INTEGER                       PRIMARY KEY,
  CATEGORY_ID  INTEGER                       NOT NULL,
  NAME         VARCHAR(100)               NOT NULL,
  DESCRIPTION  VARCHAR(1000)              NOT NULL,
  DATA_TYPE    VARCHAR(100)
)

CREATE TABLE MEMBER
(
  ID              INTEGER                 PRIMARY KEY,
  FIRST_NAME      VARCHAR(100)            NOT NULL,
  LAST_NAME       VARCHAR(100)            NOT NULL,
  EMAIL_ID        VARCHAR(100)            NOT NULL,
  MOBILE_NUMBER   VARCHAR(30),
  POSTAL_ADDRESS  VARCHAR(4000)
)

--TODO a PK needs to be added to this table
CREATE TABLE ITEM_TYPE_PROPERTY
(
  ITEM_TYPE_ID  INTEGER                      NOT NULL,
  PROPERTY_ID   INTEGER                      NOT NULL,
  MANDATORY     VARCHAR(1)
)

CREATE TABLE ITEM_TYPE
(
  ID           INTEGER                    PRIMARY KEY,
  TYPE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)              NOT NULL  
)

CREATE TABLE ITEM_TRANSACTION_PROPERTY
(
  ID                   INTEGER               PRIMARY KEY,
  ITEM_TRANSACTION_ID  INTEGER               NOT NULL,
  PROPERTY_ID          INTEGER               NOT NULL,
  PROPERTY_VALUE       VARCHAR(4000)
)

CREATE TABLE ITEM_TRANSACTION
(
  ID              INTEGER                    PRIMARY KEY,
  INSTANCE_ID     INTEGER                    NOT NULL,
  TRANSACTION_ID  INTEGER                    NOT NULL,
  MEMBER_ID       INTEGER                    NOT NULL
)

CREATE TABLE ITEM_PROPERTY
(
  ID              INTEGER                    PRIMARY KEY,
  ITEM_ID         INTEGER                    NOT NULL,
  PROPERTY_ID     INTEGER                    NOT NULL,
  PROPERTY_VALUE  VARCHAR(4000)
)

CREATE TABLE ITEM_INSTANCE_PROPERTY
(
  ID                INTEGER                  PRIMARY KEY,
  ITEM_INSTANCE_ID  INTEGER                  NOT NULL,
  PROPERTY_ID       INTEGER                  NOT NULL,
  PROPERTY_VALUE    VARCHAR(4000)
)

CREATE TABLE ITEM_INSTANCE
(
  ID       INTEGER                           PRIMARY KEY,
  ITEM_ID  INTEGER                           NOT NULL
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

CREATE TABLE SYSTEM_ROLE
(
  ID           INTEGER                       PRIMARY KEY,
  ROLE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)               NOT NULL
)

CREATE TABLE SYSTEM_FEATURE
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
  VIEW         CHAR(1) DEFAULT 'N'           NOT NULL,
  EDIT         CHAR(1) DEFAULT 'N'           NOT NULL
)



--Creating the various FK's and other indices required by hsqldb

--Insert data
INSERT INTO CATEGORY
   (ID, NAME, DESCRIPTION)
 VALUES
   (1, 'ITEM_PROPERTY', 'This category is for grouping all the properties that belongs to a Library Item');
INSERT INTO CATEGORY
   (ID, NAME, DESCRIPTION)
 VALUES
   (2, 'INSTANCE_PROPERTY', 'This category grpups all properties that belong to an instance');
INSERT INTO CATEGORY
   (ID, NAME, DESCRIPTION)
 VALUES
   (3, 'OWNER_TYPES', 'This category groups the various kinds of owners for a library item');
INSERT INTO CATEGORY
   (ID, NAME, DESCRIPTION)
 VALUES
   (4, 'TRANSACTION_PROPERTY', 'This category groups the properties that belongs to a transaction');

INSERT INTO ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 VALUES
   ('BOOK', 'Books', 1);
INSERT INTO ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 VALUES
   ('MOVIE', 'Movies', 2);
INSERT INTO ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 VALUES
   ('MUSIC', 'Audio', 3);
INSERT INTO ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 VALUES
   ('GAME', 'Console Games', 4);
INSERT INTO ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 VALUES
   ('MAGAZINE', 'Magazine', 5);
INSERT INTO ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 VALUES
   ('JOURNAL', 'Journals', 6);
INSERT INTO ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 VALUES
   ('NEWSPAPER', 'Newspaper Archives', 7);

INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (1, 'Rixon', 'Mathew', 'rixonmathew@gmail.com', '9545590291', 'Pune');
INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (2, 'Dinkar', 'Gupta', 'dinkargupta@gmail.com', '9965842261', 'Pune');
INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (3, 'Vaibhav', 'Deshpande', 'vaibhavdeshpande@gmail.com', '9956654487', 'Jaipur');
INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (4, 'Divya', 'Jain', 'divyajain@gmail.com', '6656744548', 'Zurich');

INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (1, 1, 'TITLE', 'Title', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (2, 1, 'AUTHOR', 'Author', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (3, 1, 'PUBLISHER', 'Publisher', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (4, 1, 'PUBLISHED_DATE', 'Date item was published', 'Date');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (5, 2, 'COVER_TYPE', 'Cover Type', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (6, 1, 'PAGES', 'No. of pages', 'Number');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (7, 1, 'GENRE', 'Genre', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (8, 1, 'PRICE', 'Price', 'Money');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (9, 1, 'ISBN', 'Isbn', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (10, 1, 'WEBSITE', 'Website', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (11, 1, 'CATEGORY', 'Category', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (12, 1, 'GENRE', 'Genre', 'String');
INSERT INTO PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 VALUES
   (13, 1, 'RATING', 'Rating', 'String');

INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 1, 'Y');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 2, 'Y');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 3, 'Y');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 4, 'Y');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 6, 'N');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 7, 'Y');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 8, 'Y');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 9, 'Y');
INSERT INTO ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 VALUES
   (1, 10, 'N');
   
   
INSERT INTO ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 VALUES
   (5, 'Programming Perl', 'The primer on Perl Programming', 1);
INSERT INTO ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 VALUES
   (6, 'Effective Java', 'A guide to using Java effectively', 1);
INSERT INTO ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 VALUES
   (1, 'The Fountainhead', 'A classic on Objectivitism', 1);
INSERT INTO ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 VALUES
   (2, 'The Godfather', 'Story about rise of Italian mafia in US', 1);
INSERT INTO ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 VALUES
   (3, 'Atlas Shrugged', 'Who is John Galt?', 1);
INSERT INTO ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 VALUES
   (4, 'A Prisoner of Birth', 'Jeffrey Archer', 1);   

INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (62, 1, 1, 'The Fountainhead');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (63, 1, 2, 'Ayn Rand');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (64, 1, 3, 'Bobb Williams');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (65, 1, 4, '07/26/1936');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (66, 1, 6, '900');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (67, 1, 7, 'Fiction:Objectivism');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (68, 1, 8, '500');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (69, 1, 9, '978-112322-123-1');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (70, 2, 1, 'The Godfather');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (71, 2, 2, 'Mario Puzo');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (72, 2, 3, 'FF Publishers');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (73, 2, 4, '08/01/1967');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (74, 2, 6, '600');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (75, 2, 7, 'Fiction:Crime');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (76, 2, 8, '300');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (77, 2, 9, '965-1112122-331-2');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (78, 3, 1, 'Atlas Shrugged');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (79, 3, 2, 'Ayn Rand');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (80, 3, 3, 'Blue Lagoon');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (81, 3, 4, '06/20/1957');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (82, 3, 6, '1600');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (83, 3, 7, 'Fiction:Objectivism');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (84, 3, 8, '700');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (85, 3, 9, '935-1123212-231-2');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (86, 4, 1, 'Prisoner of Birth');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (87, 4, 2, 'Jefffrey Archer');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (88, 4, 3, 'Striped Whites');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (89, 4, 4, '06/20/2008');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (90, 4, 6, '300');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (91, 4, 7, 'Fiction:Courtroom Drama');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (92, 4, 8, '700');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (93, 4, 9, '911-2322312-212-2');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (94, 5, 1, 'Programming Perl');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (95, 5, 2, 'Larry Wall');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (96, 5, 3, 'Humped Quadraped');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (97, 5, 4, '06/20/1988');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (98, 5, 6, '400');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (99, 5, 7, 'Computers:Programming');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (100, 5, 8, '700');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (101, 5, 9, '956-1023907-856-3');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (102, 6, 1, 'Effective Java');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (103, 6, 2, 'Joshua Bloch');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (104, 6, 3, 'Bespectaled Visions');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (105, 6, 4, '09/18/2005');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (106, 6, 6, '400');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (107, 6, 7, 'Computers:Programming');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (108, 6, 8, '700');
INSERT INTO ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 VALUES
   (109, 6, 9, '911-11139212-812-9');

INSERT INTO system_role
  (id,role,description) 
 VALUES
  (1,'Administrator','System Administrators');

INSERT INTO system_role
  (id,role,description) 
 VALUES
  (2,'Member','Member of the Library');  
  
INSERT INTO system_role
  (id,role,description) 
 VALUES
  (3,'Guest','Guest');    
  
  
  INSERT INTO system_feature(id,feature,description) VALUES (1,'SEARCH_ITEM','Search for Library Item');
  INSERT INTO system_feature(id,feature,description) VALUES (2,'SEARCH_MEMBER','Search for Library MEMBER');
  INSERT INTO system_feature(id,feature,description) VALUES (3,'CHECKOUT_ITEM','Checkout a Library Item');
  INSERT INTO system_feature(id,feature,description) VALUES (4,'RESERVE_ITEM','Reserve a Library Item');
  INSERT INTO system_feature(id,feature,description) VALUES (5,'ADD_MEMBER','Add a Library Member');
  INSERT INTO system_feature(id,feature,description) VALUES (6,'ADD_ITEM','Add a Library Item');
  INSERT INTO system_feature(id,feature,description) VALUES (7,'MODIFY_ITEM','Modify a Library Item');
  INSERT INTO system_feature(id,feature,description) VALUES (8,'VIEW_REPORT','View Library Reports');
  INSERT INTO system_feature(id,feature,description) VALUES (9,'EDIT_PREFERENCES','Edit System Preferences');
  
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(1,1,1,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(2,1,2,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(3,1,3,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(4,1,4,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(5,1,5,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(6,1,6,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(7,1,7,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(8,1,8,'Y','Y');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(9,1,9,'Y','Y');
  
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(10,2,1,'Y','N');
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(11,2,2,DEFAULT,DEFAULT);
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(12,2,3,DEFAULT,DEFAULT);
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(13,2,4,DEFAULT,DEFAULT);
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(14,2,5,DEFAULT,DEFAULT);
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(15,2,6,DEFAULT,DEFAULT);
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(16,2,7,DEFAULT,DEFAULT);
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(17,2,8,DEFAULT,DEFAULT);
  INSERT INTO role_feature (id,role_id,feature_id,VIEW,edit) VALUES(18,2,9,DEFAULT,DEFAULT);
  
  
# TABLE OR new books
CREATE TABLE Book
(
  isbn         VARCHAR(100)               NOT NULL,
  title        VARCHAR(250)               NOT NULL,                
  author       VARCHAR(250)               NOT NULL,
  publisher    VARCHAR(250)               NOT NULL,
  releaseDate  DATE  
)

INSERT INTO Book VALUES ('112321','Effective Java','Joshua Bloch','Wriley publisher','01-JAN-2001');
INSERT INTO Book VALUES ('112322','Software Architecture in Practice','Bazz Klemens','ORiely media','1991-01-01');
INSERT INTO Book VALUES ('112323','Patterns of Enterprise Architecture','Ruth Babe','ORiely media','1998-01-03');
INSERT INTO Book VALUES ('112324','Elemental Design Patterns','Audrey Kumar','ORiely media','2001-05-03');
INSERT INTO Book VALUES ('112325','The Taming of the Shrew','William Shakespeare','Penguin','2008-01-03');
INSERT INTO Book VALUES ('112326','Theory of Music','Ludwing Van Bach','Feathers publishing','1980-01-03');
INSERT INTO Book VALUES ('112327','Seven habits of higly effective people','Stephen Covey','ORiely media','1998-01-03');
INSERT INTO Book VALUES ('112328','Managing your time','Audrey Kumar','ORiely media','1998-01-03');
INSERT INTO Book VALUES ('112329','Living life in your own terms','Rixon Mathew','ORiely media','1998-02-05');
INSERT INTO Book VALUES ('112330','Indian cinema at its best','Anurag Kashyap','ORiely media','2012-01-03');


CREATE sequence member_id_seq AS bigint start WITH 100 increment BY 1;

CREATE TABLE MEMBER
(
  ID              INTEGER                 PRIMARY KEY,
  FIRST_NAME      VARCHAR(100)            NOT NULL,
  LAST_NAME       VARCHAR(100)            NOT NULL,
  EMAIL_ID        VARCHAR(100)            NOT NULL,
  PASSWORD        VARCHAR(100)            NOT NULL,	
  MOBILE_NUMBER   VARCHAR(30),
  POSTAL_ADDRESS  VARCHAR(4000)
)

INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (1, 'Rixon', 'Mathew', 'rixonmathew@gmail.com', 'lms123#','9545590291', 'Pune');
INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (2, 'Dinkar', 'Gupta', 'dinkargupta@gmail.com', 'password123','9965842261', 'Pune');
INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (3, 'Vaibhav', 'Deshpande', 'vaibhavdeshpande@gmail.com', 'password123', '9956654487', 'Jaipur');
INSERT INTO MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 VALUES
   (4, 'Divya', 'Jain', 'divyajain@gmail.com', 'password123', '6656744548', 'Zurich');


CREATE TABLE ITEM_TYPE
(
  ID           INTEGER                    PRIMARY KEY,
  TYPE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)              NOT NULL  
)

CREATE TABLE SYSTEM_ROLE
(
  ID           INTEGER                       PRIMARY KEY,
  ROLE         VARCHAR(20)                NOT NULL,
  DESCRIPTION  VARCHAR(500)               NOT NULL
)
