package pocketmon_catch;

import java.util.Random;

public class PockBattle {
	
	private String PM_NAME;
	private int PM_HP;

	
	public PockBattle(String pM_NAME, int pM_HP) {
		PM_NAME = pM_NAME;
		PM_HP = pM_HP;
	}

	public void atk(int PM_HP) {
		PM_HP = PM_HP - 10;
	}
	
	public void ballThrow(int PM_HP) {
		Random rd = new Random();
		
		int ball = rd.nextInt(PM_HP)+1;
		if(ball<=10) {
			System.out.println(PM_NAME + "(을)를 잡아냈다!!  획득 POINT : " + PM_HP);
		}else {
			System.out.println(PM_NAME + "(을)를 잡지못했다..");
		}
	}

}
