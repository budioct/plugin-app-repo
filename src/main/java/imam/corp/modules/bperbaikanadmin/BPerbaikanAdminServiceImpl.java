package imam.corp.modules.bperbaikanadmin;

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
public class BPerbaikanAdminServiceImpl implements BPerbaikanAdminService{

    @Autowired
    BPerbaikanAdminRepository repository;

    @Autowired
    ValidationService validation;

    @Autowired
    MapperToEntity mapper;

    @Autowired
    AutoGenerateNo generateNo;

    @Transactional(readOnly = true)
    public Page<DTO.respBPerbaikanAdmin> fetch(Map<String, Object> filter) {
        Models<BPerbaikanAdmin> models = new Models<>();
        Page<BPerbaikanAdmin> bpAdminPage = repository.findAll(models.where(filter), models.pageableSort(filter));
        List<DTO.respBPerbaikanAdmin> respBPerbaikanAdmins = bpAdminPage.getContent().stream().map(DTO::toRespBPerbaikanAdmin).toList();

        return new PageImpl<>(respBPerbaikanAdmins, bpAdminPage.getPageable(), bpAdminPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public DTO.respBPerbaikanAdmin detail(Long id) {
        BPerbaikanAdmin barang = repository.findFirstById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));

        return DTO.toRespBPerbaikanAdmin(barang);
    }

    @Transactional
    public DTO.respBPerbaikanAdmin create(DTO.reqstBPerbaikanAdmin request) {
        validation.validate(request);
        BPerbaikanAdmin bpAdmin = new BPerbaikanAdmin();
        bpAdmin.setNo(generateNo.bPAdminNO());
        bpAdmin.setNamaBarang(request.getNamaBarang());
        bpAdmin.setTanggal(LocalDateTime.now());
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
        BPerbaikanAdmin bpAdmin = repository.findFirstById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));
        mapper.requestBarangPerbaikanAdminToEntity(request, bpAdmin);
        repository.save(bpAdmin);

        return DTO.toRespBPerbaikanAdmin(bpAdmin);
    }

    @Transactional
    public void remove(Long id) {
        BPerbaikanAdmin pbAdmin = repository.findFirstById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "barang perbaikan not found!"));

        repository.delete(pbAdmin);
    }
}
