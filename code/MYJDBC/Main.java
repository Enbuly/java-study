package JDBC_Example;

import java.util.List;

/**
 * Created by john on 2016/7/4.
 * a test class
 */
public class Main {
    public static void main(String[]args){
        String sql="select * from student where id=?";
        ConnectionZzy connectionZzy=new ConnectionZzy();
        List<Object> zzy=connectionZzy.excuteQuerys(sql,new Object[]{2});
        System.out.print(zzy);

        String sqlsecond="update student set name ='Gaga' where id =?";
        int result=connectionZzy.executeUpdate(sqlsecond,new Object[]{1});
        System.out.println(result);
    }
}
