package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.UserDTO;

public class UserDAO {
   static {
      try {
         Class.forName("oracle.jdbc.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

   }

   public static Connection getConnection() {
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "c##java";
      String password = "12345";
      Connection con = null;
      try {
         con = DriverManager.getConnection(url, user, password);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return con;
   }
   
      //회원 가입
   
      public boolean insert(UserDTO dto) {
            boolean flag=false;
            
            Connection con=null;
            PreparedStatement pstmt=null;
            try {
               con=getConnection();
               String sql ="insert into customer_log(userid,username,userpwd)values(?,?,?)";
               pstmt=con.prepareStatement(sql);
               pstmt.setString(1, dto.getUserid());
               pstmt.setString(2, dto.getUsername());
               pstmt.setString(3, dto.getUserpwd());
               int result=pstmt.executeUpdate();
               if(result>0) {
                  flag=true;
               }
            } catch (Exception e) {
               e.printStackTrace();
            }finally {
               try {
                  pstmt.close();
                  con.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
   
   
            return flag;
   
      }
      
      // 로그인
      
      public UserDTO getRow(String userid , String userpwd) {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          UserDTO dto = null;
          try {
             con = getConnection();
             String sql = "select * from customer_log where userid= ? and userpwd=?";
             pstmt = con.prepareStatement(sql);
             pstmt.setString(1, userid);
             pstmt.setString(2, userpwd);
             
             rs = pstmt.executeQuery();
             
             if (rs.next()) {
                dto = new UserDTO();
                dto.setUserid(rs.getString(1));               
                dto.setUsername(rs.getString(2));                 
                dto.setUserpwd(rs.getString(3));
             }
          } catch (Exception e) {
             e.printStackTrace();
          } finally {
             try {
                rs.close();
                pstmt.close();
                con.close();
             } catch (Exception e2) {
                e2.printStackTrace();
             }

          }
          return dto;
       }
      
      // 예매 내역 확인
      public UserDTO getRow1(String mvcode){
          Connection con = null;
           PreparedStatement pstmt = null;
           ResultSet rs = null;
           UserDTO dto1 = null;
           
           try {
            con = getConnection();
            String sql = "select * from customer_ch where mvcode = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mvcode);
            rs = pstmt.executeQuery();
            dto1 = new UserDTO();
            
            if(rs.next()) {
               dto1.setUserid(rs.getString(1));
               dto1.setMvcode(rs.getString(2));
               dto1.setMvname(rs.getString(3));
               dto1.setMvtime(rs.getString(4));
               dto1.setLoc(rs.getString(5));
               dto1.setSitnum(rs.getString(6));
            }
           }
           catch (Exception e) {
               e.printStackTrace();
            }
            finally {
            try {
               rs.close();
               pstmt.close();
               con.close();
            } catch (Exception e2) {
               e2.printStackTrace();
            }
            }
            return dto1;
           }

      public boolean insertMv(UserDTO dto) {
          boolean flag=false;
          
          Connection con=null;
          PreparedStatement pstmt=null;
          try {
             con=getConnection();
             String sql ="insert into ch(mvname,loc,mvtime)values(?,?,?)";
             pstmt=con.prepareStatement(sql);
        
             pstmt.setString(1, dto.getMvname());
             pstmt.setString(2, dto.getLoc());
             pstmt.setString(3, dto.getMvtime());
            
             int result=pstmt.executeUpdate();
             if(result>0) {
                flag=true;
             }
          } catch (Exception e) {
             e.printStackTrace();
          }finally {
             try {
                pstmt.close();
                con.close();
             } catch (Exception e2) {
                e2.printStackTrace();
             }
          }
 
 
          return flag;
 
    }
      
}

