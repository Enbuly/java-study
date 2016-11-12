package Data_Structure;

/**
 * Created by john on 2016/9/11.
 * @author zzy
 * binary heap
 */
public class Binary_Heap{
    private static final int DEFAULT_CAPACITY=10;
    private int currentSize;// Number of elements in heap
    private int[] array;// The heap array

    public Binary_Heap() {
        array=new int[DEFAULT_CAPACITY];
    }

    public Binary_Heap(int capacity) {
        array=new int[capacity];
    }

    public Binary_Heap(int[]items) {
        int i=1;
        currentSize=items.length;
        array=new int[currentSize*2+1];
        for(int item:items)
            array[i++]=item;
        buildHeap();
    }

    private void buildHeap() {
        for(int i=currentSize/2;i>0;i--)
            percolateDome(i);
    }

    private void percolateDome(int hole) {
        int child;
        int tmp=array[hole];
        for(;hole*2<=currentSize;hole=child) {
            child=hole*2;
            if(child!=currentSize && array[child+1]<(array[child]))
                child++;
            if(array[child]<tmp)
                array[hole]=array[child];
            else
                break;
        }
        array[hole]=tmp;
    }

    public void insert(int x) {
        if(currentSize==array.length-1)
            enlargeArray(array.length*2+1);
        int hole=++currentSize;
        for(;hole>1 && x<array[hole/2];hole=hole/2)
            array[hole]=array[hole/2];
        array[hole]=x;
    }

    private void enlargeArray(int Newcapacity){
        int[]copy=array;
        array=new int[Newcapacity];
        for (int i=0;i<copy.length;i++)
            array[i]=copy[i];
    }

    public int deleteMin() {
        if(isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int minItem=findMin();
        array[1]=array[currentSize--];
        percolateDome(1);
        return minItem;
    }

    private int findMin() {
        return array[1];
    }

    private boolean isEmpty() {
        return currentSize==0;
    }

    public void makeEmpty() {
        array=new int[DEFAULT_CAPACITY];
        currentSize=0;
    }

}
