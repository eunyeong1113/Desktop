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

	public Employee(String name, int  ID_Number, int age, double salary, String title, String departmentname)//�Ű������� ������ ������
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
		System.out.println("�޿� ���� �޿� : " +salary);
	}
	public void getSalary(double a) throws IOException
	{
		salary=salary*a;
		if(a>1.0)
		{
			System.out.println("�޿� ���� �޿� : " + salary);
		}
		else if(a==1.0)
		{
			System.out.println("�޿� ���� �޿� :" + salary);
		}
		else
		{
			System.out.println("�޿� ����  �޿� : " + salary);
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
			System.out.println("�̸� : " + arr[i].name);
			System.out.println("ID ��ȣ : " + arr[i].ID_Number);
			System.out.println("���� : " + arr[i].age);
			System.out.println("�޿� : " + arr[i].salary);
			System.out.println("���� : " + arr[i].title);
			System.out.println("�μ� : " + arr[i].departmentname);
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
					System.out.println("�̸� : " + arr[i].name);
					System.out.println("ID ��ȣ : " + arr[i].ID_Number);
					System.out.println("���� : " + arr[i].age);
					System.out.println("�޿� : " + arr[i].salary);
					System.out.println("���� : " + arr[i].title);
					System.out.println("�μ� : " +arr[i].departmentname);
					System.out.println();
				}
			}

	}

}
