package imam.corp;

import imam.corp.modules.barangterimas.BarangTerimaEntity;
import imam.corp.modules.barangterimas.BarangTerimaRepository;
import imam.corp.modules.barangperbaikan.BarangPerbaikanRepository;
import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminEntity;
import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
public class ORMTests {

    @Autowired
    BarangTerimaRepository barangTerimaRepository;

    @Autowired
    BarangPerbaikanRepository barangPerbaikanRepository;

    @Autowired
    BPerbaikanAdminRepository bPerbaikanAdminRepository;

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
        bpadmin.setNo(111L);
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
    void gc(){
        System.gc();
    }


}
