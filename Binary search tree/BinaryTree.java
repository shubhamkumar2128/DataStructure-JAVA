import java.util.Scanner;

class Node
{
	public int data;
	public Node left,right;
	public Node(int data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}

public class BinaryTree
{
	 Scanner in;
	 Node root;
	int sum=0;
	
	Node leafNodes(Node temp)
	{
		 if(temp==null)
		{
			return null;
		}
	    leafNodes(temp.left);
        leafNodes(temp.right); 
			if(temp.left==null && temp.right==null)
			{
				System.out.print(temp.data+" ");
			}
			return temp;
	
	}
	
	 int sumOfAllNodes(Node temp)
	 {
	 if (temp == null) {
		return 0; }
        sumOfAllNodes(temp.left);
       sum=sum+temp.data;
     sumOfAllNodes(temp.right); 
	return sum;
	 }
	 	 
	 void parentNode(Node temp,int val)
	 {
		  if(temp==null )
		{
			 return ;
		}
		Node p=null;
		while(temp!=null)
		{
			if(val>temp.data)
			{
				p=temp;
				temp=temp.right;
			}
			else if(val<temp.data)
			{
				p=temp;
				temp=temp.left;
			}
			else
			{
					break;
			}
		}
		System.out.print("Parent -  "+p.data);
	 }
	 
	void insert()
	{
		System.out.print("Enter value = ");
		int value=in.nextInt();
		root=insertNode(root,value);
	}
	
	Node insertNode(Node temp,int val)
	{
		if(temp==null)
		{
			temp=new Node(val);
		    return temp;
		}
		if(val>temp.data)
			temp.right=insertNode(temp.right,val);
		else if(val<temp.data)
			temp.left=insertNode(temp.left,val);
		return temp;
	}

  Node deleteNode(Node temp,int val)
  {
	  if(temp==null)
		{
			return null;
		}
		if(val>temp.data)
			temp.right=deleteNode(temp.right,val);
		else if(val<temp.data)
			temp.left=deleteNode(temp.left,val);
		else{
			if(temp.left==null && temp.right==null)
			{
				temp=null;
			}
			else if(temp.right==null)
			{
				Node t1=temp;
				temp=temp.left;
			}
			else if(temp.left==null)
			{
				Node t1=temp;
				temp=temp.right;
			}
			else 
			{
				temp.data = minValue(temp.right); 
                temp.right = deleteNode(temp.right, temp.data); 
			}
		}
		return temp;
  }
  
  int minValue(Node root) 
    { 
        int minv = root.data; 
        while (root.left != null) 
        { 
            minv = root.left.data; 
            root = root.left; 
        } 
        return minv; 
    } 
 
 void printPostorder(Node node) 
    { 
        if (node == null) {
		return; }
        printPostorder(node.left);
        printPostorder(node.right); 
		System.out.print(node.data + " ");
    } 


 void printPreorder(Node node) 
    { 
      if (node == null) {
		return; }
		System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right); 
    } 
	
  void printInorder(Node node) 
    { 
        if (node == null) {
		return; }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right); 
    } 
	
	void searchNode(Node temp,int val)
	{
		 if(temp==null )
		{
			 return ;
		}
		Node p=null;
		while(temp!=null)
		{
		if(val>temp.data)
			temp=temp.right;
		else if(val<temp.data)
			temp=temp.left;
		else
		{
				System.out.print("element found ");
			return;
		}
		}
		System.out.print("element not found ");
	}
	int heightOfNodes(Node temp)
	{
		if(temp==null)
			return -1;
		int lside=heightOfNodes(temp.left);
		int rside=heightOfNodes(temp.right);
		if(lside>rside)
			 return (lside+1); 
		else
			 return (rside + 1); 
	}
	
	void printAtGivenLevel(Node temp,int level)
	{
	if(temp==null)
		return ;
	if(level==1){
		System.out.print(" "+temp.data);
		return;}
		printAtGivenLevel(temp.left,level-1);
		printAtGivenLevel(temp.right,level-1);
	}
	
	void printLevelOrder(Node temp)
	{
		if (temp==null)
			 return;
		 int height=heightOfNodes(temp);
		 for (int i=0;i<=height;i++)
		 {
			 printAtGivenLevel(temp,i+1);
			 System.out.println();
			 
		 }
	}
	
	void start()
	{
		in = new Scanner(System.in);
		while(true)
		{
			 System.out.println();
		System.out.print("1 . Insert\n2 . Inorder\n3 . Preorder \n4 . Postorder\n5 . Delete\n6 . Search\n7 . Parent node of given value\n8 . Sum of all nodes\n9 . Find leaf nodes\n10 . Height of tree\n11 . Level order traversing\n12 . Print element at given level\nSelect --> ");
		int choice=in.nextInt();
		int value=0;
		switch(choice)
		{
			case 1:
			insert();
			break;
			case 2:
			printInorder(root);
			break;
			case 3:
			printPreorder(root);
			break;
			case 4:
			printPostorder(root);
			break;
			case 5:
			System.out.print("Enter value = ");
		    value=in.nextInt();
			deleteNode(root,value);
			break;
			case 6:
			System.out.print("Enter value = ");
		    value=in.nextInt();
			searchNode(root,value);
			break;
			case 7:
			System.out.print("Enter value = ");
		    value=in.nextInt();
			parentNode(root,value);
			break;
			case 8:
			sum=0;
			System.out.print(sumOfAllNodes(root));
			break;
			case 9:
			leafNodes(root);
			break;
			case 10:
			System.out.print(heightOfNodes(root));
			break;
			case 11:
			printLevelOrder(root);
			break;
			case 12:
			System.out.print("Enter level = ");
			value=in.nextInt();
			printAtGivenLevel(root,value);
			break;
			
			default:
			 System.out.println("Invalid choice");
		}
		}
	}
	
	
	public static void main(String [] df)
	{
		BinaryTree bt=new BinaryTree();
		bt.start();
	}
}