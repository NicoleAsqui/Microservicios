CREATE TABLE IF NOT EXISTS Book (
                                    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    TITLE VARCHAR(255) NOT NULL,
                                    AUTHOR VARCHAR(255) NOT NULL,
                                    PUBLICATIONDATE VARCHAR(20),
                                    CATEGORY VARCHAR(100),
                                    ISBN VARCHAR(20) UNIQUE,
                                    RATING DOUBLE,
                                    VISIBLE BOOLEAN
);