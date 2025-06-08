package DAO;

import entity.Pet;
import util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDao {
    //创建connection对象
    private Connection con=null;
    //创建PreparedStatement对象
    private PreparedStatement st=null;
    //创建ResultSet对象
    private ResultSet rs=null;
//Connection、PreparedStatement 和 ResultSet，
// 用于数据库连接、预处理 SQL 语句以及存储查询结果。

    //查询方法
    public List<Pet> Query(String name){
        ArrayList<Pet> list=new ArrayList<>();
        try {
            con= JDBCutil.getConnection();
            String sql="select * from pet where name like=?";
            st.setString(1,"%"+name+"%");
            rs= st.executeQuery();
            while(rs.next()){
                Pet sr=new Pet();
                sr.setId(rs.getInt("id"));
                sr.getPetname(rs.getString("petname"));
                sr.getPetType(rs.getString("petType"));
                sr.getSex(rs.getString("sex"));
                sr.getBirthday(rs.getInt("birthday"));
                sr.getState(rs.getInt("state"));
                sr.getRemark(rs.getString("remark"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCutil.close(rs,st,con);
        }
        return list;
    }

    //删除
    public boolean del(int id){
        try{
            //获取数据库链接
            con=JDBCutil.getConnection();
            //删除数据库sql
            String sql="delete from pet where id=?";
            st=con.prepareStatement(sql);
            //设置删除id
            st.setInt(1,id);
            //执行sql并且返回结果
            return st.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //抛出异常
            JDBCutil.close(rs,st,con);
        }
        //如果异常默认返回false
        return false;
    }
}
