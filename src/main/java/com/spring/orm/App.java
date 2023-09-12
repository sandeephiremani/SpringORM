package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentdao = context.getBean("studentDao", StudentDao.class);

//     Student student = new Student(6, "dummy", "Paki");
//     int i = studentdao.insert(student);
//     System.out.println("Done"+i);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		boolean go = true;
		while (go) {

			System.out.println("------WEL-COME------");
			System.out.println("PRESS 1 for add new Student");
			System.out.println("PRESS 2 for display all Student");
			System.out.println("PRESS 3 for get details of single Student");
			System.out.println("PRESS 4 for delete Student");
			System.out.println("PRESS 5 for update Student");
			System.out.println("PRESS 6 for EXIT");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
//					Add new Student
					System.out.println("Enter Student id:");
					int sid = Integer.parseInt(br.readLine());
					System.out.println("Enter Student name:");
					String sname = br.readLine();
					System.out.println("Enter Student City:");
					String  sCity = br.readLine();
					
					Student s = new Student(sid,sname,sCity);
					
					int i = studentdao.insert(s);
					System.out.println("insert Done "+i);
					System.out.println("*************************");
					
					break;
				case 2:
//					Dispaly all student
					List<Student>	alls =	studentdao.getAllStudent();
					for(Student st:alls) {
						System.out.println(" id: "+st.getStudentId()+"| Name: "+st.getSname()+"| City: "+st.getsCity()+"|");
						System.out.println("___________________________");
					}
					
					break;
				case 3:
//					Get student of single student
					System.out.println("Enter the Student id:");
					int id = Integer.parseInt(br.readLine());
					
					Student student=studentdao.getStudent(id);
					System.out.println("___________________________________");
					System.out.println("Id: "+student.getStudentId()+"| Name: "+student.getSname()+"| City: "+student.getsCity()+"|");
					System.out.println("____________________________________");
					break;
				case 4:
					// Delete Student
					System.out.println("Enter the id to delete");
					int did = Integer.parseInt(br.readLine());
					studentdao.deleteStudent(did);
					System.out.println("Data deleted Succesfully :) ");
					break;
				case 5:
					// Update Student
					System.out.println("Enter the Id To update");
					int uid = Integer.parseInt(br.readLine());
					studentdao.update(uid);
					System.out.println("Update Done");
					System.out.println("************************");
					break;
				case 6:
					// Exit
					go=false;
					break;

				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Input try with another one!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thank you ");

	}
}
