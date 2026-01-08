package com.sushe.po.export;

import com.sushe.po.BasePageRequest;
import lombok.Data;

@Data
public class StudentExport {
    private  Integer s_id;
    private  Integer s_studentid;
    private  String  s_name;
    private  String  s_sex;
    private  Integer  s_age;
    private  Integer  s_phone;
    private  Integer  s_classid;
    private  String s_classname;
    private  Integer  s_dormitoryid;


}
