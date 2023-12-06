package imam.corp.modules.bperbaikanadmin;

import imam.corp.common.MapperToEntity;
import imam.corp.common.Models;
import imam.corp.config.converter.StringToDateConverter;
import imam.corp.config.validation.ValidationService;
import imam.corp.utilities.SecuritySecretKey;
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
public class BPerbaikanAdminServiceImpl implements BPerbaikanAdminService{

    @Autowired
    BPerbaikanAdminRepository repository;

    @Autowired
    ValidationService validation;

    @Autowired
    MapperToEntity mapper;

    @Autowired
    SecuritySecretKey secret;

    @Autowired
    StringToDateConverter converter;

    @Transactional(readOnly = true)
    public Page<DTO.respBPerbaikanAdmin> fetch(Map<String, Object> filter) {
        if (!(filter.containsKey("key"))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "keyword: key on body request not found!!");
        }
        if (!(filter.get("key") != "")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "key: must not be blank");
        }
        if (!(filter.get("key").equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        Models<BPerbaikanAdminEntity> models = new Models<>();
        Page<BPerbaikanAdminEntity> bpAdminPage = repository.findAll(models.where(filter), models.pageableSort(filter));
        List<DTO.respBPerbaikanAdmin> respBPerbaikanAdmins = bpAdminPage.getContent().stream().map(DTO::toRespBPerbaikanAdmin).toList();

        if (respBPerbaikanAdmins.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan admin not found!");
        }

        return new PageImpl<>(respBPerbaikanAdmins, bpAdminPage.getPageable(), bpAdminPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public DTO.respBPerbaikanAdmin detail(DTO.reqstDetailBPerbaikanAdmin request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BPerbaikanAdminEntity barang = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));

        return DTO.toRespBPerbaikanAdmin(barang);
    }

    @Transactional
    public DTO.respBPerbaikanAdmin create(DTO.reqstBPerbaikanAdmin request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BPerbaikanAdminEntity bpAdmin = new BPerbaikanAdminEntity();
        bpAdmin.setNamaBarang(request.getNamaBarang());
        bpAdmin.setTanggal(LocalDateTime.of(converter.convert(request.getTanggal()), LocalDateTime.now().toLocalTime()));
        bpAdmin.setBengkelToko(request.getBengkelToko());
        bpAdmin.setIsPrimary(request.getIsPrimary());
        bpAdmin.setPosisiBarang(request.getPosisiBarang());
        bpAdmin.setKeterangan(request.getKeterangan());
        bpAdmin.setKapal(request.getKapal());
        repository.save(bpAdmin);

        return DTO.toRespBPerbaikanAdmin(bpAdmin);
    }

    @Transactional
    public DTO.respBPerbaikanAdmin update(DTO.reqstUpdateBPerbaikanAdmin request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BPerbaikanAdminEntity bpAdmin = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));
        mapper.requestBarangPerbaikanAdminToEntity(request, bpAdmin);
        repository.save(bpAdmin);

        return DTO.toRespBPerbaikanAdmin(bpAdmin);
    }

    @Transactional
    public void remove(DTO.reqstDetailBPerbaikanAdmin request) {
        validation.validate(request);

        if (!(request.getKey().equals(secret.secretKey()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Key invalid!!!");
        }

        BPerbaikanAdminEntity pbAdmin = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));

        //repository.delete(pbAdmin);
        repository.deleteById(pbAdmin.getId());
    }
}
