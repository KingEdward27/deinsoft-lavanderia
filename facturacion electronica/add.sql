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
INSERT INTO tipodoc values (3,'NOTA DE VENTA','00','1',now());
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
add tipo varchar(100) default '1-DNI';

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

alter table ventas
add serieDocE varchar(4);

alter table ventas
add numDocE int;

ALTER TABLE `dblavanderia`.`clientes` 
CHANGE COLUMN `Dni` `Dni` VARCHAR(11) NULL DEFAULT NULL ;



select * from clientes
select * from detalleventas
select * from ventas
select * from numeracion_documento
select * from tipodoc
select * from parametros

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
'10' tipo_igv,
cli.tipo,
ifnull(cli.correo,''),
ifnull(v.codigoqr,''),
ifnull(v.xmlhash,''),
td.tipodoc_id,td.nombre,td.value,
ts.idtiposervicio,ts.descripcion,v.igv,ifnull(serieDocE,'') serieDocE,ifnull(numDocE,0) numDocE, ifnull(fecha_entrega,'') fecha_entrega,ifnull(envio_pse_flag,'') envio_pse_flag, ifnull(envio_pse_mensaje,'') envio_pse_mensaje
from ventas v 
inner join clientes cli on v.idcliente=cli.idcliente
left join tipodoc td on td.tipodoc_id = v.tipodoc_id
inner join tipos_servicio ts on ts.idtiposervicio = v.idtiposervicio 
where ((v.idventa  = 48792))

select p.codigo,
                + "trim(concat(p.descripcion,' ',ifnull(m.nombre,''), ' ',ifnull(c.nombre,''),' ', ifnull(ca.nombre,''))) descripcion ,d.cantidad,
                + "d.precio as precio_venta,d.importe,p.idproducto,
                + "ifnull(d.afectacion_igv,0) afectacion_igv
                + "from productos p 
                + "inner join detalleventas d
                + "on p.idproducto = d.idproducto
                + "left join marcas m on m.idmarca = d.idmarca
                + "left join colores c on c.idcolor = d.idcolor
                + "left join caracteristicas ca on ca.idcaracteristica = d.idcaracteristica
                + "where d.idventa = ?

alter table parametros
add nombre_impresora varchar(300);


drop trigger if exists tia_ventas;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` TRIGGER tia_ventas
AFTER INSERT ON ventas
FOR EACH ROW
BEGIN 
    DECLARE ln_descuento decimal(8,2); 
    DECLARE LN_MONTO decimal(8,2); 
    
    set ln_descuento =  new.descuento;
    if new.tipo_pago <> 'POR PAGAR' then
       if new.a_cuenta > 0 then
            set LN_MONTO = new.a_cuenta;
       else
            set LN_MONTO = new.total - ln_descuento;
       end if;
       insert into ingresos(idingreso,fecha,monto,motivo,idventa)
       values (null,now(),LN_MONTO,'VENTAS',new.idventa);
       
       if new.tipo_pago IN ('TARJETA VISA','TARJETA MASTERCARD') then
            insert into egresos(idegreso,fecha,monto,motivo,idventa)
            values (null,now(),LN_MONTO,'SALIDA POR TARJETA',new.idventa);
       end if;
    end if;
END$$
DELIMITER ;

drop trigger if exists tua_ventas;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` TRIGGER tua_ventas
AFTER UPDATE ON ventas
FOR EACH ROW
BEGIN 
    DECLARE ln_descuento decimal(8,2); 
    DECLARE LN_MONTO decimal(8,2); 
    
    if new.descuento > 0 then
      set ln_descuento = new.descuento;
    else
      set ln_descuento = old.descuento;
    end if;
    
    if new.estado = '1' and old.estado = 'p' then
       if new.tipo_pago = 'POR PAGAR' then
           set LN_MONTO = old.total - new.a_cuenta - ln_descuento;
           insert into ingresos(idingreso,fecha,monto,motivo,idventa)
           values (null,now(),LN_MONTO,'VENTAS',new.idventa);
        else
           if old.a_cuenta > 0 then
                set LN_MONTO = new.total - ln_descuento - old.a_cuenta;
                insert into ingresos(idingreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'VENTAS',new.idventa);
           -- else
                -- set LN_MONTO = new.total - ln_descuento;
           end if;
        end if;
    else
		if new.estado = '0' and old.estado <> '0' then
        -- si anulan la venta
			update ingresos set estado = '0' where idventa = new.idventa;
			if new.tipo_pago IN ('TARJETA VISA','TARJETA MASTERCARD') then
				update egresos set estado = '0' where idventa = new.idventa;
			end if;
        end if;
    end if;
END$$
DELIMITER ;

update ventas set estado = '2' where estado = '1' and numdoce = null 
where idventa > 0;

update ventas set estado = '1' where estado = 'p' and numdoce <> null;

alter table ventas
add clienteE_id INT;


