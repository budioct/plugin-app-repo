package imam.corp.modules.barangperbaikan;

import org.springframework.data.domain.Page;

import java.util.Map;

public interface BarangPerbaikanService {

    Page<DTO.respBarangPerbaikan> fetch(Map<String, Object> filter);

    DTO.respBarangPerbaikan detail(Long id);

    DTO.respBarangPerbaikan create(DTO.reqstBarangPerbaikan request);

    DTO.respBarangPerbaikan update(DTO.reqstUpdtBarangPerbaikan request);

    void remove(Long id);

}
