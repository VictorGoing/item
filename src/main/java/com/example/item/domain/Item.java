package com.example.item.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "OWNER_ID")
    private Long owner;

    @Column(name = "NAME")
    private String name;

    public Item(Long owner, String name) {
        this.owner = owner;
        this.name = name;
    }
}
