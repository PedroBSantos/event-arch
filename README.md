# Event Architecture

![Diagrama](https://github.com/PedroBSantos/event-arch/blob/master/images/diagram.png)

Os eventos possuem uma caracteristica fundamental: acontecem no passado. Por exemplo, usuário criado. Geralmente quando um evento ocorre queremos realizar algumas ações que são desencadeadas pelo evento. Por exemplo, quando um usuário é criado queremos:

- Enviar um email de boas vindas
- Colocar uma mensagem na fila que o usuário foi criado
- Enviar outro email para o dono do site para informar que o usuário foi criado
- Adicionar o usuário no banco de dados
- Adicionar nos Logs

## Event Dispatcher

Componente responsável por registrar eventos e os seus respectivos listeners. Deve-se informar o nome do evento e qual o listenner responsável por tratar o evento. Exemplo:

- Event: UserCreatedEvent
- Listener: UserCreatedListener

No caso acima o registro do evento será: Register("UserCreatedEvent", "UserCreatedListenner"). Já o disparo do evento pode ser feito através da função dispatch que recebe como argumento o evento.

## Listener

Componente responsável por executar uma ação, função (handle), quando um evento é disparado. Além disso, o listener deve possuir dados sobre o evento que ocorreu.

## Event

Geralmente possui um nome ou tipo, como por exemplo, UserCreated. Também dados associado ao que gerou o evento. No caso de um usuário criado, os dados do usuário podem ser passados para o evento. Além disso, pode possuir o instante em que o evento ocorreu.
