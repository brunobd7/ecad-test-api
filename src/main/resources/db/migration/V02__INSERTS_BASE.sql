INSERT INTO bancos (id,nome) VALUES (nextval('bancos_id_seq'), 'BRADESCO');
INSERT INTO bancos (id,nome) VALUES (nextval('bancos_id_seq'), 'BANCO DO BRASIL');
INSERT INTO bancos (id,nome) VALUES (nextval('bancos_id_seq'), 'CAIXA ECONOMICA');
INSERT INTO bancos (id,nome) VALUES (nextval('bancos_id_seq'), 'ITAU');


INSERT INTO carteiras (id,nome_beneficiario) VALUES (nextval('carteiras_id_seq'), 'CLIENTE A');
INSERT INTO carteiras (id,nome_beneficiario) VALUES (nextval('carteiras_id_seq'), 'CLIENTE B');
INSERT INTO carteiras (id,nome_beneficiario) VALUES (nextval('carteiras_id_seq'), 'CLIENTE C');
INSERT INTO carteiras (id,nome_beneficiario) VALUES (nextval('carteiras_id_seq'), 'CLIENTE D');


INSERT INTO  usuarios (id, nome) VALUES (nextval('usuarios_id_seq'), 'USUARIO X');
INSERT INTO  usuarios (id, nome) VALUES (nextval('usuarios_id_seq'), 'USUARIO Y');
INSERT INTO  usuarios (id, nome) VALUES (nextval('usuarios_id_seq'), 'USUARIO Z');


INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120100.REM',300,'2021-01-10','2021-01-10',54000.00,'REMESSA',1,1,1);
INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120200.REM',332,'2021-01-10','2021-01-10',5000.00,'REMESSA',1,1,1);

INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120100.RET',547,'2021-01-10','2021-01-10',312.00,'RETORNO',1,1,1);

INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120200.RET',747,'2021-01-10','2021-01-10',8912.00,'RETORNO',1,1,1);


INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120300.REM',300,'2021-12-01','2021-12-01',54000.00,'REMESSA',3,2,1);
INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120400.REM',332,'2021-12-01','2021-12-01',5000.00,'REMESSA',3,2,1);

INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120300.RET',547,'2021-12-01','2021-12-01',312.00,'RETORNO',3,2,1);

INSERT INTO arquivos_bancarios
    (id, nome_arquivo, quantidade_linhas, data_geracao, data_envio, valor, tipo_arquivo, id_banco, id_usuario, id_carteira)
    VALUES
    (nextval('arquivos_bancarios_id_seq'),'CB120400.RET',747,'2021-12-01','2021-12-01',8912.00,'RETORNO',3,2,1);


