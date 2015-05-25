package org.fahai.jisuanke;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Integer input = 0;
		try {
			input = Integer.valueOf(br.readLine());
			if(input<=0 || input>50){
				System.out.println("Wrong Input!");
				return;
			}
		} catch (Exception e) {
			System.out.println("Wrong Input!");
		}
		System.out.println(palouti(input));
	}
	
	/**
	 * 假设你现在正在爬楼梯，楼梯有n级。每次你只能爬1级或者2级，那么你有多少种方法爬到楼梯的顶部？
	 * 格式：
	 *	   第一行输入一个数n(n<=50)，代表楼梯的级数。
	 *	   接下来一行输出你的方法总数。
	 * @param level
	 * @return
	 * Integer
	 */
	public static Integer palouti(Integer level){
		Integer result = 0;
		if(level==0 || level==1){
			result = 1;
		}else{
			return palouti(level-1) + palouti(level-2);
		}
		return result;
	}

}
