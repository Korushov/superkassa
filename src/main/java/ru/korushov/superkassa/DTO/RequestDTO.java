package ru.korushov.superkassa.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Vitaly Korushov
 */

@Getter
@Setter
@Builder
public class RequestDTO {

    @NotNull
    private Integer id;
    @NotNull
    private Integer add;
}
