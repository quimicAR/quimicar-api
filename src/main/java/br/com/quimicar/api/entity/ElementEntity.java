package br.com.quimicar.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name="elements")
public class ElementEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "element_id")
    private String element_id;

    @Column(name = "number", nullable = false, unique = true, updatable = false)
    private Number number; // atomicNumber
    
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;
    
    @Column(name = "atomic_mass", nullable = false, updatable = true)
    private Number atomic_mass;

    @Column(name = "appearance", nullable = true, updatable = true)
    private String appearance;

    @Column(name = "boil", nullable = true, updatable = true)
    private Number boil;

    @Column(name = "category", nullable = false, updatable = true)
    private String category;

    @Column(name = "density", nullable = true, updatable = true)
    private Number density;

    @Column(name = "melt", nullable = true, updatable = true)
    private Number melt;

    @Column(name = "molar_heat", nullable = true, updatable = true)
    private Number molar_heat;

    @Column(name = "discovered_by", nullable = true, updatable = true)
    private String discovered_by;

    @Column(name = "named_by", nullable = true, updatable = true)
    private String named_by;

    @Column(name = "period", nullable = true, updatable = true)
    private Number period;

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
    private Number xpos;

    @Column(name = "ypos", nullable = true, updatable = false)
    private Number ypos;

    @Column(name = "shells", nullable = false, updatable = true)
    private Number[] shells;

    @Column(name = "electron_configuration", nullable = true, updatable = true)
    private String electron_configuration;

    @Column(name = "electron_configuration_semantic", nullable = true, updatable = true)
    private String electron_configuration_semantic;

    @Column(name = "electron_affinity", nullable = true, updatable = true)
    private Number electron_affinity;

    @Column(name = "electronegativity_pauling", nullable = true, updatable = true)
    private Number electronegativity_pauling;

    @Column(name = "ionization_energies", nullable = true, updatable = true)
    private Number[] ionization_energies;

    @Column(name = "element_img", nullable = false, updatable = true)
    private String element_img;

}
