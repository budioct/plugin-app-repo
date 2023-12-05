package imam.corp;

import imam.corp.modules.barangperbaikan.BarangPerbaikanServiceImpl;
import imam.corp.modules.barangterimas.BarangTerimaServiceImpl;
import imam.corp.modules.barangterimas.DTO;
import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminServiceImpl;
import imam.corp.utilities.AutoGenerateNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@EnableJpaAuditing
@SpringBootApplication
public class PluginAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PluginAppApplication.class, args);
    }

    @Autowired
    AutoGenerateNo generateNo;

    @Bean
    public CommandLineRunner commandLineRunner(
            BarangTerimaServiceImpl barangTerimaService,
            BarangPerbaikanServiceImpl barangPerbaikanService,
            BPerbaikanAdminServiceImpl barangPerbaikanAdminService
    ) {
        return args -> {
            DTO.reqstBarangTerima barangTerima = DTO.reqstBarangTerima.builder()
                    .no(generateNo.bTerimaNO())
                    .tanggal("05-12-2023")
                    .noNPP("1111-2222-3333")
                    .namaBarang("torpedo")
                    .keterangan("berlabuh di perairan cirebon")
                    .kapal("KNP sinar mas 403")
                    .key("SCPlimVbAry1rbrSV")
                    .build();
            System.out.println("ADD SERAH TERIMA BARANG " + barangTerimaService.create(barangTerima));

            imam.corp.modules.barangperbaikan.DTO.reqstBarangPerbaikan barangPerbaikan = imam.corp.modules.barangperbaikan.DTO.reqstBarangPerbaikan.builder()
                    .no(generateNo.bPerbaikanNO())
                    .tanggal("05-12-2023")
                    .noNPK("4444-5555-6666")
                    .namaBarang("meriam")
                    .keterangan("berlabuh di perairan jakarta")
                    .kapal("KNP sinar mas 402")
                    .key("SCPlimVbAry1rbrSV")
                    .build();
            System.out.println("ADD BARANG PERBAIKAN " + barangPerbaikanService.create(barangPerbaikan));

            imam.corp.modules.bperbaikanadmin.DTO.reqstBPerbaikanAdmin barangPerbaikanAdmin = imam.corp.modules.bperbaikanadmin.DTO.reqstBPerbaikanAdmin.builder()
                    .no(generateNo.bPAdminNO())
                    .tanggal("05-12-2023")
                    .bengkelToko("Bengkel Las Sejahtra")
                    .namaBarang("Piston")
                    .keterangan("berlabuh di perairan jakarta, dan sedang perbaikan")
                    .isPrimary(false)
                    .posisiBarang("di luar kapal")
                    .kapal("KNP sinar mas 401")
                    .key("SCPlimVbAry1rbrSV")
                    .build();
            System.out.println("ADD BARANG PERBAIKAN " + barangPerbaikanAdminService.create(barangPerbaikanAdmin));

        };
    }

}
