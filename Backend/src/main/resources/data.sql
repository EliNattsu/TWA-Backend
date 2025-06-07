INSERT INTO cat_owner (name, email, password, phone) VALUES
                                                         ('Anna Nováková', 'anna.novakova@email.cz', 'heslo123', '777111222'),
                                                         ('Petr Svoboda', 'petr.svoboda@email.cz', 'petrheslo', '606222333'),
                                                         ('Eva Králová', 'eva.kralova@email.cz', 'evahack', '603333444'),
                                                         ('Jan Dvořák', 'jan.dvorak@email.cz', 'dvorakjan', '777444555'),
                                                         ('Lucie Černá', 'lucie.cerna@email.cz', 'cernalu', '602555666'),
                                                         ('Tomáš Malý', 'tomas.maly@email.cz', 'mamradykočky', '608666777'),
                                                         ('Karolína Veselá', 'karolina.vesela@email.cz', 'veselak', '777777888'),
                                                         ('Marek Horák', 'marek.horak@email.cz', 'horakm', '606888999'),
                                                         ('Jana Zelená', 'jana.zelena@email.cz', 'zelenej', '603999000'),
                                                         ('Ondřej Pokorný', 'ondrej.pokorny@email.cz', 'pokorny123', '777000111');

INSERT INTO cat (name, age, breed, owner_id) VALUES
                                                 ('Micka', 3, 'Siamská', 1),
                                                 ('Oscar', 5, 'Perská', 1),
                                                 ('Luna', 2, 'Mainská mývalí', 2),
                                                 ('Max', 4, 'Britská krátkosrstá', 2),
                                                 ('Bella', 1, 'Ragdoll', 3),
                                                 ('Charlie', 6, 'Bengálská', 3),
                                                 ('Lucy', 2, 'Sphynx', 4),
                                                 ('Leo', 3, 'Sibiřská', 4),
                                                 ('Mia', 4, 'Birma', 5),
                                                 ('Simba', 5, 'Savannah', 5),
                                                 ('Tiger', 1, 'Evropská krátkosrstá', 6),
                                                 ('Coco', 2, 'Norvegská lesní', 6),
                                                 ('Smokey', 3, 'Egyptská mau', 7),
                                                 ('Lily', 4, 'Ruská modrá', 7),
                                                 ('Milo', 2, 'Bombajská', 8),
                                                 ('Zoe', 5, 'Habešská', 8),
                                                 ('Chloe', 1, 'Scottish Fold', 9),
                                                 ('Jack', 3, 'Devon Rex', 9),
                                                 ('Nala', 4, 'Oriental', 10),
                                                 ('Oliver', 2, 'Exotická krátkosrstá', 10);

INSERT INTO room (room_number, capacity, price_per_night, description, room_type) VALUES
                                                                                      ('101', 2, 500.0, 'Pokoj pro kočku - standard', 'ProKockuSTANDART'),
                                                                                      ('102', 2, 600.0, 'Pokoj pro kočku - deluxe', 'ProKockuDELUXE'),
                                                                                      ('103', 1, 800.0, 'Pokoj pro kočku - suite', 'ProKockuSUITE'),
                                                                                      ('201', 2, 700.0, 'Pokoj pro kočku a majitele - standard', 'ProKockuAMajiteleSTANDART'),
                                                                                      ('202', 2, 900.0, 'Pokoj pro kočku a majitele - deluxe', 'ProKockuAMajiteleDELUX'),
                                                                                      ('203', 1, 1200.0, 'Pokoj pro kočku a majitele - suite', 'ProKockuAMajiteleSUITE'),
                                                                                      ('104', 3, 550.0, 'Velký pokoj pro více koček', 'ProKockuSTANDART'),
                                                                                      ('204', 2, 950.0, 'Pokoj pro kočku a majitele s balkonem', 'ProKockuAMajiteleDELUX'),
                                                                                      ('105', 1, 850.0, 'Pokoj pro kočku - suite s výhledem', 'ProKockuSUITE'),
                                                                                      ('205', 2, 1250.0, 'Luxusní pokoj pro kočku a majitele', 'ProKockuAMajiteleSUITE');

INSERT INTO reservation (cat_id, room_id, start_date, end_date, status, reference_number) VALUES
                                                                                              (1, 1, '2025-07-01', '2025-07-10', 'PENDING', 'RES-0001'),
                                                                                              (2, 2, '2025-07-05', '2025-07-12', 'CONFIRMED', 'RES-0002'),
                                                                                              (3, 3, '2025-08-01', '2025-08-08', 'COMPLETED', 'RES-0003'),
                                                                                              (4, 4, '2025-08-10', '2025-08-15', 'CANCELLED', 'RES-0004'),
                                                                                              (5, 5, '2025-09-01', '2025-09-10', 'PENDING', 'RES-0005'),
                                                                                              (6, 6, '2025-09-12', '2025-09-20', 'CONFIRMED', 'RES-0006'),
                                                                                              (7, 7, '2025-10-01', '2025-10-05', 'COMPLETED', 'RES-0007'),
                                                                                              (8, 8, '2025-10-10', '2025-10-15', 'PENDING', 'RES-0008'),
                                                                                              (9, 9, '2025-11-01', '2025-11-07', 'CONFIRMED', 'RES-0009'),
                                                                                              (10, 10, '2025-11-10', '2025-11-17', 'PENDING', 'RES-0010');
