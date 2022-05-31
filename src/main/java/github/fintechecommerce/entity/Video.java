package github.fintechecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
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
public class Video implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id", nullable = false, columnDefinition = "NUMERIC(38,0)", unique = true)
    private BigInteger videoId;

    @Column(nullable = false, columnDefinition = "VARCHAR(150) DEFAULT ''")
    private String video_name;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String video_desc;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX) DEFAULT ''")
    private String video_url;

    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0")
    @JsonIgnore
    private Boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @JsonIgnore
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createdAtDateTime;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updatedAtDateTime;

    @OneToOne(mappedBy = "video", fetch = FetchType.LAZY)
    @JsonIgnore
    private Product product;
}