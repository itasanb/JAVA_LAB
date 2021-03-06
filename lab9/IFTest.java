/* Write a java program which has 
  1. A interface class for stack operations
  2. A class that implements the stack interface & creates a fixd length stack
  3. A class that implements the stack interface & creates a dynamic length stack
  4. A class that uses both the above stacks through interface reference & does the run time binding */
  
  
  
  interface IntStack{
    void push(int item);
    int pop();
    }
    
    //import java.util.Scanner;   
    
    class FixedStack implements IntStack{
      private int stck[];
      private int tos;
      FixedStack(int size)
      {
        stck=new int[size];
        tos=-1;
      }
      public void push(int item)
      {
        if(tos==stck.length-1)
        System.out.println("Stack if full");
        else
        stck[++tos]=item;
      }
      public int pop()
      {
        if(tos<0)
        {
          System.out.println("Stack underflow");
          return 0;
        }
        else
        return stck[tos--];
      }
    }
    
    class DynStack implements IntStack{
      private int stck[];
      private int tos;
      DynStack(int size)
      {
        stck=new int[size];
        tos=-1;
      }
      public void push(int item)
      {
        if(tos==stck.length-1)
        {
          int temp[]=new int[stck.length * 2];
          for(int i=0;i<stck.length;i++)
          temp[i]=stck[i];
          stck=temp;
          stck[++tos]=item;
        }
        else
        stck[++tos]=item;
      }
      public int pop()
      {
        if(tos<0)
        {
          System.out.println("Stack Underflow");
          return 0;
        }
        else
        return stck[tos--];
      }
    }
    
    class IFTest{
      public static void main(String[] args)
      {
        
        IntStack Mystack; //creating a reference to the interface variable
        //Fixed Stack
        
        /*System.out.println("Enter the size of Fixed Stack");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();*/
        
        FixedStack fs=new FixedStack(8);
        
        //pushing elements into the Fixed Stack
        Mystack=fs; //load Fixed stack
        for(int i=0;i<8;i++)
        Mystack.push(i);
        
        System.out.println("The Contents of the Fixed Stack are:");
        for(int i=0;i<8;i++)
        System.out.println(Mystack.pop());
        
        //Dynamic stack
        
        /*System.out.println("Enter the initial size of Dynamic Stack");
        //Scanner sc=new Scanner(System.in);
        int b=sc.nextInt();*/
        
        DynStack ds=new DynStack(8);
        
        //pushing elements into the Dynamic stack
        Mystack=ds; //load Dynamic stack
        for(int i=0;i<8;i++)
        Mystack.push(i);
        
        System.out.println("The contents of the Dynamic Stack are:");
        for(int i=0;i<8;i++)
        System.out.println(Mystack.pop());

      }
    }
