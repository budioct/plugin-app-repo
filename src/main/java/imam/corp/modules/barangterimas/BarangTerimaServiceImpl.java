package imam.corp.modules.barangterimas;

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
public class BarangTerimaServiceImpl implements BarangTerimaService {

    @Autowired
    BarangTerimaRepository repository;

    @Autowired
    ValidationService validation;

    @Autowired
    MapperToEntity mapper;

    @Autowired
    AutoGenerateNo generateNo;

    @Transactional(readOnly = true)
    public Page<DTO.respBarangTerima> fetchAll(Map<String, Object> filter) {
        Models<BarangTerimaEntity> models = new Models<>();
        Page<BarangTerimaEntity> barangPage = repository.findAll(models.where(filter), models.pageableSort(filter));
        List<DTO.respBarangTerima> respBarangTerimas = barangPage.getContent().stream().map(DTO::toRespBarangTerima).toList();

        return new PageImpl<>(respBarangTerimas, barangPage.getPageable(), barangPage.getTotalElements());
    }

    @Transactional
    public DTO.respBarangTerima create(DTO.reqstBarangTerima request) {
        validation.validate(request);
        BarangTerimaEntity barang = new BarangTerimaEntity();
        barang.setNo(generateNo.bTerimaNO());
        barang.setTanggal(LocalDateTime.now());
        barang.setNoNPP(request.getNoNPP());
        barang.setNamaBarang(request.getNamaBarang());
        barang.setKeterangan(request.getKeterangan());
        barang.setKapal(request.getKapal());
        repository.save(barang);

        return DTO.toRespBarangTerima(barang);
    }

    @Transactional(readOnly = true)
    public DTO.respBarangTerima detail(Long id) {
        BarangTerimaEntity barang = repository.findFirstById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang terima not found!"));

        return DTO.toRespBarangTerima(barang);
    }

    @Transactional
    public DTO.respBarangTerima update(DTO.reqstUpdtBarangTerima request) {
        BarangTerimaEntity barang = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang terima not found!"));
        mapper.requestBarangTerimaToEntity(request, barang);
        repository.save(barang);

        return DTO.toRespBarangTerima(barang);
    }

    @Transactional
    public void delete(Long id) {

        BarangTerimaEntity barang = repository.findFirstById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang terima not found!"));

        repository.delete(barang);
    }
}
