package com.dockerapp.dockerapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StoreCommand {

    private Long id;
    @NotBlank
    private String name;
    private Set<ProductCommand> products = new HashSet<>();

}
