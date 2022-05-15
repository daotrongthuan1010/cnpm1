package cnpm.test.demo.entity;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class DaiLyConDTO {

    private String stt;

    private String ngayXuat;
    private String daiLy;
    private String soLuong;
    private String tongTien;

}
