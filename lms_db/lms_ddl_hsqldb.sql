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
ALTER TABLE ITEM ADD FOREIGN KEY (ITEM_TYPE_ID) REFERENCES ITEM_TYPE(ID)

ALTER TABLE TRANSACTION_HISTORY ADD FOREIGN KEY (TRANSACTION_ID) REFERENCES ITEM_TRANSACTION (ID)

ALTER TABLE PROPERTY ADD FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID);

ALTER TABLE ITEM_TYPE_PROPERTY ADD FOREIGN KEY (ITEM_TYPE_ID) REFERENCES ITEM_TYPE (ID);

ALTER TABLE ITEM_TYPE_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY (ID);

ALTER TABLE ITEM_TRANSACTION_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY (ID);

ALTER TABLE ITEM_TRANSACTION_PROPERTY ADD FOREIGN KEY (ITEM_TRANSACTION_ID) REFERENCES ITEM_TRANSACTION (ID);

ALTER TABLE ITEM_TRANSACTION ADD FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER (ID);

ALTER TABLE ITEM_TRANSACTION ADD FOREIGN KEY (TRANSACTION_ID) REFERENCES TRANSACTION_TYPE (ID);

ALTER TABLE ITEM_TRANSACTION ADD FOREIGN KEY (INSTANCE_ID) REFERENCES ITEM_INSTANCE (ID);

ALTER TABLE ITEM_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY (ID);

ALTER TABLE ITEM_PROPERTY ADD FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID);

--
ALTER TABLE ITEM_INSTANCE_PROPERTY ADD FOREIGN KEY (PROPERTY_ID) REFERENCES PROPERTY (ID);

ALTER TABLE ITEM_INSTANCE_PROPERTY ADD FOREIGN KEY (ITEM_INSTANCE_ID) REFERENCES ITEM_INSTANCE (ID)

ALTER TABLE ITEM_INSTANCE ADD FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID);

ALTER TABLE ITEM ADD FOREIGN KEY (ITEM_TYPE_ID) REFERENCES ITEM_TYPE (ID);

ALTER TABLE ROLE_FEATURE ADD FOREIGN KEY (ROLE_ID) REFERENCES SYSTEM_ROLE(ID);

ALTER TABLE ROLE_FEATURE ADD FOREIGN KEY (FEATURE_ID) REFERENCES SYSTEM_FEATURE(ID);



--Insert data
Insert into CATEGORY
   (ID, NAME, DESCRIPTION)
 Values
   (1, 'ITEM_PROPERTY', 'This category is for grouping all the properties that belongs to a Library Item');
Insert into CATEGORY
   (ID, NAME, DESCRIPTION)
 Values
   (2, 'INSTANCE_PROPERTY', 'This category grpups all properties that belong to an instance');
Insert into CATEGORY
   (ID, NAME, DESCRIPTION)
 Values
   (3, 'OWNER_TYPES', 'This category groups the various kinds of owners for a library item');
Insert into CATEGORY
   (ID, NAME, DESCRIPTION)
 Values
   (4, 'TRANSACTION_PROPERTY', 'This category groups the properties that belongs to a transaction');

Insert into ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 Values
   ('BOOK', 'Books', 1);
Insert into ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 Values
   ('MOVIE', 'Movies', 2);
Insert into ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 Values
   ('MUSIC', 'Audio', 3);
Insert into ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 Values
   ('GAME', 'Console Games', 4);
Insert into ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 Values
   ('MAGAZINE', 'Magazine', 5);
Insert into ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 Values
   ('JOURNAL', 'Journals', 6);
