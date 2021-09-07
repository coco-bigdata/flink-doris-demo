# flink-doris-demo
flink-doris-demo

```
mvn install:install-file "-DgroupId=org.apache" "-DartifactId=doris-flink" "-Dversion=1.0-SNAPSHOT" "-Dpackaging=jar" "-Dfile=doris-flink-1.0-SNAPSHOT.jar"

~/git/flink-1.11.2/bin/flink run -c org.apache.doris.demo.flink.kafka.FlinkKafka2Doris target/flink-doris-demo-1.0-SNAPSHOT.jar

Reason: JSON data is not an array-object, `strip_outer_array` must be FALSE.. src line: [{"package_time":"2021-08-16 14:01:00","receive_time":"2021-08-16 14:01:00","equipment_number":"10","ip":"test","data":"test"}];

http://192.168.0.152:8040/api/_load_error_log?file=__shard_2/error_log_insert_stmt_db42e6d8d081cf5c-8ce12b2ab9e00984_db42e6d8d081cf5c_8ce12b2ab9e00984
http://192.168.0.198:8040/api/_load_error_log?file=__shard_0/error_log_insert_stmt_d74fc0f6265530c3-dd7470719474c5a8_d74fc0f6265530c3_dd7470719474c5a8

http://192.168.0.198:8040/api/_load_error_log?file=__shard_1/error_log_insert_stmt_9240bd3750503f38-8b8cd07fbfc9cfb9_9240bd3750503f38_8b8cd07fbfc9cfb9

Reason: JSON data is not an array-object, `strip_outer_array` must be FALSE.. src line: [{"package_time":1629617745828,"package_date":20210822,"receive_time":1629617745828,"equipment_number":"Test001","ip":"127.0.0.1","data":"test1"}];


2021-09-07 04:51:21,308 ERROR org.apache.doris.demo.flink.DorisSink                        [] - Stream Load failstatus: 200, resp msg: OK, resp content: {    "TxnId": 750714,    "Label": "audit_20210907_045121_dabbd27669b64af1bffe6c31528b60bf",    "Status": "Fail",    "Message": "too many filtered rows",    "NumberTotalRows": 1,    "NumberLoadedRows": 0,    "NumberFilteredRows": 1,    "NumberUnselectedRows": 0,    "LoadBytes": 144,    "LoadTimeMs": 6,    "BeginTxnTimeMs": 0,    "StreamLoadPutTimeMs": 1,    "ReadDataTimeMs": 0,    "WriteDataTimeMs": 4,    "CommitAndPublishTimeMs": 0,    "ErrorURL": "http://192.168.0.198:8040/api/_load_error_log?file=__shard_1/error_log_insert_stmt_9240bd3750503f38-8b8cd07fbfc9cfb9_9240bd3750503f38_8b8cd07fbfc9cfb9"}:
2021-09-07 04:51:21,351 ERROR org.apache.doris.demo.flink.DorisSink                        [] - Stream Load failstatus: 200, resp msg: OK, resp content: {    "TxnId": 750715,    "Label": "audit_20210907_045121_b3ce7f0a59214d11a0e77b4fd318ead4",    "Status": "Fail",    "Message": "too many filtered rows",    "NumberTotalRows": 1,    "NumberLoadedRows": 0,    "NumberFilteredRows": 1,    "NumberUnselectedRows": 0,    "LoadBytes": 125,    "LoadTimeMs": 24,    "BeginTxnTimeMs": 0,    "StreamLoadPutTimeMs": 1,    "ReadDataTimeMs": 0,    "WriteDataTimeMs": 21,    "CommitAndPublishTimeMs": 0,    "ErrorURL": "http://192.168.0.185:8040/api/_load_error_log?file=__shard_3/error_log_insert_stmt_8b4f46e24d0184d0-4b5da351eee5f8a5_8b4f46e24d0184d0_4b5da351eee5f8a5"}:


errCode = 2, detailMessage = failed to send task: errCode = 2, detailMessage = failed to submit task. error code: TOO_MANY_TASKS, msg: 0816f268959949d4-82b2cb501fe14784  
```