package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class used for setting and getting coordinates from objects of MusicBand class
 */

@Entity
@Data
@Table(name = "coordinates")
public class Coordinates implements Comparable<Coordinates>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Double x;
    @Column
    private Integer y;

    public Coordinates(double x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinates o) {
        int result =this.x.compareTo(o.x);
        if (result==0){
            result = this.y.compareTo(o.y);
       }
       return result;
    }
}
