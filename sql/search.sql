create table PERSON
(PERSON_ID INTEGER NOT NULL PRIMARY KEY, PERSON_NAME VARCHAR(205) NOT NULL, PERSON_ALIAS_NAME VARCHAR(250),
PERSON_ADDRESS VARCHAR(250), DOB DATETIME, ROLE_ID INTEGER NOT NULL FOREIGN KEY REFERENCES ROLES (ROLE_ID)) 

CREATE TABLE DEPARTMENT 
(DEPARTMENT_ID INTEGER NOT NULL PRIMARY KEY, DEPARTMENT_NAME VARCHAR(250) NOT NULL)

CREATE TABLE ROLES (ROLE_ID INTEGER NOT NULL PRIMARY KEY, ROLE_NAME VARCHAR(250) NOT NULL)

create table ROLE_DEPARTMENT (
ROLE_ID INTEGER NOT NULL FOREIGN KEY REFERENCES ROLES (ROLE_ID), DEPARTMENT_ID INTEGER NOT NULL FOREIGN KEY REFERENCES
DEPARTMENT (DEPARTMENT_ID))

INSERT INTO ROLES (ROLE_ID, ROLE_NAME) VALUES (1, 'Senior HR')
INSERT INTO ROLES (ROLE_ID, ROLE_NAME) VALUES (2, 'HR')
INSERT INTO ROLES (ROLE_ID, ROLE_NAME) VALUES (3, 'HR Trainee')
INSERT INTO ROLES (ROLE_ID, ROLE_NAME) VALUES (4, 'Developer')
INSERT INTO ROLES (ROLE_ID, ROLE_NAME) VALUES (5, 'Senior Developer')
INSERT INTO ROLES (ROLE_ID, ROLE_NAME) VALUES (6, 'Team Lead')
INSERT INTO ROLES (ROLE_ID, ROLE_NAME) VALUES (7, 'Project Manager')

update roles set role_name = 'Project Manager' where role_id = 7

INSERT INTO DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES (1, 'Admin')
INSERT INTO DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES (2, 'development')
INSERT INTO DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES (3, 'manager')

INSERT INTO ROLE_DEPARTMENT (ROLE_ID, DEPARTMENT_ID) VALUES (1, 1)
INSERT INTO ROLE_DEPARTMENT (ROLE_ID, DEPARTMENT_ID) VALUES (2, 1)
INSERT INTO ROLE_DEPARTMENT (ROLE_ID, DEPARTMENT_ID) VALUES (3, 1)
INSERT INTO ROLE_DEPARTMENT (ROLE_ID, DEPARTMENT_ID) VALUES (4, 2)
INSERT INTO ROLE_DEPARTMENT (ROLE_ID, DEPARTMENT_ID) VALUES (5, 2)
INSERT INTO ROLE_DEPARTMENT (ROLE_ID, DEPARTMENT_ID) VALUES (6, 3)
INSERT INTO ROLE_DEPARTMENT (ROLE_ID, DEPARTMENT_ID) VALUES (7, 3)

select person.person_name, person.person_alias_name,department.department_name, roles.role_name, city.city_name, state.state_name, state.state_code
from roles, department, role_department, state, city, state_city, person
where person.person_name like 'Sandeep'
and person.role_id = role_department.role_id 
and person.city_id = state_city.city_id
and role_department.role_id = roles.role_id
and role_department.department_id = department.department_id
and state_city.city_id = city.city_id
and state_city.state_id = state.state_id

select * from state_city
select * from city
select * from person


Create Table STATE
(STATE_ID INTEGER NOT NULL PRIMARY KEY, STATE_CODE VARCHAR(2) NOT NULL, STATE_NAME VARCHAR(250) NOT NULL)

CREATE TABLE CITY
(CITY_ID INTEGER NOT NULL PRIMARY KEY , CITY_NAME VARCHAR(250) NOT NULL)


CREATE TABLE STATE_CITY
(CITY_ID INTEGER FOREIGN KEY REFERENCES CITY (CITY_ID), STATE_ID INTEGER FOREIGN KEY REFERENCES STATE (STATE_ID))


ALTER TABLE PERSON ADD CITY_ID INTEGER FOREIGN KEY REFERENCES CITY (CITY_ID)

INSERT INTO STATE (STATE_ID, STATE_CODE, STATE_NAME) VALUES (1, 'KR', 'KARNATAKA')
INSERT INTO STATE (STATE_ID, STATE_CODE, STATE_NAME) VALUES (2, 'TN', 'TAMIL NADU')
INSERT INTO STATE (STATE_ID, STATE_CODE, STATE_NAME) VALUES (3, 'AP', 'ANDHRA PRADESH')

INSERT INTO CITY (CITY_ID, CITY_NAME) VALUES (1, 'Bangalore')
INSERT INTO CITY (CITY_ID, CITY_NAME) VALUES (2, 'Mangalore')
INSERT INTO CITY (CITY_ID, CITY_NAME) VALUES (3, 'Mysore')

insert into state_city (state_id, city_id) values (1, 1)
insert into state_city (state_id, city_id) values (1, 2)
insert into state_city (state_id, city_id) values (1, 3)

insert into person (person_id, person_name, person_alias_name, person_address, dob, role_id, city_id) values
(100, 'Sandeep', 'Sandy', 'indiranagar', cast('1975/12/23' as datetime ), 4, 1)

select* from person