package edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.outgoing;

import edu.bbte.softeng.brim2122.spring.application.domain.entity.BaseEntity;
import lombok.Data;

@Data
public class DumbbellReducedDto extends BaseEntity {
    String dtype;
    Integer weight;
    Integer price;
    Integer quantity;
}
