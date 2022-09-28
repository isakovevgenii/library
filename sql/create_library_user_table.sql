-- Table: public.library_user

-- DROP TABLE public.library_user;

CREATE TABLE public.library_user
(
    id integer NOT NULL,
    gender character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    member_since date,
    member_till date,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT library_user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.library_user
    OWNER to postgres;