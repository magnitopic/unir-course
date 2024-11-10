package com.alaparic.carregistry.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer warranty;
    private String country;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Car> cars;


}