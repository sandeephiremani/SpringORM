package com.spring.orm.Dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private HibernateTemplate hibernateTemplate;

//	Save Student
	@Transactional
	public int insert(Student student) {
//		Insert
		Integer i = (Integer) hibernateTemplate.save(student);
		return i;
	}

//	Get the single object
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
//	Get ALl student
	public List<Student> getAllStudent(){
		List<Student> student =this.hibernateTemplate.loadAll(Student.class);
		return student;
	}

//	Deleteing the data
	@Transactional
	public void deleteStudent(int studentId) {
	Student student =	this.hibernateTemplate.get(Student.class, studentId);
	this.hibernateTemplate.delete(student);
	}
	
//	Updateing the data
	@Transactional
	public void update(int studentId) {
		System.out.println("Press 1 for Update Name\nPress 2 for update City");
		try {
			int n = Integer.parseInt(br.readLine());
			
			switch (n) {
			case 1:Student student =  this.hibernateTemplate.get(Student.class,studentId);
			System.out.println("Enter the name to Update");
			String sup=br.readLine();
					student.setSname(sup);
				break;

			case 2:
				Student student1 =  this.hibernateTemplate.get(Student.class,studentId);
				System.out.println("Enter the City to Update");
				String sci=br.readLine();
						student1.setsCity(sci);
			default:
				System.out.println("Invalid Input!!!");
				break;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		Student 
	}
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
