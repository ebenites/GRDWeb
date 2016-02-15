--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

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
-- Name: area; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE area (
    id integer NOT NULL,
    nombre text,
    tipo character(1)
);


ALTER TABLE area OWNER TO postgres;

--
-- Name: area_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE area_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE area_id_seq OWNER TO postgres;

--
-- Name: area_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE area_id_seq OWNED BY area.id;


--
-- Name: caja; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE caja (
    id integer NOT NULL,
    numero integer,
    estado character(1),
    tienda_id integer
);


ALTER TABLE caja OWNER TO postgres;

--
-- Name: caja_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE caja_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE caja_id_seq OWNER TO postgres;

--
-- Name: caja_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE caja_id_seq OWNED BY caja.id;


--
-- Name: campana; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE campana (
    id integer NOT NULL,
    nombre text,
    fechainicio date,
    fechafin date,
    estado character(1)
);


ALTER TABLE campana OWNER TO postgres;

--
-- Name: campana_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE campana_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE campana_id_seq OWNER TO postgres;

--
-- Name: campana_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE campana_id_seq OWNED BY campana.id;


--
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE empleado (
    id integer NOT NULL,
    nombres text,
    apellidos text,
    direccion text,
    telefono text,
    estado character(1),
    tienda_id integer,
    area_id integer
);


ALTER TABLE empleado OWNER TO postgres;

--
-- Name: personal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE personal (
    id integer NOT NULL,
    campana_id integer
);


ALTER TABLE personal OWNER TO postgres;

--
-- Name: personal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personal_id_seq OWNER TO postgres;

--
-- Name: personal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_id_seq OWNED BY empleado.id;


--
-- Name: programacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE programacion (
    id integer NOT NULL,
    fechainicio date,
    fechafin date,
    campana_id integer,
    usuario_id integer,
    estado character(1)
);


ALTER TABLE programacion OWNER TO postgres;

--
-- Name: programacion_detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE programacion_detalle (
    programacion_id integer NOT NULL,
    item integer NOT NULL,
    tienda_id integer,
    area_id integer,
    personal_id integer,
    turno_id integer,
    caja_id integer,
    fechaasignacion date
);


ALTER TABLE programacion_detalle OWNER TO postgres;

--
-- Name: programacion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE programacion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE programacion_id_seq OWNER TO postgres;

--
-- Name: programacion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE programacion_id_seq OWNED BY programacion.id;


--
-- Name: tienda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tienda (
    id integer NOT NULL,
    nombre text,
    direccion text
);


ALTER TABLE tienda OWNER TO postgres;

--
-- Name: tienda_area; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tienda_area (
    tienda_id integer NOT NULL,
    area_id integer NOT NULL,
    capacidad integer
);


ALTER TABLE tienda_area OWNER TO postgres;

--
-- Name: tienda_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tienda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tienda_id_seq OWNER TO postgres;

--
-- Name: tienda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tienda_id_seq OWNED BY tienda.id;


--
-- Name: turno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE turno (
    id integer NOT NULL,
    nombre text,
    horainicio text,
    horafin text
);


ALTER TABLE turno OWNER TO postgres;

--
-- Name: turno_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE turno_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE turno_id_seq OWNER TO postgres;

--
-- Name: turno_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE turno_id_seq OWNED BY turno.id;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id integer NOT NULL,
    username text,
    userpass text
);


