package cnpm.test.demo.controller;

import cnpm.test.demo.entity.DaiLyConDTO;
import cnpm.test.demo.entity.SanPhamDTO;
import cnpm.test.demo.service.DaiLyConService;
import cnpm.test.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/thong-ke")
public class TKSPController {
    @Autowired
    private DaiLyConService daiLyConService;

    @Autowired
    private SanPhamService sanPhamService;
    @GetMapping("/trang-chu")
    public String trangChu(Model model){
        return "index";
    }

    @GetMapping("/chon-thong-ke")
    public String chonThongKe(){
        return "chonthongke";
    }

    @GetMapping("/tim-kiem")
    public String timKiemThongKe(Model model){
        return "thongkesanpham";
    }
    @PostMapping("/tim-kiem")
    public String dsThongKe(@RequestParam("ngayBatDau") String ngayBatDau,@RequestParam("ngayKetThuc") String ngayKetThuc, HttpSession session, Model model) throws Exception {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ngayBatDau);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ngayKetThuc);


        session.setAttribute("ngayBatDau", date1);
        session.setAttribute("ngayKetThuc", date2);
        List<SanPhamDTO> list = sanPhamService.getTKSanPham(date1, date2);
        int a=0;
        model.addAttribute("a",a);
        model.addAttribute("listSanPham", list);
        return "kqthongke";
    }
    @GetMapping("/dai-ly-san-pham")
    public String timKiemThongKe(@ModelAttribute("id") int id, Model model, HttpSession session){
        Date date  = (Date) session.getAttribute("ngayBatDau");
        Date date1  = (Date) session.getAttribute("ngayKetThuc");
        List<DaiLyConDTO> daiLyConDTO = daiLyConService.getTKDaiLy(id,date,date1);
        model.addAttribute("listDaiLyCon", daiLyConDTO);

        return "thongkedaily";
    }
}
