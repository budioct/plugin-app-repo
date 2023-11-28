package imam.corp.modules.bperbaikanadmin;

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
@Table(name = "barang_perbaikan_admins")
public class BPerbaikanAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "no")
    private Long no;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "tanggal")
    private LocalDateTime tanggal;
    @Column(name = "bengkel_toko")
    private String bengkelToko;
    @Column(name = "selesai_belumselesai")
    private Boolean isPrimary;
    @Column(name = "posisi_barang")
    private String posisiBarang;
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
