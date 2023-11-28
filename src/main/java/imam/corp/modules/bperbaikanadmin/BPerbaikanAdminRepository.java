package imam.corp.modules.bperbaikanadmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BPerbaikanAdminRepository extends JpaRepository<BPerbaikanAdmin, Long>, JpaSpecificationExecutor<BPerbaikanAdmin> {

    Optional<BPerbaikanAdmin> findFirstById(Long id);

}
