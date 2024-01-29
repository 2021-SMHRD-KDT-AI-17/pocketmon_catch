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
	
	

}
