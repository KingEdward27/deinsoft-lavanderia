create database dbBodega;
use dbBodega;

create table Usuarios(
    IdUsuario smallint unsigned auto_increment primary key,
    Nombre varchar(8) not null,
    Clave varchar(8)not null,
    Tipo varchar(35)null,
    Estado char(1) null
)engine=innodb;

create table Proveedores(
    IdProveedor int not null auto_increment,
    RazonSocial varchar(70) not null,
    Ruc varchar(11) not null,
    Direccion varchar(70),
    Telefono varchar(11),
    Estado char(1) null,
primary key(IdProveedor)
)engine=innodb;

create table Categorias(
    IdCategoria int not null auto_increment,
    Nombre varchar(70),
    Estado char(1) null,
    primary key(IdCategoria)
)engine=innodb;

create table UnidadMedidas(
    IdUnidadMedida int not null auto_increment,
    Nombre varchar(70),
    Estado char(1) null,
    primary key(IdUnidadMedida)
)engine=innodb;

create table Marcas(
    IdMarca int not null auto_increment,
    Nombre varchar(45)not null,
    Estado char(1) null,
    primary key(IdMarca)
)engine=innodb;
/*
create table SubCategorias(
IdSubCategoria int not null auto_increment,
IdCategoria int not null,
Nombre varchar(70)not null,
Estado char(1) null,
primary key(IdSubCategoria),
index fk_subcategoria (IdCategoria asc),
constraint fk_subcategoria foreign key(IdCategoria) references Categorias(IdCategoria)
)engine=innodb;
*/
create table Productos(
IdProducto int not null auto_increment,
IdMarca int null,
IdCategoria int not null,
IdUnidadMedida int null,
Descripcion varchar(80) not null,
Costo decimal(7,2),
Precio decimal(7,2),
Precio2 decimal(7,2),
paquete decimal(7,2)null,
Stock decimal(7,2) not null,
StockMinimo decimal(7,2) null,
CodigoBarra varchar(30)null,
Observacion varchar(100)null,
Estado char(1) null,
primary key(IdProducto),
index fk_idmarca_pro(IdMarca asc),
index fk_idcategoria_pro(IdCategoria asc),
index fk_unidadmedida_pro (IdUnidadMedida asc),
constraint fk_idmarca_pro foreign key (IdMarca) references Marcas(IdMarca),
constraint fk_idcategoria_pro foreign key (IdCategoria) references Categorias(IdCategoria),
constraint fk_unidadmedida_pro foreign key(IdUnidadMedida) references UnidadMedidas(IdUnidadMedida)
)engine=innodb;


create table Clientes(
IdCliente int not null auto_increment,
Nombres varchar(150) not null,
Dni varchar(8) null,
Direccion varchar(80),
Telefono varchar(11),
Estado char(1) null,
primary key(IdCliente)
)engine=innodb;

create table Compras(
IdCompra int not null auto_increment,
IdProveedor int not null,
TipoDoc varchar(20) not null,
NumDoc varchar(6) not null,
Fecha date not null,
Igv decimal(7,2) not null,
SubTotal decimal(7,2) not null,
Total decimal(7,2) not null,
Estado char(1) null, 
primary key(IdCompra),
index fk_idproveedor(IdProveedor asc),
constraint fk_idproveedor foreign key(IdProveedor) references Proveedores(IdProveedor)
)engine=innodb;

create table DetalleCompras(
IdCompra int not null,
IdProducto int not null,
Cantidad decimal(7,2) not null,
Precio decimal(7,2) not null,
Importe decimal(7,2) not null,
primary key(IdCompra,IdProducto),
index fk_idcompra(IdCompra asc),
index fk_idproducto_compra(IdProducto asc),
constraint fk_idcompra foreign key(IdCompra) references Compras(IdCompra),
constraint fk_idproducto_compra foreign key(IdProducto) references Productos(IdProducto)
)engine=innodb;

create table tipos_servicio(
    idtiposervicio int auto_increment,
    descripcion varchar(300) not null,
    estado char(1) not null,
    primary key(idtiposervicio)
)engine=innodb;

create table parametros(
    idparametro int auto_increment,
    nombre_empresa varchar(200) not null,
    direccion varchar(200) not null,
    telefono varchar(200) null,
    ruc varchar(11) null,
    monto_kilo decimal(7,2) not null,
    estado char(1) not null,
    primary key(idparametro)
)engine=innodb;

