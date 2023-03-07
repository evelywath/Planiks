# Planiks
## Endpoints 
- [Dashboard](#dashboard)
- [Calendario](#calendario)
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
        "progresso": 0
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
|id|sim|int| Numero de identificação do evento, serve como atributo unico do evento. Oculto para o usuario.
|titulo |sim            |String| Titulo do evento, pode conter qualquer caractere.
|tag|sim |int| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas.
|categoria|sim          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usuario.
|comentario|não         |texto| Uma descrição do evento com no maximo de 250 caracteres.
|progresso|sim|int| Um numero que representa completude do evento.
|estado|sim|boolean| O estado do evento que sera atualizado de acordo com o prazo proposto pelo usuario. Oculto para o usuario.

**Campos da Requisição Prazo**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|diaComeco |não|date| O dia inicial de um evento, caso não seja configurado quando o evento começará, será configurado no dia de criação do evento.
|diaFim    |não|date| O dia final de um evento, caso não seja configurado quando o evento se finalizará, será atualizado no dia de quando o estado se der como false. Caso horasFim não seja configurado o estado do evento mudara para false ao mudar para o dia final.
|horasComeco  |não|datetime| O horario em que um evento se inicializará.
|horasFim  |não|datetime| O horario de finalização do evento, ao chegar no horario configurado o estado do evento se atualizara para false.
|fuso   |não|String| Fuso horario, se atualizará automaticamente de acordo com o local do usuario.

**Códigos da Resposta**

|código|descrição
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
|id|sim|int| Numero de identificação do evento, serve como atributo unico do evento. Oculto para o usuario.
|titulo |sim            |String| Titulo do evento, pode conter qualquer caractere.
|tag|sim |int| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas.
|categoria|sim          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usuario.
|comentario|não         |texto| Uma descrição do evento com no maximo de 250 caracteres.
|progresso|sim|int| Um numero que representa completude do evento.
|estado|sim|boolean| O estado do evento que sera atualizado de acordo com o prazo proposto pelo usuario. Oculto para o usuario.

**Campos da Requisição Prazo**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|diaComeco |não|date| O dia inicial de um evento, caso não seja configurado quando o evento começará, será configurado no dia de criação do evento.
|diaFim    |não|date| O dia final de um evento, caso não seja configurado quando o evento se finalizará, será atualizado no dia de quando o estado se der como false. Caso horasFim não seja configurado o estado do evento mudara para false ao mudar para o dia final.
|horasComeco  |não|datetime| O horario em que um evento se inicializará.
|horasFim  |não|datetime| O horario de finalização do evento, ao chegar no horario configurado o estado do evento se atualizara para false.
|fuso   |não|String| Fuso horario, se atualizará automaticamente de acordo com o local do usuario.


**Códigos da Resposta**

|código|descrição
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
|id|sim|int| Numero de identificação do evento, serve como atributo unico do evento. Oculto para o usuario.
|titulo |sim            |String| Titulo do evento, pode conter qualquer caractere.
|tag|sim |int| Cor relacionada ao evento, tendo apenas uma seleção de cores pré definidas.
|categoria|sim          |String| Uma categoria atrelada ao evento definido por uma seleção feita pelo usuario.
|comentario|não         |texto| Uma descrição do evento com no maximo de 250 caracteres.
|progresso|sim|int| Um numero que representa completude do evento.
|estado|sim|boolean| O estado do evento que sera atualizado de acordo com o prazo proposto pelo usuario. Oculto para o usuario.

**Campos da Requisição Prazo**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|diaComeco |não|date| O dia inicial de um evento, caso não seja configurado quando o evento começará, será configurado no dia de criação do evento.
|diaFim    |não|date| O dia final de um evento, caso não seja configurado quando o evento se finalizará, será atualizado no dia de quando o estado se der como false. Caso horasFim não seja configurado o estado do evento mudara para false ao mudar para o dia final.
|horasComeco  |não|datetime| O horario em que um evento se inicializará.
|horasFim  |não|datetime| O horario de finalização do evento, ao chegar no horario configurado o estado do evento se atualizara para false.
|fuso   |não|String| Fuso horario, se atualizará automaticamente de acordo com o local do usuario.

**Códigos da Resposta**

|código|descrição
|-|-
200 | Os dados do evento foram atualizados.
404 | Evento não encontrado.
400 | Os novos dados são invalidos.

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

|código|descrição
|-|-
200 | O evento foi deletado com sucesso.
404 | Evento inexistente.

---

<!-- Dashboard -->
### Dashboard

`GET` planiks/api/v1/dasboard/{id}

**Exemplo de Resposta** 
```js
{
    "dashboard": {
        "todo": [evento, evento, evento],
        "projetos": [evento, evento],
        "eventos": [evento, evento]
    }
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|todo    |sim|array| Uma lista dos eventos mais proximos do dia ou hora de termino.
|projetos|sim|array| Uma lista dos eventos mais dintatnes do dia ou hora de termino. A lista pode ser configurada pelo usuario de acordo com a categoria escolhida.
|eventos |sim|array| Uma lista de eventos dentro do periodo de um mês apresentada em um calendario.

**Códigos da Resposta**

|código|descrição
|-|-
200 | O dashboard foi carregado com sucesso.
400 | Ocorreu um erro ao carregar o Dashboard.

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
        "ano": 2033
    }
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|dia|sim|int| O dia do calendario, pode conter um evento.
|mes|sim|int| O mês do calendario.
|ano|sim|int| O ano do calendario.
 
**Códigos da Resposta**

|código|descrição
|-|-
200 | O calendario foi carregado com sucesso.
400 | Ocorreu um erro ao carregar o Calendario.
