package hieu.nv.jpa.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {

	private SortDto sort;
	private int pageNumber;
	private int pageSize;

}
