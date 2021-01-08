package dao;

import entity.Personlnfo;
import utils.DbUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonlnfoDao {

    // 创建工具类对象
    DbUtils dbUtils = new DbUtils();

    /**
     * 添加信息操作
     * @param per
     * @return
     * @throws SQLException
     */
    public int addPersonlnfo(Personlnfo per) throws SQLException {
        String sql = "insert into personlnfo values (?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = {
                per.name, per.gender, per.idno, per.address, per.phone, per.hiredate,
                per.department, per.position, per.education, per.company
        };
        int count = dbUtils.executeUpdate(sql, objects);
        dbUtils.closeAll();
        return count;
    }

    /**
     * 修改信息操作
     * @param id
     * @param per
     * @return
     * @throws SQLException
     */
    public int updatePersonlnfo(int id, Personlnfo per) throws SQLException {
        String sql = "update personlnfo set name=?,gender=?,idno=?,address=?,phone=?,hiredate=?,department=?,position=?,education=?,company=? where id=?";
        Object[] objects = {
                per.name, per.gender, per.idno, per.address, per.phone, per.hiredate,
                per.department, per.position, per.education, per.company,
                id
        };
        int count = dbUtils.executeUpdate(sql, objects);
        dbUtils.closeAll();
        return count;
    }

    /**
     * 根据姓名查询信息操作
     * @param name
     * @return
     * @throws SQLException
     */
    public Personlnfo getPersonlnfoByname (String name) throws SQLException {
        Personlnfo per = null;
        String sql = "select * from personlnfo where name = ?";
        ResultSet resultSet = dbUtils.executeQuery(sql,name);
        if (resultSet.next()) {
            per = new Personlnfo();
            per.id = resultSet.getInt(1);
            per.name = resultSet.getString(2);
            per.gender = resultSet.getString(3);
            per.idno = resultSet.getString(4);
            per.address = resultSet.getString(5);
            per.phone = resultSet.getString(6);
            per.hiredate = resultSet.getDate(7);
            per.department = resultSet.getString(8);
            per.position = resultSet.getString(9);
            per.education = resultSet.getString(10);
            per.company = resultSet.getString(11);
        }
        dbUtils.closeAll();
        return per;
    }

    /**
     * 根据编号查询信息操作
     * @param id
     * @return
     * @throws SQLException
     */
    public Personlnfo getPersonlnfoByid(int id) throws SQLException {
        Personlnfo per = null;
        String sql = "select * from personlnfo where id = ?";
        ResultSet resultSet = dbUtils.executeQuery(sql,id);
        if (resultSet.next()) {
            per = new Personlnfo();
            per.id = resultSet.getInt(1);
            per.name = resultSet.getString(2);
            per.gender = resultSet.getString(3);
            per.idno = resultSet.getString(4);
            per.address = resultSet.getString(5);
            per.phone = resultSet.getString(6);
            per.hiredate = resultSet.getDate(7);
            per.department = resultSet.getString(8);
            per.position = resultSet.getString(9);
            per.education = resultSet.getString(10);
            per.company = resultSet.getString(11);
        }
        dbUtils.closeAll();
        return per;
    }

    /**
     * 删除操作
     * @param id
     * @return
     * @throws SQLException
     */
    public int deletePersonlnfo (int id) throws SQLException {
        String sql = "delete from personlnfo where id = ?";
        Object[] objects = { id };
        int count = dbUtils.executeUpdate(sql, objects);
        dbUtils.closeAll();
        return count;
    }

    /**
     * 查找所有信息操作
     * @return
     * @throws SQLException
     */
    public List<Personlnfo> getllPersonlnfo () throws SQLException {
        List<Personlnfo> personlnfos = new ArrayList<Personlnfo>();
        String sql = "select * from personlnfo";
        ResultSet resultSet = dbUtils.executeQuery(sql);
        while (resultSet.next()) {
            Personlnfo per = new Personlnfo();
            per.id = resultSet.getInt(1);
            per.name = resultSet.getString(2);
            per.gender = resultSet.getString(3);
            per.idno = resultSet.getString(4);
            per.address = resultSet.getString(5);
            per.phone = resultSet.getString(6);
            per.hiredate = resultSet.getDate(7);
            per.department = resultSet.getString(8);
            per.position = resultSet.getString(9);
            per.education = resultSet.getString(10);
            per.company = resultSet.getString(11);
            personlnfos.add(per);
        }
        dbUtils.closeAll();
        return personlnfos;
    }
}
