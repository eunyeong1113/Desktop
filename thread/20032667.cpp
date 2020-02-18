#include <windows.h>

LRESULT CALLBACK WndProc(HWND,UINT,WPARAM,LPARAM);
HINSTANCE g_hInst;
//HWND hWndMain;
LPCTSTR lpszClass=TEXT("Class");

int APIENTRY WinMain(HINSTANCE hInstance,HINSTANCE hPrevInstance
	  ,LPSTR lpszCmdParam,int nCmdShow)
{
	HWND hWnd;
	MSG Message;
	WNDCLASS WndClass;
	g_hInst=hInstance;
	
	WndClass.cbClsExtra=0;
	WndClass.cbWndExtra=0;
	WndClass.hbrBackground=(HBRUSH)GetStockObject(LTGRAY_BRUSH);
	WndClass.hCursor=LoadCursor(NULL,IDC_ARROW);
	WndClass.hIcon=LoadIcon(NULL,IDI_APPLICATION);
	WndClass.hInstance=hInstance;
	WndClass.lpfnWndProc=(WNDPROC)WndProc;
	WndClass.lpszClassName=lpszClass;
	WndClass.lpszMenuName=NULL;
	WndClass.style=CS_HREDRAW | CS_VREDRAW;
	RegisterClass(&WndClass);

	hWnd=CreateWindow(lpszClass,lpszClass,WS_OVERLAPPEDWINDOW,
		100,100,700,400,
		NULL,(HMENU)NULL,hInstance,NULL);
	ShowWindow(hWnd,nCmdShow);
//	hWndMain=hWnd;
	
	while(GetMessage(&Message,0,0,0)) {
		TranslateMessage(&Message);
		DispatchMessage(&Message);
	}
	return Message.wParam;
}

HWND hWndMain;
LONGLONG g_x;

#define ID_EDIT1 100
#define ID_EDIT2 101
#define ID_PAUSE 102

HWND hEdit1, hEdit2;

CRITICAL_SECTION crit;

char buf[1000];

typedef struct {
	int start, end, num;
} ThreadParam;

DWORD WINAPI ThreadFunc(LPVOID Param)
{
	HDC hDC;
	hDC = GetDC(hWndMain);
	char cbuf[100];
	ThreadParam *p = (ThreadParam *)Param;

	for(int i=p->start; i<=p->end; i++)
	{
		wsprintf(cbuf, "%d¹ø Thread : %d - %d : %d", p->num, p->start, p->end, i);
		TextOut(hDC, 200, 200+p->num*30, cbuf, strlen(cbuf));

		EnterCriticalSection(&crit);
		g_x+=i;
		LeaveCriticalSection(&crit);
	}

	ReleaseDC(hWndMain, hDC);
	return 0;
}

int input;
int Div;

long FAR PASCAL WndProc(HWND hWnd,UINT iMessage,WPARAM wParam,LPARAM lParam)
{
	HDC hdc;
	PAINTSTRUCT ps;
	static DWORD ThreadID;
	static HANDLE hTh[4];
	int i;

	switch(iMessage) {
	case WM_CREATE:
		InitializeCriticalSection(&crit);

		hEdit1=CreateWindow("edit", NULL, WS_CHILD | WS_VISIBLE | WS_BORDER |
			ES_AUTOHSCROLL, 15, 15, 200, 30, hWnd, (HMENU)ID_EDIT1, g_hInst, NULL);
		hEdit2=CreateWindow("edit", NULL, WS_CHILD | WS_VISIBLE | WS_BORDER |
			ES_AUTOHSCROLL, 15, 15, 200, 30, hWnd, (HMENU)ID_EDIT1, g_hInst, NULL);
		CreateWindow("button", "°è»ê", BS_PUSHBUTTON | WS_CHILD | WS_VISIBLE,
			240, 15, 100, 30, hWnd, (HMENU)ID_PAUSE, g_hInst, NULL);
		CreateWindow("static", "Thread Test", WS_CHILD | WS_VISIBLE,
			15, 330, 100, 30, hWnd, (HMENU)-1, g_hInst, NULL);
		SetFocus(hEdit1);

		return 0;

	case WM_COMMAND:
		if(HIWORD(wParam) == BN_CLICKED) {
			switch(LOWORD(wParam)) {
			case ID_PAUSE:
				ThreadParam* Params;
				g_x=0;

				GetWindowText(hEdit1, buf, 256);
				input=atoi(buf);
				Div=input/4;

				Params = (ThreadParam*)malloc(4*sizeof(ThreadParam));

				int end;

				for(i=0; i<4; i++)
				{
					(i==(3))? (end=input) : (end=(i+1)*Div);
					Params[i].start = i*Div+1;
					Params[i].end = end;
					Params[i].num = i;
					hTh[i] = CreateThread(NULL, 0, ThreadFunc, &Params[i], 0, &ThreadID);
				}
				WaitForMultipleObjects(4, hTh, TRUE, INFINITE);
				wsprintf(buf, "%I64u", g_x);
				SetWindowText(hEdit2, buf);

				break;
			}
		}

		return 0;

	case WM_PAINT:
		hdc=BeginPaint(hWnd, &ps);
		EndPaint(hWnd, &ps);
		return 0;
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	}
	return(DefWindowProc(hWnd,iMessage,wParam,lParam));
}