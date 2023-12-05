package imam.corp.modules.bperbaikanadmin;

import org.springframework.data.domain.Page;

import java.util.Map;

public interface BPerbaikanAdminService {

    Page<DTO.respBPerbaikanAdmin> fetch(Map<String, Object> filter);
    DTO.respBPerbaikanAdmin detail(DTO.reqstDetailBPerbaikanAdmin request);
    DTO.respBPerbaikanAdmin create(DTO.reqstBPerbaikanAdmin request);
    DTO.respBPerbaikanAdmin update(DTO.reqstUpdateBPerbaikanAdmin request);
    void remove(DTO.reqstDetailBPerbaikanAdmin request);

}
