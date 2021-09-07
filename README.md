# flink-doris-demo
flink-doris-demo

```
mvn install:install-file "-DgroupId=org.apache" "-DartifactId=doris-flink" "-Dversion=1.0-SNAPSHOT" "-Dpackaging=jar" "-Dfile=doris-flink-1.0-SNAPSHOT.jar"

~/git/flink-1.11.2/bin/flink run -c org.apache.doris.demo.flink.kafka.FlinkKafka2Doris target/flink-doris-demo-1.0-SNAPSHOT.jar

Reason: JSON data is not an array-object, `strip_outer_array` must be FALSE.. src line: [{"package_time":"2021-08-16 14:01:00","receive_time":"2021-08-16 14:01:00","equipment_number":"10","ip":"test","data":"test"}]; 
```