import java.util.*;
import java.io.*;
public class Main_Employee
{

	public static void main(String[] args) throws IOException
	{
		int number=0;
		Scanner input=new Scanner(System.in);
		Manager a = new Excutive();
		while(number!=5)
		{

			menu();
			number=input.nextInt();
			//number=1;
			switch(number)
			{

				case 0:
				System.out.println("���ο� ������ �߰��մϴ�");
				a.Putmanage();
				System.out.println("��� �Ϸ��� �ƹ����̳� �Է� �ϼ���");
				System.in.read();

				case 1:
				System.out.print("ȸ���� ��� ���� ��� " );
				System.out.println(" ������ :");
				a.ShowmanageList();
				System.out.println("��� �Ϸ��� �ƹ����̳� �Է� �ϼ���");
				System.in.read();
				break;

				case 2:
				System.out.print("�˻��� �μ� �Է� : ");
				String title = input.next();
				a.ShowtitleList(title);
				System.out.println("��� �Ϸ��� �ƹ����̳� �Է� �ϼ���");
				System.in.read();
				break;

				case 3:
				System.out.print("�޿��� ������ ������ ID ��ȣ �Է� : ");
				int num =input.nextInt();
				a.changesalary(num);
				System.out.println("��� �Ϸ��� �ƹ����̳� �Է� �ϼ���");
				System.in.read();
				break;

				case 4:
				double companybenefit;
				System.out.print("ȸ�� ���ͷ� �Է�(0~100%) : ");
				companybenefit=input.nextDouble();
				(a).getSalary(1+companybenefit/100);
				break;

				case 5:
				System.out.println("�����մϴ�");
				break;

				default:
				System.out.println("������ ���� ���� ���ڸ� �Է� �ϼ���" );
			}

		}

}
public static void menu()
{
	System.out.println("----------------------------ȸ�� ���� ���α׷� �޴�----------------------------");
	System.out.println("0 : ������ �߰�");
	System.out.println("1 : ȸ�� �� ������ ���");
	System.out.println("2 : Ư�� �μ� ������ ���");
	System.out.println("3 : ���� �޿� ����");
	System.out.println("4 : �ӿ� �󿩱� �߰�");
	System.out.println("5 : ���α׷� ����");
}

}
