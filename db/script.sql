CREATE DATABASE sistemaHotel;
USE sistemaHotel;

-- =============================================
-- CRIACAO DAS TABELAS
-- =============================================

CREATE TABLE cliente (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(150) NOT NULL,
                         cpf VARCHAR(20) NOT NULL,
                         email VARCHAR(150) NOT NULL,
                         telefone VARCHAR(20),
                         data_nascimento DATE NOT NULL,
                         endereco VARCHAR(150) NOT NULL
);

CREATE TABLE quarto (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        numero INT NOT NULL UNIQUE,
                        tipo ENUM('SIMPLES', 'DUPLO', 'SUITE', 'SUITE_PRESIDENCIAL') NOT NULL,
                        capacidade INT NOT NULL,
                        preco DOUBLE NOT NULL,
                        status_quarto ENUM(
        'DISPONIVEL', 'RESERVADO', 'OCUPADO',
        'EM_LIMPEZA', 'MANUTENCAO'
    )
);

CREATE TABLE imagem (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        url TEXT NOT NULL,
                        id_quarto BIGINT NOT NULL,
                        FOREIGN KEY (id_quarto) REFERENCES quarto(id)
);

CREATE TABLE reserva (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         id_cliente BIGINT NOT NULL,
                         id_quarto BIGINT NOT NULL,
                         check_in DATE NOT NULL,
                         check_out DATE NOT NULL,
                         hospedes INT NOT NULL,
                         valor DOUBLE NOT NULL,
                         FOREIGN KEY (id_cliente) REFERENCES cliente(id),
                         FOREIGN KEY (id_quarto) REFERENCES quarto(id)
);

-- =============================================
-- 20 CLIENTES
-- =============================================

INSERT INTO cliente
(nome, cpf, email, telefone, data_nascimento, endereco)
VALUES
    ('Lucas Almeida', '123.456.789-01', 'lucas@gmail.com', '47999990001', '1995-04-12', 'Rua das Flores, 120'),
    ('Mariana Oliveira', '234.567.890-12', 'mariana@gmail.com', '47999990002', '1998-08-25', 'Av. Brasil, 450'),
    ('Gabriel Santos', '345.678.901-23', 'gabriel@gmail.com', '47999990003', '1992-02-15', 'Rua Central, 80'),
    ('Ana Carolina Costa', '456.789.012-34', 'ana@gmail.com', '47999990004', '2000-11-03', 'Rua das Palmeiras, 210'),
    ('Pedro Henrique', '567.890.123-45', 'pedro@gmail.com', '47999990005', '1997-06-19', 'Av. Atlantica, 900'),
    ('Juliana Ferreira', '678.901.234-56', 'juliana@gmail.com', '47999990006', '1994-09-22', 'Rua do Sol, 35'),
    ('Rafael Rodrigues', '789.012.345-67', 'rafael@gmail.com', '47999990007', '1990-01-10', 'Rua Bela Vista, 150'),
    ('Camila Martins', '890.123.456-78', 'camila@gmail.com', '47999990008', '2001-05-17', 'Rua das Acacias, 75'),
    ('Bruno Carvalho', '901.234.567-89', 'bruno@gmail.com', '47999990009', '1996-12-08', 'Av. Beira-Mar, 300'),
    ('Fernanda Lima', '012.345.678-90', 'fernanda@gmail.com', '47999990010', '1993-03-29', 'Rua das Gaivotas, 40'),
    ('Matheus Gomes', '111.222.333-44', 'matheus@gmail.com', '47999990011', '1999-07-14', 'Rua do Comercio, 180'),
    ('Beatriz Ribeiro', '222.333.444-55', 'beatriz@gmail.com', '47999990012', '1995-10-21', 'Av. das Nacoes, 500'),
    ('Thiago Barbosa', '333.444.555-66', 'thiago@gmail.com', '47999990013', '1991-04-06', 'Rua dos Pescadores, 60'),
    ('Larissa Mendes', '444.555.666-77', 'larissa@gmail.com', '47999990014', '2002-02-18', 'Rua do Mar, 125'),
    ('Felipe Nascimento', '555.666.777-88', 'felipe@gmail.com', '47999990015', '1998-12-30', 'Av. Central, 700'),
    ('Amanda Moreira', '666.777.888-99', 'amanda@gmail.com', '47999990016', '1994-06-11', 'Rua das Conchas, 90'),
    ('Eduardo Lopes', '777.888.999-00', 'eduardo@gmail.com', '47999990017', '1990-08-04', 'Rua dos Coqueiros, 230'),
    ('Isabela Dias', '888.999.000-11', 'isabela@gmail.com', '47999990018', '2000-01-27', 'Av. Beira-Mar, 1200'),
    ('Gustavo Teixeira', '999.000.111-22', 'gustavo@gmail.com', '47999990019', '1997-09-13', 'Rua da Praia, 55'),
    ('Leticia Araujo', '000.111.222-33', 'leticia@gmail.com', '47999990020', '1996-05-09', 'Rua das Ondas, 320');

