package com.github.maritorr.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    private static final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";
    public static void main(String[] args) {

        // create producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create the producer
        KafkaProducer<String, String> producer =  new KafkaProducer<String, String>(properties);

        // producer record
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "Hello World!");

        // send data
        producer.send(record);

        // flush data
        producer.flush();
        producer.close();
    }
}
