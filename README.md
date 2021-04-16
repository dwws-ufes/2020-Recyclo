# 2020-Recyclo

Assignment for the 2020 edition of the "Web Development and the Semantic Web" course.

Para executar este aplicativo localmente você precisar ter o Docker instalado em sua máquina, caso não tenha o Docker instalado, você poderá instalar com esse comando (no linux):

sudo apt install docker.io


Depois, para o docker iniciar sempre com a máquina, esse comando:

sudo systemctl enable --now docker


Para testar se deu tudo certo:

sudo docker run hello-world


Estando tudo ok, já é possível usar o docker na máquina. 
Para fazer o deploy da aplicação, é preciso fazer o pull do repositório, ir para o branch docker-v2, e acessar a pasta recyclo, que é onde estão os arquivos de configuração do docker e os demais arquivos do projeto. Dentro dessa pasta, para subir a aplicação, precisa executar:

sudo docker-compose up


Dando tudo certo, será possível acessar a página de hello em localhost:8080/recyclo/

Importante lembrar que, caso tenha o Wildfly ou o MySQL rodando na maquina, é preciso parar sua execução antes, pois eles ficam ocupando as portas 8080 e 3306 e  o docker não consegue subir.
