public class Node<T> {
    
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    @Override
    public String toString() {
        return "Data: " + getData().toString();
    }
}
