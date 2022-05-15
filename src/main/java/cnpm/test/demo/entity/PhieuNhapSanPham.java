package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PhieuNhapSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="phieunhap_id", nullable=false)
    private PhieuNhap phieuNhap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sanpham_id", nullable=false)
    private SanPham sanPham;
}
