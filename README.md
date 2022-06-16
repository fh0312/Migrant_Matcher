# Migrant_Matcher

Projeto #2 da Cadeira de Desenvolvimento Centrado em Objetos da 
Faculdade de Ciencias da Universiadade de Lisboa

Autores:

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



