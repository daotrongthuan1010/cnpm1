package cnpm.test.demo.repository;


import cnpm.test.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    @Query(value=" SELECT\n" +
            "        sp.id,\n" +
            "        sp.ten,\n" +
            "        count(sp.id) as soluong,\n" +
            "        count(sp.id)*sp.gia as doanhthu \n" +
            "    FROM\n" +
            "        phandai.san_pham sp  \n" +
            "    left join\n" +
            "        phandai.phieu_xuat_san_pham pxsp  \n" +
            "            on pxsp.sanpham_id = sp.id  \n" +
            "    left join\n" +
            "        phandai.phieu_xuat px \n" +
            "            on pxsp.phieuxuat_id= px.id  \n" +
            "    where\n" +
            "        px.ngay_xuat  between :ngayBatDau and :ngayKetThuc \n" +
            "    group by\n" +
            "        sp.id \n" +
            "    order by\n" +
            "        count(sp.id)*sp.gia desc;",nativeQuery=true)
    List<Map<String, Object>> getTKSanPham(Date ngayBatDau, Date ngayKetThuc);




}
