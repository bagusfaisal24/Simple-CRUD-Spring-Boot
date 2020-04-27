package simplecrud.demo.mahasiswa.model;

import lombok.Getter;
import lombok.Setter;
import simplecrud.demo.util.BaseModel;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mahasiswa")
@Setter
@Getter
public class MahasiswaModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DOB_PLACE")
    private String dobPlace;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Timestamp birthDate;

    @Column(name = "PRODI", nullable = false)
    private String prodi;
}
