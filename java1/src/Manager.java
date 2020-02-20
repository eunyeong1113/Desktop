import java.util.*;
import java.io.*;
public class Manager extends Employee //���÷��� ���Ŭ��
{

	static Employee[] arr = new Employee[1000]; //õ�� ����

	static int arr_len=0;
	public Manager() throws IOException
	{
			File inputFile = new File("employee.txt");// ���÷��� ���Ͽ���
			if(!inputFile.exists())
			{
				System.out.print("������ �����ϴ�");
				System.exit(0);
			}
		Scanner eminput = new Scanner(inputFile);
		String line;
		while(eminput.hasNext())
		{
			arr[arr_len]=new Employee();
			line=eminput.next();
			arr[arr_len].name=line;
			line=eminput.next();
			arr[arr_len].ID_Number=Integer.parseInt(line);
			line=eminput.next();
			arr[arr_len].age=Integer.parseInt(line);
			line=eminput.next();
			arr[arr_len].salary=Double.parseDouble(line);
			line=eminput.next();
			arr[arr_len].title=line;
			line=eminput.next();
			arr[arr_len].departmentname=line;
			arr_len++;
		}

	}
	public Manager(String name, int  ID_Number, int age, double salary, String title, String departmentname)
	{
		arr[arr_len]=new Employee(name, ID_Number, age, salary, title, departmentname);
		arr_len++;
	}
	public void ShowmanageList()
	{
		super.ShowEmployeeList(arr);
	}
	public void ShowtitleList(String aaa)
	{
		super.ShowEmployeeList(arr, aaa);
	}
	public void changesalary(int number) throws IOException
	{
		for(int i=0; i<arr.length; i++)
		{

			if (arr[i] == null)
			{
				break;
			}
			if(arr[i].ID_Number==number)
			{
				Scanner input = new Scanner(System.in);
				System.out.print("�޿��� �����մϴ� ���� �μ� �Է�(1: int�� - �󿩱� �߰�) (2: double�� - ����� ����) : ");
				int num=input.nextInt();
				if(num==1)
				{
					System.out.print("�߰��� �󿩱� �׼� �Է� : ");
					int nnnum=input.nextInt();
					arr[i].getSalary(nnnum);
				}
				else if(num==2)
				{
					System.out.print("������ų �޿� ���� �Է�(0~100%): ");
					double nnum=input.nextDouble();
					arr[i].getSalary(1+nnum/100);
				}
			}

		}

		File outputFile = new File("employee.txt");
		PrintWriter output = new PrintWriter(outputFile);
		Scanner input= new Scanner(System.in);
		for(int i=0; i<arr.length; i++)
		{
			if (arr[i] == null) {
						break;
			}
			output.print(arr[i].name+ "\t");
			output.print(arr[i].ID_Number+"\t");
			output.print(arr[i].age+"\t");
			output.print(arr[i].salary+"\t");
			output.print(arr[i].title+"\t");
			output.print(arr[i].departmentname+"\t");
			output.println();//�ٹٲ�
		}
		output.close();

	}
	public void Putmanage() throws IOException
	{
		File outputFile = new File("employee.txt"); //���ϻ���


		PrintWriter output = new PrintWriter(new FileWriter(outputFile, true));
		Scanner input= new Scanner(System.in);
		output.println();//�ٹٲ�

		arr[arr_len]=new Employee();
		System.out.print("�̸� �Է� : ");
		arr[arr_len].name=input.next();
		output.print(arr[arr_len].name+ "\t");

		System.out.print("ID ��ȣ �Է� : ");
		arr[arr_len].ID_Number=input.nextInt();
		output.print(arr[arr_len].ID_Number+"\t");

		System.out.print("���� �Է� : ");
		arr[arr_len].age=input.nextInt();
		output.print(arr[arr_len].age+"\t");

		System.out.print("�޿� �Է� : ");
		arr[arr_len].salary=input.nextInt();
		output.print(arr[arr_len].salary+"\t");

		System.out.print("���� �Է�(������, ������) :");
		arr[arr_len].title=input.next();
		output.print(arr[arr_len].title+"\t");

		System.out.print("�μ� �Է� : ");
		arr[arr_len].departmentname=input.next();
		output.print(arr[arr_len].departmentname+"\t");
		arr_len++;
		output.close();

	}

}