ALTER TABLE usuario OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_seq OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY area ALTER COLUMN id SET DEFAULT nextval('area_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY caja ALTER COLUMN id SET DEFAULT nextval('caja_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY campana ALTER COLUMN id SET DEFAULT nextval('campana_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empleado ALTER COLUMN id SET DEFAULT nextval('personal_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion ALTER COLUMN id SET DEFAULT nextval('programacion_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tienda ALTER COLUMN id SET DEFAULT nextval('tienda_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turno ALTER COLUMN id SET DEFAULT nextval('turno_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);


--
-- Data for Name: area; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY area (id, nombre, tipo) FROM stdin;
1	Caja	C
2	Area 1	A
5	Area 4	A
4	Area 3	A
3	Area 2	A
\.


--
-- Name: area_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('area_id_seq', 5, true);


--
-- Data for Name: caja; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY caja (id, numero, estado, tienda_id) FROM stdin;
1	1	A	1
2	2	A	1
3	3	A	1
4	4	A	1
5	5	A	1
6	6	A	1
7	7	A	1
8	8	A	1
9	9	A	1
10	10	A	1
11	11	A	1
12	12	A	1
\.


--
-- Name: caja_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('caja_id_seq', 12, true);


--
-- Data for Name: campana; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY campana (id, nombre, fechainicio, fechafin, estado) FROM stdin;
1	Fiestas Patrias 2016	2016-07-01	2016-08-01	A
2	Navidad 2016	2016-12-01	2017-01-06	A
\.


--
-- Name: campana_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('campana_id_seq', 2, true);


--
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empleado (id, nombres, apellidos, direccion, telefono, estado, tienda_id, area_id) FROM stdin;
3	José	Mendivil	\N	\N	A	1	1
4	Carlos	Sánchez	\N	\N	A	1	1
5	Alessandra	Díaz	\N	\N	A	1	1
6	Rosa	Mamani	\N	\N	A	1	2
1	Erick	Benites	\N	\N	A	1	2
2	Jessica	Peve	\N	\N	A	1	1
\.


--
-- Data for Name: personal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY personal (id, campana_id) FROM stdin;
1	1
3	1
4	1
5	1
6	1
\.


--
-- Name: personal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_id_seq', 6, true);


--
-- Data for Name: programacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY programacion (id, fechainicio, fechafin, campana_id, usuario_id, estado) FROM stdin;
4	2016-07-22	2016-07-31	1	2	P
7	2016-07-01	2016-07-03	1	2	P
2	2016-07-08	2016-07-14	1	2	A
1	2016-07-01	2016-07-07	1	2	A
\.


--
-- Data for Name: programacion_detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY programacion_detalle (programacion_id, item, tienda_id, area_id, personal_id, turno_id, caja_id, fechaasignacion) FROM stdin;
7	1	1	1	3	1	1	2016-07-01
7	2	1	1	3	2	1	2016-07-01
7	3	1	1	3	1	2	2016-07-02
7	4	1	1	3	2	2	2016-07-02
7	5	1	1	3	1	3	2016-07-03
7	6	1	1	3	2	3	2016-07-03
\.


--
-- Name: programacion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('programacion_id_seq', 10, true);


--
-- Data for Name: tienda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tienda (id, nombre, direccion) FROM stdin;
1	Plaza Vea Miraflores	\N
2	Plaza Vea Lurin	\N
3	Plaza Vea Guardia Civil	\N
4	Plaza Vea Acho	\N
5	Plaza Vea Cine Rimac	\N
6	Plaza Vea Universitaria	\N
7	Plaza Vea La Molina	\N
8	Plaza Vea Primavera	\N
9	Plaza Vea Ate	\N
10	Plaza Vea San Miguel	\N
11	Plaza Vea Risso	\N
12	Plaza Vea Callao	\N
13	Plaza Vea El Cortijo	\N
14	Plaza Vea Jockey	\N
15	Plaza Vea Caminos del Inca	\N
16	Plaza Vea Comas	\N
17	Plaza Vea Los Olivos	\N
18	Plaza Vea Salamanca	\N
19	Plaza Vea Chosica	\N
\.


--
-- Data for Name: tienda_area; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tienda_area (tienda_id, area_id, capacidad) FROM stdin;
1	1	12
1	2	18
1	3	24
1	4	20
\.


--
-- Name: tienda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tienda_id_seq', 19, true);


--
-- Data for Name: turno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY turno (id, nombre, horainicio, horafin) FROM stdin;
1	Mañana	07:00	16:00
2	Tarde	14:00	23:00
\.


--
-- Name: turno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('turno_id_seq', 2, true);


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id, username, userpass) FROM stdin;
1	ebenites	tecsup
2	jpeve	123456
\.


--
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_seq', 2, true);


--
-- Name: pk_area; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY area
    ADD CONSTRAINT pk_area PRIMARY KEY (id);


--
-- Name: pk_caja; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY caja
    ADD CONSTRAINT pk_caja PRIMARY KEY (id);


--
-- Name: pk_campania; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY campana
    ADD CONSTRAINT pk_campania PRIMARY KEY (id);


--
-- Name: pk_empleado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT pk_empleado PRIMARY KEY (id);


--
-- Name: pk_personal; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT pk_personal PRIMARY KEY (id);


--
-- Name: pk_programacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion
    ADD CONSTRAINT pk_programacion PRIMARY KEY (id);


--
-- Name: pk_programacion_detalle; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion_detalle
    ADD CONSTRAINT pk_programacion_detalle PRIMARY KEY (programacion_id, item);


--
-- Name: pk_tienda; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tienda
    ADD CONSTRAINT pk_tienda PRIMARY KEY (id);


--
-- Name: pk_tienda_area; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tienda_area
    ADD CONSTRAINT pk_tienda_area PRIMARY KEY (tienda_id, area_id);


--
-- Name: pk_turno; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turno
    ADD CONSTRAINT pk_turno PRIMARY KEY (id);


--
-- Name: pk_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (id);


--
-- Name: fk_caja_tienda; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY caja
    ADD CONSTRAINT fk_caja_tienda FOREIGN KEY (tienda_id) REFERENCES tienda(id);


--
-- Name: fk_empleado_tienda_area; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT fk_empleado_tienda_area FOREIGN KEY (tienda_id, area_id) REFERENCES tienda_area(tienda_id, area_id);


--
-- Name: fk_personal_campana; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT fk_personal_campana FOREIGN KEY (campana_id) REFERENCES campana(id);


--
-- Name: fk_programacion_campana; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion
    ADD CONSTRAINT fk_programacion_campana FOREIGN KEY (campana_id) REFERENCES campana(id);


--
-- Name: fk_programacion_detalle_caja; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion_detalle
    ADD CONSTRAINT fk_programacion_detalle_caja FOREIGN KEY (caja_id) REFERENCES caja(id);


--
-- Name: fk_programacion_detalle_personal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion_detalle
    ADD CONSTRAINT fk_programacion_detalle_personal FOREIGN KEY (personal_id) REFERENCES personal(id);


--
-- Name: fk_programacion_detalle_progrmacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion_detalle
    ADD CONSTRAINT fk_programacion_detalle_progrmacion FOREIGN KEY (programacion_id) REFERENCES programacion(id);


--
-- Name: fk_programacion_detalle_tienda_area; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion_detalle
    ADD CONSTRAINT fk_programacion_detalle_tienda_area FOREIGN KEY (tienda_id, area_id) REFERENCES tienda_area(tienda_id, area_id);


--
-- Name: fk_programacion_detalle_turno; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion_detalle
    ADD CONSTRAINT fk_programacion_detalle_turno FOREIGN KEY (turno_id) REFERENCES turno(id);


--
-- Name: fk_programacion_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programacion
    ADD CONSTRAINT fk_programacion_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);


--
-- Name: fk_tienda_area_area; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tienda_area
    ADD CONSTRAINT fk_tienda_area_area FOREIGN KEY (area_id) REFERENCES area(id);


--
-- Name: fk_tienda_area_tienda; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tienda_area
    ADD CONSTRAINT fk_tienda_area_tienda FOREIGN KEY (tienda_id) REFERENCES tienda(id);


--
-- Name: fk_usuario_empleado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk_usuario_empleado FOREIGN KEY (id) REFERENCES empleado(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

