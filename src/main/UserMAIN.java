package main;

import java.util.List;
import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class UserMAIN {

   
   
   // 회원가입
   public static void main(String[] args) {

      boolean run = true;
      Scanner sc = new Scanner(System.in);
      UserDAO dao = new UserDAO();
      while (run) {
         System.out.println("***************");
         System.out.println("1. 회원가입 ");
         System.out.println("2. 로그인 ");
         System.out.println("3. ");
         System.out.println("4. ");
         System.out.println("5. ");
         System.out.println("6.종료");
         System.out.println("***************");
         
         System.out.println("선택 >>");
         int menu = sc.nextInt();

         switch (menu) {

            
         case 1: // 회원 가입
            System.out.println("회원 가입");
            System.out.println("아이디 : ");
            String userid = sc.next();
            System.out.println("이름 : ");
            String username = sc.next();
            System.out.print("비밀번호 : ");
            String userpwd = sc.next();
            UserDTO dto = new UserDTO(userid, username, userpwd);
            System.out.println(dao.insert(dto)?"가입성공" :"실패"); 
            System.out.println();
            break;
            
         case 2: // 로그인
             System.out.println("로그인");
             System.out.println("아이디 : ");
             String userid1 = sc.next();
             System.out.println("비밀번호 : ");
             String userpwd1 = sc.next();
             System.out.println(dao.getRow(userid1,userpwd1)!=null?"로그인 성공" :"실패"); 
             System.out.println();
             break;
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
       
         case 6:
            run = false;
            break;
         default:
            System.out.println("번호를 확인해 주세요");
            break;
         }
      }

   }

}