/**
 * Ali Sbeih 3/4/2022
 * An implementation of an interface representing
 * an unordered set of objects of type E.
 */
public class LinkedSimpleUSet<E> implements SimpleUSet<E> {
        //The current size of the list
        private int size = 0;

        //The first node in the list (or null if the list is empty).
        private Node<E> head = null;
        //The last node in the list (or null if the list is empty).
        private Node<E> tail = null;

    // return the size of the set
            @Override
    public int size(){
        return this.size;
    }

  //   Determine if the SimpleUSet is empty
          @Override
  public boolean isEmpty(){
      return head == null;
  }

    /**
     * Find an element equal to x in the set. If such an element y
     * satisfying x.equals(y) is found, return it. Otherwise return null.
     * This method does not change the state of the set.
     */
    @Override
    public E find(E x){
              Node<E> cur = head;
           for (int i = 0; i < size; ++i) {
               if(cur.value.equals(x)) return x;
               cur = cur.next;
            }
            return null;
        }

    /**
     * Add a new element to the set. This method first checks if
     * the set already contains an element y that is
     * equal to the element x being added. If no such
     * element is found then x is added to the set, and
     * the value true is returned. If such an element
     * y is found, then the set is not modified and the
     * method returns false
     */
    public boolean add(E x) {
            Node<E> cur = head;
            for (int i = 0; i < size; ++i) {
                if(cur.value.equals(x)) return false;
                cur = cur.next;
        }
        // make a new Node to store x
        Node<E> nd = new Node<E>();
        nd.value = x;

        if ( isEmpty() == true) {
            // if we are adding at index 0, the newly added item is
            // stored at the head
          //  nd.next = this.head;
          //  nd.previous = this.tail;
            this.head = nd;
            this.tail = nd;

        } else {
        //    Node<E> pred = tail;
            tail.next = nd;
            nd.previous = tail;
            tail=nd;

        }

        ++size;
        return true;
    }


    /**
     * Remove an element equal to x from the
     * set. Specifically, if the set contains an element
     * y satisfying x.equals(y), then
     * y is removed from the set and returned. Otherwise,
     * the method returns the value null
     */
    @Override
    public E remove(E x){
        Node<E> cur = head;
        for (int i = 0; i < size; ++i) {
            if (cur.value.equals(x)) {
                if (i == 0) {
              //      if (cur.value.equals(x)) {
                        // upon removing the head node, update the head
               //         E value = x;
                        head = head.next;
                 //       --size;
                //        return value;
             //       }
                } else if (i == size - 1) {
                   // if (cur.value.equals(x)) {
                        // upon removing the tail node, update the tail
                     //   E value = x;
                        tail = tail.previous;
                     //   --size;
                      //  return value;
                  //  }
                } else {//if (cur.value.equals(x)) {
                    Node<E> pred = cur.previous;
                    Node<E> succ = cur.next;
                    //   E value = x;
                    pred.next = succ;
                    succ.previous = pred;
                 //   --size;
                  //  return value;
                }
                --size;
                return x;
            }
            cur = cur.next;
        }
        return null;
        }



        /**
         * An inner class representing a node in the linked list. Each
         * node stores a reference to an element as well as a reference
         * to the next and previous nodes in the list.
         */
        private class Node<E> {
            Node<E> next;
            Node<E> previous;
            E value;
        }
    }


