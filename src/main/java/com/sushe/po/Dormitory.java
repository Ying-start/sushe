package com.sushe.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class Dormitory extends BasePageRequest implements Serializable {
    private  Integer d_id;
    private  Integer s_dormitoryid;
    private  String  d_dormbuilding;
    private  int  d_bedtotal;
    private  int  d_bed;
    private  String  a_name;

    private List<Student> students;

}
