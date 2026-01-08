package com.sushe.po.export;

import com.sushe.po.BasePageRequest;
import lombok.Data;

import java.util.List;
@Data
public class ClassExport {
    private  Integer c_id;
    private  Integer c_classid;
    private  String  c_classname;
    private  String  c_counsellor;
    //班级与学生为一对多关系，使用链表
    private List<StudentExport>  students;

}
