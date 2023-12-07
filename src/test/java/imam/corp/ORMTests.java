package imam.corp;

import imam.corp.config.converter.StringToDateConverter;
import imam.corp.modules.barangterimas.BarangTerimaEntity;
import imam.corp.modules.barangterimas.BarangTerimaRepository;
import imam.corp.modules.barangperbaikan.BarangPerbaikanRepository;
import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminEntity;
import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminRepository;
import imam.corp.utilities.SecuritySecretKey;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@SpringBootTest
public class ORMTests {

    @Autowired
    BarangTerimaRepository barangTerimaRepository;

    @Autowired
    BarangPerbaikanRepository barangPerbaikanRepository;

    @Autowired
    BPerbaikanAdminRepository bPerbaikanAdminRepository;

    @Autowired
    SecuritySecretKey secretKey;

    @Autowired
    StringToDateConverter converter;

    @Test
    void testInsertData() {

        String ket = "Why do we use it? It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the li Where does it come from? Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.";

    }

    @Test
    void testFindSurat() {


        String text = "Why do we use it? It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the li Where does it come from? Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.";

    }


    @Test
    void testReflection() {

        Class<BarangTerimaEntity> boiler = BarangTerimaEntity.class;
        Field[] declaredFields = boiler.getDeclaredFields();

        for (Field value : declaredFields) {
            // mendapatkan field dan tipedatanya
            System.out.println("nameField: " + value.getName() + ", typeData: " + value.getType().getName()); // Class<?> getType() mendapatkan typeData // String getName() mendapatkan nama field yang di deklarasi object tersebut
        }

    }

    @Test
    void testBPerbaikanAdmin() {

        BPerbaikanAdminEntity bpadmin = new BPerbaikanAdminEntity();
        bpadmin.setNamaBarang("nama barang");
        bpadmin.setTanggal(LocalDateTime.now());
        bpadmin.setBengkelToko("bengkel");
        bpadmin.setIsPrimary(false);
        bpadmin.setPosisiBarang("dermaga 1");
        bpadmin.setKeterangan("perbaikan tahap 2");
        bpadmin.setKapal("kapal natuna 231");

        bPerbaikanAdminRepository.save(bpadmin);

    }

    @Test
    void gc() {
        System.gc();
    }

    @Test
    void testKey() {

        String sebenarnya = secretKey.secretKey();
        String ekpetasi = "b{WV92TI-1DdKN<+B<pV*1D*^A_gi>|?o{C`aP7i4].?Y_4-w<Dy@5%4)]gJdi";

        Assertions.assertNotNull(sebenarnya);
        Assertions.assertEquals(ekpetasi, sebenarnya);

    }

    @Test
    void whenTrim_thenCorrect() {

        String data = "     Hello World!!!     ";
        log.info("Original:  {}", data.length());
        log.info("length Original:  {}", data);
        log.info("modifed trim:  {}", data.trim());
        log.info("length modifed trim:  {}", data.trim().length());

    }

    @Test
    void testStringConvertToLocalDateTime() {

        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String ld = "23-12-2023";
//        LocalDate ld = LocalDate.parse("03-12-2023", DATEFORMATTER);
        LocalDateTime ldt = LocalDateTime.of(converter.convert(ld), LocalDateTime.now().toLocalTime());
        System.out.println(ld);
        System.out.println(ldt);

    }

    @Test
    void testLocalDateConvertToString(){

        BarangTerimaEntity barangTerima = barangTerimaRepository.findFirstById(59L)
                .orElseThrow(() -> new RuntimeException("Id not found"));
//        LocalDate localDate = barangTerima.getTanggal().toLocalDate();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String text = localDate.format(formatter);
//        LocalDate parseDate = LocalDate.parse(text, formatter);

//        log.info("{}", barangTerima.getTanggal()); // 2023-04-27T01:20:13
//        log.info("{}", localDate); // 2023-04-27
//        log.info("{}", text); // 27/04/2023
//        log.info("{}", parseDate); // 2023-04-27

        String convert = converter.convert(barangTerima.getTanggal());

        log.info("{}", convert);


    }


}
