# GraalVM with R and Python
FROM oracle/graalvm-ce:20.0.0
VOLUME [ "code" ]

# R 3.6
RUN gu install R
# if necessary, explicitly set: R_HOME=/opt/graalvm-ce-java8-20.0.0/jre/languages/R
RUN yum -y install libgfortran5
RUN /opt/graalvm-ce-java8-20.0.0/jre/languages/R/bin/configure_fastr

# Python 3.7
RUN gu install python