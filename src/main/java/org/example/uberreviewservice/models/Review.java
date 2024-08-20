package org.example.uberreviewservice.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity // will work on the java logic layer
@Table(name = "bookingreview") // will only work in DB level
public class Review extends BaseModel {

    @Column(nullable = false)
    private String reviewContent;

    private Double rating;

}
