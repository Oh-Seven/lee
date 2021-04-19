package LinkedList;

import java.time.temporal.Temporal;

/**
 *  SingleList
 * @description TODO
 * @author lilei
 * @date 2021年04月15日 13:45:00
 * @version 1.0
 */
public class SingleList {

    public static void main(String[] args) {
        Node node1 = new Node(0,"tom",null);
        Node node2 = new Node(1,"tom1",null);
        Node node3 = new Node(2,"tom2",null);
        Node node4 = new Node(3,"tom3",null);
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.reverse();
        //linkedList.list();
    }

}
class SingleLinkedList{

    Node headnode = new Node(0,"",null);// 头指针
    //添加时需要找到最后一个指针
    public void add(Node node){
        Node temp = headnode;
        while(true){
            if(temp.nextNode == null){//代表当前元素就是最后一个
                break;
            }
            temp = temp.nextNode;
        }
        temp.nextNode = node;
    }

    //添加时排序
    public void addByOrder(Node node){
        Node temp = headnode;
        while(true){
            if(temp.nextNode == null){//代表当前元素就是最后一个
                break;
            }
            if(temp.nextNode.num > node.num){
                node.nextNode = temp.nextNode;
                break;
            }else if(temp.nextNode.num == node.num){ //编号重复
                break;
            }
            temp = temp.nextNode;
        }
        temp.nextNode = node;
    }

    public void list(){
        if(headnode.nextNode == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = headnode.nextNode;
        while(true){
            if(temp == null){//代表当前元素就是最后一个
                break;
            }
            System.out.println(temp);
            temp = temp.nextNode;
        }
    }

    public void reverse(){
        Node reverse = new Node(0,null,null);
        Node temp = headnode.nextNode;
        while (true){
            if(temp == null){
                System.out.println("链表为空无法reverse");
                break;
            }
            if(reverse.nextNode == null){
                Node node = new Node(temp.num,temp.name,null);
                reverse.nextNode = node;
            }else{
                Node node = reverse.nextNode;
                //reverse.nextNode = temp;
                reverse.nextNode.nextNode = node;
            }
            temp = temp.nextNode;
        }
        while(true){
            if(reverse == null){//代表当前元素就是最后一个
                break;
            }
            System.out.println(reverse);
            reverse = reverse.nextNode;
        }
    }
}

class Node{
    int num;
    String name;
    Node nextNode;

    public Node(int num, String name, Node nextNode) {
        this.num = num;
        this.name = name;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}