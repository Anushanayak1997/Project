insert into USER_REGISTER(USER_ID, CONTACT_NO, EMAIL_ID, FIRSTNAME, LASTNAME, PASSWORD, USER_TYPE) values(100,'9876543212','anushanayak@gmail.com','Anusha','Nayak', 'anusha', 'Employer');
insert into USER_REGISTER(USER_ID, CONTACT_NO, EMAIL_ID, FIRSTNAME, LASTNAME, PASSWORD, USER_TYPE) values(101,'9876543212','monisha@gmail.com','Monisha','Krishnan', 'monisha', 'Employer');
insert into USER_REGISTER(USER_ID, CONTACT_NO, EMAIL_ID, FIRSTNAME, LASTNAME, PASSWORD, USER_TYPE) values(102,'9876543212','namrata@gmail.com','Namrata','Nadang', 'namrata', 'Employer');
insert into USER_REGISTER(USER_ID, CONTACT_NO, EMAIL_ID, FIRSTNAME, LASTNAME, PASSWORD, USER_TYPE) values(103,'9876543212','akheel@gmail.com','Akheel','Sajjan', 'akheel', 'Employer');

insert into COMPANY(COMPANY_ID,company_name,company_description,establishment_date,website_url,headquarter,specialities,industry,company_type) values(100,'SONY','SONY is a Japanese multinational conglomerate corporation headquartered in Konan, Minato, Tokyo.Its diversified business includes consumer and professional electronics, gaming, entertainment and financial services.','7/05/1946','sony.co.in','Tokyo','The fifth-largest television manufacturer','Entertaiment, Finance, Software, Electronics','Conglomerate');
insert into COMPANY(COMPANY_ID,company_name,company_description,establishment_date,website_url,headquarter,specialities,industry,company_type) values(101,'Google','Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, search engine, cloud computing, software, and hardware','4/09/1998','www.google.com','California, US','Google.com is the most visited website in the world','Internet,Cloud computing,Computer software,Computer hardware,Artificial intelligence,Advertising','Internet-related services and products');
insert into COMPANY(COMPANY_ID,company_name,company_description,establishment_date,website_url,headquarter,specialities,industry,company_type) values(102,'HP','HP is an American multinational information technology company headquartered in Palo Alto, California','1/01/1939','www.hp.com','California, US','HP specialized in developing and manufacturing computing, data storage, and networking hardware, designing software and delivering services','Hardware, Software','Computer hardware,Computer software,IT services,IT consulting');
insert into COMPANY(COMPANY_ID,company_name,company_description,establishment_date,website_url,headquarter,specialities,industry,company_type) values(103,'Microsoft','Microsoft Corporation is an American multinational technology company with headquarters in Redmond, Washington','4/04/1975','www.microsoft.com','Washington, US','In April 2019, Microsoft reached the trillion-dollar market cap, becoming the third U.S. public company to be valued at over $1 trillion','Software development,Computer hardware,Consumer electronics,Social networking service,Cloud computing,Video games,Internet,Corporate venture capital','Public');

insert into emp_company(ID, COMPANY_ID, USER_ID) VALUES(100, 100, 100);
insert into emp_company(ID, COMPANY_ID, USER_ID) VALUES(101, 101, 101);
insert into emp_company(ID, COMPANY_ID, USER_ID) VALUES(102, 102, 102);
insert into emp_company(ID, COMPANY_ID, USER_ID) VALUES(103, 103, 103);

insert into user_detail values(1,'anu@gmail,com','anusha','344');

insert into skillset(skill_id, skill_name) values(100, 'Java');
insert into skillset(skill_id, skill_name) values(101, 'Python');
insert into skillset(skill_id, skill_name) values(102, 'C/C++');
insert into skillset(skill_id, skill_name) values(103, 'Angular');
insert into skillset(skill_id, skill_name) values(104, 'SQL');
insert into skillset(skill_id, skill_name) values(105, '.Net');
insert into skillset(skill_id, skill_name) values(106, 'Machine Learning');