package imam.corp.modules.barangterimas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BarangTerimaRepository extends JpaRepository<BarangTerimaEntity, Long>, JpaSpecificationExecutor<BarangTerimaEntity> {

    Optional<BarangTerimaEntity> findFirstById(Long id);

    @Query(value = "SELECT IFNULL(MAX(CONVERT(no, SIGNED INTEGER)), 0) AS kode FROM barang_terimas", nativeQuery = true)
    Long generateNoBTerima();


}