Insert into ITEM_TYPE
   (TYPE, DESCRIPTION, ID)
 Values
   ('NEWSPAPER', 'Newspaper Archives', 7);

Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
   (1, 'Rixon', 'Mathew', 'rixonmathew@gmail.com', '9545590291', 'Pune');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
   (2, 'Dinkar', 'Gupta', 'dinkargupta@gmail.com', '9965842261', 'Pune');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
   (3, 'Vaibhav', 'Deshpande', 'vaibhavdeshpande@gmail.com', '9956654487', 'Jaipur');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
   (4, 'Divya', 'Jain', 'divyajain@gmail.com', '6656744548', 'Zurich');

Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (1, 1, 'TITLE', 'Title', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (2, 1, 'AUTHOR', 'Author', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (3, 1, 'PUBLISHER', 'Publisher', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (4, 1, 'PUBLISHED_DATE', 'Date item was published', 'Date');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (5, 2, 'COVER_TYPE', 'Cover Type', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (6, 1, 'PAGES', 'No. of pages', 'Number');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (7, 1, 'GENRE', 'Genre', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (8, 1, 'PRICE', 'Price', 'Money');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (9, 1, 'ISBN', 'Isbn', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (10, 1, 'WEBSITE', 'Website', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (11, 1, 'CATEGORY', 'Category', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (12, 1, 'GENRE', 'Genre', 'String');
Insert into PROPERTY
   (ID, CATEGORY_ID, NAME, DESCRIPTION, DATA_TYPE)
 Values
   (13, 1, 'RATING', 'Rating', 'String');

Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 1, 'Y');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 2, 'Y');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 3, 'Y');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 4, 'Y');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 6, 'N');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 7, 'Y');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 8, 'Y');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 9, 'Y');
Insert into ITEM_TYPE_PROPERTY
   (ITEM_TYPE_ID, PROPERTY_ID, MANDATORY)
 Values
   (1, 10, 'N');
   
   
Insert into ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 Values
   (5, 'Programming Perl', 'The primer on Perl Programming', 1);
Insert into ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 Values
   (6, 'Effective Java', 'A guide to using Java effectively', 1);
Insert into ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 Values
   (1, 'The Fountainhead', 'A classic on Objectivitism', 1);
Insert into ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 Values
   (2, 'The Godfather', 'Story about rise of Italian mafia in US', 1);
Insert into ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 Values
   (3, 'Atlas Shrugged', 'Who is John Galt?', 1);
Insert into ITEM
   (ID, NAME, DESCRIPTION, ITEM_TYPE_ID)
 Values
   (4, 'A Prisoner of Birth', 'Jeffrey Archer', 1);   

Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (62, 1, 1, 'The Fountainhead');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (63, 1, 2, 'Ayn Rand');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (64, 1, 3, 'Bobb Williams');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (65, 1, 4, '07/26/1936');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (66, 1, 6, '900');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (67, 1, 7, 'Fiction:Objectivism');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (68, 1, 8, '500');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (69, 1, 9, '978-112322-123-1');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (70, 2, 1, 'The Godfather');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (71, 2, 2, 'Mario Puzo');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (72, 2, 3, 'FF Publishers');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (73, 2, 4, '08/01/1967');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (74, 2, 6, '600');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (75, 2, 7, 'Fiction:Crime');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (76, 2, 8, '300');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (77, 2, 9, '965-1112122-331-2');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (78, 3, 1, 'Atlas Shrugged');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (79, 3, 2, 'Ayn Rand');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (80, 3, 3, 'Blue Lagoon');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (81, 3, 4, '06/20/1957');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (82, 3, 6, '1600');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (83, 3, 7, 'Fiction:Objectivism');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (84, 3, 8, '700');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (85, 3, 9, '935-1123212-231-2');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (86, 4, 1, 'Prisoner of Birth');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (87, 4, 2, 'Jefffrey Archer');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (88, 4, 3, 'Striped Whites');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (89, 4, 4, '06/20/2008');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (90, 4, 6, '300');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (91, 4, 7, 'Fiction:Courtroom Drama');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (92, 4, 8, '700');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (93, 4, 9, '911-2322312-212-2');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (94, 5, 1, 'Programming Perl');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (95, 5, 2, 'Larry Wall');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (96, 5, 3, 'Humped Quadraped');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (97, 5, 4, '06/20/1988');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (98, 5, 6, '400');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (99, 5, 7, 'Computers:Programming');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (100, 5, 8, '700');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (101, 5, 9, '956-1023907-856-3');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (102, 6, 1, 'Effective Java');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (103, 6, 2, 'Joshua Bloch');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (104, 6, 3, 'Bespectaled Visions');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (105, 6, 4, '09/18/2005');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (106, 6, 6, '400');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (107, 6, 7, 'Computers:Programming');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (108, 6, 8, '700');
Insert into ITEM_PROPERTY
   (ID, ITEM_ID, PROPERTY_ID, PROPERTY_VALUE)
 Values
   (109, 6, 9, '911-11139212-812-9');

insert into system_role
  (id,role,description) 
 Values
  (1,'Administrator','System Administrators');

insert into system_role
  (id,role,description) 
 Values
  (2,'Member','Member of the Library');  
  
