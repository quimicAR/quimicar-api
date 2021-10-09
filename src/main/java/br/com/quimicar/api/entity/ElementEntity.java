package br.com.quimicar.api.entity;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;


@TypeDef(name = "int[]", typeClass = IntArrayType.class)
@Entity
@Table(name = "elements")
@Getter
@Setter
public class ElementEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(nullable = false, unique = true, updatable = false)
    private Integer number;

    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    @Column(nullable = false)
    private Double atomic_mass;

    private String appearance;

    private Double boil;

    @Column(nullable = false)
    private String category;

    private Double density;

    private Double melt;

    private Double molar_heat;

    private String discovered_by;

    private String named_by;

    private Integer period;

    private String phase;

    @Column(nullable = false)
    private String symbol;

    private String source;

    private String spectral_img;

    private String summary;

    @Column(updatable = false)
    private Integer xpos;

    @Column(updatable = false)
    private Integer ypos;

    @Type(type = "int[]")
    @Column(nullable = false)
    private Integer[] shells;

    private String electron_configuration;

    private String electron_configuration_semantic;

    private Integer electron_affinity;

    private Integer electronegativity_pauling;

    @Type(type = "int[]")
    @Column(nullable = false)
    private Integer[] ionization_energies;

    private String element_img;

    @Column(nullable = false)
    private Boolean enabled;
}