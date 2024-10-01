package hieu.nv.jpa.workers.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@ToString(exclude = "assignedWorker")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worker_tasks")
public class WorkerTask {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String taskName;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="worker_id")
	private Worker assignedWorker;
}