select * from clientes
select * from detalleventas
select * from ventas
select * from numeracion_documento
select * from tipodoc
select * from parametros
select * from ingresos


CREATE DEFINER=`root`@`localhost` TRIGGER tua_ventas
AFTER UPDATE ON ventas
FOR EACH ROW
BEGIN 
    DECLARE ln_descuento decimal(8,2); 
    DECLARE LN_MONTO decimal(8,2); 
    
    if new.descuento > 0 then
      set ln_descuento = new.descuento;
    else
      set ln_descuento = old.descuento;
    end if;
    
    if new.estado = '1' and old.estado = 'p' then
        if old.a_cuenta > 0 then
                set LN_MONTO = new.total - ln_descuento - old.a_cuenta;
                insert into ingresos(idingreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'VENTAS',new.idventa);
        else
             set LN_MONTO = new.total - ln_descuento;
             insert into ingresos(idingreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'VENTAS',new.idventa);
        end if;
       /*if new.tipo_pago = 'POR PAGAR' then
           set LN_MONTO = old.total - new.a_cuenta - ln_descuento;
           insert into ingresos(idingreso,fecha,monto,motivo,idventa)
           values (null,now(),LN_MONTO,'VENTAS',new.idventa);
        else
           if old.a_cuenta > 0 then
                set LN_MONTO = new.total - ln_descuento - old.a_cuenta;
                insert into ingresos(idingreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'VENTAS',new.idventa);
           -- else
                -- set LN_MONTO = new.total - ln_descuento;
           end if;
        end if;*/
    else
		if new.estado = '0' and old.estado <> '0' then
        -- si anulan la venta
			update ingresos set estado = '0' where idventa = new.idventa;
			if new.tipo_pago IN ('TARJETA VISA','TARJETA MASTERCARD') then
				update egresos set estado = '0' where idventa = new.idventa;
			end if;
        end if;
    end if;
END

alter table productos
add orden int default 9999;

UPDATE `productos` SET `orden` = '1' WHERE (`IdProducto` = '86');
UPDATE `productos` SET `orden` = '2' WHERE (`IdProducto` = '99');
UPDATE `productos` SET `orden` = '3' WHERE (`IdProducto` = '169');
UPDATE `productos` SET `orden` = '4' WHERE (`IdProducto` = '13');
UPDATE `productos` SET `orden` = '4' WHERE (`IdProducto` = '174');
UPDATE `productos` SET `orden` = '5' WHERE (`IdProducto` = '7');
UPDATE `productos` SET `orden` = '6' WHERE (`IdProducto` = '4');
UPDATE `productos` SET `orden` = '7' WHERE (`IdProducto` = '175');
UPDATE `dblavanderia`.`productos` SET `orden` = '8' WHERE (`IdProducto` = '3');

alter table ventas
add fecha_pago date;

update ventas set fecha_pago = STR_TO_DATE(substr( fecha_entrega,1,10),'%d/%m/%Y') 
where estado in ('1','2') and idventa > 0;

SELECT * FROM VENTAS WHERE NUMDOC = 155411

select * from resumen_diario

update ventas v set estado = '1' 
where tipo_pago <> 'POR PAGAR'
AND v.ESTADO = 'p' and seriedoc <> '0001'
and ifnull((select sum(monto) from ingresos i where i.idventa = v.idventa),0) = v.total

update ventas v set subtotal = round(total/1.18,2), igv = round(total - total/1.18,2)
WHERE IGV = 0 AND ESTADO = 'p' and seriedoc = '001'

update detalleventas v set afectacion_igv = round(importe - importe/1.18)
WHERE afectacion_igv is null

-- aqui 

alter table ingresos
add igv decimal(12,2);

alter table ingresos
add subtotal decimal(12,2);

alter table ingresos
add tipodoc_id int;

alter table ingresos
add envio_pse_flag char(1);

alter table ingresos
add envio_pse_mensaje varchar(1000);

alter table ingresos
add xmlhash varchar(300);

alter table ingresos
add codigoqr varchar(300);

alter table ingresos
add num_ticket varchar(300);

alter table ingresos
add serie_doc varchar(4);

alter table ingresos
add num_doc int;

alter table ingresos
add cliente_id varchar(300);

alter table ingresos
add recibido  decimal(12,2);

alter table ingresos
add fecha_envio datetime;

alter table ventas
add saldo decimal(12,2);

alter table ingresos
add flag_adelanto char(1);

alter table ingresos
add fecha_pago datetime;

/*
update ingresos i set i.igv = round(monto - (monto/1.18),2),
subtotal = round(monto/1.18,2),
tipodoc_id = (select tipodoc_id from ventas where idventa = i.idventa),
envio_pse_flag = (select envio_pse_flag from ventas where idventa = i.idventa),
envio_pse_mensaje = (select envio_pse_mensaje from ventas where idventa = i.idventa),
xmlhash = (select xmlhash from ventas where idventa = i.idventa),
codigoqr = (select codigoqr from ventas where idventa = i.idventa),
num_ticket = (select num_ticket from ventas where idventa = i.idventa),
serie_doc = (select serieDocE from ventas where idventa = i.idventa),
num_doc = (select numDocE from ventas where idventa = i.idventa),
cliente_id = (select clienteE_id from ventas where idventa = i.idventa),
fecha_envio = (select fecha_pago from ventas where idventa = i.idventa),
estado = '1'
where exists (select 1 from ventas v 
where v.idventa = i.idventa and v.numDocE is not null)*/


