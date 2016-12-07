package fr.quintipio.fr.quintipio.modelArchiAngularJs.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(of="id")
@Entity
@Table(name="COMMUNE")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(of = {"libelle"} )
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotNull
    @Size(max = 5)
    @Column(name="CODE_INSEE", length=5, nullable=false)
    String codeInsee;

    @NotNull
    @Size(max = 5)
    @Column(name="CODE_POSTAL", length=5, nullable=false)
    String codePostal;

    @NotNull
    @Column(name="LIBELLE", length=5, nullable=false)
    String libelle;



}
