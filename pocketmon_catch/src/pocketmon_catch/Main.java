package pocketmon_catch;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		PocketDAO podao = new PocketDAO();
		PlayDAO pldao = new PlayDAO();
		
		
		
		while(true) {
			System.out.println("즐거운 포켓몬월드 캐치!");
			System.out.print("[1]로그인 [2]회원가입 [3]랭킹보기 [4]닉네임수정 [5]회원탈퇴 [6]게임종료 ");
			int choice = sc.nextInt();
			if(choice==1) {
				System.out.print("아이디입력 : ");
				String ID = sc.next();
				System.out.print("비밀번호입력 : ");
				String PW = sc.next();
				
				UserDTO dto = new UserDTO();
				dto.setID(ID);
				dto.setPW(PW);
				
				UserDTO result = udao.login(dto);
				if(result!=null) {
					
				}
				
				
				
				
				
			}else if(choice==2) {
//				ArrayList<PlayDTO> list = pldao.ranking();
				System.out.println("랭킹\t닉네임\t점수");
				System.out.println("--------------------");
//				for(int i=0; i<list.size(); i++) {
//					System.out.println((i+1)+"위"+"\t"+list.get(i).getNICK() + "\t" + list.get(i).getSCORE());
//				}
				
				
				
				
				
			}else if(choice==3) {
				
			}else if(choice==4) {
				
			}else if(choice==5) {
				
			}else {
				System.out.println("게임이 종료되었습니다.");
				break;
			}
		}
			
	}

}
