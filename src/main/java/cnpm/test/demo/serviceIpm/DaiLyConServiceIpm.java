package cnpm.test.demo.serviceIpm;

import cnpm.test.demo.entity.DaiLyCon;
import cnpm.test.demo.entity.DaiLyConDTO;
import cnpm.test.demo.entity.SanPhamDTO;
import cnpm.test.demo.repository.DaiLyConRepository;
import cnpm.test.demo.service.DaiLyConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class DaiLyConServiceIpm implements DaiLyConService {
    @Autowired
     private DaiLyConRepository daiLyConRepository;

    @Override
    public List<DaiLyConDTO> getTKDaiLy(int id, Date ngayBatDau, Date ngayKetThuc) {
        List<DaiLyConDTO> list = new ArrayList<>();
        List<Map<String, Object>> obj = daiLyConRepository.getTKDaiLyCon(id,ngayBatDau,ngayKetThuc);


        obj.forEach(x->
        {  DaiLyConDTO daiLyConDTO = new DaiLyConDTO();
            StringBuffer buffer = new StringBuffer();
            buffer.append(String.valueOf(x.get("ngayxuat")));
            daiLyConDTO.setStt(String.valueOf(1));
            System.out.println(buffer);
            String.valueOf(buffer);


            daiLyConDTO.setNgayXuat(  String.valueOf(buffer));
            daiLyConDTO.setDaiLy(String.valueOf(x.get("ten")));
            daiLyConDTO.setSoLuong(String.valueOf(x.get("soluong")));
            daiLyConDTO.setTongTien(String.valueOf(x.get("doanhthu")));
            list.add(daiLyConDTO);

        });
        return  list;
    }
    }

