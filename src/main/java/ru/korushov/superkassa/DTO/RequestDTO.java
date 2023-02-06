package ru.korushov.superkassa.DTO;

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
    private int id;
    private int add;
}
