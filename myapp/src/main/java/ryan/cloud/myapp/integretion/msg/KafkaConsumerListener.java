package ryan.cloud.myapp.integretion.msg;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import ryan.cloud.myapp.dao.module.Orders;
import ryan.cloud.myapp.service.OrderService;

@Service
public class KafkaConsumerListener {

    @Autowired
    OrderService orderService;

//    @KafkaListener(topics = "myapp_order", groupId = "myGroup")
//    public void consume(Orders message) {
//        System.out.println("Consumed message: " + message.toString());
//        // 处理消息的逻辑...
//    }


    @KafkaListener(topics = "myapp_order", groupId = "myGroup")
    public void listen(ConsumerRecord<String, Orders> record,
                       Acknowledgment acknowledgment) {
        Orders order = record.value();
        System.out.println("Received Order: " + order.toString());
        if (orderService.handleBiz(order) != null) {
            acknowledgment.acknowledge();  // 手动提交offset
        }
    }
}
