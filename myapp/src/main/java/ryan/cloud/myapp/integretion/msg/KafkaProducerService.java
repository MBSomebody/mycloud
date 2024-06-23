package ryan.cloud.myapp.integretion.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ryan.cloud.myapp.dao.module.Orders;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Orders> kafkaTemplate;

    private static final String TOPIC = "myapp_order";

    public void sendOrder(Orders order) throws Exception {
        kafkaTemplate.send(TOPIC, order).get();
    }
}