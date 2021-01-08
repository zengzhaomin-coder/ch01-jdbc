package entity;

import java.sql.Date;

public class Personlnfo {
    // 基本参数
    public int id;      // 编号
    public String name; // 姓名
    public String gender; //性别
    public String idno; // 身份证号
    public String address;  // 家庭住址
    public String phone;    // 联系方式
    public Date hiredate; // 入职日期
    public String department;   // 部门
    public String position; // 职位
    public String education;    // 学历
    public String company;  // 公司

    // 重写 toString 方法
    @Override
    public String toString() {
        return "Personlnfo: {" +
                "编号= " + id +
                ", 姓名= '" + name + '\'' +
                ", 性别= '" + gender + '\'' +
                ", 身份证号= '" + idno + '\'' +
                ", 家庭住址= '" + address + '\'' +
                ", \n 手机号= '" + phone + '\'' +
                ", 入职时间= " + hiredate +
                ", 部门= '" + department + '\'' +
                ", 职位= '" + position + '\'' +
                ", 学历= '" + education + '\'' +
                ", 公司= '" + company + '\'' +
                '}';
    }
}
