# flink-doris-demo
flink-doris-demo

```
mvn install:install-file "-DgroupId=org.apache" "-DartifactId=doris-flink" "-Dversion=1.0-SNAPSHOT" "-Dpackaging=jar" "-Dfile=doris-flink-1.0-SNAPSHOT.jar"

~/git/flink-1.11.2/bin/flink run -c org.apache.doris.demo.flink.kafka.FlinkKafka2Doris target/flink-doris-demo-1.0-SNAPSHOT.jar

Reason: JSON data is not an array-object, `strip_outer_array` must be FALSE.. src line: [{"package_time":"2021-08-16 14:01:00","receive_time":"2021-08-16 14:01:00","equipment_number":"10","ip":"test","data":"test"}];

http://192.168.0.152:8040/api/_load_error_log?file=__shard_2/error_log_insert_stmt_db42e6d8d081cf5c-8ce12b2ab9e00984_db42e6d8d081cf5c_8ce12b2ab9e00984
http://192.168.0.198:8040/api/_load_error_log?file=__shard_0/error_log_insert_stmt_d74fc0f6265530c3-dd7470719474c5a8_d74fc0f6265530c3_dd7470719474c5a8 
```