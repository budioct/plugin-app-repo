show databases;

create database plugin_app;

create database db_ttd_barang;
use db_ttd_barang;

show tables;


use plugin_app;

create table items
(
    id                   int(11) not null auto_increment,
    nama_barang          varchar(255),
    tanggal              timestamp,
    no_npk               varchar(255),
    bengkel_toko         varchar(200),
    selesai_belumselesai boolean,
    posisi_barang        varchar(255),
    keterangan           text,
    kapal                varchar(200),
    create_at            timestamp,
    update_modified_at   timestamp,
    primary key (id)
) engine = InnoDB;

# table 1
create table barang_terimas
(
    id                 int(11) not null auto_increment,
--     no                 int(11),
    tanggal            timestamp,
    no_npp             varchar(200),
    nama_barang        varchar(200),
    keterangan         text,
    kapal              varchar(200),
    create_at          timestamp,
    update_modified_at timestamp,
    delete_at          int(1),
    primary key (id)
) engine = InnoDB;

# table 2
create table barang_perbaikans
(
    id                 int(11) not null auto_increment,
--     no                 int(11),
    tanggal            timestamp,
    no_npk             varchar(200),
    nama_barang        varchar(200),
    keterangan         text,
    kapal              varchar(200),
    create_at          timestamp,
    update_modified_at timestamp,
    delete_at          int(1),
    primary key (id)
) engine = InnoDB;

# table 3
create table barang_perbaikan_admins
(
    id                   int(11) not null auto_increment,
--     no                   int(11),
    nama_barang          varchar(200),
    tanggal              timestamp,
    bengkel_toko         varchar(200),
    selesai_belumselesai boolean,
    posisi_barang        varchar(200),
    keterangan           text,
    kapal                varchar(200),
    create_at            timestamp,
    update_modified_at   timestamp,
    delete_at            int(1),
    primary key (id)
) engine = InnoDB;


show tables;
describe items;
describe barang_terimas;
describe barang_perbaikans;
describe barang_perbaikan_admins;

# select * from items;
select * from barang_terimas;
select * from barang_perbaikans;
select * from barang_perbaikan_admins;

# drop table items;
# drop table barang_terimas;
# drop table barang_perbaikans;
# drop table barang_perbaikan_admins;


SELECT IFNULL(MAX(CONVERT(no, SIGNED INTEGER)), 0) AS kode
FROM barang_terimas;
SELECT IFNULL(MAX(CONVERT(no, SIGNED INTEGER)), 0) AS kode
FROM barang_perbaikans;
SELECT IFNULL(MAX(CONVERT(no, SIGNED INTEGER)), 0) AS kode
FROM barang_perbaikan_admins;

