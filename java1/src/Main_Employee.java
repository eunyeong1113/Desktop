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
				System.out.println("새로운 직원을 추가합니다");
				a.Putmanage();
				System.out.println("계속 하려면 아무값이나 입력 하세요");
				System.in.read();

				case 1:
				System.out.print("회사의 모든 직원 출력 " );
				System.out.println(" 목록출력 :");
				a.ShowmanageList();
				System.out.println("계속 하려면 아무값이나 입력 하세요");
				System.in.read();
				break;

				case 2:
				System.out.print("검색할 부서 입력 : ");
				String title = input.next();
				a.ShowtitleList(title);
				System.out.println("계속 하려면 아무값이나 입력 하세요");
				System.in.read();
				break;

				case 3:
				System.out.print("급여를 변경할 종업원 ID 번호 입력 : ");
				int num =input.nextInt();
				a.changesalary(num);
				System.out.println("계속 하려면 아무값이나 입력 하세요");
				System.in.read();
				break;

				case 4:
				double companybenefit;
				System.out.print("회사 이익률 입력(0~100%) : ");
				companybenefit=input.nextDouble();
				(a).getSalary(1+companybenefit/100);
				break;

				case 5:
				System.out.println("종료합니다");
				break;

				default:
				System.out.println("지정된 범위 내의 숫자를 입력 하세요" );
			}

		}

}
public static void menu()
{
	System.out.println("----------------------------회사 관리 프로그램 메뉴----------------------------");
	System.out.println("0 : 종업원 추가");
	System.out.println("1 : 회사 내 직원들 출력");
	System.out.println("2 : 특정 부서 직원들 출력");
	System.out.println("3 : 직원 급여 변경");
	System.out.println("4 : 임원 상여금 추가");
	System.out.println("5 : 프로그램 종료");
}

}
