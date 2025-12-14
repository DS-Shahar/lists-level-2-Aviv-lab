import java.util.*;
public class List_Homework
{
    public static void main(String[] args) 
    {
        int [] a = {1, 8, 7, 4, 8, 6, 5};
        int [] b = {1, 2, 3, 4, 5, 6, 7};
        Node<Integer> head1 = ex1_build_List(a);
        Node<Integer> head2 = ex1_build_List(b);
        System.out.println(head1);
        System.out.println(head2);
        //ex2_print_list(head1);
        //System.out.println("------------------");
        //ex2_print_list(head2);
        //ex2_print_list_recursive(head1);
        //System.out.println(ex3_only_positives());
        //ex4_print_evens(head1);
        //System.out.println(ex5_check_number(head1, 5));
        //System.out.println(ex5_check_number_tail_recursive(head1, 6));
        //System.out.println(ex6_del_first_num(head1,4));
        //System.out.println(ex7_del_by_index(head1,5));
        //System.out.println(ex8_isAllIn(head1, head2));
        //ex9_printIfInBoth(head1, head2);
        //ex10_listOfBoth(head1, head2);
        //System.out.println(ex11_delIfInBoth(head1, head2));
        //System.out.println(delMinInList(head1));
        //System.out.println(level2_ex2(head1));
        //System.out.println(level2_ex3(head1,8));
        //System.out.println(level2_ex4(head1));
        System.out.println(level2_ex5(head1));
    }
    public static Node<Integer> ex1_build_List(int [] a)
    {
        Node<Integer> p = new Node<Integer>(a[0]);
        Node<Integer> head = p;

        for (int i = 1; i < a.length; i++)
        {
            Node<Integer> x = new Node<Integer>(a[i]);
            p.setNext(x);
            p = p.getNext();
        }
        return head;
    }
    public static int sum_List(Node<Integer> head)
    {
        int a = 0;
        Node<Integer> x = head;
        while (x != null)
        {
            a += x.getValue();
            x = x.getNext();
        }
        return a;
    }
    public static void ex2_print_list(Node<Integer> head)
    {
       boolean value = true;
       while (value==true)
       {
         if (head != null)
         {
           System.out.println(head.getValue());
           head = head.getNext();
         }
         else
           value = false;
       }
    }
    public static void ex2_print_list_recursive(Node<Integer> head)
    {
        if (head != null)
        {
            System.out.println(head.getValue());
            ex2_print_list_recursive(head.getNext());
        }
        return;
    }
    public static Node<Integer> ex3_only_positives()
    {
        Node<Integer> head = new Node<Integer>(null);
        Node<Integer> p = head;
        Scanner reader = new Scanner(System.in);
        boolean b = true;
        while (b)
        {
          System.out.println("Enter a positive number ");
          int x = reader.nextInt();
          if (x!=-1)
          {
            p.setValue(x);
            p.setNext(new Node<Integer> (null));
            p= p.getNext();
          }  
          else
            b = false;
        }
        reader.close();
        return head;
    }
    public static void ex4_print_evens(Node<Integer> head)
    {
       while (head != null)
       {
         if (head.getValue()%2==0)
           System.out.println(head.getValue());
         head = head.getNext();
       }
       return;
    }
    public static boolean ex5_check_number(Node<Integer> head, int n)
    {
          boolean check = false;
            while (head != null)
            {
                if (head.getValue()==n)
                {
                   check = true;
                   return check;
                }
                head = head.getNext();
            }
            return check;
    }
    public static boolean ex5_check_number_tail_recursive(Node<Integer> head, int n)
    {
        if (head == null)
           return false;
        if (head.getValue() == n)
           return true;
        else
           return ex5_check_number_tail_recursive(head.getNext(), n);
    }
    public static Node<Integer> ex6_del_first_num(Node<Integer> p, int x)
    {
        Node<Integer> h = new Node<> (null,p);
        p=h;
        while(p.hasNext())
        {
            if (p.getNext().getValue()==x)
            {    
               p.setNext(p.getNext().getNext());
               return h.getNext();
            }   
               p=p.getNext();
        }  
        return h.getNext(); 
    }
    public static <T> Node<T> del_by_value(Node<T> p, T x)
    {
        Node<T> h = new Node<> (null,p);
        p=h;
        while(p.hasNext())
        {
            if (p.getNext().getValue().equals(x))
                 p.setNext(p.getNext().getNext());
            else 
               p=p.getNext();
        }  
        return h.getNext(); 
    }
    public static Node<Integer> ex7_del_by_index(Node<Integer> p, int x)
    {
        Node<Integer> h = new Node<> (null,p);
        p=h;
        int i=1;
        while (p.hasNext())
        {
            if(x!=i)
            {    
              i++;
              p=p.getNext();
            }
            else
            {
                p.setNext(p.getNext().getNext());
                return h.getNext();
            }  
        }
        return h.getNext();
    }
    public static <T> boolean isIn(Node<T> head, T value)
    {
        while (head != null)
        {
            if (head.getValue().equals(value))
                return true;
            head = head.getNext();
        }
        return false;
    }
    public static <T> boolean ex8_isAllIn(Node<T> head1, Node<T> head2)
    {
        if (head1==null)
            return true;
        if (!isIn(head2, head1.getValue()))   
            return false;
        return ex8_isAllIn(head1.getNext(), head2);
    }   
    public static <T> void ex9_printIfInBoth(Node<T> head1, Node<T> head2)
    {
       while (head1 != null)
       {
         if (isIn(head2, head1.getValue()))
           System.out.println(head1.getValue());
         head1 = head1.getNext();
       }
       return;
    }
    public static <T> void ex10_listOfBoth(Node<T> head1, Node<T> head2)
    {
        Node<T> head3 = new Node<T>(null);
        Node<T> head4 = head3;
        while (head1!=null)
        {
            if (isIn(head2, head1.getValue()))
            {
                head4.setNext(new Node<T> (head1.getValue())); 
                head4 = head4.getNext();
            }   
            head1=head1.getNext();
        }   
        System.out.println(head3.getNext());         
    }
    public static <T> Node<T> ex11_delIfInBoth(Node<T> head1, Node<T> head2)
    {
        while (head1.hasNext())
        {
            if (isIn(head2, head1.getValue()))
                del_by_value(head1, head1.getValue());
            head1 = head1.getNext();
        }
        return head1;
    }
    public static Node<Integer> level2_ex1(Node<Integer> head1, Node<Integer> head2)
    {
        Node<Integer> head3=new Node<Integer>(null);
        Node<Integer> head4=head3;
        while (head1!=null && head2!=null)
        {
            if (head1.getValue()<=head2.getValue())
            {
                head3.setNext(head1);
                head1=head1.getNext();
                head3=head3.getNext();
            }    
            else
            {
                head3.setNext(head2);
                head2=head2.getNext();
                head3=head3.getNext();
            }    
        }
        if (head1==null && head2!=null)   
        {
            head3.setNext(head2);
            head2=head2.getNext();
            head3=head3.getNext();
        }
        if (head1!=null && head2==null)   
        {
            head3.setNext(head1);
            head1=head1.getNext();
            head3=head3.getNext();
        }  
        return head4;       
    }
    public static Node<Integer> level2_ex2(Node<Integer> head1)
    {
        Node<Integer> dummy = new Node<Integer>(null);
        Node<Integer> tail = dummy;
        while (head1 != null)
        {
            int min = head1.getValue();
            Node<Integer> p = head1.getNext();
            while (p != null)
            {
                if (p.getValue() < min) min = p.getValue();
                p = p.getNext();
            }
            tail.setNext(new Node<Integer>(min));
            tail = tail.getNext();
            head1 = ex6_del_first_num(head1, min);
        }
        return dummy.getNext();
    }
    public static int delMinInList(Node<Integer> head1)
    {
        Node<Integer> head2 = head1;
        int x=head1.getValue();
        while (head2.hasNext())
        {
            if (x>head2.getNext().getValue())
                x=head2.getNext().getValue();
            head2=head2.getNext();
        }
        ex6_del_first_num(head1, x);
        return x;   
    }
    public static int level2_ex3(Node<Integer> head1, int x)
    {
        Node<Integer> saver = new Node<Integer>(null);
        Node<Integer> cur = head1;
        int start=0;
        int end=0;
        while (cur!=null)
        {
           if (cur.getValue()==x) 
               break; 
           start++;
           cur=cur.getNext();
        }
        cur=head1;
        while (cur!=null)
        {
            if (cur.getValue()==x)
                saver=cur;
            cur=cur.getNext();
        }
        cur=saver;
        while (cur.getNext()!=null)
        {
            end++;
            cur=cur.getNext();
        }

        if (saver.getValue()==null)
            return -1;
        return start+end;
    }
    public static <T> boolean level2_ex4(Node<T> head1)
    {
       int x=0;
       Node<T> dummy=head1;
       Node<T> dummy2=head1;
       while (dummy!=null)
       {
          x++;
          dummy=dummy.getNext();
       }
       dummy=head1;
       for (int i=0; i<x; i++)
       {
           for (int j=0; j<x; j++)
           {
              if (j!=i)
              {
                  if (dummy.getValue().equals(dummy2.getValue()))
                    return false;
              }
              dummy2=dummy2.getNext();  
           }
           dummy=dummy.getNext(); 
           dummy2=head1;
       }   
       return true;
    }
    public static <T> Node<T> level2_ex5(Node<T> head1)
    {
       Node<T> dummy1 = head1;
       Node<T> dummy2 = new Node<T>(null);
       Node<T> dummy3 = dummy2;
       while (dummy1!=null) 
       {
          if (!isIn(dummy1.getNext(), dummy1.getValue()))
          {
            dummy2.setNext(new Node<T>(dummy1.getValue()));
            dummy2=dummy2.getNext();
          }
          dummy1=dummy1.getNext();
       } 
       return dummy3.getNext();
    }
}
