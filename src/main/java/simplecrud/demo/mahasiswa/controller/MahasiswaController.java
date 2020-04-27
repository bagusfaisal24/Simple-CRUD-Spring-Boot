package simplecrud.demo.mahasiswa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simplecrud.demo.mahasiswa.form.MahasiswaForm;
import simplecrud.demo.mahasiswa.model.MahasiswaModel;
import simplecrud.demo.mahasiswa.service.MahasiswaSvc;
import simplecrud.demo.util.DataNotFoundException;
import simplecrud.demo.util.OkResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/mahasiswa/mahasiswa")
public class MahasiswaController {

    private final MahasiswaSvc mahasiswaSvc;

    @Autowired
    public MahasiswaController(MahasiswaSvc mahasiswaSvc) {
        this.mahasiswaSvc = mahasiswaSvc;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<MahasiswaModel> getAll() {
        return mahasiswaSvc.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public MahasiswaModel createNew(@RequestBody MahasiswaForm form) {
        return mahasiswaSvc.save(form);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public MahasiswaModel getDetail(@PathVariable Long id) {
        Optional<MahasiswaModel> optionalMahasiswa = mahasiswaSvc.findOne(id);
        if (!optionalMahasiswa.isPresent()) {
            throw new DataNotFoundException("data mahasiswa tidak ada");
        }
        return optionalMahasiswa.get();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    @ResponseBody
    public MahasiswaModel update(@RequestBody MahasiswaForm form, @PathVariable Long id) {
        return mahasiswaSvc.update(form, id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public OkResponse delete(@PathVariable Long id) {
        mahasiswaSvc.delete(id);
        return new OkResponse();
    }

}
