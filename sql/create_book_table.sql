-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE public.book
(
    id integer NOT NULL,
    author character varying(255) COLLATE pg_catalog."default",
    genre character varying(255) COLLATE pg_catalog."default",
    publisher character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT book_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.book
    OWNER to postgres;