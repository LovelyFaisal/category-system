DROP TABLE categories;

CREATE TABLE IF NOT EXISTS categories (
    id BIGINT NOT NULL AUTO_INCREMENT,
    slug VARCHAR(255) NOT NULL UNIQUE,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    sort_order INT DEFAULT 0,
    parent_id BIGINT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (parent_id) REFERENCES categories(id) ON DELETE CASCADE
);

use test;

SELECT * FROM categories;

INSERT INTO categories (slug, name_ar, name_en, parent_id) VALUES
('electronics', 'إلكترونيات', 'Electronics', NULL);

INSERT INTO categories (slug, name_ar, name_en, parent_id) VALUES
('mobiles',   'جوالات',  'Mobiles',   1),
('computers', 'حواسيب',  'Computers', 1),
('iphone',    'آيفون',   'iPhone',    2),
('samsung',   'سامسونج', 'Samsung',   2),
('macbook',   'ماك بوك', 'MacBook',   3),
('dell',      'ديل',     'Dell',      3);


SELECT * FROM categories ORDER BY sort_order ASC, parent_id ASC;




INSERT INTO categories (slug, name_ar, name_en, parent_id) VALUES
    ('iphonepromax', 'ايفون برو ماكس', 'iphone pro max', 2);
