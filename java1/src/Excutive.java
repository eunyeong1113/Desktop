import java.io.*;
import java.util.*;
public class Excutive extends Manager //�Ŵ������� Ȯ��� Ŭ��
{

	public void getSalary(double a) throws IOException
	{
		for(int i=0; i<arr.length; i++)
		{

			if (arr[i] == null)
			{
				break;
			}
			if((arr[i].title).equals("�ӿ�"))
			{
				System.out.print("�ӿ��� �޿��� ȸ�� ���ͷ�(");
				System.out.printf("%.0f",(100*(a-1)));
				System.out.println("%) ��ŭ �󿩱� �߰� ");

				if(a>0)
				{
					arr[i].getSalary(a);
				}
				else
				{
					System.out.println("ȸ�� ������ ���̳ʽ��̹Ƿ� �󿩱��� ����");
				}

			}

		}

		File outputFile = new File("employee.txt"); // ���� ����
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
	public Excutive() throws IOException
	{
		super();
	}
	public Excutive(String name, int  ID_Number, int age, double salary, String title, String departmentname)
	{
			super(name, ID_Number, age, salary, title, departmentname);
	}

}
