package cnpm.test.demo.service;

import cnpm.test.demo.entity.SanPhamDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public interface SanPhamService {
    List<SanPhamDTO> getTKSanPham(Date ngayBatDau, Date ngayKetThuc);

}
