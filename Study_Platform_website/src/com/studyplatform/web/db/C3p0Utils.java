package com.studyplatform.web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.studyplatform.web.utils.DebugUtils;

/**
 * c3p0连接池
 * Title: C3p0Utils
 * @date 2018年2月1日
 * @author Freedom0013
 */
public class C3p0Utils {
    /** 数据源 */
    private static DataSource ds ;
    
    static{
//        ds = new ComboPooledDataSource("platform-use-config");
        //此处注释掉了两个冗余数据源设置，如果后期项目拓展可以在此更换数据源及数据库
        ds = new ComboPooledDataSource("mysql-tencent-config");
        //ds = new ComboPooledDataSource("orcale-config");
    }
    
    /**
     * 获取C3p0连接池链接
     */
    public static Connection getConnection(){
        try {
            return ds.getConnection() ;
        } catch (SQLException e) {
            DebugUtils.showLog("C3p0错误服务器忙");
            throw new RuntimeException("服务器忙");
        }
    }
    
    /**
     * 关闭（释放）C3p0连接池链接
     */
    public static void close(Connection conn) throws SQLException{
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }  
    
    /**
     * 关闭Statement接口
     */
    public static void close(PreparedStatement pstate) throws SQLException{    
        if(pstate!=null){    
            pstate.close();    
        }    
    }    
    
    /**
     * 关闭结果集
     */
    public static void close(ResultSet rs) throws SQLException{    
        if(rs!=null){    
            rs.close();    
        }    
    }    
    
    /**
     * 链接测试
     */
    public static void main(String[] args){
        Connection conn = C3p0Utils.getConnection() ;
        DebugUtils.showLog("获取到C3p0连接池链接：" + conn.getClass().getName());
    }
}
