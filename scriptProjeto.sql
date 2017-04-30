
-- Banco de dados postgres 


CREATE DATABASE "webServicePessoa_rest_jersey_JPA"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
CREATE TABLE public.tb_pessoa
(
    id serial NOT NULL,
    nome character varying(45) NOT NULL,
    sexo "char" NOT NULL,
    cpf character varying(11),
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.tb_pessoa
    OWNER to postgres;
COMMENT ON TABLE public.tb_pessoa
    IS 'Tabela com os dados de pessoa.';
    
INSERT INTO public.tb_pessoa( id, nome, sexo, cpf ) VALUES (1, 'Diego Francisco', 'M', '03994435180');
INSERT INTO public.tb_pessoa( id, nome, sexo, cpf ) VALUES (2, 'Rafael Francisco', 'M', '01235835180');
INSERT INTO public.tb_pessoa( id, nome, sexo, cpf ) VALUES (3, 'Thiago Francisco', 'M', '03994415634');
INSERT INTO public.tb_pessoa( id, nome, sexo, cpf ) VALUES (4, 'Ester Francisco', 'F', '95225489952');
