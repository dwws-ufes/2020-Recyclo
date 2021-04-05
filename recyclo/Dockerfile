FROM jboss/wildfly:22.0.1.Final

RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main

COPY ./mysql-connector-java-8.0.17.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/

COPY ./standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

COPY ./module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/

RUN /opt/jboss/wildfly/bin/add-user.sh -u 'admin' -p 'password'


CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]