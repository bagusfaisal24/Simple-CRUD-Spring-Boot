package simplecrud.demo.mahasiswa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import simplecrud.demo.mahasiswa.model.MahasiswaModel;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MahasiswaRepository extends CrudRepository<MahasiswaModel, Long>
{
}
