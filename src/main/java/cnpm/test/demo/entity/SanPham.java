package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ten;

    private String loai;

    private String moTa;

    private String gia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sanPham")
    private List<PhieuNhapSanPham> phieuNhapSanPhamDS;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sanPham")
    private List<PhieuXuatSanPham> phieuXuatSanPhamDS;
}
