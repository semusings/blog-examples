package bhuwanupadhyay.kubernetes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;

import java.util.UUID;

@SpringBootApplication
public class SpringBootKubernetesApplication {

    @Autowired
    @Lazy
    private OrderRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKubernetesApplication.class, args);
    }

    @EventListener
    public void onAppReady(ApplicationReadyEvent event) {
        repository.save(new Order(newId(), newId(), new DeliveryAddress("Dubai")));
    }

    private String newId() {
        return UUID.randomUUID().toString();
    }

}
