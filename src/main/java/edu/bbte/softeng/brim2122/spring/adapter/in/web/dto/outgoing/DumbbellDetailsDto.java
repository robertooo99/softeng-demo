package edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.outgoing;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DumbbellDetailsDto extends DumbbellReducedDto {
    String description;
}
