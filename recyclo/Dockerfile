FROM jboss/wildfly:22.0.1.Final

USER root

# Configurações de root

RUN yum install -y maven
RUN mkdir -p /opt/recyclo/
RUN chown jboss /opt/recyclo

USER jboss

# Instalando dependências do wildfly pro mysql
RUN mkdir -p /opt/jboss/wildfly/modules/com/mysql/main/
COPY ./mysql-connector-java-8.0.23.jar /opt/jboss/wildfly/modules/com/mysql/main/
COPY ./module.xml /opt/jboss/wildfly/modules/com/mysql/main/

# Configurando o servidor
COPY ./standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

# Copiando projeto
WORKDIR /opt/recyclo
COPY ./pom.xml /opt/recyclo/pom.xml
RUN mvn dependency:go-offline dependency:resolve-plugins clean package
COPY ./src /opt/recyclo/src
RUN mvn clean package

# Criando o usuário no wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh -u 'admin' -p 'password'

# Compilando o projeto
RUN mvn package

# Add your application to the deployment folder
RUN mv /opt/recyclo/target/recyclo.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
