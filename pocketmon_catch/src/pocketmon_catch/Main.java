package pocketmon_catch;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		PocketDAO podao = new PocketDAO();
		PlayDAO pldao = new PlayDAO();
		BgmDAO bgm = new BgmDAO();

		System.out.println("즐거운 포켓몬월드 캐치!");
		System.out.println("포켓몬 월드에 오신걸 환영합니다!");
		while (true) {
			bgm.ostPlay();
			System.out.print("[1]로그인 [2]회원가입 [3]랭킹보기 [4]닉네임수정 [5]회원탈퇴 [6]게임종료 ");
			int choice = sc.nextInt();
			if (choice == 1) {

				System.out.print("아이디입력 : ");
				String ID = sc.next();
				System.out.print("비밀번호입력 : ");
				String PW = sc.next();

				UserDTO dto = new UserDTO();
				dto.setID(ID);
				dto.setPW(PW);

				UserDTO result = udao.login(dto);

				if(result!=null) {
					System.out.println("입력된 정보가 회원정보와 일치하지 않습니다.");

				}

			} else if (choice == 2) {
				System.out.print("가입할 아이디 : ");
				String joinId = sc.next();

				int result = udao.Idcheck(joinId);

				if (result == 0) {
					System.out.println("사용가능한 ID 입니다.");
				} else {
					System.out.println("중복된 ID 입니다.");
					continue;
				}

				System.out.print("가입할 비밀번호 입력 : ");
				String joinPw = sc.next();
				System.out.print("가입할 닉네임 입력 : ");
				String joinNick = sc.next();

				UserDTO dto = new UserDTO();
				dto.setID(joinId);
				dto.setPW(joinPw);
				dto.setNICK(joinNick);

				int cnt = udao.join(dto);

			} else if (choice == 3) {
				ArrayList<PlayDTO> list = pldao.ranking();
				System.out.println("랭킹\t닉네임\t점수");
				System.out.println("--------------------");
				for (int i = 0; i < list.size(); i++) {
					System.out.println((i + 1) + "위" + "\t" + list.get(i).getNICK() + "\t" + list.get(i).getSCORE());
				}

			} else if (choice == 4) {
				while (true) {
					System.out.print("수정할 닉네임 입력 : ");
					String changeNick = sc.next();

					int result = udao.Nickcheck(changeNick);

					if (result == 0) {
						System.out.print("변경 가능한 닉네임입니다. 변경하시겠습니까? [1]변경진행 [2]변경취소 >>");
						int modify = sc.nextInt();
						if (modify == 1) {
							UserDTO dto = new UserDTO();
							dto.setNICK(changeNick);
							int cnt = udao.Nchange(dto);
							break;
						}
					} else {
						System.out.println("중복된 닉네임입니다. 다시 입력해주세요.");
						continue;
					}
				}
			} else if (choice == 5) {
				System.out.print("삭제할 아이디입력:");
				String deleteId = sc.next();
				// 비밀번호 확인
				System.out.print("로그인한 비밀번호를 입력하세요 : ");
				String deletePw = sc.next();

				UserDTO dto = new UserDTO();
				dto.setID(deleteId);
				dto.setPW(deletePw);

				int cnt = udao.delete(dto);

			} else {
				bgm.bgmStop();
				System.out.println("게임이 종료되었습니다.");
				break;
			}
		}
	}
}