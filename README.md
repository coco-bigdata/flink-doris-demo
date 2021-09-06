# flink-doris-demo
flink-doris-demo

```
mvn install:install-file "-DgroupId=org.apache" "-DartifactId=doris-flink" "-Dversion=1.0-SNAPSHOT" "-Dpackaging=jar" "-Dfile=doris-flink-1.0-SNAPSHOT.jar"

~/git/flink-1.11.2/bin/flink run -c org.apache.doris.demo.flink.kafka.FlinkKafka2Doris target/flink-doris-demo-1.0-SNAPSHOT.jar
```