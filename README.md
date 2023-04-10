# Planiks
## Endpoints 
- [Dashboard](#dashboard)
- [Calendário](#calendário)
- [Criar evento](#criação-de-evento)
- [Detalhar evento](#detalhar-evento)
- [Alterar evento](#atualizar-evento)
- [Apagar evento](#deletar-evento)

---

<!-- POST - CRIAR -->
### Criação de evento

`POST` planiks/api/v1/evento

**Exemplo de Entrada** 
```js
{
    "evento": {
        "eventoId": 1,
        "titulo": "Prova",
        "tag": 1,
        "categoria": "Estudos",
        "comentario": "vale nota",
        "progresso": 0,
        "estado": "true"
    },
    "prazo": {
        "diaComeco": 04/03/2023,
        "diaFim": 07/03/2023,
        "horasComeco": 13:00,
        "horasFim": 23:59,
        "fuso": "GMT-0"
    }

}
```

**Campos da Requisição Evento**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|eventoId|sim|Long| Número de identificação do evento, serve como atributo único do evento. Oculto para o usuário.
|titulo |sim            |String| Título do evento, pode conter qualquer caractere.
|tag|não |String| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas.
|categoria|não          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usuário.
|comentario|não         |String| Uma descrição do evento com no máximo de 250 caractéres.
|progresso|não|Long| Um número que representa completude do evento.
|estado|sim|boolean| O estado do evento que sera atualizado de acordo com o prazo proposto pelo usuário. Oculto para o usuário.

**Campos da Requisição Prazo**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|diaHora|não|LocalDateTime| Dia e hora do dia selecionado.
|fuso   |não|String| Fuso horário, se atualizará automaticamente de acordo com o local do usuário.

**Códigos da Resposta**

|Código|Descrição
|-|-
201 | O evento foi criado com sucesso.
400 | Os dados enviados são inválidos.

---

<!-- GET - LISTAR/MOSTRAR -->
### Detalhar Evento

`GET` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{
    "evento": {
        "eventoId": 1,
        "titulo": "Prova",
        "tag": 1,
        "categoria": "Estudos",
        "comentario": "vale nota",
        "progresso": 0,
        "estado": true
    },
    "prazo": {
        "diaComeco": 04/03/2023,
        "diaFim": 07/03/2023,
        "horasComeco": 13:00,
        "horasFim": 23:59,
        "fuso": "GMT-0"
    }

}
```

**Campos da Requisição Evento**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|eventoId|sim|Long| Número de identificação do evento, serve como atributo único do evento. Oculto para o usúario.
|titulo |sim            |String| Título do evento, pode conter qualquer caractére.
|tag|não |String| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas.
|categoria|não          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usuário.
|comentario|não         |String| Uma descrição do evento com no máximo de 250 caractéres.
|progresso|não|Long| Um número que representa completude do evento.
|estado|sim|boolean| O estado do evento que sera atualizado de acordo com o prazo proposto pelo usuário. Oculto para o usuário.

**Campos da Requisição Prazo**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|diaHora|não|LocalDateTime| Dia e hora do dia selecionado.
|fuso   |não|String| Fuso horário, se atualizará automaticamente de acordo com o local do usuário.

**Códigos da Resposta**

|Código|Descrição
|-|-
200 | As informações do evento foram retornadas.
404 | Evento inexistente.

---

<!-- PUT - ATUALIZAR -->
### Atualizar Evento

`PUT` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{
    "evento": {
        "eventoId": 1,
        "titulo": "Prova2",
        "tag": 1,
        "categoria": "Estudos",
        "comentario": "vale nota demais",
        "progresso": 0,
        "estado": true
    },
    "prazo": {
        "diaComeco": 10/03/2023,
        "diaFim": 22/03/2023,
        "horasComeco": 13:00,
        "horasFim": 23:59,
        "fuso": "GMT-0"
    }

}
```

**Campos da Requisição Evento**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|eventoId|sim|Long| Número de identificação do evento, serve como atributo único do evento. Oculto para o usuário.
|titulo |sim            |String| Título do evento, pode conter qualquer caractére.
|tag|não |String| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas.
|categoria|não          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usuário.
|comentario|não         |String| Uma descrição do evento com no máximo de 250 caractéres.
|progresso|não|Long| Um número que representa completude do evento.
|estado|sim|boolean| O estado do evento que sera atualizado de acordo com o prazo proposto pelo usuário. Oculto para o usuário.

**Campos da Requisição Prazo**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|diaHora|não|LocalDateTime| Dia e hora do dia selecionado.
|fuso   |não|String| Fuso horário, se atualizará automaticamente de acordo com o local do usuário.

**Códigos da Resposta**

|Código|Descrição
|-|-
200 | Os dados do evento foram atualizados.
404 | Evento não encontrado.
400 | Os novos dados são inválidos.

---

<!-- DELETE - DELETAR -->
### Deletar Evento

`DELETE` planiks/api/v1/evento/{id}

**Exemplo de Resposta** 
```js
{
    "notificacao": {
        "mensagem": "o evento foi excluido com sucesso"
    }
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|mensagem|sim|String| Uma mensagem confirmando que a ação foi realizada.

**Códigos da Resposta**

|Código|Descrição
|-|-
200 | O evento foi deletado com sucesso.
404 | Evento inexistente.

---

<!-- Calendário -->
### Calendário

`GET` planiks/api/v1/calendario/{id}

**Exemplo de Resposta** 
```js
{
    "calendario": {
        Calendar(Calendar.getInstance());
    }
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|calendario|sim|Calendar| Um calendario com ano, mês e dia
 
**Códigos da Resposta**

|Código|Descrição
|-|-
200 | O calendário foi carregado com sucesso.
400 | Ocorreu um erro ao carregar o calendário.
