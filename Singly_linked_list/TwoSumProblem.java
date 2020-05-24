import java.util.Scanner;

class TwoSumProblem
{
	void solve(int arr[],int num)
	{		
			int check=0;
			for(int i=0;i<5;i++)
				for(int j=0;j<5;j++)
					if(i!=j)
						if((arr[i]+arr[j])==num)
						{
							check=1;
							 System.out.println("sum of indices value = "+i+" "+j+" gives us "+num);	
						}
			if(check==0)
				System.out.println("No indices found");	
	}
	
	void findIndex()
	{
			int arr[]=new int[5];
			Scanner in=new Scanner(System.in);
			for(int i=0;i<5;i++)
			{	System.out.print("Enter numbers = "); arr[i]=in.nextInt(); }
			System.out.print("Enter target number = ");
			int num=in.nextInt();
			for(int i=0;i<5;i++)	{	System.out.print(arr[i]+" "); }
			System.out.println();
			solve(arr,num);
	}
	
	public static void main(String [] ar)
	{
		TwoSumProblem tsm=new TwoSumProblem();
		tsm.findIndex();
	}
}