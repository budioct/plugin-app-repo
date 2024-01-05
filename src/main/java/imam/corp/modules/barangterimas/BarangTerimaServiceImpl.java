package imam.corp.modules.barangterimas;

import imam.corp.common.MapperToEntity;
import imam.corp.common.Models;
import imam.corp.config.converter.StringToDateConverter;
import imam.corp.config.validation.ValidationService;
import imam.corp.utilities.SecuritySecretKey;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
public class BarangTerimaServiceImpl implements BarangTerimaService {

    @Autowired
    BarangTerimaRepository repository;

    @Autowired
    ValidationService validation;

    @Autowired
    MapperToEntity mapper;

    @Autowired
    SecuritySecretKey secret;

    @Autowired
    StringToDateConverter converter;

    @Transactional(readOnly = true)
    public Page<DTO.respBarangTerima> fetchAll(Map<String, Object> filter) {
        if (!(filter.containsKey("key"))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "keyword: key on body request not found!!");
        }
        if (!(filter.get("key") != "")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "key: must not be blank");
        }
        if (!(filter.get("key").equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        Models<BarangTerimaEntity> models = new Models<>();
        Page<BarangTerimaEntity> barangPage = repository.findAll(models.where(filter), models.pageableSort(filter));
        List<DTO.respBarangTerima> respBarangTerimas = barangPage.getContent().stream().map(DTO::toRespBarangTerima).toList();

        if (respBarangTerimas.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "barang terima not found!");
        }

        return new PageImpl<>(respBarangTerimas, barangPage.getPageable(), barangPage.getTotalElements());
    }

    @Transactional
    public DTO.respBarangTerima create(DTO.reqstBarangTerima request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BarangTerimaEntity barang = new BarangTerimaEntity();
        barang.setTanggal(LocalDateTime.of(converter.convert(request.getTanggal()), LocalDateTime.now().toLocalTime()));
        barang.setNoNPP(request.getNoNPP().trim());
        barang.setNamaBarang(request.getNamaBarang().trim());
        barang.setKeterangan(request.getKeterangan().trim());
        barang.setKapal(request.getKapal().trim());
        repository.save(barang);

        return DTO.toRespBarangTerima(barang);
    }


    @Transactional(readOnly = true)
    public DTO.respBarangTerima detail(DTO.reqstDetailBarangTerima request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BarangTerimaEntity barang = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang terima not found!"));

        return DTO.toRespBarangTerima(barang);
    }

    @Transactional
    public DTO.respBarangTerima update(DTO.reqstUpdtBarangTerima request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BarangTerimaEntity barang = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang terima not found!"));
        mapper.requestBarangTerimaToEntity(request, barang);
        repository.save(barang);

        return DTO.toRespBarangTerima(barang);
    }

    @Transactional
    public void delete(DTO.reqstDetailBarangTerima request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BarangTerimaEntity barang = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang terima not found!"));

        //repository.delete(barang);
        repository.deleteById(barang.getId());
    }
}
