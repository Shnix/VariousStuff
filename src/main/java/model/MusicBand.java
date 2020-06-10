package model;

import help.MusicGenre;
import lombok.Data;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "musicband")
@Data
public class MusicBand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @OneToOne(orphanRemoval = true)
    private Coordinates coordinates;
    @Transient
    private LocalDateTime creationDate;
    @Column
    private Long numberOfParticipants;
    @Column
    private Long singlesCount;
    @Column(name = "musicgenre")
    @Enumerated(EnumType.STRING)
    private MusicGenre genre;
    @OneToOne(orphanRemoval = true)
    private Album bestAlbum;

    public MusicBand() {
        this.creationDate = LocalDateTime.now();
    }
    public MusicBand(String name, Coordinates coordinates, Long numberOfParticipants, Long singlesCount, MusicGenre genre, Album bestAlbum) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
    }
}
