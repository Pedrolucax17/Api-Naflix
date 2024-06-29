CREATE TABLE tbl_serie (
    id bigint not null auto_increment,
    title VARCHAR(255) NOT NULL,
    total_season INT NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    actors VARCHAR(255) NOT NULL,
    plot VARCHAR(255) NOT NULL,
    poster VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
