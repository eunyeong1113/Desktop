import java.util.*;
import java.io.*;
public class Manager extends Employee //임플로이 상속클라스
{

	static Employee[] arr = new Employee[1000]; //천명 제한

	static int arr_len=0;
	public Manager() throws IOException
	{
			File inputFile = new File("employee.txt");// 임플로이 파일오픈
			if(!inputFile.exists())
			{
				System.out.print("파일이 없습니다");
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
				System.out.print("급여를 변경합니다 변경 인수 입력(1: int형 - 상여금 추가) (2: double형 - 백분율 증가) : ");
				int num=input.nextInt();
				if(num==1)
				{
					System.out.print("추가할 상여금 액수 입력 : ");
					int nnnum=input.nextInt();
					arr[i].getSalary(nnnum);
				}
				else if(num==2)
				{
					System.out.print("증가시킬 급여 비율 입력(0~100%): ");
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
			output.println();//줄바꿈
		}
		output.close();

	}
	public void Putmanage() throws IOException
	{
		File outputFile = new File("employee.txt"); //파일생성


		PrintWriter output = new PrintWriter(new FileWriter(outputFile, true));
		Scanner input= new Scanner(System.in);
		output.println();//줄바꿈

		arr[arr_len]=new Employee();
		System.out.print("이름 입력 : ");
		arr[arr_len].name=input.next();
		output.print(arr[arr_len].name+ "\t");

		System.out.print("ID 번호 입력 : ");
		arr[arr_len].ID_Number=input.nextInt();
		output.print(arr[arr_len].ID_Number+"\t");

		System.out.print("나이 입력 : ");
		arr[arr_len].age=input.nextInt();
		output.print(arr[arr_len].age+"\t");

		System.out.print("급여 입력 : ");
		arr[arr_len].salary=input.nextInt();
		output.print(arr[arr_len].salary+"\t");

		System.out.print("직함 입력(종업원, 관리자) :");
		arr[arr_len].title=input.next();
		output.print(arr[arr_len].title+"\t");

		System.out.print("부서 입력 : ");
		arr[arr_len].departmentname=input.next();
		output.print(arr[arr_len].departmentname+"\t");
		arr_len++;
		output.close();

	}

}
