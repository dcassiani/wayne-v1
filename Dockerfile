FROM ascdc/jdk8

ENV APPLICATION_NAME wayne-api
ENV LOCALE "pt_BR.UTF-8"
ENV LOCALTIME "America/Sao_Paulo"

ADD target/*.jar /app/app.jar
WORKDIR app

CMD java $JAVA_OPTS -jar /app/app.jar $ARGS
