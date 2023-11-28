package imam.corp.modules.barangperbaikan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class DTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class respBarangPerbaikan{
        private Long id;
        private Long no;
        private LocalDateTime tanggal;
        private String noNPK;
        private String namaBarang;
        private String keterangan;
        private String kapal;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class reqstBarangPerbaikan{
        private Long no;
        private LocalDateTime tanggal;
        @NotBlank
        private String noNPK;
        @NotBlank
        private String namaBarang;
        private String keterangan;
        @NotBlank
        private String kapal;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class reqstUpdtBarangPerbaikan{
        @JsonIgnore
        private Long id;
        private Long no;
        private LocalDateTime tanggal;
        private String noNPK;
        private String namaBarang;
        private String keterangan;
        private String kapal;
    }

    public static respBarangPerbaikan toRespBarangPerbaikan(BarangPerbaikanEntity entity){
        return respBarangPerbaikan.builder()
                .id(entity.getId())
                .no(entity.getNo())
                .tanggal(entity.getTanggal())
                .noNPK(entity.getNoNPK())
                .namaBarang(entity.getNamaBarang())
                .keterangan(entity.getKeterangan())
                .kapal(entity.getKapal())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }



}
