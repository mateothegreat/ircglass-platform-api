package ircglass.messaging;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    private final RabbitTemplate        rabbitTemplate;
    private final SimpMessagingTemplate template;

    @Autowired
    public MessagingService(RabbitTemplate rabbitTemplate,
                            final SimpMessagingTemplate template) {

        this.rabbitTemplate = rabbitTemplate;
        this.template = template;

    }

    public void send(Message message) {

//        this.rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE_NAME, MessagingConfig.ROUTING_KEY, message);

        this.template.convertAndSend("/chat", message);

    }

    //    @Scheduled(fixedRate = 1000)
    public void sendMessage() {

//        Message<CameraMode> message = new Message<>();
//
//        message.setName("test name");
//        message.setCameraUUID(UUID.randomUUID());
//        message.setPayload(CameraMode.RECORDING);
//
//        System.out.println("SENDING: " + message.toString());
//        System.out.println("SENDING: " + Thread.activeCount());
//        System.out.println("SENDING: " + Thread.currentThread().getId());
//        send(message);
//        send(message);
//        send(new Message("from server1"));
//        System.out.println("Asdf'");

    }

}
