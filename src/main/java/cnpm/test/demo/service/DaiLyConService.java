package cnpm.test.demo.service;

import cnpm.test.demo.entity.DaiLyConDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface DaiLyConService {
List<DaiLyConDTO> getTKDaiLy(int id, Date ngayBatDau,Date ngayKetThuc);
}
