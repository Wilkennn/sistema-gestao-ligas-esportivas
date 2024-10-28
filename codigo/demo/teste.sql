-- SQLBook: Code
-- Tabela de equipes

CREATE TABLE
    equipe (
        equipe_id INT AUTO_INCREMENT PRIMARY KEY,
        equipe_name TEXT NOT NULL,
        campeonato_id INT,
        FOREIGN KEY (campeonato_id) REFERENCES campeonato(campeonato_id)
    );

-- Tabela de campeonatos

CREATE TABLE
    campeonato (
        campeonato_id INT AUTO_INCREMENT PRIMARY KEY,
        equipe_id INT,
        FOREIGN KEY (equipe_id) REFERENCES equipe(equipe_id)
    );

-- Tabela de partidas

CREATE TABLE
    partida (
        partida_id INT AUTO_INCREMENT PRIMARY KEY,
        partida_data TEXT NOT NULL,
        partida_equipe_casa_id INT NOT NULL,
        partida_equipe_visitante_id INT NOT NULL,
        partida_campeonato_id INT NOT NULL,
        partida_placar_id INT NOT NULL,
        FOREIGN KEY (partida_equipe_casa_id) REFERENCES equipe(equipe_id),
        FOREIGN KEY (partida_equipe_visitante_id) REFERENCES equipe(equipe_id),
        FOREIGN KEY (partida_campeonato_id) REFERENCES campeonato(campeonato_id)
    );

-- Tabela de placar

CREATE TABLE
    placar (
        placar_id INT AUTO_INCREMENT PRIMARY KEY,
        partida_id INT NOT NULL,
        placar_q1_casa INT NOT NULL,
        placar_q1_visitante INT NOT NULL,
        placar_q2_casa INT NOT NULL,
        placar_q2_visitante INT NOT NULL,
        placar_q3_casa INT NOT NULL,
        placar_q3_visitante INT NOT NULL,
        placar_q4_casa INT NOT NULL,
        placar_q4_visitante INT NOT NULL,
        prorrogacao_casa INT,
        prorrogacao_visitante INT,
        placar_total_casa INT NOT NULL,
        placar_total_visante INT NOT NULL,
        FOREIGN KEY (partida_id) REFERENCES partida(partida_id)
    ) ENGINE = InnoDB;

-- Tabela de equipes


-- Gerando dados aleatórios para as equipes

INSERT INTO
    equipe (equipe_name, campeonato_id)
VALUES ('Lakers', 1), ('Celtics', 1), ('Warriors', 1), ('Bulls', 1), ('Heat', 1), ('Rockets', 2), ('Cavaliers', 2), ('Mavericks', 2);

-- Gerando dados aleatórios para os campeonatos

INSERT INTO campeonato (equipe_id) VALUES (1), (2);


