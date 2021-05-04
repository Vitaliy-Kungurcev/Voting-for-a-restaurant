# drop table lunch.authorities;
# drop table lunch.users;
#
# CREATE TABLE users
# (
#
#     username varchar(15),
#     password varchar(100),
#     enabled  tinyint(1),
#     PRIMARY KEY (username)
# );
#
# CREATE TABLE authorities
# (
#     username  varchar(15),
#     authority varchar(25),
#     FOREIGN KEY (username) references users (username)
# );
#
# INSERT INTO lunch.users (username, password, enabled)
# VALUES ('vitaliy', '{noop}vitaliy', 1),
#        ('elena', '{noop}elena', 1),
#
#        ('eva', '{noop}eva', 1),
#        ('oleg', '{noop}oleg', 1),
#        ('adam', '{noop}adam', 1),
#        ('egor', '{noop}egor', 1),
#        ('rita', '{noop}rita', 1),
#        ('mila', '{noop}mila', 1),
#        ('isa', '{noop}isa', 1),
#        ('alex', '{noop}alex', 1),
#
#        ('ivan', '{noop}ivan', 1);
#
#
#
#
# INSERT INTO lunch.authorities (username, authority)
# VALUES ('vitaliy', 'ROLE_EMPLOYEE'),
#        ('elena', 'ROLE_EMPLOYEE'),
#        ('eva', 'ROLE_EMPLOYEE'),
#        ('oleg', 'ROLE_EMPLOYEE'),
#        ('adam', 'ROLE_EMPLOYEE'),
#        ('egor', 'ROLE_EMPLOYEE'),
#        ('rita', 'ROLE_EMPLOYEE'),
#        ('mila', 'ROLE_EMPLOYEE'),
#        ('isa', 'ROLE_EMPLOYEE'),
#        ('alex', 'ROLE_EMPLOYEE'),
#
#        ('ivan', 'ROLE_ADMIN');
#
#
#
