FROM gcr.io/dataflow-templates-base/java11-template-launcher-base

ARG WORKDIR=/dataflow/template
RUN mkdir metadata && \ 
    mkdir plugins && \
    mkdir v1 && \
    mkdir -p ${WORKDIR} && \
    mkdir -p ${WORKDIR}/v1/src/main/java/com/google/cloud/teleport/templates

WORKDIR ${WORKDIR}

COPY v1 .
COPY plugins .
COPY metadata .
COPY v1/src/main/java/com/google/cloud/teleport/templates/DLPReidentifyBigQueryToBigQueryBatch.java /dataflow/template/v1/src/main/java/com/google/cloud/teleport/templates/

ENV FLEX_TEMPLATE_JAVA_MAIN_CLASS="com.google.cloud.teleport.templates.custom.DLPReidentifyBigQueryToBigQueryBatch"
ENV FLEX_TEMPLATE_JAVA_CLASSPATH="${WORKDIR}/v1/src/main/java/com/google/cloud/teleport/templates/DLPReidentifyBigQueryToBigQueryBatch.java"

ENTRYPOINT ["/opt/google/dataflow/java_template_launcher"]