CREATE TABLE client
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) NOT NULL UNIQUE,
    description VARCHAR(255),
    name VARCHAR(255),
    rebates_id BIGINT
);

CREATE TABLE client_rebates
(
    client_id BIGINT NOT NULL,
    rebates_id BIGINT NOT NULL
);

CREATE TABLE document
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) NOT NULL UNIQUE,
    date DATETIME,
    number VARCHAR(255),
    tax_rate REAL,
    total_document_amount REAL,
    total_gross_amount REAL,
    total_net_amount REAL,
    total_tax_amount REAL,
    total_rebate_amount REAL,
    client_id BIGINT,
    type INT
);

CREATE TABLE document_line
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) NOT NULL UNIQUE,
    quantity REAL,
    product_id BIGINT
);

CREATE TABLE document_lines
(
    document_id BIGINT NOT NULL,
    lines_id BIGINT NOT NULL
);

CREATE TABLE product
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) NOT NULL UNIQUE,
    description VARCHAR(255),
    name VARCHAR(255),
    price REAL,
    number VARCHAR(255),
    stock REAL
);

CREATE TABLE rebate
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) NOT NULL UNIQUE,
    description VARCHAR(255),
    discount_percentage REAL,
    end_period DATETIME,
    quantity_threshold INT,
    start_period DATETIME,
    type INT,
    time_of_year INT
);

ALTER TABLE client_rebates ADD FOREIGN KEY (client_id) REFERENCES client (id);
ALTER TABLE client_rebates ADD FOREIGN KEY (rebates_id) REFERENCES rebate (id);
CREATE UNIQUE INDEX UK_4ke3naqqgvhv092n64ifp99un ON client_rebates (rebates_id);
CREATE INDEX FK_re57lsigf3oimiu51x9y27935 ON client_rebates (client_id);
ALTER TABLE document ADD FOREIGN KEY (client_id) REFERENCES client (id);
CREATE INDEX FK_fkkhgus997mjuggrw70m9tgg9 ON document (client_id);
ALTER TABLE document_line ADD FOREIGN KEY (product_id) REFERENCES product (id);
CREATE INDEX FK_bpnkpqos0k4bbdyryey5r327s ON document_line (product_id);
ALTER TABLE document_lines ADD FOREIGN KEY (document_id) REFERENCES document (id);
ALTER TABLE document_lines ADD FOREIGN KEY (lines_id) REFERENCES document_line (id);
CREATE UNIQUE INDEX UK_qdlivsomsy7mg3qu91le4s1ii ON document_lines (lines_id);
CREATE INDEX FK_41j8tgcjixx2p24yx586acg0s ON document_lines (document_id);
