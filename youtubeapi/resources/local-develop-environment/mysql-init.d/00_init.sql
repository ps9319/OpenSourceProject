CREATE
    USER 'opensource-local'@'localhost' IDENTIFIED BY 'opensource-local';
CREATE
    USER 'opensource-local'@'%' IDENTIFIED BY 'opensource-local';

GRANT ALL PRIVILEGES ON *.* TO
    'opensource-local'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO
    'opensource-local'@'%';

CREATE
    DATABASE opensource DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
