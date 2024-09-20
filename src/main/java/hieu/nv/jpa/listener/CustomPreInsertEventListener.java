package hieu.nv.jpa.listener;

import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.random.RandomStringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomPreInsertEventListener implements PreInsertEventListener {

	private final RandomStringService randomStringService;

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		// Your logic before insertion
		if (event.getEntity() instanceof Article) {
			Article article = (Article) event.getEntity();
			article.setContent("This is a sample article " + randomStringService.generateRandomString(10));
		}
		return false;
	}
}
