-- Table: public.borrowed

-- DROP TABLE public.borrowed;

CREATE TABLE public.borrowed
(
    id integer NOT NULL,
    book character varying(255) COLLATE pg_catalog."default",
    borrowed character varying(255) COLLATE pg_catalog."default",
    borrowed_from date,
    borrowed_to date,
    name character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT borrowed_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.borrowed
    OWNER to postgres;