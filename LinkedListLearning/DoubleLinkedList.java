package LinkedListLearning;

public class DoubleLinkedList {

  /**
   * Node
   */
  public static class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  public void addFirst(int data) {
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }

  public int removeFirst() {
    if (head == null) {
      System.out.println("null");
      return Integer.MIN_VALUE;
    }

    if (size == 1) {
      int val = head.data;
      head = tail = null;
      size--;
      return val;
    }

    int val = head.data;
    head = head.next;
    head.prev = null;
    size--;
    return val;
  }

  public void reverseLinkList() {
    Node curr = head;
    Node prev = null;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      curr.prev = next;
      prev = curr;
      curr = next;
    }

    head = prev;
  }

  public void print() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " <=> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    DoubleLinkedList dll = new DoubleLinkedList();
    dll.addFirst(1);
    dll.addFirst(2);
    dll.addFirst(3);
    // dll.reverseLinkList();
    dll.print();
  }
}
