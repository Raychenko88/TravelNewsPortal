package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "texts")
public class Text {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(targetEntity = News.class)
    private News news;
    @ManyToOne(targetEntity = Training.class)
    private Training training;
    @ManyToOne(targetEntity = Interview.class)
    private Interview interview;
    private String text;
    private Date creationTimeText;
}