INSERT INTO placar (partida_id, placar_q1_casa, placar_q1_visitante, placar_q2_casa, placar_q2_visitante, placar_q3_casa, placar_q3_visitante, placar_q4_casa, placar_q4_visitante, prorrogacao_casa, prorrogacao_visitante, placar_total) VALUES
    (1, 20, 15, 18, 20, 25, 30, 22, 18, NULL, NULL, 85),
    (2, 18, 22, 16, 14, 28, 29, 24, 21, 5, 7, 100),
    (3, 19, 20, 17, 19, 26, 30, 23, 20, NULL, NULL, 95),
    (4, 21, 16, 20, 21, 24, 25, 26, 27, NULL, NULL, 88),
    (5, 23, 24, 19, 20, 22, 25, 28, 29, 3, 2, 98),
    (6, 22, 20, 23, 19, 24, 26, 25, 23, NULL, NULL, 89),
    (7, 21, 22, 25, 24, 21, 24, 30, 29, NULL, NULL, 97),
    (8, 17, 18, 23, 22, 20, 19, 24, 21, 3, 2, 85),
    (9, 20, 21, 18, 19, 19, 20, 20, 21, 3, 2, 80),
    (10, 23, 24, 25, 24, 23, 22, 20, 21, 5, 7, 112),
    (11, 22, 20, 23, 19, 22, 20, 21, 24, NULL, NULL, 98),
    (12, 21, 22, 20, 21, 24, 26, 27, 25, NULL, NULL, 95),
    (13, 24, 25, 23, 22, 25, 24, 26, 27, NULL, NULL, 112),
    (14, 18, 19, 21, 22, 20, 22, 25, 24, NULL, NULL, 87),
    (15, 19, 20, 18, 19, 19, 20, 22, 24, 4, 5, 84),
    (16, 22, 18, 20, 19, 23, 25, 21, 20, NULL, NULL, 85),
    (17, 23, 21, 22, 20, 25, 24, 23, 22, NULL, NULL, 92),
    (18, 24, 20, 22, 21, 26, 25, 24, 22, NULL, NULL, 95),
    (19, 21, 22, 19, 20, 20, 21, 22, 24, NULL, NULL, 85),
    (20, 20, 21, 21, 22, 22, 23, 24, 23, NULL, NULL, 88),
    (21, 19, 20, 23, 22, 25, 24, 22, 21, NULL, NULL, 89),
    (22, 20, 21, 20, 21, 24, 25, 23, 24, 3, 2, 87),
    (23, 22, 24, 25, 24, 26, 25, 24, 23, NULL, NULL, 110),
    (24, 21, 22, 23, 24, 22, 23, 25, 24, NULL, NULL, 92),
    (25, 22, 23, 24, 25, 21, 22, 20, 19, 4, 5, 103),
    (26, 23, 24, 25, 26, 24, 25, 23, 22, NULL, NULL, 110),
    (27, 22, 23, 23, 24, 24, 23, 22, 21, NULL, NULL, 91),
    (28, 21, 22, 20, 21, 22, 24, 25, 23, NULL, NULL, 88),
    (29, 23, 24, 22, 23, 24, 25, 26, 24, 3, 2, 100),
    (30, 20, 21, 19, 20, 20, 21, 22, 23, 4, 5, 87),
    (31, 22, 24, 25, 26, 23, 22, 24, 23, NULL, NULL, 102),
    (32, 21, 22, 23, 24, 25, 26, 24, 23, 3, 2, 94),
    (33, 23, 25, 22, 23, 24, 23, 22, 21, NULL, NULL, 101),
    (34, 21, 22, 20, 21, 22, 24, 25, 23, NULL, NULL, 88),
    (35, 23, 24, 25, 26, 24, 25, 23, 22, NULL, NULL, 112),
    (36, 22, 23, 23, 24, 24, 23, 22, 21, NULL, NULL, 91),
    (37, 21, 22, 20, 21, 22, 24, 25, 23, NULL, NULL, 88),
    (38, 23, 24, 22, 23, 24, 25, 26, 24, 3, 2, 100),
    (39, 20, 21, 19, 20, 20, 21, 22, 23, 4, 5, 87),
    (40, 22, 24, 25, 26, 23, 22, 24, 23, NULL, NULL, 102),
    (41, 21, 22, 23, 24, 25, 26, 24, 23, 3, 2, 94),
    (42, 23, 25, 22, 23, 24, 23, 22, 21, NULL, NULL, 101),
    (43, 21, 22, 20, 21, 22, 24, 25, 23, NULL, NULL, 88),
    (44, 23, 24, 25, 26, 24, 25, 23, 22, NULL, NULL, 112),
    (45, 22, 23, 23, 24, 24, 23, 22, 21, NULL, NULL, 91),
    (46, 21, 22, 20, 21, 22, 24, 25, 23, NULL, NULL, 88),
    (47, 23, 24, 22, 23, 24, 25, 26, 24, 3, 2, 100),
    (48, 20, 21, 19, 20, 20, 21, 22, 23, 4, 5, 87),
    (49, 22, 24, 25, 26, 23, 22, 24, 23, NULL, NULL, 102),
    (50, 21, 22, 23, 24, 25, 26, 24, 23, 3, 2, 94),
    (51, 23, 25, 22, 23, 24, 23, 22, 21, NULL, NULL, 101),
    (52, 21, 22, 20, 21, 22, 24, 25, 23, NULL, NULL, 88),
    (53, 23, 24, 25, 26, 24, 25, 23, 22, NULL, NULL, 112),
    (54, 22, 23, 23, 24, 24, 23, 22, 21, NULL, NULL, 91),
    (55, 21, 22, 20, 21, 22, 24, 25, 23, NULL, NULL, 88),
    (56, 23, 24, 22, 23, 24, 25, 26, 24, 3, 2, 100);

