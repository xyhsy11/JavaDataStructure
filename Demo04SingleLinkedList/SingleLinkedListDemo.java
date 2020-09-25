package Demo04SingleLinkedList;

import java.util.Stack;

/**
 * @author Thomas Siyu
 * @version 1.00
 * @time 2020 2020/9/21 14:37
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) throws java.lang.NullPointerException {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "张三", "法外狂徒");
        HeroNode hero6 = new HeroNode(6, "李四", "酒肉朋友");
        HeroNode hero7 = new HeroNode(7, "李忠", "打虎将");
        HeroNode hero8 = new HeroNode(8, "呵呵", "怪气侠");


        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(hero5);
        singleLinkedList1.addByOrder(hero4);
        singleLinkedList1.addByOrder(hero6);
        singleLinkedList1.addByOrder(hero7);
        //add without order
       /* singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/
        //add with order
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero8);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        SingleLinkedList res = mergeSingleLinkedList(singleLinkedList,singleLinkedList1);
        res.show();

       /* HeroNode newHeroNode = new HeroNode(2, "小卢俊义", "小玉麒麟");
        singleLinkedList.update(newHeroNode);
       *//* singleLinkedList.del(1);
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.del(4);
*//*


        singleLinkedList.show();
        *//*System.out.println(getLength(singleLinkedList.getHead()));
        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 1));*//*
        System.out.println();
        System.out.println("After we reverse:");
        reverseList(singleLinkedList.getHead());

        singleLinkedList.show();
        System.out.println();
        System.out.println("Then, we reversePrint it, so we still can see the ordinal list, but the content remains reverse");
        reversePrint(singleLinkedList.getHead());*/


    }

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//linkList is empty that can not be printed
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static SingleLinkedList mergeSingleLinkedList(SingleLinkedList singleLinkedList1,SingleLinkedList singleLinkedList2) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode newHead = singleLinkedList.getHead();
        HeroNode head1 = singleLinkedList1.getHead();
        HeroNode head2 = singleLinkedList2.getHead();
        if(head1.next == null && head2.next == null){
            return singleLinkedList;
        }else if(head1.next == null){
            return singleLinkedList2;
        }else if(head2.next == null){
            return singleLinkedList1;
        }else{
            HeroNode temp = newHead;
            HeroNode temp1 = head1.next;
            HeroNode temp2 = head2.next;
            while(temp1 != null || temp2 != null){
                if(temp1 == null){
                    temp.next = temp2;
                    temp2 = temp2.next;
                    temp.next.next = null;
                    temp = temp.next;

                }else if(temp2 == null){
                    temp.next = temp1;
                    temp1 = temp1.next;
                    temp.next.next = null;
                    temp = temp.next;

                }else{
                    if(temp1.no < temp2.no){
                        temp.next = temp1;
                        temp1 = temp1.next;
                        temp.next.next = null;
                        temp = temp.next;

                    }else{
                        temp.next = temp2;
                        temp2 = temp2.next;
                        temp.next.next = null;
                        temp = temp.next;

                    }
                }
            }

        }

        return singleLinkedList;
    }



    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;

        }
        head.next = reverseHead.next;
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;

    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("要添加的英雄编号%d已经存在了,不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }

    }

    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点\n", no);
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    public HeroNode getHead() {
        return head;
    }
}

class HeroNode {//this class is used to construct every single hero of "Heroes of the Marshes"( Water Margin)
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    //constructor
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}



