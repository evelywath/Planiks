# Planiks
#### Sua aplicação de gestão de tarefas e planejamento.


### ENDPOINTS
 
- Dashboard
- Meu Calendário
- Criar (evento, tag, to-do, categoria, comentário, progresso)
-  Editar (evento, tag, to-do, categoria, comentário, progresso)
 - Deletar (?)

<!--- [](#) - [](#)

---

### Cadastro de Despesa

<!-- Endereço do recurso -->
`GEt` planiks/api/v1/dashboard

<!-- Colocar a versão é importante para compatibilidade  --> 
**Insira aqui a response
```js
{
    "": ,
    "": ,
    "": ,
    "": ,
    "": ''
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|  |||
||||
||||
||||
||||

**Códigos da Resposta**
|Código|Descrição
|-|-
 |
 |

---

<!--### Detalhar Despesa

`GET` nubeck/api/v1/despesa/{id}

**Exemplo de Resposta** 
```js
{
    "valor": 100,
    "categoria": {
        "id": 1,
        "nome": "lazer"
    },
    "conta": {
        "id": 1,
        "nome": "itaú",
    }
    "data": '2023-01-01',
    "descricao": 'cinema'
}
```

**Códigos da Resposta**
|Código|Descrição
|-|-
200 | Os dados da despesa foram retornados
404 | Não existe despesa com o ID informado--!>