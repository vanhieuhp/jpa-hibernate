package hieu.nv.jpa.message.entity;

import hieu.nv.jpa.message.config.NoForbiddenWords;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

//@DynamicInsert
//@DynamicUpdate
@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages")
public class Message {

    @Id
    @UuidGenerator
    private String id;

    @NoForbiddenWords
    @Column(name = "payload")
    private String payload;
}
