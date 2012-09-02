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


--MEMBER
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD)
 Values
   (1, 'Rixon', 'Mathew', 'rixonmathew@gmail.com', 'lms123#');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD)
 Values
   (2, 'Dinkar', 'Gupta', 'dinkargupta@gmail.com', 'password123');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD)
 Values
   (3, 'Vaibhav', 'Deshpande', 'vaibhavdeshpande@gmail.com', 'password123');
Insert into MEMBER
   (ID, FIRST_NAME, LAST_NAME, EMAIL_ID,PASSWORD)
 Values
   (4, 'Divya', 'Jain', 'divyajain@gmail.com', 'password123');


--ITEM
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
   
--PROPERTY
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

--ITEM_PROPERTY
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
   
   
insert into role(id,role,description) 
values(next value for role_id_seq,'MEMBER','Member of the Library');
insert into role(id,role,description) 
values(next value for role_id_seq,'USER','Standard user  of the Library');
insert into role(id,role,description) 
values(next value for role_id_seq,'ADMIN','User with admin privileges of the Library');
insert into role(id,role,description) 
values(next value for role_id_seq,'GUEST','Guest user of the Library');

insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,104,100,'Y')
insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,104,101,'Y')
insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,104,102,'Y')

insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,106,100,'Y')
insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,106,101,'Y')
insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,106,102,'Y')
insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,106,103,'Y')
insert into role_feature(id,role_id,feature_id,allowed)
values(next value for role_feature_id_seq,106,104,'Y')