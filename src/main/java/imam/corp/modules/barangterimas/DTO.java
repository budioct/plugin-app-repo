package imam.corp.modules.barangterimas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class DTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class respBarangTerima {
        private Long id;
        private Long no;
        private LocalDateTime tanggal;
        private String noNPP;
        private String namaBarang;
        private String keterangan;
        private String kapal;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class reqstBarangTerima {
        private Long no;
        private LocalDateTime tanggal;
        @NotBlank
        private String noNPP;
        @NotBlank
        private String namaBarang;
        private String keterangan;
        @NotBlank
        private String kapal;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class reqstUpdtBarangTerima {
        @JsonIgnore
        private Long id;
        private Long no;
        private LocalDateTime tanggal;
        private String noNPP;
        private String namaBarang;
        private String keterangan;
        private String kapal;
    }

    public static respBarangTerima toRespBarangTerima(BarangTerimaEntity entity){
        return respBarangTerima.builder()
                .id(entity.getId())
                .no(entity.getNo())
                .tanggal(entity.getTanggal())
                .noNPP(entity.getNoNPP())
                .namaBarang(entity.getNamaBarang())
                .keterangan(entity.getKeterangan())
                .kapal(entity.getKapal())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