-- =============================================
-- 20 QUARTOS
-- =============================================

INSERT INTO quarto
(numero, tipo, capacidade, preco, status_quarto)
VALUES
    (101, 'SIMPLES', 1, 180.00, 'DISPONIVEL'),
    (102, 'SIMPLES', 1, 180.00, 'OCUPADO'),
    (103, 'SIMPLES', 2, 220.00, 'DISPONIVEL'),
    (104, 'DUPLO', 2, 280.00, 'RESERVADO'),
    (105, 'DUPLO', 2, 300.00, 'DISPONIVEL'),
    (106, 'DUPLO', 3, 350.00, 'OCUPADO'),
    (107, 'SUITE', 2, 450.00, 'DISPONIVEL'),
    (108, 'SUITE', 3, 500.00, 'RESERVADO'),
    (109, 'SUITE', 4, 550.00, 'DISPONIVEL'),
    (110, 'SUITE_PRESIDENCIAL', 4, 1200.00, 'DISPONIVEL'),
    (201, 'SIMPLES', 1, 190.00, 'EM_LIMPEZA'),
    (202, 'SIMPLES', 2, 230.00, 'DISPONIVEL'),
    (203, 'DUPLO', 2, 290.00, 'OCUPADO'),
    (204, 'DUPLO', 3, 360.00, 'DISPONIVEL'),
    (205, 'SUITE', 2, 480.00, 'MANUTENCAO'),
    (206, 'SUITE', 3, 520.00, 'DISPONIVEL'),
    (207, 'SUITE', 4, 580.00, 'RESERVADO'),
    (208, 'SUITE_PRESIDENCIAL', 5, 1400.00, 'DISPONIVEL'),
    (209, 'SUITE_PRESIDENCIAL', 4, 1300.00, 'OCUPADO'),
    (210, 'DUPLO', 2, 310.00, 'DISPONIVEL');

-- =============================================
-- 20 RESERVAS
-- =============================================

INSERT INTO reserva
(id_cliente, id_quarto, check_in, check_out, hospedes, valor)
VALUES
    (1, 2, '2026-11-01', '2026-11-04', 1, 540.00),
    (2, 4, '2026-11-02', '2026-11-06', 2, 1120.00),
    (3, 6, '2026-11-03', '2026-11-07', 3, 1400.00),
    (4, 8, '2026-11-05', '2026-11-08', 2, 1500.00),
    (5, 10, '2026-11-06', '2026-11-10', 4, 4800.00),
    (6, 11, '2026-11-07', '2026-11-09', 1, 380.00),
    (7, 13, '2026-11-08', '2026-11-12', 2, 1160.00),
    (8, 15, '2026-11-10', '2026-11-14', 2, 1920.00),
    (9, 17, '2026-11-11', '2026-11-15', 4, 2320.00),
    (10, 19, '2026-11-12', '2026-11-16', 3, 5200.00),
    (11, 1, '2026-11-15', '2026-11-18', 1, 540.00),
    (12, 3, '2026-11-16', '2026-11-20', 2, 880.00),
    (13, 5, '2026-11-17', '2026-11-21', 2, 1200.00),
    (14, 7, '2026-11-18', '2026-11-22', 2, 1800.00),
    (15, 9, '2026-11-19', '2026-11-23', 4, 2200.00),
    (16, 12, '2026-11-20', '2026-11-24', 2, 920.00),
    (17, 14, '2026-11-21', '2026-11-25', 3, 1440.00),
    (18, 16, '2026-11-22', '2026-11-26', 3, 2080.00),
    (19, 18, '2026-11-23', '2026-11-27', 4, 5600.00),
    (20, 20, '2026-11-24', '2026-11-28', 2, 1240.00);

-- =============================================
-- 50 IMAGENS
-- =============================================

