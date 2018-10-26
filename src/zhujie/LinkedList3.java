package zhujie;

public class LinkedList3<T> {
    private Node<T> tail;
    private Node<T> head;
    public LinkedList3(){
        head = tail=null;
    }
    public static class Node<T>{
        T data;
        Node<T> next;
        Node(T data,Node<T> next){//当为中间节点的时候用此构造方法
            this.data=data;
            this.next=next;
        }
        Node(T data){  //当为头结点或尾节点的时候 使用此构造方法
            this.data=data;
            this.next=null;
        }

    }
    public void addHead(T point){   //为空链表增加头结点
        head=new Node<T>(point);
        if(tail==null){
            tail=head;
        }
    }
    public void addTail(T point){      //为链表增加尾节点
        tail=new Node<T>(point);
        head.next=tail;
    }
    public boolean insert(T point){   //插入一个中间节点　　使用头插法
        Node<T>   preNext=head.next;
        Node<T> newNode=new Node(point,preNext);
        if(head.next!=null){
            preNext=head.next;
            head.next=newNode;
            newNode.next=preNext;
        }
        return true;
    }
    public void show(){    //打印链表
        Node<T>   curr=head;
        if(isEmpty()){
            System.out.print(head.data+" ");
            curr=head.next;
        }
        else{
            System.out.println("链表错误");
            return;
        }

        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    public void delete(T data){   //删除某一节点
        Node<T> curr=head,prev=null;
        boolean b=false;
        while(curr!=null){

            if(curr.data.equals(data)){
                //判断是什么节点
                if(curr==head){   //如果删除的是头节点
                    System.out.println('\n'+"delete head node");
                    head=curr.next;
                    b=true;
                    return;
                }
                if(curr==tail){ //如果删除的是尾节点
                    System.out.println('\n'+"delete tail node");

                    tail=prev;
                    prev.next=null;

                    b=true;
                    return;
                }
                else{  //  如果删除的是中间节点（即非头节点或非尾节点）
                    System.out.println('\n'+"delete center node");
                    prev.next=curr.next;
                    b=true;
                    return;
                }

            }

            prev=curr;
            curr=curr.next;
        }
        if(b==false){
            System.out.println('\n'+"没有这个数据");
        }

    }
    public  boolean isEmpty(){    //判断链表是否为空
        if(head!=null&&tail!=null){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//LinkedList3 mylist=new LinkedList3();//构造一个空链表
        Integer[]b={0,2,4,67,8,9,11,22,33,44};
        LinkedList3<Integer> list=new LinkedList3<Integer>();

        list.addHead(5);
        list.addTail(6);
        for( int i =0; i<b.length;i++)
            list.insert(b[i]);
        list.show();
        list.delete(11);
        list.show();
        list.delete(6);
        list.show();
    }

}
