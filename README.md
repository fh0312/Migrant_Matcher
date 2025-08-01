# 🇵🇹 Versão em Português

> 📘 A versão original em inglês deste README está disponível em [README.md](./README.md)

---

# Migrant_Matcher

## Projeto em java da UC de Desenvolvimento Centrado em Objetos da 
### Faculdade de Ciencias da Universiadade de Lisboa.

## Descrição do projeto

### MigrantMatcher
- A aplicação MigrantMatcher está a ser desenvolvida com o objectivo de facilitar a ajuda de migrantes em massa. Em situações de guerra, vulcões ou outras calamidades, esta aplicação irá ajudar a que os migrantes consigam receber ajuda (quer em items, quer em alojamento) de forma mais eficaz.


# Autores:

Francisco Henriques - FC56348
Manuel Cardoso - FC56274

#----------------#------------------#-------------------------#--------------------#

Migrant Matcher:

Para iniciar o MigrantMatcher correr a classe Main.java e responder às perguntas feitas pelo sistema.

Para utilização do Script da classe de Testes : casoDeUsoProcurarAjuda() 

	1º - O ficheiro input.txt já tem um script com 3 registos de ajuda e 3 procuras de ajuda.
	2º - Ao correr o script, o sistema fará o scan do ficheiro "input.txt" por isso:
		- Cada linha desse ficheiro "input.txt" tem o seguinte formato:
			
			//CASO DE USO : REGISTAR AJUDA
				-voluntario
				-999999999 //telemovel para scripts
				-(tipo de ajuda)
				-(numero de pessoas que alberga || descricao do item)
				-(regiao)
				-sim //sim desejo confirmar a doacao
				-123456 //codigo para scripts
				-nao //nao desejo mais operacoes

			//CASO DE USO : PROCURAR AJUDA
				-migrante
				-(inserir nº de telemovel)
				-(inserir nome)
				-(inserir regiao para onde se vai mudar)
				-(inserir tipo de ordenacao das ajudas - tipo ou data)
				-0 // primeira ajuda da lista caso já tenha sido adionada alguma.
				-nao	//nao desejo adicionar mais ajudas
				-sim  //sim desejo confirmar a reserva
				-nao	//nao desejo mais operacoes	
        
        3º - O resultado do Script estará no ficheiro "output.txt"
	
	

## Casos de uso:

### Caso de Uso 1: Registar ajuda
Este caso de uso permite a voluntários disponibilizar um tipo de ajuda na plataforma.

Descrição do Caso de Uso:

O voluntário identifica-se com o seu contacto telefónico.
O sistema pede ao voluntário para indicar o tipo de ajuda que pretende oferecer.
No caso de o voluntário pretender oferecer um alojamento,
O voluntário indicando o número de pessoas que esse alojamento alberga.
O sistema devolve a lista de regiões no país.
O voluntário indica a região onde se encontra o alojamento.
No caso de o voluntário pretender oferecer um item (por exemplo, colchões, roupas, brinquedos),
O voluntário indica a descrição do item.
Em qualquer dos casos, o sistema envia uma notificação por SMS para o voluntário com um código único.
O utilizador indica ao sistema o código único para confirmar a oferta de ajuda.


### Caso de Uso 2: Procurar Ajuda
Este caso de uso permite a migrantes procurar e aceitar ajudas oferecidas.

Descrição do Caso de Uso:

Alternativamente,
O migrante indica que pretende registar-se individualmente, indicando o seu nome e número de telefone. 
Ou indica que pretende registar a sua família, indicando o número de pessoas.
Nesse caso, o sistema pergunta o nome e contacto do cabeça de casal.
O migrante indica o nome e contacto correspondente.
O sistema pergunta os dados de outro membro da família.
O migrante indica o nome do outro membro.
Os dois últimos passos podem ser repetidos enquanto o migrante entender.
De seguida, o migrante pede a lista de regiões para onde se poderá mover.
O sistema devolve a lista de regiões no país.
O migrante indica a região para onde se vai mover.
O sistema devolve uma lista de ajudas possíveis (tanto alojamentos nessa região, como items).
O migrante escolhe a ajuda de que pretende usufruir de entre dessas listadas.
O sistema regista esta informação.
Os dois passos anteriores podem ser repetidos tantas vezes quantas o migrante necessitar.
Finalmente, o migrante indica que pretende confirmar.
O sistema regista a atribuição de ajudas a esse migrante, e envia uma SMS aos voluntários que ofereceram as respectivas ajudas.

### Extensão 5a:

5. O Sistema indica que não existe nenhuma ajuda nessa região.
6. O migrante indica que pretende ser notificado quando existir nessa região.



