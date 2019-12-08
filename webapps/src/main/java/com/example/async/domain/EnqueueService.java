package com.example.async.domain;

import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class EnqueueService {

    private static final Logger logger = LoggerFactory.getLogger(EnqueueService.class);

    /**
     * AutoConfigureによってServiceBusへの接続設定が隠蔽されます。
     */
    @Autowired
    QueueClient queueClient;

    public boolean sendQueueMessage() {
        String messageBody = "queue Message";
        logger.info("message body:{}", messageBody);
        // 送信するメッセージの生成
        Message message = new Message(messageBody.getBytes(StandardCharsets.UTF_8));
        try {
            // Service Busへの送信
            queueClient.send(message);
            queueClient.close();
        } catch (ServiceBusException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
