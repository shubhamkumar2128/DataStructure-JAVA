import java.util.Scanner;

class ListNode{
		 int data;
		 ListNode next;
		public ListNode(int data){
		this.data=data;
	    this.next=null;}
	}

public class Circuler_Singly_link_List
{
	static ListNode last,first;
	static Scanner in;
	int value,length;
	
	public Circuler_Singly_link_List()
	{
		last=null;
		length=0;	
	}
	
	int listCount()
	{
		int count=1;
		ListNode curr=first;
		while(curr!=last)
		{
			curr=curr.next;
			count++;
		}
		return count;
	}
	
	void insertBegning()
	{
		System.out.print("Enter value = ");
		value=in.nextInt();
		ListNode newNode=new ListNode(value);
		if(last==null)
		{
			first=newNode;
			newNode.next=first;
			last=newNode;
			return;
		}
		newNode.next=last.next;
		last.next=newNode;
		first=newNode;
	}
	
	void deleteFromEnd()
	{
		if(last==first)
		{
			try
			{
				first=last=null;
			}catch(NullPointerException npl)
			{
				System.out.println("Empty list");
			}
		}		
		if(last!=null)
		{
			int c=1;
			ListNode curr=first;
			while(curr.next!=last)
			{
				curr=curr.next;
				c++;
			}
			curr.next=curr.next.next;
			last=curr;
		}
		else
			System.out.println("Empty list");
	}
	
	
	void deleteFromBegning()
	{
		if(last==first)
		{
			try
			{
				first=last=null;
			}catch(NullPointerException npl)
			{
				System.out.println("Empty list");
			}
			return;
		}
		if(last.next!=null)
		{
			last.next=last.next.next;
			first=last.next;
		}
		else
			System.out.println("Empty list");
	}
	
	void deleteFromNthPlace()
	{
		if(last!=null)
		{
			System.out.print("Enter position = ");
			int pos=in.nextInt();
			int count=1;
			if (pos==1)
			{
				deleteFromBegning();
				return;
			}		
			if(pos==listCount())
			{
				deleteFromEnd();
				return;
			}
			ListNode curr=first;
			while(count<pos-1)
				{
					curr=curr.next;	
					count++;
				}
				curr.next=curr.next.next;
		}
	}
	
	void insertAtNthPlace()
	{
		if(last!=null)
		{			
		System.out.print("Enter position = ");
		int pos=in.nextInt();
		int count=1;
		
		if (pos==1)
		{
		insertBegning();
		return;
		}
		System.out.print("Enter value : ");
		value=in.nextInt();
		ListNode newnode=new ListNode(value);
		ListNode curr=first;
		while(count<pos-1)
		{
			curr=curr.next;	
			count++;
		}
		newnode.next=curr.next;
		curr.next=newnode;
	}
	else
		System.out.println("Empty list");
	}
	
	
	void insertEnd()
	{
		System.out.print("Enter value = ");
		value=in.nextInt();
		ListNode newNode=new ListNode(value);
		if(last==null)
		{
			first=newNode;
			newNode.next=first;
			last=newNode;
			return;
		}
		newNode.next=first;
		last.next=newNode;
		last=newNode;
		
	}
	
	
	public void addNode()
	{
		System.out.print("Enter value = ");
		value=in.nextInt();
		ListNode newNode=new ListNode(value);
		if(last==null)
		{
			first=newNode;
			newNode.next=first;
			last=newNode;
			return;
		}
		last.next=newNode;
		newNode.next=first;
		last=newNode;
	}
	
	void display()
	{
		if(last==null)
		{
				System.out.print("Empty List");
			return;
		}
		ListNode temp=first;
		while(temp!=last)
		{
					System.out.print("|"+temp.data+"| -> ");
					temp=temp.next;
		}
		System.out.print("|"+temp.data+"| ->");
	}
	
	
	public static void main(String [] ds)
	{		
	Circuler_Singly_link_List  csll=new Circuler_Singly_link_List();	
	while(true)
	{
		System.out.print("Circuler_Singly_link_List list operations : \n1 . Add\n2 . Add on beginning\n3 . Add at End\n4 . Add at nth place\n5 . Delete form n'th place\n6 . Delete from end\n7 . Delete from beginning\n0 . Display\nSelect = ");	
		in=new Scanner(System.in);
		int ch=in.nextInt();
		switch(ch)
		{
			case 1:
				csll.addNode();
				csll.display();
				System.out.print("NULL\n");
				//System.out.println(csll.listCount());
				break;
			case 2:
				csll.insertBegning();
					csll.display();
						//System.out.println(csll.listCount());
				break;
			case 3:
				csll.insertEnd();
					csll.display();
						//System.out.println(csll.listCount());
				break;
			case 4:
				csll.insertAtNthPlace();
					csll.display();
					//System.out.println(csll.listCount());
				break;	
			case 5:
				csll.deleteFromNthPlace();
					csll.display();
					//System.out.println(csll.listCount());
				break;	
			case 6:
				csll.deleteFromEnd();
					csll.display();
					//System.out.println(csll.listCount());
				break;	
			case 7:
				csll.deleteFromBegning();
				csll.display();
				//System.out.println(csll.listCount());
				break;	
			case 0:
				csll.display();
			
		}
	}
	}
}