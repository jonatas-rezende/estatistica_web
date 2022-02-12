/**
 * View de variáveis de resposta por projeto
 * @author Andrey Silva Ribeiro
 */
CREATE VIEW variaveis_resposta_por_projeto AS
SELECT variaveis_respostas.id, variaveis_respostas.nome
FROM variaveis_respostas
INNER JOIN projetos ON projetos.id = variaveis_respostas.id
GROUP BY projetos.nome
ORDER BY  projetos.nome, variaveis_respostas.nome;


/**
 * View de tratamentos por projeto.
 * @author Lara Caroline
 */ 
CREATE VIEW `estatistica`.`tratamentos_por_projeto` AS
SELECT projeto, COUNT(id) AS numero_tratamentos 
FROM tratamentos 
GROUP BY projeto;

/**
 * View de projetos por usuários
 * @author Adallberto Lucena Moura 
 */
CREATE VIEW qtde_projetos_por_usuarios AS 

SELECT 
	usuarios.id AS id_usuario, 
	usuarios.nome AS usuario, 
    COUNT(projetos.id) AS qtde_projetos 
    
FROM usuarios
	LEFT JOIN projetos ON projetos.usuario = usuarios.id
    
   	GROUP BY usuarios.id
	ORDER BY qtde_projetos desc;
