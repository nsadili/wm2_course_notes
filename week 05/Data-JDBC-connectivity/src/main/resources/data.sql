CREATE TABLE book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      author VARCHAR(100) NOT NULL,
                      publisher VARCHAR(100) NOT NULL,
                      isbn VARCHAR(13) NOT NULL,
                      quantity INT NOT NULL,
                      price DECIMAL(10, 2) NOT NULL
);
