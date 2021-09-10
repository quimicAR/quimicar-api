package br.com.quimicar.api.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;


@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
@Entity
@Table(name="elements")
public class ElementEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "number", nullable = false, unique = true, updatable = false)
    private Integer number; // atomicNumber

    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    @Column(name = "atomic_mass", nullable = false, updatable = true)
    private Double atomic_mass;

    @Column(name = "appearance", nullable = true, updatable = true)
    private String appearance;

    @Column(name = "boil", nullable = true, updatable = true)
    private Double boil;

    @Column(name = "category", nullable = false, updatable = true)
    private String category;

    @Column(name = "density", nullable = true, updatable = true)
    private Double density;

    @Column(name = "melt", nullable = true, updatable = true)
    private Double melt;

    @Column(name = "molar_heat", nullable = true, updatable = true)
    private Double molar_heat;

    @Column(name = "discovered_by", nullable = true, updatable = true)
    private String discovered_by;

    @Column(name = "named_by", nullable = true, updatable = true)
    private String named_by;

    @Column(name = "period", nullable = true, updatable = true)
    private Integer period;

    @Column(name = "phase", nullable = true, updatable = true)
    private String phase;

    @Column(name = "symbol", nullable = false, updatable = true)
    private String symbol;

    @Column(name = "source", nullable = true, updatable = true)
    private String source;

    @Column(name = "spectral_img", nullable = true, updatable = true)
    private String spectral_img;

    @Column(name = "summary", nullable = true, updatable = true)
    private String summary;

    @Column(name = "xpos", nullable = true, updatable = false)
    private Integer xpos;

    @Column(name = "ypos", nullable = true, updatable = false)
    private Integer ypos;

    @Type(type = "jsonb")
    @Column(name = "shells", nullable = false, updatable = true, columnDefinition = "jsonb")
    private Integer[] shells;

    @Column(name = "electron_configuration", nullable = true, updatable = true)
    private String electron_configuration;

    @Column(name = "electron_configuration_semantic", nullable = true, updatable = true)
    private String electron_configuration_semantic;

    @Column(name = "electron_affinity", nullable = true, updatable = true)
    private Integer electron_affinity;

    @Column(name = "electronegativity_pauling", nullable = true, updatable = true)
    private Integer electronegativity_pauling;

    @Type(type = "jsonb")
    @Column(name = "ionization_energies", nullable = true, updatable = true, columnDefinition = "jsonb")
    private Integer[] ionization_energies;

    @Column(name = "element_img", nullable = false, updatable = true)
    private String element_img;

    @Column(name = "enabled", nullable = false, updatable = true)
    private Boolean enabled;
}