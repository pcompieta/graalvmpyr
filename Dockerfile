# GraalVM with R and Python
FROM oracle/graalvm-ce:20.0.0

RUN gu install R
RUN yum -y install libgfortran5
RUN /opt/graalvm-ce-java8-20.0.0/jre/languages/R/bin/configure_fastr

RUN gu install python

VOLUME [ "code" ]