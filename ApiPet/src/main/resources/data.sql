insert ignore into tb_dono_pet(id, cpf, nome)
values(1, "111111111", "Elisio"),
(2, "22222222222", "Natalia"),
(3, "333333333333", "Fabiana");

insert ignore into tb_perfil(id, nome)
values(1, "admin"),
(2, "user");

insert ignore into tb_usuario(id, email, senha, perfil_id)
values(1, "Admin@admin.com", "$2a$10$jOlX6b7tYJbvCc3ndD5jjOXoXeoC2rV4kv8H1sqreiO7qWwr5tiQ.", 1),
(2, "user@user.com", "$2a$10$jOlX6b7tYJbvCc3ndD5jjOXoXeoC2rV4kv8H1sqreiO7qWwr5tiQ.", 2);

insert ignore into tb_pet(id, nome_pet, peso, tipo, dono_pet_id)
values(1, "Batman", "5", "Gato", 1),
(2, "Negao", "20,5", "Cachorro", 3),
(3, "Princesa", "30,5", "Cachorro", 3),
(4, "Kyara", "15,5", "Cachorro", 3),
(5, "Nick", "2", "Papagaio", 2),
(6, "Mel", "8,5", "Gato", 2),
(7, "Lorena", "7,5", "Tartaruga", 1),
(8, "Laranja", "3,5", "Gato", 3),
(9, "piu", "1,5", "Passarinho", 1),
(10, "Amarelo", "20,5", "Cobra", 3);

/*email acesso: Admin@admin.com
senha: 1234*/