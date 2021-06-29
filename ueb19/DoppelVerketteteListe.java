import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Doppel verkettete liste
 */
public class DoppelVerketteteListe<E> implements List<E> {

    // Head of the list;
    private Node<E> head;

    public DoppelVerketteteListe() {
    };

    public DoppelVerketteteListe(Node<E> head) {
        this.head = head;
    }

    /**
     * Get size of doubly linked list;
     */
    @Override
    public int size() {
        int counter = 0;
        Node<E> temp = head;
        while (temp != null) {
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    /**
     * Check if doubly linked list is empty
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Check if doubly linked has object
     */
    @Override
    public boolean contains(Object o) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.getData().equals(o)){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E data = node.getData();
                node = node.getNext();
                return data;
            }
        };
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int counter = 0;

        Iterator<E> it = iterator();

        Node<E> temp = head;
        while(it.hasNext()) {
            a[counter] = (T) temp.getData();
            temp = temp.getNext();
            counter++;
            it.next();
        }

        return a;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<E>(e);
        Node<E> lastNode = head;

        if (head == null) {
            head = newNode;
            return true;
        }

        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        lastNode.setNext(newNode);
        newNode.setPrev(lastNode);
        newNode.setNext(null);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null || o == null) {
            return false;
        }

        Node<E> temp = getByObject(o);

        if (temp == null) {
            return false;
        }

        if (temp == head) {
            head = temp.getNext();
        }

        if (temp.getNext() != null) {
            temp.getNext().setPrev(temp.getPrev());
        }

        if (temp.getPrev() != null) {
            temp.getPrev().setNext(temp.getNext());
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int oldSize = size();
        for (E e : c) {
            add(e);
        }
        if (oldSize == size()) {
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public E get(int index) {
        if (index < 0)
            return null;

        int counter = 0;
        Node<E> temp = head;

        Iterator<E> it = iterator();

        while(it.hasNext()) {
            if (counter == index) {
                return temp.getData();
            }
            counter++;
            temp = temp.getNext();
            it.next();
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        int counter = 0;
        Node<E> temp = head;
        Iterator<E> it = iterator();

        while(it.hasNext()) {
            if(counter == index) {
                E prev = temp.getData();
                temp.setData(element);
                return prev;
            }
            counter++;
            temp = temp.getNext();
            it.next();
        }

        return null;
    }

    @Override
    public void add(int index, E element) {
        if(index >= size() || index < 0) {
            throw new IllegalArgumentException("Index not available");
        }
        if(index == 0) {
            pushFront(element);
            return;
        }
        if(index == size()-1) {
            add(element);
            return;
        }
        
        int counter = 0;
        Node<E> temp = head;
        Node<E> newNode = new Node<E>(element);
        Iterator<E> it = iterator();
        while(it.hasNext()) {
            if(counter == index) {
                newNode.setNext(temp);
                newNode.setPrev(temp.getPrev());
                temp.getPrev().setNext(newNode);
                temp.setPrev(newNode);
                return;
            }
            counter++;
            temp = temp.getNext();
            it.hasNext();
        }
    }

    @Override
    public E remove(int index) {
        if(index >= size() || index < 0) {
            throw new IllegalArgumentException("Index not available");
        }
        int counter = 0;
        Node<E> temp = head;
        Iterator<E> it = iterator();

        if(index == 0) {
            head = head.getNext();
            return temp.getData();
        }

        while(it.hasNext()) {
            if(counter == index) {
                temp.getPrev().setNext(temp.getNext());
                if(temp.getNext() != null) {
                    temp.getNext().setPrev(temp.getPrev());
                }
                temp.setPrev(null);
                temp.setNext(null);
                return temp.getData();
            }
            if(counter == size() - 1) {
                temp.setPrev(null);
                return temp.getData();
            }
            counter++;
            temp = temp.getNext();
            it.next();
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;
        Node<E> temp = head;
        while (temp.getNext() != null) {
            if (temp.getData() == o) {
                return counter;
            }
            counter++;
            temp = temp.getNext();
        }
        return 0;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    private boolean exists(Object o) {
        Node<E> temp = head;
        while (temp.getNext() != null) {
            if (temp.getData() == o) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    private Node<E> getByObject(Object o) {
        Node<E> temp = head;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (temp.getData().equals(o)) {
                return temp;
            }
            temp = temp.getNext();
            it.next();
        }

        return null;
    }

    
    public void pushFront(E element) {
        Node<E> newNode = new Node<E>(element);
        
        newNode.setNext(head);
        newNode.setPrev(null);

        if (head != null)
        head.setPrev(newNode);

        head = newNode;
    }
    

    @Override
    public String toString() {
        String s = "null<-->";
        if(isEmpty())
        return s;
        Node<E> temp = head;
        while(temp.getNext() != null) {
            s += "[ " + temp.getData() + " ]" + "<---->";
            temp = temp.getNext();
        }
        s += "[ " + temp.getData() + " ]" + "<---->null";
        return s;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

	public long[] toArray(int[] a) {
		return null;
	}
}