alter table ingresos
add descuento decimal(12,2) default 0;


drop trigger if exists tia_ventas;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` TRIGGER tia_ventas
AFTER INSERT ON ventas
FOR EACH ROW
BEGIN 
    DECLARE ln_descuento decimal(8,2); 
    DECLARE LN_MONTO decimal(8,2); 
    
    set ln_descuento =  new.descuento;
    -- if new.tipo_pago <> 'POR PAGAR' then
       if new.a_cuenta > 0 then
            set LN_MONTO = new.a_cuenta;
       else
            set LN_MONTO = new.total - ln_descuento;
       end if;
       if new.a_cuenta > 0 then
        insert into ingresos(idingreso,fecha,monto,motivo,idventa,flag_adelanto,estado)
           values (null,now(),LN_MONTO,'VENTAS',new.idventa,'1','1');
           
           if new.tipo_pago IN ('TARJETA VISA','TARJETA MASTERCARD') then
                insert into egresos(idegreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'SALIDA POR TARJETA',new.idventa);
           end if;
       end if;
       
    -- end if;
END$$
DELIMITER ;

drop trigger if exists tua_ventas;
DELIMITER $$
CREATE TRIGGER tua_ventas
AFTER UPDATE ON ventas
FOR EACH ROW
BEGIN 
    DECLARE ln_descuento decimal(8,2); 
    DECLARE LN_MONTO decimal(8,2); 
    
    if new.descuento > 0 then
      set ln_descuento = new.descuento;
    else
      set ln_descuento = old.descuento;
    end if;
    
    /*if new.estado = '1' and old.estado = 'p' then
        
	if old.a_cuenta > 0 then
                set LN_MONTO = new.total - ln_descuento - old.a_cuenta;
                insert into ingresos(idingreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'VENTAS',new.idventa);
        else
             set LN_MONTO = new.total - ln_descuento;
             insert into ingresos(idingreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'VENTAS',new.idventa);
        end if;
       if new.tipo_pago = 'POR PAGAR' then
           set LN_MONTO = old.total - new.a_cuenta - ln_descuento;
           insert into ingresos(idingreso,fecha,monto,motivo,idventa)
           values (null,now(),LN_MONTO,'VENTAS',new.idventa);
        else
           if old.a_cuenta > 0 then
                set LN_MONTO = new.total - ln_descuento - old.a_cuenta;
                insert into ingresos(idingreso,fecha,monto,motivo,idventa)
                values (null,now(),LN_MONTO,'VENTAS',new.idventa);
           -- else
                -- set LN_MONTO = new.total - ln_descuento;
           end if;
        end if;
    else*/
		if new.estado = '0' and old.estado <> '0' then
        -- si anulan la venta
			update ingresos set estado = '0' where idventa = new.idventa;
			if new.tipo_pago IN ('TARJETA VISA','TARJETA MASTERCARD') then
				update egresos set estado = '0' where idventa = new.idventa;
			end if;
        end if;
    -- end if;
END$$
DELIMITER ;

drop trigger tua_ventas;

update ingresos i set i.flag_adelanto = '1' , i.estado = '1'
where exists (select 1 from ventas v where v.idventa = i.idventa 
				and i.monto = v.a_cuenta and v.estado in ('p') ) 
                
select * from productos where idproducto = 149
select * from detalleventas 49397
select * from ventas
select * from ingresos
select * from ingresos
select * from detalleventas where idventa = 49276

select * from numeracion_documento
select * from parametros

-- 2022-05-19
ALTER TABLE `dblavanderia`.`ingresos` 
ADD INDEX `ingresos_idx01` (`Fecha` ASC) ;

ALTER TABLE `dblavanderia`.`ingresos` 
ADD INDEX `ingresos_idx02` (`fecha_pago` ASC, `estado` ASC) ;

ALTER TABLE `dblavanderia`.`ingresos` 
ADD INDEX `ingresos_idx03` (`idventa` ASC) ;

-- 2022-07-10
update ingresos set fecha_envio = fecha_pago where idingreso > 0

-- 2022-0-19
create table doc_ref
(
	doc_ref_id int auto_increment primary key,
    idingreso int,
    serie varchar(4),
    numero int,
    tipodoc_id int
)engine=innodb;

alter table doc_ref
add constraint fk_docref_ingresos foreign key (idingreso) references ingresos (idingreso);

alter table doc_ref
add constraint fk_docref_tipodoc foreign key (tipodoc_id) references tipodoc(tipodoc_id);