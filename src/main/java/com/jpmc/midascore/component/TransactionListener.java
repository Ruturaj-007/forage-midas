package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @KafkaListener(topics = "${general.kafka-topic}",
                    groupId = "midas-group",
                    properties = {"spring.json.value.default.type=com.jpmc.midascore.foundation.Transaction"})
    public void listen(Transaction transaction) {
        // This method will receive all transactions from kafka
        System.out.println("Received transaction: " + transaction);
        System.out.println("Amount: " + transaction.getAmount());
    }
}
