package pocketmon_catch;

import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class PockBattle {
	
	
	BgmDAO bgm = new BgmDAO();
	private String PM_NAME;
	private int PM_HP;

	
	public PockBattle(String pM_NAME, int pM_HP) {
		PM_NAME = pM_NAME;
		PM_HP = pM_HP;
	}

	public String getPM_NAME() {
		return PM_NAME;
	}

	public int getPM_HP() {
		return PM_HP;
	}

	public void atk() {
		PM_HP = PM_HP - 10;
	}
	
	public void run(int chance, int heart) {
//		int chance = 4;
//		System.out.print("정말로 도망가시겠습니까?  [1]도망간다 [2]계속 이어간다 >> ");  메인문에
		Scanner ans = new Scanner(System.in);

		System.out.println("도망가기를 선택 하셨습니다.");
		System.out.print("정말로 도망가시겠습니까?  [1]도망간다 [2]계속 이어간다 >> ");
		int answer = ans.nextInt();

		if (answer == 1) {
			System.out.println("포켓몬한테서 도망쳤다...");
			System.out.println("남은 도망가기 기회 : " + (chance - 1) + "회 / 4회");
			chance -= 1;

			if (chance == 0) {
				System.out.println("도망 기회를 모두 소진하여 목숨이 하나 차감됩니다!");
				heart -= 1;
				System.out.println("남은 목숨 : " + heart + "번");

//				System.out.print("목숨이 하나 차감되었습니다... 계속 진행하시겠습니까??  [1]이어간다 [2]게임종료  >> ");
//				int answer2 = ans.nextInt();
//				if (answer == 2)
//					break;

				// 도망기회 초기화
				chance = 4;
			}
		}

	}
	

}
