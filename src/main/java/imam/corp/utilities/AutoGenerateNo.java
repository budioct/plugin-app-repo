package imam.corp.utilities;

import imam.corp.modules.barangperbaikan.BarangPerbaikanRepository;
import imam.corp.modules.barangterimas.BarangTerimaRepository;
import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AutoGenerateNo {

    @Autowired
    BarangTerimaRepository barangTerimaRepository;

    @Autowired
    BarangPerbaikanRepository barangPerbaikanRepository;

    @Autowired
    BPerbaikanAdminRepository bPerbaikanAdminRepository;

    public long bTerimaNO() {
        long banyakData = barangTerimaRepository.generateNoBTerima();
//        log.info("no: {}", banyakData);
        long nomorBerikutnya = banyakData + 1;
        long urutan = 0;
        if (banyakData == 0) {
            urutan = 1;
        } else {
            urutan = nomorBerikutnya;
        }

        return urutan;
    }

    public long bPerbaikanNO() {
        long banyakData = barangPerbaikanRepository.generateNoBPerbaikan();
//        log.info("no: {}", banyakData);
        long nomorBerikutnya = banyakData + 1;
        long urutan = 0;
        if (banyakData == 0) {
            urutan = 1;
        } else {
            urutan = nomorBerikutnya;
        }

        return urutan;
    }

    public long bPAdminNO() {
        long banyakData = bPerbaikanAdminRepository.generateNoBPAdmin();
//        log.info("no: {}", banyakData);
        long nomorBerikutnya = banyakData + 1;
        long urutan = 0;
        if (banyakData == 0) {
            urutan = 1;
        } else {
            urutan = nomorBerikutnya;
        }

        return urutan;
    }

}
