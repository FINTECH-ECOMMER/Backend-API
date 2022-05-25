package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "videos")
@SQLDelete(sql = "UPDATE videos SET deleted=true WHERE video_id=?")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private BigInteger videoId;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String video_name;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String video_desc;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String video_url;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedDateTime;

    @OneToOne(mappedBy = "video")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Product product;

}
