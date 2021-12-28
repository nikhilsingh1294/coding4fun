#include<stdio.h>
#include<stdlib.h>
int main()
{
	int i,j,s,space1,sctr1,space2,sctr2;

while(1)
{
	space1=13 ,sctr1=15,space2=12,sctr2=17;
	
	/*Smaller Heart*/
	system("cls");
	
	for(i=1;i<=8;i++)
	{
		if(i>=7&&i<=8)
		{
			for(s=1;s<=12;s++)
			printf(" ");
				
			printf("*");
				
			for(s=1;s<=17;s++)
			printf(" ");
				
			printf("*");
			printf("\n");
		}
		else
		{
			if(i==1||i==2||i==3)
			printf("\n");
			
			else
			{
				if(i==4)
				{
					for(s=1;s<=14;s++)
					printf(" ");
						
					for(j=1;j<=15;j++)
					{
						if(j==7||j==8||j==9)
						printf(" ");
						else
						printf("*");
					}
						printf("\n");
				}
				
				if(i==5)
				{
					for(s=1;s<=13;s++)
					printf(" ");
						
					for(j=1;j<=19;j++)
					{
						if(j==1||j==8||j==10||j==17)
						printf("*");
						
						else
						printf(" ");
					}
						printf("\n");
				}
				
				if(i==6)
				{
					for(s=1;s<=12;s++)
					printf(" ");
					
					for(j=1;j<=19;j++)
					{
						if(j==1||j==10||j==19)
						printf("*");
						
						else
						printf(" ");
					}
					printf("\n");
				}
			}
		}
	}	
	
	for(i=1;i<=9;i++)
	{
		for(s=1;s<=space1;s++)
		printf(" ");
		space1++;
		
		if(i==9)
		printf("*");
		else
		{
			printf("*");
			
			for(s=1;s<=sctr1;s++)
			printf(" ");
			printf("*");
			sctr1-=2;
			printf("\n");
		}
	}
	
	sleep(1); 
	
	/*Bigger Heart*/
	
	system("cls");
	
	for(i=1;i<=8;i++)
	{
		if(i>=7&&i<=8)
		{
			for(s=1;s<=11;s++)
			printf(" ");
			printf("*");
			for(s=1;s<=19;s++)
			printf(" ");
			printf("*");
			printf("\n");
		}
		else
		{
			if(i==1||i==2)
			printf("\n");
			else
			{
				if(i==3)
				{
					for(s=1;s<=14;s++)
					printf(" ");
					for(j=1;j<=15;j++)
					{
						if(j==7||j==8||j==9)
						printf(" ");
						else
						printf("*");
					}
				printf("\n");
				}
				
				if(i==4)
				{
					for(s=1;s<=13;s++)
					printf(" ");
					for(j=1;j<=17;j++)
					{
						if(j==1||j==8||j==10||j==17)
						printf("*");
						else
						printf(" ");
					}
				printf("\n");
				}
				
				if(i==5)
				{
					for(s=1;s<=12;s++)
					printf(" ");
					for(j=1;j<=19;j++)
					{
						if(j==1||j==10||j==19)
						printf("*");
						else
						printf(" ");
					}
				printf("\n");
				}
				
				if(i==6)
				{
					for(s=1;s<=11;s++)
					printf(" ");
					for(j=1;j<=21;j++)
					{
						if(j==1||j==21)
						printf("*");
						else
						printf(" ");
					}
				printf("\n");
				}
			}
		}
	}	
	

	for(i=1;i<=10;i++)
	{
		for(s=1;s<=space2;s++)
		printf(" ");
		space2++;
		
		if(i==10)
		printf("*");
		else
		{
			printf("*");
			for(s=1;s<=sctr2;s++)
			printf(" ");
			printf("*");
			sctr2-=2;
			printf("\n");
		}
	}
	//sleep(1);
}
	return 1;
}
