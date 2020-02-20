import java.util.*;
import java.io.*;
public class Employee
{
	protected String name;
	protected int ID_Number;
	protected int age;
	protected double salary;
	protected String title;
	protected String departmentname;

	public Employee(String name, int  ID_Number, int age, double salary, String title, String departmentname)//매개변수를 가지는 생성자
	{
		this.name=name;
		this.ID_Number=ID_Number;
		this.age=age;
		this.salary=salary;
		this.title=title;
		this.departmentname=departmentname;
	}
	public void getSalary(int a) throws IOException
	{
		salary+=a;
		System.out.println("급여 증가 급여 : " +salary);
	}
	public void getSalary(double a) throws IOException
	{
		salary=salary*a;
		if(a>1.0)
		{
			System.out.println("급여 증가 급여 : " + salary);
		}
		else if(a==1.0)
		{
			System.out.println("급여 증가 급여 :" + salary);
		}
		else
		{
			System.out.println("급여 감소  급여 : " + salary);
		}
	}
	public Employee()
	{
	}
	public void ShowEmployeeList(Employee arr[])
	{

		for(int i=0; i<arr.length; i++)
		{

			if (arr[i] == null)
			{
				break;
			}
			System.out.println("이름 : " + arr[i].name);
			System.out.println("ID 번호 : " + arr[i].ID_Number);
			System.out.println("나이 : " + arr[i].age);
			System.out.println("급여 : " + arr[i].salary);
			System.out.println("직함 : " + arr[i].title);
			System.out.println("부서 : " + arr[i].departmentname);
			System.out.println();
		}

	}
	public void ShowEmployeeList(Employee arr[], String a)
		{

			for(int i=0; i<arr.length; i++)
			{

				if (arr[i] == null) {
					break;
				}
				if((arr[i].departmentname).equals(a))
				{
					System.out.println("이름 : " + arr[i].name);
					System.out.println("ID 번호 : " + arr[i].ID_Number);
					System.out.println("나이 : " + arr[i].age);
					System.out.println("급여 : " + arr[i].salary);
					System.out.println("직함 : " + arr[i].title);
					System.out.println("부서 : " +arr[i].departmentname);
					System.out.println();
				}
			}

	}

}
