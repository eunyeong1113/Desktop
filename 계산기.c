#include<stdio.h>
#include<conio.h>
void main(){
	int i, j;
	int result; int temp; int lastNumber; char myOperator;
	int isRunning = 1, isNumber = 1, isNotComplete = 0;
	char ch;
	int cnt = 0;

	int max, min;
	max = '9', min = '0';
	myOperator = ' ';
	 
	result = 0;

	while( isRunning ){
		
		int currentNumber = 0; 
		isNumber = 1;

		while( isNumber ){
			ch = getch();
			printf("%c", ch);

			if( ch >= min && ch <= max ){
				currentNumber = currentNumber * 10;

				temp = ch - min;
				currentNumber += temp;

				if( currentNumber > 999 ){
					printf("수식에 사용되는 수는 3자리 정수로 제한됨");
				}
			}else{
				if( currentNumber == 0 ){
					if( ch == '=' ){
						printf("수식이 완성되지 않았음");
					}else{
						printf("수식은 숫자로 시작함.");
					}
					isRunning = 0; isNumber = 0;
				}else if( myOperator == ' ' ){
					result = currentNumber;
				}else{
					if( myOperator == '+' ){
						result = result + currentNumber;
					}else if( myOperator == '-' ){
						result = result - currentNumber;
					}else if( myOperator == '*' ){
						result = result * currentNumber;
					}else if( myOperator == '/' ){
						result = result / currentNumber;
					}
				}

				if( currentNumber == 0 ){
					
				}else if( ch == '+' ){
					myOperator = '+';
				}else if( ch == '-' ){
					myOperator = '-';
				}else if( ch == '*' ){
					myOperator = '*';
				}else if( ch == '/' ){
					myOperator = '/';
				}else{
					if( ch == '=' ){
						isRunning = 0; isNumber = 0;
						if( currentNumber == 0 ){
							printf("수식이 완성되지 않았음");
						}else{
							printf("%d", result);
						}
					}
				}

				isNumber = 0;
			}

			cnt++;
		}
	}
}
