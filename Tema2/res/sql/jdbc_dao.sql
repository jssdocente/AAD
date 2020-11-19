
DROP TABLE IF EXISTS Empleado;
DROP TABLE IF EXISTS Producto;

CREATE TABLE `Empleado`
(
    `id`        int(11)      NOT NULL,
    `dni`       varchar(100) NOT NULL,
    `nombre`    varchar(100) NOT NULL,
    `apellido1` varchar(100) NOT NULL,
    `apellido2` varchar(100) DEFAULT NULL,
    `edad`      int(11)      DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `Empleado_UN` (`dni`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- jdbc_dao.Producto definition

CREATE TABLE `Producto`
(
    `id`    int(11)      NOT NULL,
    `name`  varchar(100) NOT NULL,
    `price` decimal(10, 0) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


COMMIT;