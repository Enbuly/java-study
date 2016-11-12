package Data_Structure;


/**
 * Created by Administrator on 2016/4/5.
 * a test for well hash
 * 01111001	121	79	y
 * 01111010	122	7A	z
 */
public class A_best_hash_example {
    public static int hash(String key,int tableSize) {
    //一个好的散列函数
        int hashVal=0;
        for(int i=0;i<key.length();i++)
            hashVal=37*hashVal+key.charAt(i);
        hashVal%=tableSize;
        if(hashVal<0)
            hashVal=hashVal+tableSize;
        return hashVal;
    }
    public static void main(String[]args){
        int zzy=hash("zzy",12);
        System.out.println(zzy);
        System.out.print(0%(-3));
    }
}
