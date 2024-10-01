package hieu.nv.jpa.article.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Embeddable
public class Vote {

	@Column(name = "review")
	private String review;

	@Column(name = "rate")
	private int rate;

	public Vote(String review, int rate) {
		this.review = review;
		this.rate = rate;
	}
}


