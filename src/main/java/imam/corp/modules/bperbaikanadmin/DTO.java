package imam.corp.modules.bperbaikanadmin;

import imam.corp.config.converter.StringToDateConverter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class DTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class respBPerbaikanAdmin {
        private Long id;
        private String namaBarang;
        private String tanggal;
        private String bengkelToko;
        private Boolean isPrimary;
        private String posisiBarang;
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
    public static class reqstBPerbaikanAdmin {
        @NotBlank
        private String namaBarang;
        @NotBlank
        private String tanggal;
        @NotBlank
        private String bengkelToko;
        private Boolean isPrimary;
        @NotBlank
        private String posisiBarang;
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
    public static class reqstDetailBPerbaikanAdmin {
        @NotNull
        private Long id;
        @NotBlank
        private String key;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class reqstUpdateBPerbaikanAdmin {
        @NotNull
        private Long id;
        private String namaBarang;
        private String tanggal;
        private String bengkelToko;
        private Boolean isPrimary;
        private String posisiBarang;
        private String keterangan;
        private String kapal;
        @NotBlank
        private String key;
    }

    public static respBPerbaikanAdmin toRespBPerbaikanAdmin(BPerbaikanAdminEntity entity) {
        return respBPerbaikanAdmin.builder()
                .id(entity.getId())
                .namaBarang(entity.getNamaBarang())
                .tanggal(StringToDateConverter.convert(entity.getTanggal()))
                .bengkelToko(entity.getBengkelToko())
                .isPrimary(entity.getIsPrimary())
                .posisiBarang(entity.getPosisiBarang())
                .keterangan(entity.getKeterangan())
                .kapal(entity.getKapal())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
