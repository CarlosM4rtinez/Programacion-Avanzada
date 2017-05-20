INSERT INTO PAIS (ID_PAIS, NOMBRE) VALUES ('1', 'Colombia');
INSERT INTO PAIS (ID_PAIS, NOMBRE) VALUES ('2', 'Estados Unidos');
INSERT INTO PAIS (ID_PAIS, NOMBRE) VALUES ('3', 'Alemania');
INSERT INTO PAIS (ID_PAIS, NOMBRE) VALUES ('4', 'Espania');

INSERT INTO DEPARTAMENTO (ID_DEPARTAMENTO, NOMBRE, PAIS_ID_PAIS) VALUES ('1', 'Quindio', '1');
INSERT INTO DEPARTAMENTO (ID_DEPARTAMENTO, NOMBRE, PAIS_ID_PAIS) VALUES ('2', 'Valle del cauca', '1');
INSERT INTO DEPARTAMENTO (ID_DEPARTAMENTO, NOMBRE, PAIS_ID_PAIS) VALUES ('3', 'Antioquia', '1');

INSERT INTO CIUDAD (ID_CIUDAD, NOMBRE, DEPARTAMENTO_ID_DEPARTAMENTO) VALUES ('1', 'Armenia', '1');
INSERT INTO CIUDAD (ID_CIUDAD, NOMBRE, DEPARTAMENTO_ID_DEPARTAMENTO) VALUES ('2', 'Calarca', '1');
INSERT INTO CIUDAD (ID_CIUDAD, NOMBRE, DEPARTAMENTO_ID_DEPARTAMENTO) VALUES ('3', 'Circasia', '1');
INSERT INTO CIUDAD (ID_CIUDAD, NOMBRE, DEPARTAMENTO_ID_DEPARTAMENTO) VALUES ('4', 'Cali', '2');
INSERT INTO CIUDAD (ID_CIUDAD, NOMBRE, DEPARTAMENTO_ID_DEPARTAMENTO) VALUES ('5', 'Medellin', '3');

INSERT INTO TIPO_EPS (ID_TIPO_EPS, TIPO_EPS) VALUES ('1', 'Subsidiada');
INSERT INTO TIPO_EPS (ID_TIPO_EPS, TIPO_EPS) VALUES ('2', 'Postpagada');
INSERT INTO TIPO_EPS (ID_TIPO_EPS, TIPO_EPS) VALUES ('3', 'SISBEN');

INSERT INTO EPS (ID_EPS, NOMBRE, DIRECCION, TELEFONO, TIPO_EPS_ID_TIPO_EPS) VALUES ('1', 'Cafesalud', 'Cra 20 #30-10', '7422145', '1');
INSERT INTO EPS (ID_EPS, NOMBRE, DIRECCION, TELEFONO, TIPO_EPS_ID_TIPO_EPS) VALUES ('2', 'EMI', 'Call 10 A # 54-13', '77433164', '2');
INSERT INTO EPS (ID_EPS, NOMBRE, DIRECCION, TELEFONO, TIPO_EPS_ID_TIPO_EPS) VALUES ('3', 'Pasvisalud', 'Cra 25 # 43 -57', '7466159', '3');