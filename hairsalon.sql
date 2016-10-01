--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    detail character varying,
    email character varying,
    phonenumber character varying,
    stylistid integer
);


ALTER TABLE clients OWNER TO "Guest";

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO "Guest";

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE stylists (
    id integer NOT NULL,
    artist character varying,
    detail character varying
);


ALTER TABLE stylists OWNER TO "Guest";

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO "Guest";

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY clients (id, name, detail, email, phonenumber, stylistid) FROM stdin;
1	afdss	fdadf	dfafda	42412	1
11	rewqrr	werqwr	eqrwr	qew	29
12	JOJIOJ	ojjiasfd 	ofijdsaoidf	dfasoijfoidsa	33
13	rewqrewqr	dsafdsa	czvxvx	dfasfds	29
14	qwrwqr	dfsafd	cxzvcx	fdsads	29
15	qtwtteqtw	rweqreqr	rqwe	erqrwewr	32
16	qwrqrw	wqwr	rqwr	ewrqrr	32
17	qewrqr	tetwqte	dasf	dfsadfsa	32
18	aewrawe	eawrwe	eawrwe	waree	32
21	Jane	Brown Thick Hair	8faehfoa@gmail.com	455-551-2343	34
22	Dominique	Frizzy dark hair.	OPFK@hotmail.com	312-412-5325	35
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('clients_id_seq', 22, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY stylists (id, artist, detail) FROM stdin;
29	aefea	aefwfeawfa
33	aewr	aefwwf
34	Jacque	3 Years Experience in French Canada
35	Pierre	5 Years Experience in Paris, France
36	Roberto	3 Years experience from Rio
37	Francine	Specializes in dry cut.
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('stylists_id_seq', 37, true);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

