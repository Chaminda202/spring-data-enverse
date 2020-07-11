package com.spring.data.enverse.model;

import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

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
    private String createdBy;
    private LocalDate createdDate;
    private String lastModifiedBy;
    private LocalDate lastModifiedDate;
}
