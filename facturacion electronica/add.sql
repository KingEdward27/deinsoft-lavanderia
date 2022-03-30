SELECT * FROM dblavanderia.ventas;

create table tipodoc
(
	tipodoc_id int primary key auto_increment,
	nombre varchar(200),
    value varchar(30),
    estado char(1) default '1',
    fecha_creacion datetime default now() 
)engine=innodb;

INSERT INTO tipodoc values (1,'BOLETA','03','1',now());
INSERT INTO tipodoc values (2,'FACTURA','01','1',now());
INSERT INTO tipodoc values (3,'TICKET','00','1',now());
INSERT INTO tipodoc values (4,'NOTA DE CREDITO','07','1',now());


create table numeracion_documento
(
	numeracion_documento_id int primary key auto_increment,
    tipodoc_id int not null,
    serie varchar(4),
    ultimo_numero int,
    estado char(1) default '1',
    fecha_creacion datetime default now() 
)engine=innodb;

INSERT INTO numeracion_documento values (null,1,'B001',0,'1',now()); 
INSERT INTO numeracion_documento values (null,2,'F001',0,'1',now());
INSERT INTO numeracion_documento values (null,3,'0001',0,'1',now());
INSERT INTO numeracion_documento values (null,4,'B002',0,'1',now());

alter table ventas
add tipodoc_id int;

update ventas set tipodoc_id = 3 where idventa >= 45000;

alter table ventas
add envio_pse_flag char(1);

alter table ventas
add envio_pse_mensaje varchar(300);

alter table ventas
add xmlhash varchar(500);

alter table ventas
add codigoqr varchar(500);

alter table parametros
add ruta_pse varchar(300);

alter table parametros
add token varchar(900);

alter table parametros
add rutadocs varchar(900);

alter table clientes
add correo varchar(300);

alter table clientes
add tipo int default 1;

alter table productos
add codigo varchar(20) default '-';

alter table ventas
add num_ticket varchar(500);

ALTER TABLE ventas
CHANGE COLUMN `SerieDoc` `SerieDoc` VARCHAR(4) NOT NULL ;

CREATE INDEX idx_ventas_num_ticket ON ventas(num_ticket);

update ventas set num_ticket = numdoc where idventa >= 5000 and idventa < 10000;

select v.idventa,v.seriedoc,v.numdoc,
trim(concat(ifnull(cli.nombres,''))) cliente,
v.fecha,
v.total-ifnull(v.descuento,0) importe,
ifnull(v.tipo_pago,'Contado') forma_pago,
case when cli.dni= '11111111' then '00000000' 
else cli.dni end nrodocumento,
cli.direccion,
f_descripcion_monto(v.total-ifnull(v.descuento,0),'SOLES') descripcion_monto,
ifnull(v.descuento,0) descuento ,
case when v.tipodoc_id = 1 then '20' else '10' end tipo_igv,
cli.tipo,
ifnull(cli.correo,''),
ifnull(v.codigoqr,''),
ifnull(v.xmlhash,''),
td.tipodoc_id,td.nombre,
ts.idtiposervicio,ts.descripcion
from ventas v 
inner join clientes cli on v.idcliente=cli.idcliente
inner join tipodoc td on td.tipodoc_id = v.tipodoc_id
inner join tipos_servicio ts on ts.idtiposervicio = v.idtiposervicio
where v.idventa = 46932

select p.codigo,
trim(concat(p.descripcion,' ',ifnull(m.nombre,''), ' ',ifnull(c.nombre,''),' ', ifnull(ca.nombre,''))) descripcion ,d.cantidad,
d.precio as precio_venta,d.importe,p.idproducto,
d.*
from productos p 
inner join detalleventas d
on p.idproducto = d.idproducto
left join marcas m on m.idmarca = d.idmarca
left join colores c on c.idcolor = d.idcolor
left join caracteristicas ca on ca.idcaracteristica = d.idcaracteristica
where d.idventa = 46932
                
select * from detalleventas
select * from ventas
DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `f_descripcion_monto`(XNumero NUMERIC(20,2),  XMoneda VARCHAR(100)) RETURNS varchar(512) CHARSET utf8
    DETERMINISTIC
