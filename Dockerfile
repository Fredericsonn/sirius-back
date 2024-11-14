FROM jenkins/inbound-agent

USER root

# Update package lists and install Mjenkins/inbound-agentaven
RUN apt-get update --allow-releaseinfo-change && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Instll lsof
RUN apt-get update && apt-get install -y lsof

ENV MAVEN_HOME=/usr/share/maven
ENV PATH="${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}"

USER jenkins