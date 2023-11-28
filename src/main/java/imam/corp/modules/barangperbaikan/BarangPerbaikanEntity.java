package imam.corp.modules.barangperbaikan;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners({AuditingEntityListener.class})
@Entity
@Table(name = "barang_perbaikans")
public class BarangPerbaikanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "no")
    private Long no;
    @Column(name = "tanggal")
    private LocalDateTime tanggal;
    @Column(name = "no_npk")
    private String noNPK;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "kapal")
    private String kapal;
    @CreatedDate
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "update_modified_at", insertable = false)
    private LocalDateTime updatedAt;

}
