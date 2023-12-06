package imam.corp.modules.bperbaikanadmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BPerbaikanAdminRepository extends JpaRepository<BPerbaikanAdminEntity, Long>, JpaSpecificationExecutor<BPerbaikanAdminEntity> {

    Optional<BPerbaikanAdminEntity> findFirstById(Long id);

}
