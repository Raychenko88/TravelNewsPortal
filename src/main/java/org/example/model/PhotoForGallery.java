package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "photo_for_gallery")
public class PhotoForGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(targetEntity = Gallery.class)
    private Gallery gallery;
    private String link;
    private LocalDate localDate;
}
