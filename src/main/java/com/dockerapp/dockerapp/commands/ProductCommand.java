package com.dockerapp.dockerapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ProductCommand {
    private Long id;

    @NotBlank
    private String name;

    @NotEmpty
    private Double price;

    private String url;
}
