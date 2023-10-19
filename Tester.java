package Max;
import java.util.ArrayList;
public class Tester {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i<=3; i++) {
			nums.add(i);
		}
		int sum = 0;
		for(int i = 0; i<nums.size(); i++) {
			sum += new Integer(nums.get(i));
		}
		System.out.println(sum);
	}

}
