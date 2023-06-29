INSERT INTO USERS (user_id, username, email, password, created_date, updated_date) values (1, 'luis', 'luis@foo.bar', 'abcd', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())

INSERT INTO CATEGORIES (category_id, name, created_date, updated_date) values (1, 'Java', CURRENT_TIMESTAMP(), NULL)
INSERT INTO CATEGORIES (category_id, name, created_date, updated_date) values (2, 'Go', CURRENT_TIMESTAMP(), NULL)
INSERT INTO CATEGORIES (category_id, name, created_date, updated_date) values (3, 'Python', CURRENT_TIMESTAMP(), NULL)
INSERT INTO CATEGORIES (category_id, name, created_date, updated_date) values (4, 'Databases', CURRENT_TIMESTAMP(), NULL)

INSERT INTO SUBCATEGORIES (subcategory_id, name, category_id, created_date, updated_date) values (1, 'Spring Boot', 1, CURRENT_TIMESTAMP(), NULL)
INSERT INTO SUBCATEGORIES (subcategory_id, name, category_id, created_date, updated_date) values (2, 'Annotations', 1, CURRENT_TIMESTAMP(), NULL)
INSERT INTO SUBCATEGORIES (subcategory_id, name, category_id, created_date, updated_date) values (3, 'Stream API', 1, CURRENT_TIMESTAMP(), NULL)
INSERT INTO SUBCATEGORIES (subcategory_id, name, category_id, created_date, updated_date) values (4, 'Go Routines', 2, CURRENT_TIMESTAMP(), NULL)
INSERT INTO SUBCATEGORIES (subcategory_id, name, category_id, created_date, updated_date) values (5, 'Generics', 2, CURRENT_TIMESTAMP(), NULL)

INSERT INTO TAGS (tag_id, name, created_date, updated_date) values (1, 'Development', CURRENT_TIMESTAMP(), NULL)
INSERT INTO TAGS (tag_id, name, created_date, updated_date) values (2, 'Practice', CURRENT_TIMESTAMP(), NULL)
INSERT INTO TAGS (tag_id, name, created_date, updated_date) values (3, 'Powerful', CURRENT_TIMESTAMP(), NULL)

INSERT INTO POSTS (post_id, title, content, user_id, subcategory_id, created_date, updated_date) values (1, 'Spring Boot 3.0 New Features', 'Spring boot 3.0 is coming with this new features...', 1, 1, CURRENT_TIMESTAMP(), NULL)
INSERT INTO POSTS (post_id, title, content, user_id, subcategory_id, created_date, updated_date) values (2, 'Foo bar', 'Lorem ipsum foo', 1, NULL, CURRENT_TIMESTAMP(), NULL)

INSERT INTO POSTS_TAGS (posts_tags_id, post_id, tag_id, created_date, updated_date) values (1, 1, 1, CURRENT_TIMESTAMP(), NULL)
INSERT INTO POSTS_TAGS (posts_tags_id, post_id, tag_id, created_date, updated_date) values (2, 1, 2, CURRENT_TIMESTAMP(), NULL)
