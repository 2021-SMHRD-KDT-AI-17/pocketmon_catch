package pocketmon_catch;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		PocketDAO podao = new PocketDAO();
		PlayDAO pldao = new PlayDAO();
		BgmDAO bgm = new BgmDAO();
		PocketASCII ascii = new PocketASCII();

		int score = 0;
		ascii.open();

		System.out.println();
		
		while (true) {
			bgm.ostPlay();
			System.out.print("[1]로그인 [2]회원가입 [3]회원탈퇴 [4]게임종료 ");
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

				if(result == null) {
					System.out.println("입력된 정보가 회원정보와 일치하지 않습니다.");
				}else {
	                while(true) {
					System.out.print("[1]게임시작 [2]게임규칙 [3]랭킹보기 [4]닉네임수정 [5]로그아웃 >> ");
					int select = sc.nextInt();
					 	if(select == 1) {
					 		bgm.bgmStop();
					 		ascii.dr();
					 		String str = "이야~ "+result.getNICK()+"아(야) 포켓몬스터의 세계에 잘왔단다!\r\n"
			                		+ "나의 이름은 오박사\r\n"
			                		+ "모두로부터는 포켓몬박사라고 존경받고 있단다\r\n"
			                		+ "이 세계에는 포켓몬스터라고 불려지는 생명체들이 도처에 살고있다\r\n"
			                		+ "사람은 포켓몬들과 정답게 지내거나\r\n"
			                		+ "함께 싸우거나 서로 도와가며 살아가고 있단다\r\n"
			                		+ "하지만 포켓몬의 비밀은 아직도 잔뜩 있다!\r\n"
			                		+ "나는 그것을 밝혀내기 위하여 매일 포켓몬의 연구를 계속하고 있다는 말이다!\r\n"
			                		+ "그럼 슬슬 너에게 포켓몬을 선택할 기회를 주겠다!\r\n"
			                		+ "피카츄, 파이리, 꼬부기 중에 선택을 할 수 있지\r\n"
			                		+ "너는 어떤 포켓몬을 선택할거니?";
			                String[] cut = str.split("");
			                
			                try {
			                    for (int i = 0; i < cut.length; i++) {
			                        System.out.print(cut[i]);
			                        Thread.sleep(50);
			                    }
			                } catch (InterruptedException e) {
			                    e.printStackTrace();
			                } 
			                System.out.println();
			                bgm.ohbakPlay();
			                
			                String choice1 = "";
			                
			                System.out.print("[1]피카츄 [2]파이리 [3]꼬부기 >> ");
			                int num = sc.nextInt();
			                
			                if (num == 1) {
			                	ascii.pika();
			                	System.out.println("피카!츄!");
			                	choice1 = "피카츄";
			                }else if (num == 2) {
			                	ascii.firi();
			                	System.out.println("파이리!");
			                	choice1 = "파이리";
			                }else {
			                	ascii.kkobugi();
			                	System.out.println("꼬북꼬북!");
			                	choice1 = "꼬부기";
			                }
			                bgm.bgmStop();
			                System.out.println(result.getNICK()+"은(는) 오박사님에게 몬스터볼 3개를 받았다!");
			                int ball = 3;
			                int heart = 3;
			                int chance = 4;
			                
			                
			                System.out.println(choice1 + "! 이제 모험을 떠나볼까?!\n"
			                		+ "모험중...\n"
			                		+ "부스럭 부스럭\n"
			                		+ "이게 무슨 소리지...?\n");
			                
			                Random rd = new Random();
			                PocketDTO[] pock = podao.showPocket();
			                
			                bgm.battlePlay();
			                int num2 = rd.nextInt(pock.length);
			                System.out.println("야생의 "+ pock[num2].getPM_NAME()+"이(가) 등장했다!!\n"
			                					+"HP : "+pock[num2].getPM_HP());
			                
			                PockBattle pb = new PockBattle(pock[num2].getPM_NAME(), pock[num2].getPM_HP());
			              
			                System.out.println(pock[num2].getPM_NAME()+"와(과) 배틀이 시작되었다!");
			                int atk1 = 3;
			                while(true) {
			                System.out.println("[1] 공격하기 \n"
			                		+ "[2] 몬스터볼 던지기\n"
			                		+ "[3] 도망가기\n"
			                		+ ">> ");
			                int choice2 = sc.nextInt();
			                
			                if (choice2 == 1) {
			                	if (atk1 == 0 ) {
			                		System.out.println("남은 공격횟수가 없습니다.");
			                	}else {
			                		System.out.println("가라! " + choice1 + "!!");
			                		pb.atk();
			                		atk1--;
			                	System.out.println("효과는 굉장했다!\n"
			                			+pock[num2].getPM_NAME() +"의 HP가 10감소했다.\n"
			                					+ "HP는 " +pb.getPM_HP()+"가 남았다!" 
			                					+ "(남은 공격횟수 :"+atk1+")");
			                	}
			                }else if (choice2 == 2) {
			                	bgm.monsterBallPlay();
			                	ascii.ballTrow();
			                	System.out.println("가라! 몬스터볼!!");
			                	try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
			                	bgm.bgmStop();
			                	
			                	int monCatch = rd.nextInt(pb.getPM_HP())+1;
			            		if(monCatch <=10) {
			            			bgm.getPlay();
			            			ascii.ball();
			            			System.out.println(pock[num2].getPM_NAME() + "(을)를 잡아냈다!!  획득 POINT : " + pb.getPM_HP());
			                    	try {
			            				Thread.sleep(2000);
			            			} catch (InterruptedException e) {
			            				e.printStackTrace();
			            			}
			                    	bgm.bgmStop();
			                    	score += pb.getPM_HP();
			                    	break;
			            		}else {
			            			System.out.println(pock[num2].getPM_NAME() + "(을)를 잡지못했다..");
			            			ball -= 1;
			            			System.out.println("( 남은 몬스터볼 개수 : "+ ball + "개 )");
			            			if(ball == 0) {
			            				System.out.println("몬스터볼을 모두 사용하여 목숨이 하나 차감됩니다!");
			            				heart -= 1;
			            				System.out.println("남은 목숨 : " + heart + "번");
			            				// 새로운 목숨을 시작할 때 볼 개수 초기화
			            				System.out.println();
			            				System.out.println("오박사님으로부터 몬스터볼 3개를 다시 받았습니다!!");
			            				ball = 3;
			            				break;
			            			}
			                
			            		}
			                	
			                }else {
			                	bgm.bgmStop();
			                }
			                
			               } 
			                
			                
					 		
					 	}else if(select == 2) {
					 		String str = "목숨은 총 3번 주어지고\n"
					 				+ "공격횟수 및 몬스터볼 횟수도 3번 주어진다.\n"
					 				+ "① 공격 시, 야생 몬스터의 HP가 10 줄어들면서\n"
					 				+ "  몬스터볼로 잡을 수 있는 확률 UP! BUT 내 포인트는 DOWN!\n"
					 				+ "② 몬스터볼로 잡으면 야생 포켓몬의 남은 HP은 모두 자신의 포인트!\n"
					 				+ "  야생 몬스터의 HP가 높을수록 잡기 어렵다\n"
					 				+ "★ 주어진 몬스터볼을 모두 사용하면 목숨 1개가 사라지니\n"
					 				+ "  공격횟수와 몬스터볼을 잘 활용해야 한다!";
					 				String[] cut = str.split("");
					                try {
					                    for (int i = 0; i < cut.length; i++) {
					                        System.out.print(cut[i]);
					                        Thread.sleep(50);
					                    }
					                } catch (InterruptedException e) {
					                    e.printStackTrace();
					                } 
					                System.out.println();
					                System.out.println();
					                
					 	
					 	}else if(select == 3) {
							ArrayList<PlayDTO> list = pldao.ranking();
							System.out.println("랭킹\t닉네임\t점수");
							System.out.println("--------------------");
							for (int i = 0; i < list.size(); i++) {
								System.out.println((i + 1) + "위" + "\t" + list.get(i).getNICK() + "\t" + list.get(i).getSCORE());
							}
					 		
					 	}else if(select == 4) {
							while (true) {
								System.out.print("수정할 닉네임 입력 : ");
								String changeNick = sc.next();

								int result1 = udao.Nickcheck(changeNick);

								if (result1 == 0) {
									System.out.print("변경 가능한 닉네임입니다. 변경하시겠습니까? [1]변경진행 [2]변경취소 >>");
									int modify = sc.nextInt();
									if (modify == 1) {
										UserDTO dto1 = new UserDTO();
										dto1.setNICK(changeNick);
										int cnt = udao.Nchange(dto1);
										break;
									}
								} else {
									System.out.println("중복된 닉네임입니다. 다시 입력해주세요.");
									continue;
								}
							}
					 	}else {
					 		System.out.println("로그아웃 되었습니다.");
					 		break;
					 	}
	                }
					
					
	                
	                
					
				}
				
				
				
				
				

			}else if(choice==2) {
				String joinId = "";
				String joinPw = "";
				String joinNick = "";
				
				
				while(true) {
			      System.out.print("가입할 아이디 : ");
			      joinId = sc.next();
			      
			      int result = udao.Idcheck(joinId);
			      
			      if(result == 0) {
			         System.out.println("사용가능한 ID 입니다.");
			         break;
			      }else {
			         System.out.println("중복된 ID 입니다.");
			         continue;
			      }
				}
				
				System.out.print("가입할 비밀번호 입력 : ");
			    joinPw = sc.next();
			      
				while(true) {
			      System.out.print("가입할 닉네임 입력 : ");
			      joinNick = sc.next();
			      
			      int result2 = udao.Nickcheck(joinNick);
			      if (result2 == 0) {
			    	  System.out.println("사용가능한 닉네임 입니다.");
						

			    	  break;
			    	  
			      } else {
			    	  System.out.println("중복된 닉네임 입니다.");
			    	  continue;
			      }
			      

				}
				
		    	  UserDTO udto = new UserDTO();
					udto.setID(joinId);
					udto.setPW(joinPw);
					udto.setNICK(joinNick);

					int cnt = udao.join(udto);  




			} else if (choice == 3) {
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