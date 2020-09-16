package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String image;
    @Transient
    private List<String> listPhotos;
    @Transient
    private List<String> listVideo;
    @Transient
    private List<String> listTexts;
    private String heading;
    private String text;
    private String author;
    private String video;
    private Date creationTime;
    private String pageLanguage;
}