insert into system_role
  (id,role,description) 
 Values
  (3,'Guest','Guest');    
  
  
  insert into system_feature(id,feature,description) values (1,'SEARCH_ITEM','Search for Library Item');
  insert into system_feature(id,feature,description) values (2,'SEARCH_MEMBER','Search for Library MEMBER');
  insert into system_feature(id,feature,description) values (3,'CHECKOUT_ITEM','Checkout a Library Item');
  insert into system_feature(id,feature,description) values (4,'RESERVE_ITEM','Reserve a Library Item');
  insert into system_feature(id,feature,description) values (5,'ADD_MEMBER','Add a Library Member');
  insert into system_feature(id,feature,description) values (6,'ADD_ITEM','Add a Library Item');
  insert into system_feature(id,feature,description) values (7,'MODIFY_ITEM','Modify a Library Item');
  insert into system_feature(id,feature,description) values (8,'VIEW_REPORT','View Library Reports');
  insert into system_feature(id,feature,description) values (9,'EDIT_PREFERENCES','Edit System Preferences');
  
  insert into role_feature (id,role_id,feature_id,view,edit) values(1,1,1,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(2,1,2,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(3,1,3,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(4,1,4,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(5,1,5,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(6,1,6,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(7,1,7,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(8,1,8,'Y','Y');
  insert into role_feature (id,role_id,feature_id,view,edit) values(9,1,9,'Y','Y');
  
  insert into role_feature (id,role_id,feature_id,view,edit) values(10,2,1,'Y','N');
  insert into role_feature (id,role_id,feature_id,view,edit) values(11,2,2,DEFAULT,DEFAULT);
  insert into role_feature (id,role_id,feature_id,view,edit) values(12,2,3,DEFAULT,DEFAULT);
  insert into role_feature (id,role_id,feature_id,view,edit) values(13,2,4,DEFAULT,DEFAULT);
  insert into role_feature (id,role_id,feature_id,view,edit) values(14,2,5,DEFAULT,DEFAULT);
  insert into role_feature (id,role_id,feature_id,view,edit) values(15,2,6,DEFAULT,DEFAULT);
  insert into role_feature (id,role_id,feature_id,view,edit) values(16,2,7,DEFAULT,DEFAULT);
  insert into role_feature (id,role_id,feature_id,view,edit) values(17,2,8,DEFAULT,DEFAULT);
  insert into role_feature (id,role_id,feature_id,view,edit) values(18,2,9,DEFAULT,DEFAULT);
  
  
# table or new books
CREATE TABLE Book
(
  isbn         VARCHAR(100)               NOT NULL,
  title        VARCHAR(250)               NOT NULL,                
  author       VARCHAR(250)               NOT NULL,
  publisher    VARCHAR(250)               NOT NULL,
  releaseDate  DATE  
)

insert into Book values ('112321','Effective Java','Joshua Bloch','Wriley publisher','01-JAN-2001');
insert into Book values ('112322','Software Architecture in Practice','Bazz Klemens','ORiely media','1991-01-01');
insert into Book values ('112323','Patterns of Enterprise Architecture','Ruth Babe','ORiely media','1998-01-03');
insert into Book values ('112324','Elemental Design Patterns','Audrey Kumar','ORiely media','2001-05-03');
insert into Book values ('112325','The Taming of the Shrew','William Shakespeare','Penguin','2008-01-03');
insert into Book values ('112326','Theory of Music','Ludwing Van Bach','Feathers publishing','1980-01-03');
insert into Book values ('112327','Seven habits of higly effective people','Stephen Covey','ORiely media','1998-01-03');
insert into Book values ('112328','Managing your time','Audrey Kumar','ORiely media','1998-01-03');
insert into Book values ('112329','Living life in your own terms','Rixon Mathew','ORiely media','1998-02-05');
insert into Book values ('112330','Indian cinema at its best','Anurag Kashyap','ORiely media','2012-01-03');


create sequence member_id_seq as bigint start with 100 increment by 1;

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

Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
   (1, 'Rixon', 'Mathew', 'rixonmathew@gmail.com', 'lms123#','9545590291', 'Pune');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
   (2, 'Dinkar', 'Gupta', 'dinkargupta@gmail.com', 'password123','9965842261', 'Pune');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
   (3, 'Vaibhav', 'Deshpande', 'vaibhavdeshpande@gmail.com', 'password123', '9956654487', 'Jaipur');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD, MOBILE_NUMBER, POSTAL_ADDRESS)
 Values
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
