package model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "album")
public class Album {
    @Id
    private String name;
    @Column
    private Long tracks;
    @Column
    private Long length;

    public Album(String name, Long tracks, Long length) {
        this.name = name;
        this.tracks = tracks;
        this.length = length;
    }

}
