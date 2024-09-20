package hieu.nv.jpa.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortDto {
	private String active;     // Field to sort by
	private String direction;  // Sorting direction ("ASC" or "DESC")
}
