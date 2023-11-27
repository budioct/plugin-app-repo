package imam.corp.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.data.annotation.AccessType;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AccessType(AccessType.Type.FIELD)
public class BoilerPlater implements Serializable {

    private static final long serialVersionUID = 1L;

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
