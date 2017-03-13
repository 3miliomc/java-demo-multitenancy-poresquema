CREATE DATABASE IF NOT EXISTS cliente_a;
CREATE DATABASE IF NOT EXISTS cliente_b;

CREATE TABLE IF NOT EXISTS cliente_a.personas (
  id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(60) not null,
  apellido  varchar(60) not null,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS cliente_b.personas (
  id         BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(60) not null,
  apellido  varchar(60) not null,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);