BEGIN 
DECLARE XlnEntero INT; 
DECLARE XlcRetorno VARCHAR(512); 
DECLARE XlnTerna INT; 
DECLARE XlcMiles VARCHAR(512); 
DECLARE XlcCadena VARCHAR(512); 
DECLARE XlnUnidades INT; 
DECLARE XlnDecenas INT; 
DECLARE XlnCentenas INT; 
DECLARE XlnFraccion INT; 
DECLARE Xresultado varchar(512); 

SET XlnEntero = FLOOR(XNumero); 
SET XlnFraccion = (XNumero - XlnEntero) * 100; 
SET XlcRetorno = ''; 
SET XlnTerna = 1 ; 
    WHILE( XlnEntero > 0) DO 

        #Recorro terna por terna 
        SET XlcCadena = ''; 
        SET XlnUnidades = XlnEntero MOD 10; 
        SET XlnEntero = FLOOR(XlnEntero/10); 
        SET XlnDecenas = XlnEntero MOD 10; 
        SET XlnEntero = FLOOR(XlnEntero/10); 
        SET XlnCentenas = XlnEntero MOD 10; 
        SET XlnEntero = FLOOR(XlnEntero/10); 

        #Analizo las unidades 
        SET XlcCadena = 
            CASE # UNIDADES 
                WHEN XlnUnidades = 1 AND XlnTerna = 1 THEN CONCAT('UNO ', XlcCadena) 
                WHEN XlnUnidades = 1 AND XlnTerna <> 1 THEN CONCAT('UN ', XlcCadena) 
                WHEN XlnUnidades = 2 THEN CONCAT('DOS ', XlcCadena) 
                WHEN XlnUnidades = 3 THEN CONCAT('TRES ', XlcCadena) 
                WHEN XlnUnidades = 4 THEN CONCAT('CUATRO ', XlcCadena) 
                WHEN XlnUnidades = 5 THEN CONCAT('CINCO ', XlcCadena) 
                WHEN XlnUnidades = 6 THEN CONCAT('SEIS ', XlcCadena) 
                WHEN XlnUnidades = 7 THEN CONCAT('SIETE ', XlcCadena) 
                WHEN XlnUnidades = 8 THEN CONCAT('OCHO ', XlcCadena) 
                WHEN XlnUnidades = 9 THEN CONCAT('NUEVE ', XlcCadena) 
                ELSE XlcCadena 
            END; #UNIDADES 

        #Analizo las decenas 
        SET XlcCadena = 
            CASE #DECENAS 
                WHEN XlnDecenas = 1 THEN 
                    CASE XlnUnidades 
                        WHEN 0 THEN 'DIEZ ' 
                        WHEN 1 THEN 'ONCE ' 
                        WHEN 2 THEN 'DOCE ' 
                        WHEN 3 THEN 'TRECE ' 
                        WHEN 4 THEN 'CATORCE ' 
                        WHEN 5 THEN 'QUINCE' 
                        ELSE CONCAT('DIECI', XlcCadena) 
                    END 
                WHEN XlnDecenas = 2 AND XlnUnidades = 0 THEN CONCAT('VEINTE ', XlcCadena) 
                WHEN XlnDecenas = 2 AND XlnUnidades <> 0 THEN CONCAT('VEINTI', XlcCadena) 
                WHEN XlnDecenas = 3 AND XlnUnidades = 0 THEN CONCAT('TREINTA ', XlcCadena) 
                WHEN XlnDecenas = 3 AND XlnUnidades <> 0 THEN CONCAT('TREINTA Y ', XlcCadena) 
                WHEN XlnDecenas = 4 AND XlnUnidades = 0 THEN CONCAT('CUARENTA ', XlcCadena) 
                WHEN XlnDecenas = 4 AND XlnUnidades <> 0 THEN CONCAT('CUARENTA Y ', XlcCadena) 
                WHEN XlnDecenas = 5 AND XlnUnidades = 0 THEN CONCAT('CINCUENTA ', XlcCadena) 
                WHEN XlnDecenas = 5 AND XlnUnidades <> 0 THEN CONCAT('CINCUENTA Y ', XlcCadena) 
                WHEN XlnDecenas = 6 AND XlnUnidades = 0 THEN CONCAT('SESENTA ', XlcCadena) 
                WHEN XlnDecenas = 6 AND XlnUnidades <> 0 THEN CONCAT('SESENTA Y ', XlcCadena) 
                WHEN XlnDecenas = 7 AND XlnUnidades = 0 THEN CONCAT('SETENTA ', XlcCadena) 
                WHEN XlnDecenas = 7 AND XlnUnidades <> 0 THEN CONCAT('SETENTA Y ', XlcCadena) 
                WHEN XlnDecenas = 8 AND XlnUnidades = 0 THEN CONCAT('OCHENTA ', XlcCadena) 
                WHEN XlnDecenas = 8 AND XlnUnidades <> 0 THEN CONCAT('OCHENTA Y ', XlcCadena) 
                WHEN XlnDecenas = 9 AND XlnUnidades = 0 THEN CONCAT('NOVENTA ', XlcCadena) 
                WHEN XlnDecenas = 9 AND XlnUnidades <> 0 THEN CONCAT('NOVENTA Y ', XlcCadena) 
                ELSE XlcCadena 
            END; #DECENAS 

        # Analizo las centenas 
        SET XlcCadena = 
            CASE # CENTENAS 
                WHEN XlnCentenas = 1 AND XlnUnidades = 0 AND XlnDecenas = 0 THEN CONCAT('CIEN ', XlcCadena) 
                WHEN XlnCentenas = 1 AND NOT(XlnUnidades = 0 AND XlnDecenas = 0) THEN CONCAT('CIENTO ', XlcCadena) 
                WHEN XlnCentenas = 2 THEN CONCAT('DOSCIENTOS ', XlcCadena) 
                WHEN XlnCentenas = 3 THEN CONCAT('TRESCIENTOS ', XlcCadena) 
                WHEN XlnCentenas = 4 THEN CONCAT('CUATROCIENTOS ', XlcCadena) 
                WHEN XlnCentenas = 5 THEN CONCAT('QUINIENTOS ', XlcCadena) 
                WHEN XlnCentenas = 6 THEN CONCAT('SEISCIENTOS ', XlcCadena) 
                WHEN XlnCentenas = 7 THEN CONCAT('SETECIENTOS ', XlcCadena) 
                WHEN XlnCentenas = 8 THEN CONCAT('OCHOCIENTOS ', XlcCadena) 
                WHEN XlnCentenas = 9 THEN CONCAT('NOVECIENTOS ', XlcCadena) 
                ELSE XlcCadena 
            END; #CENTENAS 

        # Analizo la terna 
        SET XlcCadena = 
            CASE # TERNA 
                WHEN XlnTerna = 1 THEN XlcCadena 
                WHEN XlnTerna = 2 AND (XlnUnidades + XlnDecenas + XlnCentenas <> 0) THEN CONCAT(XlcCadena,  'MIL ') 
                WHEN XlnTerna = 3 AND (XlnUnidades + XlnDecenas + XlnCentenas <> 0) AND XlnUnidades = 1 AND XlnDecenas = 0 AND XlnCentenas = 0 THEN CONCAT(XlcCadena, 'MILLON ') 
                WHEN XlnTerna = 3 AND (XlnUnidades + XlnDecenas + XlnCentenas <> 0) AND NOT (XlnUnidades = 1 AND XlnDecenas = 0 AND XlnCentenas = 0) THEN CONCAT(XlcCadena, 'MILLONES ') 
                WHEN XlnTerna = 4 AND (XlnUnidades + XlnDecenas + XlnCentenas <> 0) THEN CONCAT(XlcCadena, 'MIL MILLONES ') 
                ELSE '' 
            END; #TERNA 

        #Armo el retorno terna a terna 
        SET XlcRetorno = CONCAT(XlcCadena, XlcRetorno); 
        SET XlnTerna = XlnTerna + 1; 
    END WHILE; # WHILE 

    IF XlnTerna = 1 THEN SET XlcRetorno = 'CERO'; END IF; 

SET Xresultado = CONCAT(RTRIM(XlcRetorno), ' CON ', lpad( LTRIM(XlnFraccion),2,'0'), '/100 ', XMoneda); 

RETURN Xresultado; 

END$$
DELIMITER ;

alter table detalleventas
add afectacion_igv decimal(14,2);

select * from clientes
select * from detalleventas
select * from ventas
select * from numeracion_documento
select * from tipodoc