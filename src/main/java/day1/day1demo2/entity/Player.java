package day1.day1demo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Laver automatisk getters og setters
@Getter
@Setter
@NoArgsConstructor  //Laver automatisk en null constructor
//------------------------ da annoteringerne kommer fra to pakker og har to funktioner skal de deles op
@Entity
@Table(name="spiller")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true, length = 70, nullable = false)
    private String name;
    String country;
    String position;
    public  Player(String name, String country, String position) {
        this.name = name;
        this.country = country;
        this.position = position;
    }
}
