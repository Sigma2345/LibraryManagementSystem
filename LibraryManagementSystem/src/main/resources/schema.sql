DROP TABLE IF EXISTS "admins";
DROP TABLE IF EXISTS "users";
DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "orders";

CREATE SEQUENCE "admins_id_seq"
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 1000000
    START WITH 1;

CREATE TABLE "admins" (
    "id"  bigint DEFAULT nextval('admins_id_seq') NOT NULL,
    "name" text,
    "age" integer,
    CONSTRAINT "authors_pkey" PRIMARY KEY("id")
);

CREATE SEQUENCE "users_id_seq"
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 1000000
    START WITH 1;

CREATE TABLE "users" (
    "id"  bigint DEFAULT nextval('users_id_seq') NOT NULL,
    "name" text,
    "age" integer,
    CONSTRAINT "users_pkey" PRIMARY KEY("id")
);

CREATE TABLE "books"(
    "isbn" text,
    "title" text,
    "quantity" integer,
    CONSTRAINT "books_pkey" PRIMARY KEY("isbn")
);

CREATE SEQUENCE "orders_id_seq"
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 1000000
    START WITH 1;

CREATE TABLE "orders"(
    "id" bigint DEFAULT nextval('orders_id_seq') NOT NULL,
    "book_id" text,
    "user_id" bigint,
    "issue_date" DATE,
    "expiration_date" DATE,
    "return_date" DATE,
    "fine" int,
    CONSTRAINT "orders_pkey" PRIMARY KEY("id"),
    CONSTRAINT "fk_book" FOREIGN KEY(book_id) REFERENCES books(isbn),
    CONSTRAINT "fk_user" FOREIGN KEY(user_id) REFERENCES users(id)
);