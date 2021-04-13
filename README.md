# Case Cyrela
Esta é uma Solução de API REST desenvolvida pelo time GoTech para realizar o cadastro de `Ocorrências / Atividades Agendadas` para a empresa Cyrela.

## Modelagem que sugerimos, baseada nas informações que obtivemos
![Modelagem do banco de dados](https://semparar.vteximg.com.br/arquivos/tb_cs_cy.png?v=1)

## Regras de negócio que consideramos para cadastrar Ocorrências e Atividades Agendadas
1. `Ocorrências / Atividades Agendadas` só podem ser agendadas para dias da semana (seg, ter, qua, qui, sex).
2. Só podem ser cadastradas `3 Ocorrências / Atividades Agendadas` por dia e por empreendimento.

## Endpoints especiais que desenvolvemos para o case Cyrela
##### 1. Dias disponíveis para agendamento no mês, por empreendimento

Com base no mês, ano e ID de empreedimento enviados, retorna os dias no mês disponíveis para agendamento de uma atividade, desconsiderando finais de semanas e dias que o empreendimento já possui 3 agendamentos registrados. Ideal para ser consumido em telas que terão um calendário para o cliente visualizar os dias disponíveis e escolher o dia mais adequado para si.

> Dados da Requisição
```
    TIPO DE REQUISIÇÃO: GET
    ENDPOINT: http://localhost:8080/atividade_agendada/calendario_agendamento?mes=4&ano=2021&idEmpreendimento=1

    PARÂMETROS:
    1. mes -> número de 1 à 12
    2. ano -> numero com 4 digitos
    3. idEmpreendimento -> ID do empreendimento que deseja consultar os dias disponíveis para agendamento

    RESPOSTA:
    [{"dia": 1, "disponivel": true}, {"dia": 2, "disponivel": false}, ...]
```

> Evidência de funcionamento
![Evidência de funcionamento do calendário de agendamentos](https://semparar.vteximg.com.br/arquivos/ev_fn_cl.png?v=1)

##### 2. Agendamentos no dia por empreendimento

Com base na data e ID de empreedimento enviados, retorna as atividades agendadas no dia para o empreendimento informado. O empreendimento é um parâmetro opcional, que quando não enviado, retorna todas as atividades agendadas para o dia informado, independente de empreendimento.

> Dados da Requisição
```
    TIPO DE REQUISIÇÃO: GET
    
    ENDPOINT 1 (data + empreendimento): http://localhost:8080/atividade_agendada/agendamentos_no_dia?dataInicio=12/04/2021&idEmpreendimento=1
    ENDPOINT 2 (apenas data): http://localhost:8080/atividade_agendada/agendamentos_no_dia?dataInicio=12/04/2021
    
    PARÂMETROS:
    1. dataInicio -> data do agendamento no formato dd/mm/aaaa
    3. idEmpreendimento -> ID do empreendimento que deseja consultar as atividades agendadas

    RESPOSTA:
    [
        {
            "idAtividadeAgendada": 1,
            "dataInicio": "2021-04-12T03:00:00.000+00:00",
            "dataTermino": null,
            "assunto": "Rachadura nas paredes",
            "tipoAtividade": {
                "idTipoAtividade": 2,
                "nome": "Manutenção"
            },
            "ocorrencia": {
                "idOcorrencia": 1,
                "descricao": "Hoje pela manhã ocorreu uma rachadura no teto, e gostaria de agendar uma vistoria, pois faz apenas 1 ano que me mudei para o apartamento, e acredito que esteja dentro da garantia",
                "unidade": {
                    "idUnidade": 1,
                    "numero": "APTO 1",
                    "bloco": {
                        "idBloco": 1,
                        "nome": "BLOCO A1",
                        "empreendimento": {
                            "idEmpreendimento": 1,
                            "nome": "Vivaz Estação Guaianases",
                            "logradouro": "Rua Salvador Gianetti",
                            "numero": "201",
                            "bairro": "Guaianases",
                            "cidade": "São Paulo",
                            "uf": "SP",
                            "cep": "08410-000",
                            "bandeira": {
                                "idBandeira": 3,
                                "nome": "Vivaz"
                            }
                        }
                    },
                    "clienteDaUnidade": {
                        "idClienteDaUnidade": 1,
                        "cpf": "545.753.740-40",
                        "nome": "Karina Rocha dos Santos"
                    }
                }
            }
        },
        ...
    ]
```

> Evidência de funcionamento
![Evidência de funcionamento do calendário de agendamentos](https://semparar.vteximg.com.br/arquivos/ev_fn_ag.png?v=1)

## Para testar as APIs
##### 1. Clone do Projeto
1. Realize o clone deste projeto;
2. Abra este projeto com a IDE IntelliJ e realize o download de todas as dependências;
3. Execute o `"Run"` no método `main(String[] args)` na Classe `src/main/java/br.com/gotech/cyrela/CyrelaApplication`, conforme à imagem abaixo.
![Startando a aplicação](https://semparar.vteximg.com.br/arquivos/rn_pj_cy.png?v=1)

##### 2. Importe a Collection das APIs
1. Tenha o Postman instalado em seu computador;
2. Baixe separadamente o arquivo da versão que mais se adequa ao seu Postman `(v1 ou v2)`;

[Collection v1](https://github.com/samueltj/cyrela/blob/main/src/main/resources/misc/cyrela_collection_v1.json) | [Collection v2](https://github.com/samueltj/cyrela/blob/main/src/main/resources/misc/cyrela_collection_v2.json)

3. Após importar a versão adequada, será possível acessar as APIs dentro do Postman
![Collection das APIs](https://semparar.vteximg.com.br/arquivos/en_cy_ps.png?v=3)

##### 3. Crie seus próprios registros, ou insira em cada API os dados da base que criamos para testar
1. Baixe separadamente o arquivo `cyrela_data_base.json` que possui os `"body's"` de cada requisição;
[cyrela_data_base.json](https://github.com/samueltj/cyrela/blob/main/src/main/resources/misc/cyrela_data_base.json)
2. Insira no body de cada API o trecho correspondente, e realize os cadastros através do tipo de requisição `POST`.
