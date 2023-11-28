package imam.corp.modules.barangperbaikan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BarangPerbaikanRepository extends JpaRepository<BarangPerbaikanEntity, Long>, JpaSpecificationExecutor<BarangPerbaikanEntity> {

    Optional<BarangPerbaikanEntity> findFirstById(Long id);

    @Query(value = "SELECT IFNULL(MAX(CONVERT(no, SIGNED INTEGER)), 0) AS kode FROM barang_perbaikans", nativeQuery = true)
    Long generateNoBPerbaikan();

}
