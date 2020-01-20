public class LinkedListDeque<T> {
    private DNode sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new DNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    private class DNode {
        private T item;
        private DNode prev;
        private DNode next;

        DNode(T x, DNode p, DNode n) {
            item = x;
            prev = p;
            next = n;
        }
    }

    public void addFirst(T item) {
        size += 1;
        if (sentinel.next != sentinel) {
            DNode p = sentinel.next;
            p.prev = new DNode(item, sentinel, p);
            sentinel.next = p.prev;
        } else {
            sentinel.next = new DNode(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        }
    }

    public void addLast(T item) {
        size += 1;
        if (sentinel.prev != sentinel) {
            DNode p = sentinel.prev;
            p.next = new DNode(item, p, sentinel);
            sentinel.prev = p.next;
        } else {
            sentinel.next = new DNode(item, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        }
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel && sentinel.prev == sentinel;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println("");
    }

    public T removeFirst() {
        if (sentinel.next != sentinel) {
            size -= 1;
            DNode p = sentinel.next;
            T x = p.item;
            if (p.next != sentinel) {
                sentinel.next = p.next;
                p.next.prev = sentinel;
                return x;
            } else {
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
                return null;
            }
        }
        return null;
    }

    public T removeLast() {
        if (sentinel.prev != sentinel) {
            size -= 1;
            DNode p = sentinel.prev;
            T x = p.item;
            if (p.prev != sentinel) {
                sentinel.prev = p.prev;
                p.prev.next = sentinel;
                return x;
            } else {
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
                return null;
            }
        }
        return null;
    }

    public T get(int index) {
        DNode p = sentinel;
        if (p.next == sentinel) {
            return null;
        }
        for (int n = 0; n < index + 1; n++) {
            if (p.next != sentinel) {
                p = p.next;
            } else {
                return null;
            }
        }
        return p.item;
    }

    private T getRecursive(int index, DNode p) {
        if (p.next == sentinel) {
            return null;
        }
        if (index == 0) {
            return p.next.item;
        }
        return getRecursive(index - 1, p.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel);
    }
}
