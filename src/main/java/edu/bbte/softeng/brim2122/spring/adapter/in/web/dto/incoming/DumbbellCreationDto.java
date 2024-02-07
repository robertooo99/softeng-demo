package edu.bbte.softeng.brim2122.spring.adapter.in.web.dto.incoming;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class DumbbellCreationDto implements Serializable {
    @Positive
    Long id;

    @NotEmpty
    @Size(max = 100)
    String description;

    @NotEmpty
    @Size(max = 20)
    String dtype;

    @Min(2)
    @Max(80)
    Integer weight;

    @Positive
    Integer price;

    @PositiveOrZero
    Integer quantity;
}
