import java.io.*;
import java.util.*;
public class Excutive extends Manager //매니저에서 확장된 클라스
{

	public void getSalary(double a) throws IOException
	{
		for(int i=0; i<arr.length; i++)
		{

			if (arr[i] == null)
			{
				break;
			}
			if((arr[i].title).equals("임원"))
			{
				System.out.print("임원의 급여에 회사 이익률(");
				System.out.printf("%.0f",(100*(a-1)));
				System.out.println("%) 만큼 상여금 추가 ");

				if(a>0)
				{
					arr[i].getSalary(a);
				}
				else
				{
					System.out.println("회사 이익이 마이너스이므로 상여금은 없음");
				}

			}

		}

		File outputFile = new File("employee.txt"); // 파일 쓰기
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
			output.println();//줄바꿈
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
