package imam.corp.modules.barangperbaikan;

import imam.corp.common.MapperToEntity;
import imam.corp.common.Models;
import imam.corp.config.validation.ValidationService;
import imam.corp.utilities.AutoGenerateNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class BarangPerbaikanServiceImpl implements BarangPerbaikanService {

    @Autowired
    BarangPerbaikanRepository repository;

    @Autowired
    ValidationService validation;

    @Autowired
    MapperToEntity mapper;

    @Autowired
    AutoGenerateNo generateNo;

    @Transactional(readOnly = true)
    public Page<DTO.respBarangPerbaikan> fetch(Map<String, Object> filter) {
        Models<BarangPerbaikanEntity> models = new Models<>();
        Page<BarangPerbaikanEntity> barangPage = repository.findAll(models.where(filter), models.pageableSort(filter));
        List<DTO.respBarangPerbaikan> respBarangBarangPerbaikan = barangPage.getContent().stream().map(DTO::toRespBarangPerbaikan).toList();

        return new PageImpl<>(respBarangBarangPerbaikan, barangPage.getPageable(), barangPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public DTO.respBarangPerbaikan detail(Long id) {
        BarangPerbaikanEntity barang = repository.findFirstById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));

        return DTO.toRespBarangPerbaikan(barang);
    }

    @Transactional
    public DTO.respBarangPerbaikan create(DTO.reqstBarangPerbaikan request) {
        validation.validate(request);
        BarangPerbaikanEntity barang = new BarangPerbaikanEntity();
        barang.setNo(generateNo.bPerbaikanNO());
        barang.setTanggal(LocalDateTime.now());
        barang.setNoNPK(request.getNoNPK());
        barang.setNamaBarang(request.getNamaBarang());
        barang.setKeterangan(request.getKeterangan());
        barang.setKapal(request.getKapal());
        repository.save(barang);

        return DTO.toRespBarangPerbaikan(barang);
    }

    @Transactional
    public DTO.respBarangPerbaikan update(DTO.reqstUpdtBarangPerbaikan request) {
        BarangPerbaikanEntity barang = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));
        mapper.requestBarangPerbaikanToEntity(request, barang);
        repository.save(barang);

        return DTO.toRespBarangPerbaikan(barang);
    }

    @Transactional
    public void remove(Long id) {
        BarangPerbaikanEntity barang = repository.findFirstById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));

        repository.delete(barang);
    }
}
