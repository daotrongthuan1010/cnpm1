package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class PhieuXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date ngayXuat;

    private String tongTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="thanhvien_id", nullable=false)
    private ThanhVien thanhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dailycon_id", nullable=false)
    private DaiLyCon daiLyCon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuXuat")
    private List<PhieuXuatSanPham> phieuXuatSanPhamDS;
}
