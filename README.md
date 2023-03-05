# Planiks
## Endpoints 
- [Dashboard](#dashboard)
- [Calendário](#calendario)
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
    "tag": "#0000CD",
    "prazo": 07/03/2023,
    "categoria": "Estudos",
    "comentario": "vale nota",
    "progresso": 0
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| Número de identificação do evento, serve como atributo único do evento
|Título |sim            |String| Título do evento, pode conter qualquer caractére
|Tag    |não            |int| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas
|Prazo  |não            |data| Um dia da semana em que o evento ira se finalizar ao enviar uma notificação
|Categoria|não          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usúario.
|Comentário|não         |texto| Uma descrição do evento com no máximo de 250 caractéres.
|Progresso|não         |float| Uma barra que registrará o progresso desejado em porcentagem até a conclusão.

**Códigos da Resposta**

|Código|Descrição
|-|-
201 | O evento foi criado com sucesso
400 | Os dados enviados são inválidos

---

<!-- GET - LISTAR/MOSTRAR -->
### Mostrar Evento

`GET` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{
    "evento": {
        "titulo": "Prova",
        "tag": "#0000CD",
        "prazo": 07/03/2023,
        "categoria": "Estudos",
        "comentario": "vale nota",
        "progresso": 0
    }
}
```

**Códigos da Resposta**

|Código|Descrição
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
        "newTag": "#DC143C",
        "newoPrazo": 07/03/2023,
        "newCategoria": "Estudos",
        "newComentario": "vale nota",
        "newProgresso": 0
    }
}
```

**Códigos da Resposta**

|Código|Descrição
|-|-
200 | Os dados do evento foram atualizados
400 | Os novos dados são inválidos


### Deletar Evento

`DELETE` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{

}
```

**Códigos da Resposta**

|Código|Descrição
|-|-
200 | O evento foi deletado com sucesso
400 | Evento inexistente


<!-- Dashboard -->
### Dashboard

`GET` planiks/api/v1/dasboard/{id}

**Exemplo de Resposta** 
```js
{
    "dashboard": {
        "to-do": "",
        "projetos": "",
        "compromissos": ""
    }
}
```

**Códigos da Resposta**

|Código|Descrição
|-|-
200 | O dashboard foi carregado com sucesso
400 | Ocorreu um erro ao carregar o Dashboard


<!-- Calendario -->
### Calendário

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

|Código|Descrição
|-|-
200 | O calendário foi carregado com sucesso
400 | Ocorreu um erro ao carregar o cálendario
