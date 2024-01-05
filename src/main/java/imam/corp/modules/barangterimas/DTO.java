package imam.corp.modules.barangterimas;

import imam.corp.config.converter.StringToDateConverter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
        private String tanggal;
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
        @NotBlank
        private String tanggal;
        @NotBlank
        private String noNPP;
        @NotBlank
        private String namaBarang;
        private String keterangan;
        @NotBlank
        private String kapal;
        @NotBlank
        private String key;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class reqstDetailBarangTerima {
        @NotNull
        private Long id;
        @NotBlank
        private String key;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class reqstUpdtBarangTerima {
        @NotNull
        private Long id;
        private String tanggal;
        private String noNPP;
        private String namaBarang;
        private String keterangan;
        private String kapal;
        @NotBlank
        private String key;
    }

    public static respBarangTerima toRespBarangTerima(BarangTerimaEntity entity) {
        return respBarangTerima.builder()
                .id(entity.getId())
                .tanggal(StringToDateConverter.convert(entity.getTanggal()))
                .noNPP(entity.getNoNPP())
                .namaBarang(entity.getNamaBarang())
                .keterangan(entity.getKeterangan())
                .kapal(entity.getKapal())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
