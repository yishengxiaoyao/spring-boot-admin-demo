package com.edu.springbootadmin.config;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractEventNotifier;
import reactor.core.publisher.Mono;

public class CustomNotifier  extends AbstractEventNotifier {

    public CustomNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        return Mono.fromRunnable(() -> {
            if (event instanceof InstanceStatusChangedEvent) {
                String.format("Instance {} ({}) is {}", instance.getRegistration().getName(), event.getInstance(),
                    ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
            } else {
                String.format("Instance {} ({}) {}", instance.getRegistration().getName(), event.getInstance(),
                    event.getType());
            }
        });
    }
}