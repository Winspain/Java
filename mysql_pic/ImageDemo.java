package mysql_pic;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Administrator 测试写入数据库以及从数据库中读取
 */


public class ImageDemo {
	fileList filelist = new fileList() ;
    
    
    // 将图片插入数据库
    public static void readImage2DB() throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null;	
        FileInputStream in = null;
       
        for (int j=0; j<fileList.Dirfiles().size(); j++)
        {
        try {
        	String path=fileList.Dirfiles().get(j);
            in = ImageUtil.readImage(path);
            conn = pic_store.getConn();
            String sql = "insert into photo (id,name,photo)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,j);
            ps.setString(2, "Tom");
            ps.setBinaryStream(3, in, in.available());
            int count = ps.executeUpdate();
            if (count > 0) {
            	System.out.println("成功插入"+(j+1)+"张图片");
            } else {
                System.out.println("插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	pic_store.closeConn(conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    }

	// 读取数据库中图片
    public static void readDB2Image() {
        String targetPath = "D:/image/1.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = pic_store.getConn();
            String sql = "select * from photo where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("photo");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	pic_store.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //测试
    public static void main(String[] args) throws Exception {
     	readImage2DB();
    	
    	//System.out.println(fileList.filele());
    	//System.out.println(fileList.Dirfiles().get(2));
        
     
        //readDB2Image();
    }
}
