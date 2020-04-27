package simplecrud.demo.mahasiswa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simplecrud.demo.mahasiswa.form.MahasiswaForm;
import simplecrud.demo.mahasiswa.model.MahasiswaModel;
import simplecrud.demo.mahasiswa.repository.MahasiswaRepository;
import simplecrud.demo.util.DataNotFoundException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaSvcImp implements MahasiswaSvc {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public MahasiswaModel save(MahasiswaModel mhs) {
        return mahasiswaRepository.save(mhs);
    }

    @Override
    public List<MahasiswaModel> findAll() {
        return (List<MahasiswaModel>) mahasiswaRepository.findAll();
    }

    @Override
    public Optional<MahasiswaModel> findOne(Long id) {
        return mahasiswaRepository.findById(id);
    }

    @Override
    public MahasiswaModel update(MahasiswaForm form, Long id) {
        Optional<MahasiswaModel> mhs = findOne(id);
        if (!mhs.isPresent()) {
            throw new DataNotFoundException("data mahasiswa tidak ditemukan");
        }
        mhs.get().setName(form.getName());
        mhs.get().setDobPlace(form.getDobPlace());
        mhs.get().setProdi(form.getProdi());
        mhs.get().setBirthDate(Timestamp.valueOf(form.getBirthDate().atStartOfDay()));
        return save(mhs.get());
    }

    @Override
    public MahasiswaModel save(MahasiswaForm form) {
        MahasiswaModel mhs = new MahasiswaModel();
        mhs.setName(form.getName());
        mhs.setDobPlace(form.getDobPlace());
        mhs.setBirthDate(Timestamp.valueOf(form.getBirthDate().atStartOfDay()));
        mhs.setProdi(form.getProdi());
        return save(mhs);
    }

    @Override
    public void delete(Long id) {
        mahasiswaRepository.deleteById(id);
    }
}
