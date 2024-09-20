package hieu.nv.jpa.supermarket.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = "addresses")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supermarkets")
public class Supermarket {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(
			name = "supermarket_addresses",
			joinColumns = @JoinColumn(name = "supermarket_id")
	)
	private Set<SupermarketAddress> addresses = new HashSet<>();
}
