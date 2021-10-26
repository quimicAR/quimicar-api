package br.com.quimicar.api.entity;

import br.com.quimicar.api.utils.View;
import com.fasterxml.jackson.annotation.JsonView;
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
import java.util.UUID;


@TypeDef(name = "int[]", typeClass = IntArrayType.class)
@Entity
@Table(name = "elements")
@Getter
@Setter
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({View.ElementListView.class, View.ElementDetailsView.class})
    private UUID id;

    @Column(nullable = false, unique = true, updatable = false)
    @JsonView({View.ElementListView.class, View.ElementDetailsView.class})
    private Integer number;

    @Column(nullable = false, unique = true, updatable = false)
    @JsonView({View.ElementListView.class, View.ElementDetailsView.class})
    private String name;

    @Column(nullable = false)
    @JsonView({View.ElementListView.class, View.ElementDetailsView.class})
    private Double atomic_mass;

    @JsonView(View.ElementDetailsView.class)
    private String appearance;

    @JsonView(View.ElementDetailsView.class)
    private Double boil;

    @Column(nullable = false)
    @JsonView({View.ElementListView.class, View.ElementDetailsView.class})
    private String category;

    @JsonView(View.ElementDetailsView.class)
    private Double density;

    @JsonView(View.ElementDetailsView.class)
    private Double melt;

    @JsonView(View.ElementDetailsView.class)
    private Double molar_heat;

    @JsonView(View.ElementDetailsView.class)
    private String discovered_by;

    @JsonView(View.ElementDetailsView.class)
    private String named_by;

    @JsonView(View.ElementDetailsView.class)
    private Integer period;

    @JsonView(View.ElementDetailsView.class)
    private String phase;

    @Column(nullable = false)
    @JsonView({View.ElementListView.class, View.ElementDetailsView.class})
    private String symbol;

    @JsonView(View.ElementDetailsView.class)
    private String source;

    @JsonView(View.ElementDetailsView.class)
    private String spectral_img;

    @JsonView(View.ElementDetailsView.class)
    private String summary;

    @Column(updatable = false)
    @JsonView(View.ElementListView.class)
    private Integer xpos;

    @Column(updatable = false)
    @JsonView(View.ElementListView.class)
    private Integer ypos;

    @Type(type = "int[]")
    @Column(nullable = false)
    @JsonView(View.ElementListView.class)
    private Integer[] shells;

    @JsonView(View.ElementDetailsView.class)
    private String electron_configuration;

    @JsonView(View.ElementDetailsView.class)
    private String electron_configuration_semantic;

    @JsonView(View.ElementDetailsView.class)
    private Integer electron_affinity;

    private Integer electronegativity_pauling;

    @Type(type = "int[]")
    @Column(nullable = false)
    private Integer[] ionization_energies;

    @JsonView(View.ElementDetailsView.class)
    private String element_img;

    @Column(nullable = false)
    @JsonView({View.ElementListView.class, View.ElementDetailsView.class})
    private Boolean enabled;
}