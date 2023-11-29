package imam.corp.modules.bperbaikanadmin;

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
    public static class respBPerbaikanAdmin {
        private Long id;
        private Long no;
        private String namaBarang;
        private LocalDateTime tanggal;
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
        private Long id;
        private Long no;
        @NotBlank
        private String namaBarang;
        private LocalDateTime tanggal;
        @NotBlank
        private String bengkelToko;
        private Boolean isPrimary;
        @NotBlank
        private String posisiBarang;
        private String keterangan;
        @NotBlank
        private String kapal;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class reqstUpdateBPerbaikanAdmin {
        @JsonIgnore
        private Long id;
        private Long no;
        @NotBlank
        private String namaBarang;
        private LocalDateTime tanggal;
        @NotBlank
        private String bengkelToko;
        private Boolean isPrimary;
        @NotBlank
        private String posisiBarang;
        private String keterangan;
        @NotBlank
        private String kapal;
    }

    public static respBPerbaikanAdmin toRespBPerbaikanAdmin(BPerbaikanAdminEntity entity) {
        return respBPerbaikanAdmin.builder()
                .id(entity.getId())
                .no(entity.getNo())
                .namaBarang(entity.getNamaBarang())
                .tanggal(entity.getTanggal())
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
