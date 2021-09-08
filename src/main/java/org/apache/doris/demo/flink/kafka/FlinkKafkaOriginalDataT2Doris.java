// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package org.apache.doris.demo.flink.kafka;


import org.apache.doris.demo.flink.DorisSink;
import org.apache.doris.demo.flink.DorisStreamLoad;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/**
 * This example mainly demonstrates how to use flink to stream Kafka data.
 * And use the doris streamLoad method to write the data into the table specified by doris
 * <p>
 * Kafka data format is an array, For example: ["id":1,"name":"root"]
 */

public class FlinkKafkaOriginalDataT2Doris {
    //kafka address
    private static final String bootstrapServer = "192.168.0.200:9092,192.168.0.160:9092,192.168.0.178:9092";
    //kafka groupName
    private static final String groupName = "flink_doris_camtg_group";
    //kafka topicName
    private static final String topicName = "c_original_data_t_topic";
    //doris ip port
    private static final String hostPort = "192.168.0.186:8030";
    //doris dbName
    private static final String dbName = "camtg";
    //doris tbName
    private static final String tbName = "c_original_data_t";
    //doris userName
    private static final String userName = "root";
    //doris password
    private static final String password = "camtg";
    //doris columns
    private static final String columns = "package_time,package_date,equipment_number,receive_time,ip,data";
    //json format
    private static final String jsonFormat = "[\"$.package_time\",\"$.package_date\",\"$.equipment_number\",\"$.receive_time\",\"$.ip\",\"$.data\"]";

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServer);
        props.put("zookeeper.connect", "192.168.0.200:2181,192.168.0.160:2181,192.168.0.178:2181");
        props.put("group.id", groupName);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "latest");
        props.put("max.poll.records", "10000");

        StreamExecutionEnvironment blinkStreamEnv = StreamExecutionEnvironment.getExecutionEnvironment();
        blinkStreamEnv.enableCheckpointing(10000);
        blinkStreamEnv.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);

        FlinkKafkaConsumer<String> flinkKafkaConsumer = new FlinkKafkaConsumer<>(topicName,
                new SimpleStringSchema(),
                props);

        DataStreamSource<String> dataStreamSource = blinkStreamEnv.addSource(flinkKafkaConsumer).setParallelism(2);

        DorisStreamLoad dorisStreamLoad = new DorisStreamLoad(hostPort, dbName, tbName, userName, password);

        dataStreamSource.addSink(new DorisSink(dorisStreamLoad, columns, jsonFormat));
        blinkStreamEnv.execute("flink kafka to doris c_original_data_t");

    }
}
