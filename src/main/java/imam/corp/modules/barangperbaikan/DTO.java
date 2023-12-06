package imam.corp.modules.barangperbaikan;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public static class respBarangPerbaikan{
        private Long id;
        private String tanggal;
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
        @NotBlank
        private String tanggal;
        @NotBlank
        private String noNPK;
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
    public static class reqstDetailBarangPerbaikan {
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
    public static class reqstUpdtBarangPerbaikan{
        @NotNull
        private Long id;
        private String tanggal;
        private String noNPK;
        private String namaBarang;
        private String keterangan;
        private String kapal;
        @NotBlank
        private String key;
    }

    public static respBarangPerbaikan toRespBarangPerbaikan(BarangPerbaikanEntity entity){
        return respBarangPerbaikan.builder()
                .id(entity.getId())
                .tanggal(StringToDateConverter.convert(entity.getTanggal()))
                .noNPK(entity.getNoNPK())
                .namaBarang(entity.getNamaBarang())
                .keterangan(entity.getKeterangan())
                .kapal(entity.getKapal())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }



}
