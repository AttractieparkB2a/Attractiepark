-- import.sql file

-- TicketProduct
insert into ticket_product (id, name, description, price) values (1, "Gold", "Ticket which includes getting a photo with Mickey Mouse", 25);
insert into ticket_product (id, name, description, price) values (2, "Silver", "Ticket which includes getting a photo with Peter Pan", 20);
insert into ticket_product (id, name, description, price) values (3, "Bronze", "Base ticket", 15);

-- Role
insert into role (id, name) values (1, "ROLE_MEMBER");
insert into role (id, name) values (2, "ROLE_ADMIN");

-- User
insert into user (id, address, birthday, city, first_name, last_name, newsletter, password, username, zipcode, role_id) values (1, "Lovensdijkstraat", 1990/03/03, "Breda", "Admin", "Admin", 0, "$2a$10$.ZOOlJYCQfC5WeA4iS66Y.7HXTTze1Ao4nLFfrXP1Kw8I0UcsI7gW", "admin@b2a.com", "1111 AA", 2);