create table Ventas(
IdVenta int not null auto_increment,
IdCliente int null,
TipoDoc varchar(20) not null,
SerieDoc varchar(3) not null,
NumDoc varchar(6) not null,
Fecha date not null,
hora time not null,
Igv decimal(7,2) not null,
SubTotal decimal(7,2) not null,
Total decimal(7,2) not null,
IdUsuario smallint unsigned,
Estado char(1) null, 
tipo_pago varchar(100),
idtiposervicio int not null,
fecha_entrega date null,
primary key(IdVenta),
index fk_idcliente(IdCliente asc),
index fk_idusuario (IdUsuario asc),
constraint fk_idcliente foreign key(IdCliente) references Clientes(IdCliente),
constraint fk_idusuario foreign key(IdUsuario) references Usuarios(IdUsuario),
constraint fk_tipos_servicio foreign key(idtiposervicio) references tipos_servicio(idtiposervicio)
)engine=innodb;

create table DetalleVentas(
IdVenta int not null,
IdProducto int not null,
Cantidad decimal(7,2) not null,
Precio decimal(7,2) not null,
Descuento decimal(7,2) not null,
Importe decimal(7,2) not null,
primary key(IdVenta,IdProducto),
index fk_idventa(IdVenta asc),
index fk_idproducto_venta(IdProducto asc),
constraint fk_idventa foreign key(IdVenta) references Ventas(IdVenta),
constraint fk_idproducto_venta foreign key(IdProducto) references Productos(IdProducto)
)engine=innodb;

create table Ingresos(
IdIngreso int not null auto_increment primary key,
Fecha date not null,
Monto decimal(7,2) not null,
Motivo varchar(30)null
)engine=innodb;

create table Egresos(
IdEgreso int not null auto_increment primary key,
Fecha date not null,
Monto decimal(7,2) not null,
Motivo varchar(30)null
)engine=innodb;

insert into usuarios values(null,'admin','admin','ADMINISTRADOR','1');
insert into clientes values(null,'PUBLICO EN GENERAL','11111111','-','-','1');
insert into proveedores values(null,'SIN PROVEEDOR','11111111111','-','-','1');

-- insert into marcas values(100,'SIN MARCA','1');
insert into categorias values(null,'SIN CATEGORIA','1');
insert into unidadmedidas values(null,'UNIDAD','1');


delete from productos where idproducto >= 1;
delete from marcas where idmarca >= 1;

LOAD DATA INFILE 'E:/Migracion_lavanderia/marcas.csv' INTO TABLE marcas
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n';

LOAD DATA INFILE 'E:/Migracion_lavanderia/productos.csv' INTO TABLE productos
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n';
/*
truncate table ventas
 
select v.seriedoc,v.numdoc,cli.nombres,v.tipodoc,v.seriedoc,v.numdoc,v.fecha,v.fecha,v.subtotal,v.total,
u.idusuario,u.nombre,v.estado
from ventas v inner join clientes cli on v.idcliente=cli.idcliente
inner join usuarios u on u.idusuario=v.idusuario

select c.idcompra,p.idproveedor, p.razonsocial,c.tipodoc,
c.numdoc,c.fecha,c.igv,c.subtotal,c.total from compras c inner join
proveedores p on p.idproveedor=c.idproveedor
select * from productos
select * from detalleventas where idventa = ?

select p.idproducto,c.nombre,m.nombre,p.descripcion,u.nombre,p.stock,p.precio
from productos p inner join marcas m on m.idmarca=p.idmarca
inner join categorias c on c.idcategoria=p.idcategoria
inner join unidadmedidas u on u.idunidadmedida=p.idunidadmedida
where p.stock < p.stockminimo and p.estado like '1'

select v.idventa,c.nombres,v.tipodoc,v.seriedoc,v.numdoc,v.fecha,ifnull(v.hora,'00:00'),v.igv,v.subtotal,u.nombre,v.total 
from ventas v 
inner join usuarios u on u.idusuario=v.idusuario
inner join clientes c on c.idcliente=v.idcliente
where v.estado like 'p' and v.fecha like curdate()
order by v.fecha,v.hora

select dv.idproducto,dv.cantidad,p.descripcion,dv.precio,dv.importe
from detalleventas dv
inner join ventas v on v.idventa=dv.idventa
inner join productos p on p.idproducto=dv.idproducto
where v.idventa=2

select dc.idproducto,dc.cantidad,p.descripcion,dc.precio,dc.importe
from detallecompras dc
                inner join compras c on c.idcompra=dc.idcompra
                inner join productos p on p.idproducto=dc.idproducto