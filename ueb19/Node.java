/**
 * Node to use in linkedlist
 */
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

    /**
     * Get data of node
     */
    public T getData() {
        return data;
    }

    /**
     * Set data of node
     * @param data of node 
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * get next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * set next node
     * @param next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * get Prev node 
     * @return prev node
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Set prev node
     * @param prev node
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
    @Override
    public String toString() {
        return "Data: " + getData().toString();
    }
}
