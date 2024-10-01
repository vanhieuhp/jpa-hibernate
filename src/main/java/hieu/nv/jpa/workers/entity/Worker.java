package hieu.nv.jpa.workers.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@ToString(exclude = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workers")
public class Worker {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy="assignedWorker", fetch = FetchType.EAGER)
	@MapKey(name="taskName")
	@JsonManagedReference
	private Map<String, WorkerTask> tasks;
}
