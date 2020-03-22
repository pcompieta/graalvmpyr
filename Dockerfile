# GraalVM with R and Python
FROM oracle/graalvm-ce:20.0.0

RUN gu install R
RUN gu install python

ENTRYPOINT [ "bash" ]