-- Inserir 56 registros de partidas fictícias
INSERT INTO partida (partida_data, partida_equipe_casa_id, partida_equipe_visitante_id, partida_placar_id) VALUES
    ('2023-10-16', 33, 34, 1),
    ('2023-10-17', 33, 35, 2),
    ('2023-10-18', 33, 36, 3),
    ('2023-10-19', 33, 37, 4),
    ('2023-10-20', 33, 38, 5),
    ('2023-10-21', 33, 39, 6),
    ('2023-10-22', 33, 40, 7),
    ('2023-10-23', 34, 35, 8),
    ('2023-10-24', 34, 36, 9),
    ('2023-10-25', 34, 37, 10),
    ('2023-10-26', 34, 38, 11),
    ('2023-10-27', 34, 39, 12),
    ('2023-10-28', 34, 40, 13),
    ('2023-10-29', 35, 36, 14),
    ('2023-10-30', 35, 37, 15),
    ('2023-10-31', 35, 38, 16),
    ('2023-11-01', 35, 39, 17),
    ('2023-11-02', 35, 40, 18),
    ('2023-11-03', 36, 37, 19),
    ('2023-11-04', 36, 38, 20),
    ('2023-11-05', 36, 39, 21),
    ('2023-11-06', 36, 40, 22),
    ('2023-11-07', 37, 38, 23),
    ('2023-11-08', 37, 39, 24),
    ('2023-11-09', 37, 40, 25),
    ('2023-11-10', 38, 39, 26),
    ('2023-11-11', 38, 40, 27),
    ('2023-11-12', 39, 40, 28),
    ('2023-11-13', 39, 33, 29),
    ('2023-11-14', 39, 34, 30),
    ('2023-11-15', 39, 35, 31),
    ('2023-11-16', 39, 36, 32),
    ('2023-11-17', 39, 37, 33),
    ('2023-11-18', 39, 38, 34),
    ('2023-11-19', 40, 34, 35),
    ('2023-11-20', 40, 35, 36),
    ('2023-11-21', 40, 36, 37),
    ('2023-11-22', 40, 37, 38),
    ('2023-11-23', 40, 38, 39),
    ('2023-11-24', 40, 39, 40),
    ('2023-11-25', 33, 35, 41),
    ('2023-11-26', 33, 36, 42),
    ('2023-11-27', 33, 37, 43),
    ('2023-11-28', 33, 38, 44),
    ('2023-11-29', 33, 39, 45),
    ('2023-11-30', 33, 40, 46),
    ('2023-12-01', 34, 35, 47),
    ('2023-12-02', 34, 36, 48),
    ('2023-12-03', 34, 37, 49),
    ('2023-12-04', 34, 38, 50),
    ('2023-12-05', 34, 39, 51),
    ('2023-12-06', 34, 40, 52),
    ('2023-12-07', 35, 36, 53),
    ('2023-12-08', 35, 37, 54),
    ('2023-12-09', 35, 38, 55),
    ('2023-12-10', 35, 39, 56);
