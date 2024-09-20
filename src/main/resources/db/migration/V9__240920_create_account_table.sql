CREATE TABLE if not exists accounts
(
    id         VARCHAR(255)   NOT NULL,
    created_at datetime       NULL,
    balance    DECIMAL(10, 2) NULL,
    is_active  BIT(1)         NULL,
    CONSTRAINT pk_accounts PRIMARY KEY (id)
);