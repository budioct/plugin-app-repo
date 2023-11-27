package imam.corp.modules.barangterimas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BarangTerimaRepository extends JpaRepository<BarangTerimaEntity, Long>, JpaSpecificationExecutor<BarangTerimaEntity> {

    Optional<BarangTerimaEntity> findFirstById(Long id);


}
