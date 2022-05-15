package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class ThanhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String ho;

    private String ten;

    private Date ngaysinh;

    private String email;

    private String dienThoai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thanhVien")
    private List<PhieuNhap> phieuNhapDS;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thanhVien")
    private List<PhieuXuat> phieuXuatDS;
}
