package hieu.nv.jpa.message.dto;

import hieu.nv.jpa.message.config.NoForbiddenWords;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link hieu.nv.jpa.message.entity.Message}
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageDto implements Serializable {
    private String id;

    @NoForbiddenWords
    private String payload;
}