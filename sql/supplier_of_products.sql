--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2024-05-25 20:50:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4874 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16637)
-- Name: deliveries_products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deliveries_products (
    id bigint NOT NULL,
    delivery_id bigint,
    product_id bigint,
    count integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.deliveries_products OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16636)
-- Name: deliveries_products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.deliveries_products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.deliveries_products_id_seq OWNER TO postgres;

--
-- TOC entry 4875 (class 0 OID 0)
-- Dependencies: 215
-- Name: deliveries_products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.deliveries_products_id_seq OWNED BY public.deliveries_products.id;


--
-- TOC entry 218 (class 1259 OID 16644)
-- Name: delivery; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.delivery (
    id bigint NOT NULL,
    supplier_id bigint,
    date date
);


ALTER TABLE public.delivery OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16643)
-- Name: delivery_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.delivery_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.delivery_id_seq OWNER TO postgres;

--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 217
-- Name: delivery_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.delivery_id_seq OWNED BY public.delivery.id;


--
-- TOC entry 220 (class 1259 OID 16651)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    title character varying(255)
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16650)
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.product_id_seq OWNER TO postgres;

--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 219
-- Name: product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;


--
-- TOC entry 222 (class 1259 OID 16658)
-- Name: supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier (
    id bigint NOT NULL,
    full_name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.supplier OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16657)
-- Name: supplier_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.supplier_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.supplier_id_seq OWNER TO postgres;

--
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 221
-- Name: supplier_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.supplier_id_seq OWNED BY public.supplier.id;


--
-- TOC entry 4703 (class 2604 OID 16640)
-- Name: deliveries_products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries_products ALTER COLUMN id SET DEFAULT nextval('public.deliveries_products_id_seq'::regclass);


--
-- TOC entry 4704 (class 2604 OID 16647)
-- Name: delivery id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery ALTER COLUMN id SET DEFAULT nextval('public.delivery_id_seq'::regclass);


--
-- TOC entry 4705 (class 2604 OID 16654)
-- Name: product id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);


--
-- TOC entry 4706 (class 2604 OID 16661)
-- Name: supplier id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier ALTER COLUMN id SET DEFAULT nextval('public.supplier_id_seq'::regclass);


--
-- TOC entry 4862 (class 0 OID 16637)
-- Dependencies: 216
-- Data for Name: deliveries_products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (1, 1, 2, 5, 20);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (2, 1, 4, 10, 12);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (3, 1, 2, 5, 20);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (4, 1, 4, 10, 12);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (5, 2, 1, 100, 500);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (6, 2, 3, 50, 20);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (7, 2, 1, 100, 500);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (8, 2, 3, 50, 20);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (9, 2, 1, 100, 500);
INSERT INTO public.deliveries_products (id, delivery_id, product_id, count, price) VALUES (10, 2, 3, 50, 20);


--
-- TOC entry 4864 (class 0 OID 16644)
-- Dependencies: 218
-- Data for Name: delivery; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.delivery (id, supplier_id, date) VALUES (1, 2, '2024-05-18');
INSERT INTO public.delivery (id, supplier_id, date) VALUES (2, 1, '2024-05-23');


--
-- TOC entry 4866 (class 0 OID 16651)
-- Dependencies: 220
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product (id, title) VALUES (1, 'Груша золотая');
INSERT INTO public.product (id, title) VALUES (2, 'Груша обычная');
INSERT INTO public.product (id, title) VALUES (3, 'Яблоко красное');
INSERT INTO public.product (id, title) VALUES (4, 'Яблоко зеленое');


--
-- TOC entry 4868 (class 0 OID 16658)
-- Dependencies: 222
-- Data for Name: supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.supplier (id, full_name, phone) VALUES (1, 'Алексеев Петр', '+7900980');
INSERT INTO public.supplier (id, full_name, phone) VALUES (2, 'Иванов Иван', '+7952812');


--
-- TOC entry 4879 (class 0 OID 0)
-- Dependencies: 215
-- Name: deliveries_products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.deliveries_products_id_seq', 10, true);


--
-- TOC entry 4880 (class 0 OID 0)
-- Dependencies: 217
-- Name: delivery_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.delivery_id_seq', 2, true);


--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 219
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_id_seq', 4, true);


--
-- TOC entry 4882 (class 0 OID 0)
-- Dependencies: 221
-- Name: supplier_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.supplier_id_seq', 2, true);


--
-- TOC entry 4708 (class 2606 OID 16642)
-- Name: deliveries_products deliveries_products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries_products
    ADD CONSTRAINT deliveries_products_pkey PRIMARY KEY (id);


--
-- TOC entry 4710 (class 2606 OID 16649)
-- Name: delivery delivery_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery
    ADD CONSTRAINT delivery_pkey PRIMARY KEY (id);


--
-- TOC entry 4712 (class 2606 OID 16656)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 4714 (class 2606 OID 16665)
-- Name: supplier supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (id);


--
-- TOC entry 4717 (class 2606 OID 16676)
-- Name: delivery fk3pvccpw13vordr1meuof4vh7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery
    ADD CONSTRAINT fk3pvccpw13vordr1meuof4vh7 FOREIGN KEY (supplier_id) REFERENCES public.supplier(id) ON DELETE CASCADE;


--
-- TOC entry 4715 (class 2606 OID 16666)
-- Name: deliveries_products fk9ij0sfshomcvep1vtdveii6wu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries_products
    ADD CONSTRAINT fk9ij0sfshomcvep1vtdveii6wu FOREIGN KEY (delivery_id) REFERENCES public.delivery(id);


--
-- TOC entry 4716 (class 2606 OID 16671)
-- Name: deliveries_products fkoloheef6yqtoillajn07joxc0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries_products
    ADD CONSTRAINT fkoloheef6yqtoillajn07joxc0 FOREIGN KEY (product_id) REFERENCES public.product(id);


-- Completed on 2024-05-25 20:50:09

--
-- PostgreSQL database dump complete
--

