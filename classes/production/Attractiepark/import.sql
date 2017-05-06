-- import.sql file

-- TicketProduct
insert into ticket_product (id, name, description, price) values (100000, 'Gold', 'Ticket with lunch and gift', 10);
insert into ticket_product (id, name, description, price) values (100001, 'Silver', 'Ticket with lunch', 10);
insert into ticket_product (id, name, description, price) values (100002, 'Bronze', 'Entry ticket', 10);

-- Role
insert into role (id, name) values (100000, 'ROLE_MEMBER');
insert into role (id, name) values (100001, 'ROLE_ADMIN');
-- User
insert into park_user (id, address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values (100000, 'Lovensdijkstraat', '1990-03-03 00:00:00', 'Breda', 'Admin', 'Admin', FALSE , '$2a$10$.ZOOlJYCQfC5WeA4iS66Y.7HXTTze1Ao4nLFfrXP1Kw8I0UcsI7gW', 'admin@b2a.com', '1111 AA', 100001);
insert into park_user (id, address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values (100001, 'Dokter Blomsingel', '1996-02-26 00:00:00', 'Krimpen aan den IJssel', 'Niels', 'Kerdel', FALSE, '$2a$10$t8Os2D.wJbEjGzAjgE51N.JZTiyROXXhbZGoa7tMGbK9G8lsCSADW', 'nskerdel@hotmail.com', '2922 CD', 100000);
