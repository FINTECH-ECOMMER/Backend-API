package github.fintech.error.component;

import github.fintech.error.Entity.Error;
import github.fintech.error.service.ErrorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ErrorComponent {
    private final ErrorService errorService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(Error error) {
        log.info("Consumed {} from queue", error);
        errorService.postError(error);
    }

}
