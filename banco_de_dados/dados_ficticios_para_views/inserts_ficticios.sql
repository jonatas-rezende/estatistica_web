INSERT INTO usuarios (nome, email, senha) VALUES
					 ('Maria','maria@',123),
                     ('Pedro','pedro@',123),
                     ('João','joao@',123),
                     ('Carla','carla@',123),
                     ('Lara','lara@',123),
                     ('Thalia','thalia@',123),
                     ('Ianka','ianka@',123);                     
					
INSERT INTO projetos (id, nome, quantidade_repeticoes, significancia, teste, usuario) VALUES
					 (7,'projeto 1', 2, 1, 55, 1),
                     (6,'projeto 2', 4, 2, 66, 2),
                     (5,'projeto 3', 3, 5, 77, 1),
                     (4,'projeto 4', 1, 1, 88, 4),
                     (3,'projeto 5', 2, 2, 99, 2),
                     (2,'projeto 6', 5, 2, 11, 6),
                     (1,'projeto 7', 6, 5, 22, 2);
                    
INSERT INTO tratamentos (id, descricao, projeto) VALUES
						(1,'descricao 1', 1),
                        (2,'descricao 1.1', 2),
                        (3,'descricao trat', 1),
                        (4,'desc trat 1', 4),
                        (5,'desc tratamento', 2),
                        (6,'descricao trat 1', 6),
                        (7,'descricao trat 2', 2);
                        
INSERT INTO variaveis_respostas (id, nome, projeto) VALUES
								(1,'Quantitativa Discreta', 1),
                                (2,'Quantitativa Continua ', 2),
                                (3,'Qualitativa Nominal', 1),
                                (4,'Qualitativa Ordinal', 4),
                                (5,'Quantitativa Continua 2', 2),
                                (6,'Qualitativa Ordinal 2', 6),
                                (7,'Quantitativa Discreta 2', 2);
                                
INSERT INTO dados_dic (variavel_resposta, tratamento, repeticao, valor, x, y) VALUES
					  (1, 7, 11,'10.1',  44, 77),
					  (2, 6,  22,'11.2', 55, 888),
					  (3, 5,  33,'12.3', 66, 999),
					  (4, 4,  44,'13.4', 77, 444),
					  (5, 3,  55,'14.5', 88, 555),
					  (6, 2,  66,'15.6', 99, 666),
					  (7, 1,  77,'16.7', 11, 222);

INSERT INTO dados_simples (id, valor, projeto) VALUES
						(1, '120.1',7),
                        (2, '131.2',6),
                        (3, '142.3',5),
                        (4, '154.5',4),
                        (5, '165.6',3),
                        (6, '176.7',2),
                        (7, '183.4',1);
