package imam.corp.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class BoilerPlater {

    @Column(name = "no")
    private Long no;
    @Column(name = "tanggal")
    private LocalDateTime tanggal;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "kapal")
    private String kapal;

}
