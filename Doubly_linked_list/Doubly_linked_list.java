import java.util.Scanner;

class ListNode{
  int data;
  ListNode prev;
  ListNode next;

  public ListNode(int data)
  {
    this.data=data;
    this.prev=null;
    this.next=null;
  }
}

public class Doubly_linked_list
{
 ListNode head; ListNode tail; int length;
 Scanner in;
 int value;
 public Doubly_linked_list()
 {
   this.head=null;   this.tail=null;   this.length=0;
 }
 public boolean isEmpty() {   return length==0; }

void addAtNthPlace()
{
  if(!isEmpty())
  {
  System.out.print("Enter position = ");
	int pos=in.nextInt();
	System.out.print("Enter value = ");
	value=in.nextInt();
  ListNode newnode=new ListNode(value);
  if (pos==1)
	{
	newnode.prev=head.prev;
	newnode.next=head;
  head.prev=newnode;
  head=newnode;
	return;
	}
  int count=1;
  ListNode temp=head;
  while(count<pos-1)
  {
    temp=temp.next;
    count++;
  }
  newnode.next=temp.next;
  temp.next.prev=newnode;
  temp.next=newnode;
  newnode.prev=temp;
  length++;
 }
 else
 {
  System.out.println("Empty list");
  return;
 }
}

void addAtbeginning()
{
  System.out.print("Enter value = ");
	value=in.nextInt();
  ListNode newnode=new ListNode(value);
  if(isEmpty())
    tail=newnode;
  else
    head.prev=newnode;
  newnode.next=head;
  head=newnode;
  length++;
}

void addNode()
{
  System.out.print("Enter value = ");
	value=in.nextInt();
  ListNode newnode=new ListNode(value);
  if(isEmpty())
    head=newnode;
  else
    tail.next=newnode;
  newnode.prev=tail;
  tail=newnode;
  length++;
}

 void displayForward()
 {
   if(head==null)
   return;
   ListNode temp=head;
   while(temp!=null)
   {
     System.out.print("|"+temp.data+"|->");
     temp=temp.next;
   }
   System.out.println("NULL");
 }

 void displayBackward()
 {
   if(tail==null)
   return;
   ListNode temp=tail;
   while(temp!=null)
   {
     System.out.print("|"+temp.data+"|->");
     temp=temp.prev;
   }
   System.out.println("NULL");
 }

 void deleteFromBegning()
 {
  if(isEmpty())
  {
    System.out.println("Empty list");
    return;
  }
  if(head!=null)
  {
    try
    {
      if(head==tail)
      {
        head=null;
        tail=null;
        return;
      }
    head=head.next;
    head.prev=null;
    }
    catch(NullPointerException nlp)
    {System.out.println(nlp.getMessage());}
  }
  length--;
 }

void deleteFromNthPlace()
{
  if(!isEmpty())
  {
  System.out.print("Enter position = ");
	int pos=in.nextInt();
  ListNode temp=head;
  int count=1;
  while(count<pos)
  {
  temp=temp.next;
  count++;
  }
  if(temp==head)
  {
    head=head.next;
    head.prev=null;
    length--;
    return;
  }
  if(temp.next==null)
  {
    tail=temp.prev;
    tail.next=null;
    length--;
    return;
  }
  temp.prev.next=temp.next;
  temp.next.prev=temp.prev;
  length--;
}
  else
      System.out.print("Empty list");
}

void deleteFromEnd()
{
  if(isEmpty())
  {
      System.out.print("Empty list");
      return;
  }
  if(tail!=null)
  {
    try
    {
      if(tail==head)
      {
        head=null;
        tail=null;
        return;
      }
    tail=tail.prev;
    tail.next=null;
    }
    catch(NullPointerException nlp)
    {System.out.println(nlp.getMessage());}
  }
  length--;
}

void totalLength(){ System.out.println("\nTotal length = "+length);}

void start()
  {
    while(true)
	  {
		System.out.print("Doubly linked list operations :\n1 . Add\n2 . Add at beginning\n3 . Add at n'th place\n4 . Delete from beginning\n5 . Delete from end\n6 . Delete form n'th place\n7 . Display Forward\n8 . Display Backward\nSelect = ");
		in=new Scanner(System.in);
		int ch=in.nextInt();
		switch(ch)
		{
			case 1:
				addNode();
				displayForward();
        totalLength();
				break;
			case 2:
				addAtbeginning();
				displayForward();
        totalLength();
				break;
			case 3:
			  addAtNthPlace();
				displayForward();
        totalLength();
				break;
			case 4:
				deleteFromBegning();
				displayForward();
        totalLength();
				break;
			case 5:
				deleteFromEnd();
				displayForward();
        totalLength();
				break;
			case 6:
				deleteFromNthPlace();
				displayForward();
        totalLength();
				break;
			case 7:
				displayForward();
        break;
      case 8:
  			displayBackward();
        break;
			default:
				 System.out.println("Invalid entry");
		}
	}
	}

  public static void main(String[] args) {
    Doubly_linked_list dll=new Doubly_linked_list();
    dll.start();
  }
}
