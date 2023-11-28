package imam.corp.modules.bperbaikanadmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BPerbaikanAdminRepository extends JpaRepository<BPerbaikanAdmin, Long>, JpaSpecificationExecutor<BPerbaikanAdmin> {

    Optional<BPerbaikanAdmin> findFirstById(Long id);

    @Query(value = "SELECT IFNULL(MAX(CONVERT(no, SIGNED INTEGER)), 0) AS kode FROM barang_perbaikan_admins", nativeQuery = true)
    Long generateNoBPAdmin();

}
