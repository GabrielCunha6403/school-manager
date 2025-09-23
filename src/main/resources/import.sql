INSERT INTO tp_users (cd_tp_user, ds_tp_user) VALUES
    (1, 'ADMINISTRADOR'),
    (2, 'COORDENADOR'),
    (3, 'PROFESSOR'),
    (4, 'ALUNO')
ON CONFLICT DO NOTHING;
