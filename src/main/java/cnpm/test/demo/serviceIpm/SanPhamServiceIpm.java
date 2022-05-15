package cnpm.test.demo.serviceIpm;

import cnpm.test.demo.entity.SanPhamDTO;
import cnpm.test.demo.repository.SanPhamRepository;
import cnpm.test.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class SanPhamServiceIpm implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    int a=0;
    @Override
    public List<SanPhamDTO> getTKSanPham(Date ngayBatDau, Date ngayKetThuc) {

        List<SanPhamDTO> list = new ArrayList<>();
        List<Map<String, Object>> obj = sanPhamRepository.getTKSanPham(ngayBatDau,ngayKetThuc);

        obj.forEach(x->

        {  SanPhamDTO sanPhamDTO = new SanPhamDTO();
            sanPhamDTO.setStt(String.valueOf(a));
            sanPhamDTO.setId(String.valueOf(x.get("id")));
            sanPhamDTO.setTen(String.valueOf(x.get("ten")));
            sanPhamDTO.setSoLuong(String.valueOf(x.get("soluong")));
            sanPhamDTO.setDoanhThu(String.valueOf(x.get("doanhthu")));
            list.add(sanPhamDTO);

        });
        return  list;
    }
}