INSERT INTO imagem (url, id_quarto)
VALUES
    ('https://picsum.photos/seed/quarto101a/1200/800', 1),
    ('https://picsum.photos/seed/quarto101b/1200/800', 1),
    ('https://picsum.photos/seed/quarto101c/1200/800', 1),

    ('https://picsum.photos/seed/quarto102a/1200/800', 2),
    ('https://picsum.photos/seed/quarto102b/1200/800', 2),

    ('https://picsum.photos/seed/quarto103a/1200/800', 3),
    ('https://picsum.photos/seed/quarto103b/1200/800', 3),
    ('https://picsum.photos/seed/quarto103c/1200/800', 3),

    ('https://picsum.photos/seed/quarto104a/1200/800', 4),
    ('https://picsum.photos/seed/quarto104b/1200/800', 4),

    ('https://picsum.photos/seed/quarto105a/1200/800', 5),
    ('https://picsum.photos/seed/quarto105b/1200/800', 5),

    ('https://picsum.photos/seed/quarto106a/1200/800', 6),
    ('https://picsum.photos/seed/quarto106b/1200/800', 6),
    ('https://picsum.photos/seed/quarto106c/1200/800', 6),

    ('https://picsum.photos/seed/quarto107a/1200/800', 7),
    ('https://picsum.photos/seed/quarto107b/1200/800', 7),

    ('https://picsum.photos/seed/quarto108a/1200/800', 8),
    ('https://picsum.photos/seed/quarto108b/1200/800', 8),
    ('https://picsum.photos/seed/quarto108c/1200/800', 8),

    ('https://picsum.photos/seed/quarto109a/1200/800', 9),
    ('https://picsum.photos/seed/quarto109b/1200/800', 9),

    ('https://picsum.photos/seed/quarto110a/1200/800', 10),
    ('https://picsum.photos/seed/quarto110b/1200/800', 10),
    ('https://picsum.photos/seed/quarto110c/1200/800', 10),

    ('https://picsum.photos/seed/quarto201a/1200/800', 11),
    ('https://picsum.photos/seed/quarto201b/1200/800', 11),

    ('https://picsum.photos/seed/quarto202a/1200/800', 12),
    ('https://picsum.photos/seed/quarto202b/1200/800', 12),

    ('https://picsum.photos/seed/quarto203a/1200/800', 13),
    ('https://picsum.photos/seed/quarto203b/1200/800', 13),
    ('https://picsum.photos/seed/quarto203c/1200/800', 13),

    ('https://picsum.photos/seed/quarto204a/1200/800', 14),
    ('https://picsum.photos/seed/quarto204b/1200/800', 14),

    ('https://picsum.photos/seed/quarto205a/1200/800', 15),
    ('https://picsum.photos/seed/quarto205b/1200/800', 15),

    ('https://picsum.photos/seed/quarto206a/1200/800', 16),
    ('https://picsum.photos/seed/quarto206b/1200/800', 16),
    ('https://picsum.photos/seed/quarto206c/1200/800', 16),

    ('https://picsum.photos/seed/quarto207a/1200/800', 17),
    ('https://picsum.photos/seed/quarto207b/1200/800', 17),

    ('https://picsum.photos/seed/quarto208a/1200/800', 18),
    ('https://picsum.photos/seed/quarto208b/1200/800', 18),
    ('https://picsum.photos/seed/quarto208c/1200/800', 18),

    ('https://picsum.photos/seed/quarto209a/1200/800', 19),
    ('https://picsum.photos/seed/quarto209b/1200/800', 19),

    ('https://picsum.photos/seed/quarto210a/1200/800', 20),
    ('https://picsum.photos/seed/quarto210b/1200/800', 20),
    ('https://picsum.photos/seed/quarto210c/1200/800', 20);

-- =============================================
-- CONFERENCIA DAS INSERCOES
-- =============================================

SELECT COUNT(*) AS total_clientes FROM cliente;
SELECT COUNT(*) AS total_quartos FROM quarto;
SELECT COUNT(*) AS total_reservas FROM reserva;
SELECT COUNT(*) AS total_imagens FROM imagem;

-- =============================================
-- CONSULTA DE RESERVAS COM CLIENTE E QUARTO
-- =============================================

SELECT
    r.id AS reserva,
    c.nome AS cliente,
    q.numero AS quarto,
    q.tipo,
    r.check_in,
    r.check_out,
    r.hospedes,
    r.valor
FROM reserva r
         INNER JOIN cliente c ON r.id_cliente = c.id
         INNER JOIN quarto q ON r.id_quarto = q.id;

-- =============================================
-- CONSULTA DE QUARTOS COM SUAS IMAGENS
-- =============================================

SELECT
    q.numero,
    q.tipo,
    i.url
FROM quarto q
         INNER JOIN imagem i ON q.id = i.id_quarto
ORDER BY q.numero;
