-- import.sql file

-- Role
insert into role (name) values ('ROLE_MEMBER');
insert into role (name) values ('ROLE_ADMIN');

-- Subscriber
insert into subscriber (email) values ('nkerdel@avans.nl');
insert into subscriber (email) values ('nskerdel@hotmail.com');

-- TicketProduct
insert into ticket_product (name, description, price) values ('Gold', 'Ticket with lunch and gift', 20);
insert into ticket_product (name, description, price) values ('Silver', 'Ticket with lunch', 15);
insert into ticket_product (name, description, price) values ('Bronze', 'Entry ticket', 10);

-- User
insert into park_user (address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values ('Lovensdijkstraat 61', '1990-01-01 00:00:00', 'Breda', 'Admin', 'Admin', FALSE , '$2a$10$.ZOOlJYCQfC5WeA4iS66Y.7HXTTze1Ao4nLFfrXP1Kw8I0UcsI7gW', 'admin@b2a.com', '1111 AA', 2);
insert into park_user (address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values ('Marconistraat 34', '1994-04-17 00:00:00', 'Rotterdam', 'Niels', 'Kerdel', TRUE, '$2a$10$ccEHdoGiiljrJ1SsO4EI4uk3K4p8CN.581K9e9qpxDIdR.t9mKTmy', 'n.kerdel@student.avans.nl', '3718 OQ', 1);
insert into park_user (address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values ('Beren-straat 193', '1996-01-28 00:00:00', 'Amsterdam', 'Bart', 'Helleman', FALSE, '$2a$10$6AtBQ6d2FBa0q7jIkJfIDuaNf03rpRz7TRzix1F8A8gPwbmUuLVF6', 'b.helleman1@student.avans.nl', '1938 MK', 1);
insert into park_user (address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values ('Haagweg 72', '1991-03-23 00:00:00', 'Breda', 'Ferdinand', 'van Disseldorp', FALSE, '$2a$10$wreYxlnR9qPdTECU1Brmsu.hx3q2Ar5fniNaZUyuhGNA6ufcKNOLW', 'fjp.vandisseldorp@student.avans.nl', '4812 XB', 1);
insert into park_user (address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values ('Handelsweg 23', '1983-09-11 00:00:00', 'Emmen', 'Mohamed', 'Charif', FALSE, '$2a$10$a7pcN3yeNRGX2DWiW0BggeNVuH6Ik0BSPEq.rvpi8I1pOXaclDp1.', 'm.charif@student.avans.nl', '7928 KI', 1);

-- UserImage
insert into user_image (name, user_id) values ('mickey', 2);
insert into user_image (name, user_id) values ('goofy', 2);
insert into user_image (name, user_id) values ('donald', 2);
