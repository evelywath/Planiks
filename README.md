# Planiks
## Endpoints 
- [Dashboard](#dashboard)
- [Calendario](#calendario)
- [Criar evento](#criação-de-evento)
- [Listar evento](#mostrar-evento)
- [Alterar evento](#atualizar-evento)
- [Apagar evento](#deletar-evento)

---

<!-- POST - CRIAR -->
### Criação de evento

`POST` planiks/api/v1/evento

**Exemplo de Entrada** 
```js
{
    "eventoId": 1,
    "titulo": "Prova",
    "tag": 1,
    "prazo": 07/03/2023,
    "categoria": "Estudos",
    "comentario": "vale nota",
    "progresso": 0
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| Numero de identificação do evento, serve como atributo unico do evento
|titulo |sim            |String| Titulo do evento, pode conter qualquer caractere
|tag    |sim            |int| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas
|prazo  |sim            |data| Um dia da semana em que o evento ira se finalizar ao enviar uma notificação
|categoria|sim          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usuario.
|comentario|não         |texto| Uma descrição do evento com no maximo de 250 caracteres.

**Códigos da Resposta**

|código|descrição
|-|-
201 | O evento foi criado com sucesso
400 | os dados enviados são inválidos

---

<!-- GET - LISTAR/MOSTRAR -->
### Mostrar Evento

`GET` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{
    "evento": {
        "titulo": "Prova",
        "tag": 1,
        "prazo": 07/03/2023,
        "categoria": "Estudos",
        "comentario": "vale nota",
        "progresso": 0
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | As informações do evento foram retornadas
404 | Evento inexistente

---

<!-- PUT - ATUALIZAR -->
### Atualizar Evento

`PUT` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{
    "evento": {
        "newTitulo": "Prova",
        "newTag": 1,
        "newoPrazo": 07/03/2023,
        "newCategoria": "Estudos",
        "newComentario": "vale nota",
        "newProgresso": 0
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | Os dados do evento foram atualizados
400 | Os novos dados são invalidos

---

<!-- DELETE - DELETAR -->
### Deletar Evento

`DELETE` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{

}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | O evento foi deletado com sucesso
400 | Evento inexistente

---

<!-- Dashboard -->
### Dashboard

`GET` planiks/api/v1/dasboard/{id}

**Exemplo de Resposta** 
```js
{
    "dashboard": {
        "todo": "",
        "projetos": "",
        "compromissos": ""
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | O dashboard foi carregado com sucesso
400 | Ocorreu um erro ao carregar o Dashboard

---

<!-- Calendario -->
### Calendario

`GET` planiks/api/v1/calendario/{id}

**Exemplo de Resposta** 
```js
{
    "calendario": {
        "dia": 07,
        "mes": 03,
        "ano": 2032,
        "hora": 13:00
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | O calendario foi carregado com sucesso
400 | Ocorreu um erro ao carregar o Calendario
