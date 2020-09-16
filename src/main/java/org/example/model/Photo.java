package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(targetEntity = News.class)
    private News news;
    @ManyToOne(targetEntity = Training.class)
    private Training training;
    @ManyToOne(targetEntity = Interview.class)
    private Interview interview;
    private String link;
    private Date creationTimePhoto;
}
