package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class DaiLyCon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ten;

    private String email;

    private String sdt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "daiLyCon")
    private List<PhieuXuat> phieuXuatDS;
}
