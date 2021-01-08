package ui;

import dao.PersonlnfoDao;
import entity.Personlnfo;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Test {
    // 定义一个菜单的方法
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("========== 员工操作系统 ==========");
            System.out.println("-------- 1、添加信息功能 --------");
            System.out.println("-------- 2、修改信息功能 --------");
            System.out.println("-------- 3、根据姓名查找功能 --------");
            System.out.println("-------- 4、根据编号查找功能 --------");
            System.out.println("-------- 5、删除信息功能 --------");
            System.out.println("-------- 6、查找所有信息功能 --------");
            System.out.println("-------- 7、退出操作系统 --------\n");
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入你的操作选项：");
            int number = scanner.nextInt();
            if (number == 7) {
                System.out.println("你选择了退出操作系统！！！\n下次见咯...");
                break;
            } else {
                switch (number) {
                    case 1: addPersonlnfo();break;
                    case 2: updatePersonlnfo();break;
                    case 3: getPersonlnfoByname();break;
                    case 4: getPersonlnfoByid();break;
                    case 5: deletePersonlnfo();break;
                    case 6: getllPersonlnfo();break;
                    default:
                        System.out.println("抱歉，找不到该功能...\n");
                        break;
                }
            }
        }
    }

    // 添加信息操作
    public static void addPersonlnfo() {
        Personlnfo per = new Personlnfo();
        PersonlnfoDao pers = new PersonlnfoDao();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你要添加姓名：");
        per.name = scanner.next();
        System.out.print("请输入你要添加的性别：");
        per.gender = scanner.next();
        System.out.print("请输入你要添加的身份证号：");
        per.idno = scanner.next();
        System.out.print("请输入你要添加的家庭住址：");
        per.address = scanner.next();
        System.out.print("请输入你要添加的联系方式：");
        per.phone = scanner.next();
        System.out.print("请输入你要添加的入职日期：");
        per.hiredate = Date.valueOf(scanner.next());
        System.out.print("请输入你要添加的部门：");
        per.department = scanner.next();
        System.out.print("请输入你要添加的职位：");
        per.position = scanner.next();
        System.out.print("请输入你要添加的学历：");
        per.education = scanner.next();
        System.out.print("请输入你要添加的公司：");
        per.company = scanner.next();
        try {
            int count = pers.addPersonlnfo(per);
            if (count > 0) {
                System.out.println("恭喜你，添加成功！");
            } else {
                System.out.println("抱歉，添加失败...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改信息操作
    public static void updatePersonlnfo() {
        PersonlnfoDao pers = new PersonlnfoDao();
        Personlnfo per = new Personlnfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要修改的编号：");
        int id = scanner.nextInt();
        System.out.print("请输入要修改的姓名：");
        per.name = scanner.next();
        System.out.print("请输入要修改的性别：");
        per.gender = scanner.next();
        System.out.print("请输入要修改的身份证号：");
        per.idno = scanner.next();
        System.out.print("请输入要修改的家庭住址：");
        per.address = scanner.next();
        System.out.print("请输入要修改的联系方式：");
        per.phone = scanner.next();
        System.out.print("请输入要修改的入职日期：");
        per.hiredate = Date.valueOf(scanner.next());
        System.out.print("请输入要修改的部门：");
        per.department = scanner.next();
        System.out.print("请输入要修改的职位：");
        per.position = scanner.next();
        System.out.print("请输入要修改的学历：");
        per.education = scanner.next();
        System.out.print("请输入要修改的公司：");
        per.company = scanner.next();
        try {
            int count = pers.updatePersonlnfo(id, per);
            if (count > 0) {
                System.out.println("恭喜你，修改成功！");
            } else {
                System.out.println("抱歉，修改失败...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据姓名查找操作
    public static void getPersonlnfoByname() {
        PersonlnfoDao pers = new PersonlnfoDao();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查询的姓名：");
        String name = scanner.next();
        try {
            Personlnfo per = pers.getPersonlnfoByname(name);
            if (per != null) {
                System.out.println("恭喜你，找到了该信息！");
                System.out.println(per);
            } else {
                System.out.println("抱歉，找不到信息...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据编号查询操作
    public static void getPersonlnfoByid() {
        PersonlnfoDao pers = new PersonlnfoDao();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查询的编号：");
        int id = scanner.nextInt();
        try {
            Personlnfo per = pers.getPersonlnfoByid(id);
            if (per != null) {
                System.out.println("恭喜你，找到了该信息！");
                System.out.println(per);
            } else {
                System.out.println("抱歉，找不到信息...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除信息操作
    public static void deletePersonlnfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要删除的编号：");
        int id = scanner.nextInt();
        PersonlnfoDao pers = new PersonlnfoDao();
        try {
            int count = pers.deletePersonlnfo(id);
            if (count > 0) {
                System.out.println("恭喜你，删除成功！");
            } else {
                System.out.println("抱歉，删除失败...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询所有信息操作
    public static void getllPersonlnfo() {
        PersonlnfoDao pers = new PersonlnfoDao();
        try {
            List<Personlnfo> List = pers.getllPersonlnfo();
            for (Personlnfo per : List) {
                System.out.println(per + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}