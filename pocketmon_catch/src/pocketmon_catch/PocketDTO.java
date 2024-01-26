package pocketmon_catch;

public class PocketDTO {

	private String PM_NAME;

	private int PM_HP;

	
	public PocketDTO(String PM_NAME, int PM_HP) {
		this.PM_NAME = PM_NAME;
		this.PM_HP = PM_HP;
	}
	
	public PocketDTO() { }

	// GETTER 설정
	public String getPM_NAME() {
		return PM_NAME;
	}

	public int getPM_HP() {
		return PM_HP;
	}

}
