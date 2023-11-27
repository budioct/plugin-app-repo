package imam.corp.modules.barangterimas;

import org.springframework.data.domain.Page;

import java.util.Map;

public interface BarangTerimaService {

    Page<DTO.respBarangTerima> fetchAll(Map<String, Object> filter);
    DTO.respBarangTerima create(DTO.reqstBarangTerima request);
    DTO.respBarangTerima detail(Long id);
    DTO.respBarangTerima update(DTO.reqstUpdtBarangTerima request);
    void delete(Long id);

}
