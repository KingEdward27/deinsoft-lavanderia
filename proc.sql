alter table ventas
add a_cuenta decimal(8,2);

alter table detalleventas
add item int null;


drop procedure if exists wa;
delimiter //
create procedure wa()
begin
declare ln_sueldo decimal(8,2);
declare ln_numrows int;
declare ln_numrows2 int;
declare ln_contador int;
declare ln_contador2 int;
declare ln_idventa int;
declare ln_idventa_prim int;

drop temporary table if exists temporal;
drop temporary table if exists temporal2;

    create temporary table temporal
    (
        nrofila int auto_increment primary key,
        idventa int
    );
    insert  into temporal 
    select null,idventa from ventas where idventa > 0 order by idventa;
    
    create temporary table temporal2
    (
        nrofila int auto_increment primary key,
        idventa int
    );
    
    select COUNT(*) 
    into ln_numrows from temporal;
    
    set ln_contador = 1; 
    
    while ln_contador <= ln_numrows
        do  
            
            select idventa into ln_idventa
            from temporal where nrofila = ln_contador;
            
            delete from temporal2 where idventa>=1;
            
            insert  into temporal2 
            select null,idventa from detalleventas where idventa = ln_idventa;
    
            set ln_contador2 = 1;
            
            select COUNT(*) into ln_numrows2 from temporal2;
                
            while ln_contador2 <= ln_numrows2
            do  
                select @rownum:=@rownum+1 AS rownum,dv.* from (SELECT @rownum:=0) r,detalleventas dv
                
                update detalleventas set item =  ln_contador2 where nrofila = ln_contador2;
                
                set ln_contador2 = ln_contador2 + 1;
            end while;    
            
            set ln_contador = ln_contador + 1;
    end while;  
end

call wa();

update detalle ventas set item = 

0	24	15:09:23	call wa()	Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column
 To disable safe mode, toggle the option in Preferences -> SQL Editor -> Query Editor and reconnect.	0.235 sec