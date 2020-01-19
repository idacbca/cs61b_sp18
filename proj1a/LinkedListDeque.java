public class LinkedListDeque<T> {
    private DNode sentinel;
    private int size;

    private class DNode {
        public DNode prev;
        public T item;
        public DNode next;

        public DNode(T x, DNode p, DNode n) {
            item = x;
            prev = p;
            next = n;
        }
    }

    public void addFirst(T item) {
        size += 1;
        if (sentinel.next != null) {
            DNode p = sentinel.next;
            p.prev = new DNode(item, null, p);
            sentinel.next = p.prev;
        } else {
            sentinel.next = new DNode(item, null, null);
            sentinel.prev = sentinel.next;
        }
    }

    public void addLast(T item) {
        size += 1;
        if (sentinel.prev != null) {
            DNode p = sentinel.prev;
            p.next = new DNode(item, p, null);
            sentinel.prev = p.next;
        } else {
            sentinel.next = new DNode(item, null, null);
            sentinel.prev = sentinel.next;
        }
    }

    public boolean isEmpty() {
        if (sentinel.next == null && sentinel.prev == null) return true;
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DNode p = sentinel;
        while (p.next != null) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println("");
    }

    public T removeFirst() {
        if (sentinel.next != null) {
            size -= 1;
            DNode p = sentinel.next;
            if (p.next != null) {
                sentinel.next = p.next;
                p.next.prev = sentinel;
                return sentinel.next.item;
            } else {
                sentinel.next = null;
                sentinel.prev = null;
                return null;
            }
        }
        return null;
    }

    public T removeLast() {
        if (sentinel.prev != null) {
            size -= 1;
            DNode p = sentinel.prev;
            if (p.prev != null) {
                sentinel.prev = p.prev;
                p.prev.next = sentinel;
                return sentinel.prev.item;
            } else {
                sentinel.next = null;
                sentinel.prev = null;
                return null;
            }
        }
        return null;
    }

    public T get(int index) {
        DNode p = sentinel;
        if (p.next == null) return null;
        for (int n = 0; n < index; n++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return null;
            }
        }
        return p.item;
    }

    private T getRecursive(int index, DNode p) {
        if (p.next == null) return null;
        if (index == 0) return p.next.item;
        return getRecursive(index - 1, p.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel);
    }

    public LinkedListDeque(T item) {
        size = 1;
        sentinel = new DNode(null, null, null);
        sentinel.next = new DNode(item, null, null);
        sentinel.prev = sentinel.next;
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new DNode(null, null, null);
    }
}
