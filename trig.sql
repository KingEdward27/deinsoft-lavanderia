alter table ingresos
add idventa int;

alter table ingresos
add estado int;

alter table egresos
add idventa int;

alter table egresos
add estado int;

drop trigger if exists tia_ventas;

DELIMITER $$
CREATE TRIGGER tia_ventas
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
    
    if new.estado <> 0 then
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
        -- si anulan la venta
        update ingresos set estado = '0' where idventa = new.idventa;
        if new.tipo_pago IN ('TARJETA VISA','TARJETA MASTERCARD') then
            update egresos set estado = '0' where idventa = new.idventa;
        end if;
    end if;
END$$