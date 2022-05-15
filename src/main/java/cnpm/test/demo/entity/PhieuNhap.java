package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date ngayNhap;

    private float tongTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="thanhvien_id", nullable=false)
    private ThanhVien thanhVien;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="ncc_id", nullable=false)
//    private NCC ncc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuNhap")
    private List<PhieuNhapSanPham> phieuNhapSanPhamDS;


}
