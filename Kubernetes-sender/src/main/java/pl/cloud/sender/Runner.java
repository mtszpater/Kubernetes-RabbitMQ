package pl.cloud.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 1);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 2);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 3);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 9000003);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 9000004);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 9000005);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 9000006);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 9000007);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 9000008);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 9000009);
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", 10000000);
    }

}
