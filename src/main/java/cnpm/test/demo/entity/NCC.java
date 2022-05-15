package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class NCC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ten;

    private String email;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nCC")
//    private List<PhieuNhap> phieuNhapDS;

}
