package com.spring.data.enverse.model;

import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private Integer id;
    @NotNull(message = "{name.not.null}")
    private String name;
    @NotNull(message = "{occupation.not.null}")
    private String occupation;
    @Digits(integer=5, fraction = 2)
    private BigDecimal salary;
    private int age;
}
