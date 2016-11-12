package Thread_use.Publish;

import java.util.Arrays;

/**
 * Created by zzy on 2016/5/24.
 * @author zzy
 */
public class UnsafeStates {
    private String[]states=new String[]{
            "zzy","zzx","yxl"
    };

    public String[] getStates(){
        return states;
    }

    @Override
    public String toString() {
        return "UnsafeStates{" +
                "states=" + Arrays.toString(states) +
                '}';
    }
}
