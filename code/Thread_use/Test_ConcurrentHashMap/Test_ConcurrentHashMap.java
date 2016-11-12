package Thread_use.Test_ConcurrentHashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by john on 2016/5/15.
 * >>>n
 就是每一位都向右移动n位
 会溢出的就补到最左边
 */
public class Test_ConcurrentHashMap {
    LinkedList linkedList=new LinkedList();
    HashMap hashMap=new HashMap();
    ConcurrentHashMap zzy=new ConcurrentHashMap();
    CopyOnWriteArrayList zzx=new CopyOnWriteArrayList();
    // Positional Access Operations
}

/** Positional Access Operations
        private E get(Object[] a, int index) {
            return (E) a[index];
        }

        public E get(int index) {
            return get(getArray(), index);
        }


 public E set(int index, E element) {
     final ReentrantLock lock = this.lock;
     lock.lock();
     try {
     Object[] elements = getArray();
     E oldValue = get(elements, index);

    if (oldValue != element) {
        int len = elements.length;
        Object[] newElements = Arrays.copyOf(elements, len);
        newElements[index] = element;
        setArray(newElements);
    } else {
         // Not quite a no-op; ensures volatile write semantics
         setArray(elements);
    }
         return oldValue;
     } finally {
          lock.unlock();
     }
 }



 public boolean add(E e) {
      final ReentrantLock lock = this.lock;
      lock.lock();
      try {
         Object[] elements = getArray();
         int len = elements.length;
         Object[] newElements = Arrays.copyOf(elements, len + 1);
         newElements[len] = e;
         setArray(newElements);
         return true;
      } finally {
           lock.unlock();
      }
 }



 public E remove(int index) {
      final ReentrantLock lock = this.lock;
      lock.lock();
      try {
          Object[] elements = getArray();
          int len = elements.length;
          E oldValue = get(elements, index);
          int numMoved = len - index - 1;
          if (numMoved == 0)
              setArray(Arrays.copyOf(elements, len - 1));
          else {
              Object[] newElements = new Object[len - 1];
              System.arraycopy(elements, 0, newElements, 0, index);
              System.arraycopy(elements, index + 1, newElements, index,
              numMoved);
              setArray(newElements);
          }
          return oldValue;
      } finally {
           lock.unlock();
      }
 }


 public boolean remove(Object o) {
       Object[] snapshot = getArray();
       int index = indexOf(o, snapshot, 0, snapshot.length);
       return (index < 0) ? false : remove(o, snapshot, index);
 }

 **/
