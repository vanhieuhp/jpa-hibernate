package hieu.nv.jpa.config;

import hieu.nv.jpa.listener.CustomPostInsertEventListener;
import hieu.nv.jpa.listener.CustomPreInsertEventListener;
import jakarta.persistence.EntityManagerFactory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CustomPreInsertEventListenerBeanPostProcessor implements BeanPostProcessor {

    private final CustomPreInsertEventListener customPreInsertEventListener;
    private final CustomPostInsertEventListener customPostInsertEventListener;

    @Override
    public Object postProcessAfterInitialization(
            @NonNull Object bean,
            @NonNull String beanName
    ) throws BeansException {
        if (bean instanceof EntityManagerFactory entityManagerFactory) {
            SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
            EventListenerRegistry registry = sessionFactory
                    .getServiceRegistry()
                    .getService(EventListenerRegistry.class);
            assert registry != null;
            registry.getEventListenerGroup(EventType.PRE_INSERT)
                    .appendListener(customPreInsertEventListener);

            registry.getEventListenerGroup(EventType.POST_INSERT)
					.appendListener(customPostInsertEventListener);
        }

        return bean;
    }

}
