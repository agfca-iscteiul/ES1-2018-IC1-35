# ES1-2018-IC1-35

A aplicação BDA permite o acesso à informação académica disponibilizada através de vários canais, nomeadamente, Email (v.g. emails enviados pelo diretor de departamento/curso/ano, emails enviados pela plataforma de eLearning, etc.), Facebook (v.g. posts da conta Facebook do ISCTE/departamento/curso) e Twitter (v.g. tweets da conta Twitter do ISCTE/departamento/curso).
A aplicação permite que o utilizador não só aceda/consulte, mas também enviar informação através desses canais (v.g. resposta a emails, posts Facebook, retweets).
Os dados das configurações associadas aos serviços referidos (identificação de contas/utilizadores, informação de autenticação/tokens de acesso, etc.) são armazenados num ficheiro XML (com nome config.xml) e podem ser consultados e editados (criados, alterados, removidos) através da interface gráfica da aplicação BDA. É ainda possível ativar/desativar serviços, bem como a criação de filtros para os conteúdos fornecidos pelos serviços, tendo em consideração as características de cada serviço e de cada API (Application Programming Interface) de acesso ao serviço. Entre os critérios para filtragem da informação que devem ser contemplados estão a origem da mensagem (v.g. conta/utilizador), palavras chave no conteúdo (v.g. exame), período a que deve respeitar a informação recolhida nesses serviços (v.g. últimas 24h), entre outros critérios que o grupo de trabalho entenda relevantes para a melhoria das funcionalidades da aplicação. Os critérios a usar nos filtros associados aos diferentes serviços são guardados num documento XML de configuração dos serviços (config.xml).
A informação obtida a partir dos vários serviços (fontes de informação académica) é toda apresentada na interface gráfica da aplicação, seguindo uma estrutura do tipo timeline (informação organizada cronologicamente), onde é facilmente identificado os dados principais da mensagem (v.g. fonte, data/hora, título) e caso o utilizador pretenda, é possível expandir e visualizar todos os detalhes da mensagem.
A aplicação permite o modo de funcionamento offline, ou seja, o utilizador pode continuar a consultar os últimos conteúdos que a aplicação conseguiu obter dos vários serviços, mesmo que a aplicação perca a ligação de rede e o utilizador tenha fechado e voltado a abrir a aplicação.

Projeto Realizado Por:
- André Correia 73743
- Filipe Gonçalves 78740
- Kirill Lapshev 78003
- Tiago Sousa 77997
