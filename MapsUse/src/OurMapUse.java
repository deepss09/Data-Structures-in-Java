import java.util.HashMap;
import java.util.Map;

public class OurMapUse {

	public static void main(String[] args) {
		Map<String,Integer> map = new Map<>();
        for(int i=0;i<20;i++) {
        	 map.insert("abc" + i, 1+i);
        	 System.out.println("i =" + i + "lf =" +  map.LoadFactor());
        	
        }
	}

}