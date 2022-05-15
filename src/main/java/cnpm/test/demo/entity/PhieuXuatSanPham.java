package cnpm.test.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PhieuXuatSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="phieuxuat_id", nullable=false)
    private PhieuXuat phieuXuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sanpham_id", nullable=false)
    private SanPham sanPham;





}
