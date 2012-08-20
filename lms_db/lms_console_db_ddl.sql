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
