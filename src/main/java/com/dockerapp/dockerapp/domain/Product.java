package com.dockerapp.dockerapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"stores"})
@Entity
public class Product {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;

   private String name;

   private Double price;

   private String url;

   @OneToOne
   private Category category;

   @ManyToMany(mappedBy = "products")
   private Set<Store> stores = new HashSet<>();
}