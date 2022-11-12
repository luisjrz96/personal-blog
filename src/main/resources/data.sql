INSERT INTO categories (id, name, created_at) values (1, 'Java', CURRENT_TIMESTAMP());
INSERT INTO categories (id, name, created_at) values (2, 'Python', CURRENT_TIMESTAMP());
INSERT INTO categories (id, name, created_at) values (3, 'Networking', CURRENT_TIMESTAMP());
INSERT INTO categories (id, name, created_at) values (4, 'Kubernetes', CURRENT_TIMESTAMP());


INSERT INTO subcategories (id, category_id, name, created_at) values (1, 1, 'Spring Boot', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (2, 1, 'Kafka', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (3, 1, 'Java FX', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (4, 2, 'Web Scraping', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (5, 2, 'JPA', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (6, 2, 'Pandas', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (7, 2, 'CEH with Scapy', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (8, 3, 'TCP/IP', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (9, 3, 'DNS', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (10, 4, 'Ingress', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (11, 4, 'ConfigMaps and Secrets', CURRENT_TIMESTAMP());
INSERT INTO subcategories (id, category_id, name, created_at) values (12, 4, 'Deployments', CURRENT_TIMESTAMP());

INSERT INTO tags (id,name, created_at) values (1, 'Development', CURRENT_TIMESTAMP());
INSERT INTO tags (id,name, created_at) values (2, 'Microservices', CURRENT_TIMESTAMP());
INSERT INTO tags (id,name, created_at) values (3, 'Internet', CURRENT_TIMESTAMP());
INSERT INTO tags (id,name, created_at) values (4, 'Frameworks', CURRENT_TIMESTAMP());
INSERT INTO tags (id,name, created_at) values (5, 'Maths', CURRENT_TIMESTAMP());


INSERT INTO posts (id, title,content, created_at) values (1, 'Implement a TODO list in Spring Boot', 'Content about - Implement a TODO list in Spring Boot', CURRENT_TIMESTAMP());
INSERT INTO posts (id, title,content, created_at) values (2, 'Unit and integration test for Spring Rest API', 'Content about - Unit and integration test for Spring Rest API', CURRENT_TIMESTAMP());
INSERT INTO posts (id, title,content, created_at) values (3, 'Support Vector Machines', 'Content about - Support Vector Machines', CURRENT_TIMESTAMP());
INSERT INTO posts (id, title,content, created_at) values (4, 'Spring Security', 'Content about - Spring Security', CURRENT_TIMESTAMP());
INSERT INTO posts (id, title,content, created_at) values (5, 'Configure secrets and configmaps using kubernetes', 'Content about -  Configure secrets and configmaps using kubernetes', CURRENT_TIMESTAMP());
INSERT INTO posts (id, title,content, created_at) values (6, 'HTTP Protocol Overview', 'Content about - HTTP Protocol Overview', CURRENT_TIMESTAMP());


INSERT INTO posts_subcategories (id, subcategory_id, post_id, created_at) values (1, 1, 1, CURRENT_TIMESTAMP());
INSERT INTO posts_subcategories (id, subcategory_id, post_id, created_at) values (2, 1, 2, CURRENT_TIMESTAMP());
INSERT INTO posts_subcategories (id, subcategory_id, post_id, created_at) values (3, 6, 3, CURRENT_TIMESTAMP());
INSERT INTO posts_subcategories (id, subcategory_id, post_id, created_at) values (4, 11, 5, CURRENT_TIMESTAMP());
INSERT INTO posts_subcategories (id, subcategory_id, post_id, created_at) values (5, 8, 6, CURRENT_TIMESTAMP());
INSERT INTO posts_subcategories (id, subcategory_id, post_id, created_at) values (6, 8, 6, CURRENT_TIMESTAMP());

INSERT INTO posts_tags (id, tag_id, post_id, created_at) values (1, 1, 1, CURRENT_TIMESTAMP());
INSERT INTO posts_tags (id, tag_id, post_id, created_at) values (2, 1, 2, CURRENT_TIMESTAMP());
INSERT INTO posts_tags (id, tag_id, post_id, created_at) values (3, 1, 4, CURRENT_TIMESTAMP());
INSERT INTO posts_tags (id, tag_id, post_id, created_at) values (4, 4, 1, CURRENT_TIMESTAMP());
INSERT INTO posts_tags (id, tag_id, post_id, created_at) values (5, 3, 6, CURRENT_TIMESTAMP());
INSERT INTO posts_tags (id, tag_id, post_id, created_at) values (6, 5, 3, CURRENT_TIMESTAMP());


INSERT INTO comments (id,post_id, content, created_at) values (1, 1, 'ABCEFGHIJ', CURRENT_TIMESTAMP());
INSERT INTO comments (id,post_id, content, created_at) values (2, 1, 'KLMNOPQES', CURRENT_TIMESTAMP());
INSERT INTO comments (id,post_id, content, created_at) values (3, 2, 'KLMNOPQES', CURRENT_TIMESTAMP());
INSERT INTO comments (id,post_id, content, created_at) values (4, 5, 'JDKFDJDIJFDIFJID', CURRENT_TIMESTAMP());
