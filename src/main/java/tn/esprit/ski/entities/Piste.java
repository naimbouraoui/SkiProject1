package tn.esprit.ski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numPiste;
    String nomPiste;
    @Enumerated(EnumType.STRING)
    Couleur couleur;
    int longeur;
    int pente;
    @JsonIgnore
    @ManyToMany(mappedBy = "pistes")
    List<Skieur> skieurs;


}
