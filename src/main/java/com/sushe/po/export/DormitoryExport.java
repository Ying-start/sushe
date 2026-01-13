package com.sushe.po.export;

import com.sushe.po.BasePageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class DormitoryExport implements Serializable {
    private  Integer d_id;
    private  Integer s_dormitoryid;
    private  String  d_dormbuilding;
    private  Integer  d_bedtotal;
    private  Integer  d_bed;
    private  String  a_name;

    private List<StudentExport> students;

}
