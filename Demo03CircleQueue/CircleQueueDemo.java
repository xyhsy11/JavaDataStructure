package Demo03CircleQueue;

import java.util.Scanner;

/**
 * @author Thomas Siyu
 * @version 1.00
 * @time 2020 2020/9/20 19:24
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请规定数组的长度");
        CircleQueue circleQueue = new CircleQueue(sc.nextInt());
        char key = ' ';//接受用户输入

        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加元素到队列");
            System.out.println("g(get):从队列取出元素");
            System.out.println("h(head):查看队列头的元素");
            key = sc.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showArray();
                    break;
                case 'a':
                    System.out.println("请输入");
                    circleQueue.addQueue(sc.nextInt());
                    break;
                case 'g':
                    try {
                        System.out.println("数据为" + circleQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("头数据为" + circleQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;

            }

        }
        System.out.println("系统已退出");
    }

}

class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];

    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
            return;
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法输出数据");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public void showArray() {
        if (isEmpty()) {
            System.out.println("数据为空，无法展示");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }

    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能返回");
        }
        return arr[front];
    }

}
