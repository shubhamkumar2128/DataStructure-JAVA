import java.util.Scanner;

class ListNode{
		 int data;
		 ListNode next;
		public ListNode(int data){
		this.data=data;
	    this.next=null;}
	}

public class Singly_link_List
{
	static ListNode head;
	static Scanner in;
	int value;
	
	void reverse()
	{
		if(head!=null)
		{
			ListNode curr=head;
			ListNode prev=null;
			ListNode nextn=null;
			while(curr!=null)
			{
				nextn=curr.next;
				curr.next=prev;
				prev=curr;
				curr=nextn;
			}
			head=prev;
		}
		else
			System.out.println("Empty list");
	}
	
	void deleteFromNthPlace()
	{
		if(head!=null)
		{
			System.out.print("Enter position = ");
			int pos=in.nextInt();
			int count=1;
			if (pos==1)
			{
				deleteFromBegning();
				return;
			}
			ListNode curr=head;
			while(count<pos-1)
				{
					curr=curr.next;	
					count++;
				}
				curr.next=curr.next.next;
		}
	}
	
	void deleteFromBegning()
	{
		if(head!=null)
			head=head.next;
		else
			System.out.println("Empty list");
	}
	
	void deleteFromEnd()
	{
		if(head!=null)
		{
				if (listCount()==1)
				{
					head=null;
					return;
				}
			int c=1;
			ListNode curr=head;
			while(c<listCount()-1)
			{
				curr=curr.next;
				c++;
			}
			curr.next=null;
		}
		else
			System.out.println("Empty list");
	}
	
	public void addNthPlace()
	{
		if(head!=null)
		{			
		System.out.print("Enter position = ");
		int pos=in.nextInt();
		System.out.print("Enter value = ");
		value=in.nextInt();
		int count=1;
		ListNode newnode=new ListNode(value);
		if (pos==1)
		{
		newnode.next=head;
		head=newnode;
		return;
		}
		ListNode curr=head;
		while(count<pos-1)
		{
			curr=curr.next;	
			count++;
		}
		ListNode c=curr.next;
		newnode.next=c;
		curr.next=newnode;
	}
	else
		System.out.println("Empty list");
	}
	
	public void addNode()
	{
		System.out.print("Enter value = ");
		value=in.nextInt();
		ListNode ln=new ListNode(value);
		if(head==null)
		{
			head=ln;
			return;
		}
		ListNode curr=head;
		while(curr.next!=null)
		{
			curr=curr.next;
		}
		curr.next=ln;
	}

	public void insertBegning()
	{
		System.out.print("Enter value = ");
		value=in.nextInt();
		ListNode ln=new ListNode(value);
		ln.next=head;
		head=ln;
	}
	
	public void display()
	{
		ListNode current=head;
		System.out.println("******************************************************************************");
		while(current!=null)
		{
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.println("NULL");
		System.out.println("\n******************************************************************************");
	}
		
	int listCount()
	{
		int count=0;
		ListNode curr=head;
		while(curr!=null)
		{
			count+=1;
			curr=curr.next;
		}
		return count;
	}
	
	public static void main(String [] ds)
	{		
	Singly_link_List  sll=new Singly_link_List();	
	while(true)
	{
		System.out.print("Singly linked list operations : \n1 . Add\n2 . Add on beginning\n3 . Add at n'th place\n4 . Delete from beginning\n5 . Delete form n'th place\n6 . Delete from end\n7 . Reverse list\n0 . Display\nSelect = ");	
		in=new Scanner(System.in);
		int ch=in.nextInt();
		switch(ch)
		{
			case 1:
				sll.addNode();
					sll.display();
				break;
			case 2:
				sll.insertBegning();
					sll.display();
				break;
			case 3:
				sll.addNthPlace();
					sll.display();
				break;
			case 4:
				sll.deleteFromBegning();
					sll.display();
				break;	
			case 5:
				sll.deleteFromNthPlace();
					sll.display();
				break;	
			case 6:
				sll.deleteFromEnd();
					sll.display();
				break;	
			case 7:
				sll.reverse();
				sll.display();
				
				break;	
				
			case 0:
				sll.display();
			
		}
	}
	}
}