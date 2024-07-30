package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity // will work on the java logic layer
@Table(name = "bookingreview") // will only work in DB level
public class Review {

    @Id // annotation to make the id property -> primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id property will not be feeded by the user, it needs to be created.
    private Long id;

    @Column(nullable = false)
    private String reviewContent;

    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells spring about the format of Date object we are going to store
    @CreatedDate // this annotation tells spring that only handle it for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // this annotation tells spring that only handle it for object update
    private Date updatedAt;

}
