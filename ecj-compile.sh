#!/usr/bin/env bash

export MVN_REPO=../../../.m2/repository
export CP="$MVN_REPO/jakarta/persistence/jakarta.persistence-api/3.1.0/jakarta.persistence-api-3.1.0.jar;$MVN_REPO/com/querydsl/querydsl-apt/5.0.0/querydsl-apt-5.0.0-jakarta.jar;$MVN_REPO/com/querydsl/querydsl-codegen/5.0.0/querydsl-codegen-5.0.0.jar;$MVN_REPO/com/querydsl/codegen-utils/5.0.0/codegen-utils-5.0.0.jar;$MVN_REPO/org/eclipse/jdt/ecj/3.26.0/ecj-3.26.0.jar;$MVN_REPO/javax/inject/javax.inject/1/javax.inject-1.jar;$MVN_REPO/io/github/classgraph/classgraph/4.8.108/classgraph-4.8.108.jar;$MVN_REPO/com/querydsl/querydsl-jpa/5.0.0/querydsl-jpa-5.0.0-jakarta.jar;$MVN_REPO/com/querydsl/querydsl-core/5.0.0/querydsl-core-5.0.0.jar;$MVN_REPO/com/mysema/commons/mysema-commons-lang/0.2.4/mysema-commons-lang-0.2.4.jar;$MVN_REPO/org/aspectj/aspectjrt/1.9.9.1/aspectjrt-1.9.9.1.jar"

export SRC=baz/src/main/java

# Workaround: add '-proc:none' option to ECJ build
java -jar $MVN_REPO/org/eclipse/jdt/ecj/3.31.0/ecj-3.31.0.jar -nowarn -17 -cp "$CP" -d baz/target/classes $SRC/com/foobar/showme/baz/AbstractDurable.java $SRC/com/foobar/showme/baz/Durable.java $SRC/com/foobar/showme/baz/JPADurable.java $SRC/com/foobar/showme/baz/TimestampedJPADurable.java
