package JDBC_Example;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by john on 2016/7/3.
 * @author zzy
 */
class ConnectionZzy{

    //drivername
    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";

    //url
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_example";

    //username
    private static final String USERNAME = "root";

    //password
    private static final String USERPASSWORD = "";

    private Connection connnection = null;

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    static{
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection getConnection() {
        try {
            connnection = DriverManager.getConnection(URL,USERNAME,USERPASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connnection;
    }

    //select something
    private ResultSet executeQuery(String sql,Object[] params) {
        try {
            connnection = this.getConnection();
            preparedStatement = connnection.prepareStatement(sql);
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    //select something return a arraylist
    List<Object> excuteQuerys(String sql,Object[] params) {
        List<Object> list = new ArrayList<>();
        ResultSetMetaData rsmd;
        int columnCount;
        ResultSet rs = executeQuery(sql,params);
        try {
            rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();//get the table column count
            while (rs.next()) {
                Map<String,Object> map=new HashMap<>();
                for(int i=1;i<=columnCount;i++){
                    map.put(rsmd.getColumnLabel(i),rs.getObject(i));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return list;
    }

    //update something,insert something,delete something
    int executeUpdate(String sql,Object[] params) {
        int affectedLine = 0;
        try {
            connnection = this.getConnection();
            preparedStatement = connnection.prepareStatement(sql);
            if(params!= null) {
                for(int i=0;i<params.length;i++){
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            affectedLine = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return affectedLine;
    }

    //colse something
    private void closeAll() {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (connnection != null) {
            try {
                connnection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
