package pocketmon_catch;



import javazoom.jl.player.MP3Player;

public class BgmDAO {
	
	MP3Player mp3 = new MP3Player();
	
	
	public void ostPlay() {
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\PK_BGM\\";
		BgmDTO ost = new BgmDTO(defaultPath+"PK_OST.MP3");
		mp3.play(ost.getPath());
	}
	public void ohbakPlay() {
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\PK_BGM\\";
		BgmDTO ohbak = new BgmDTO(defaultPath+"ohbak.MP3");
		
		mp3.play(ohbak.getPath());
	}
	public void movingPlay() {
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\PK_BGM\\";
		BgmDTO ohbak = new BgmDTO(defaultPath+"moving.MP3");
		
		mp3.play(ohbak.getPath());
	}
	public void monsterBallPlay() {
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\PK_BGM\\";
		BgmDTO monsterBall = new BgmDTO(defaultPath+"Monsterball.MP3");
		
		mp3.play(monsterBall.getPath());
	}
	public void getPlay() {
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\PK_BGM\\";
		BgmDTO get = new BgmDTO(defaultPath+"getPM.MP3");
		
		mp3.play(get.getPath());
	}
	public void battlePlay() {
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\PK_BGM\\";
		BgmDTO battle = new BgmDTO(defaultPath+"battle.MP3");
		
		mp3.play(battle.getPath());
	}
	
	public void bgmStop() {
		mp3.stop();
	}

}
