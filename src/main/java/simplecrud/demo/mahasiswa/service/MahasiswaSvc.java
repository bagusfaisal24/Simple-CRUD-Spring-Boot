package simplecrud.demo.mahasiswa.service;

import simplecrud.demo.mahasiswa.form.MahasiswaForm;
import simplecrud.demo.mahasiswa.model.MahasiswaModel;

import java.util.List;
import java.util.Optional;

public interface MahasiswaSvc {

    List<MahasiswaModel> findAll();

    MahasiswaModel save(MahasiswaModel mhs);

    Optional<MahasiswaModel> findOne(Long id);

    MahasiswaModel update(MahasiswaForm form, Long id);

    MahasiswaModel save(MahasiswaForm form);

    void delete(Long id);
}
