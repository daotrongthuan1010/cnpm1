package cnpm.test.demo.repository;


import cnpm.test.demo.entity.DaiLyCon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface DaiLyConRepository extends JpaRepository<DaiLyCon, Integer> {

    @Query(value="SELECT px.ngay_xuat as ngayxuat, dl.ten, count(px.dailycon_id) as soluong, sum(px.tong_tien) as doanhthu FROM phandai.san_pham sp \n" +
            "left join phandai.phieu_xuat_san_pham pxsp \n" +
            "on pxsp.sanpham_id = sp.id \n" +
            "left join phieu_xuat px\n" +
            "on pxsp.phieuxuat_id= px.id \n" +
            "left join dai_ly_con dl on px.dailycon_id = dl.id\n" +
            "where pxsp.sanpham_id = :id and px.ngay_xuat \n" +
            "between :ngayBatDau and :ngayKetThuc  group by px.dailycon_id ;",nativeQuery=true)
    List<Map<String, Object>> getTKDaiLyCon(int id, Date ngayBatDau, Date ngayKetThuc);

}
