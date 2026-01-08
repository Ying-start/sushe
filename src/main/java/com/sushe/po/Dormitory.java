package com.sushe.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class Dormitory extends BasePageRequest implements Serializable {
    private  Integer d_id;
    private  Integer s_dormitoryid;
    private  String  d_dormbuilding;
    private  String  d_bedtotal;
    private  String  d_bed;
    private  String  a_name;

    private List<Student> students;

}
