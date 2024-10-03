package hieu.nv.jpa.listener;

import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.random.RandomStringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomPostInsertEventListener implements PostInsertEventListener {

	@Override
	public void onPostInsert(PostInsertEvent postInsertEvent) {
		// Your logic after insertion
		if (postInsertEvent.getEntity() instanceof Article article) {
			System.out.println("[After] Article is inserted: " + article);
		}
	}

	@Override
	public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
		return false;
	}
}
