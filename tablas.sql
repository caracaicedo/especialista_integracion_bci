-- Tabla para UserEntity
CREATE TABLE UserEntity (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created TIMESTAMP,
    modified TIMESTAMP,
    lastLogin TIMESTAMP,
    token VARCHAR(255),
    isActive BOOLEAN,
    PRIMARY KEY (id)
);

-- Tabla para PhoneEntity
CREATE TABLE PhoneEntity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(20) NOT NULL,
    citycode VARCHAR(10),
    contrycode VARCHAR(10),
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES UserEntity(id) ON DELETE CASCADE
);
