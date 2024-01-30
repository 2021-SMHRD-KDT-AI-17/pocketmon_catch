# 🎇포켓몬 캐치 게임 (팀명 : 포켓몬을 JAVA조)
![PPT메인](https://github.com/2021-SMHRD-KDT-AI-17/pocketmon_catch/assets/157354042/d936b0c7-2e6f-41d4-af8d-e22ebfe9661f)
<br>

## 🙋‍♀️ 서비스 소개
* 본 게임은 주어지는 포켓몬스터를 선택하여 야생의 몬스터를 잡는 것을 중심으로
* 공격 및 몬스터볼을 던져 야생 몬스터의 남은 HP를 포인트로 누적하여 점수를 올리는 것을 목표로 한다.
<br>

## 🗓 프로젝트 기간
**2024.01.26 ~ 2024.01.30**
<br>
<br>
## 🛠 주요기능
* 회원가입
* 로그인
* 게임규칙
* 게임 (메인)
* 랭킹
* 회원탈퇴
<br>

## ⚔ 기술스택
<table>
    <tr>
        <th>구분</th>
        <th>내용</th>
    </tr>
    <tr>
        <td>사용언어</td>
        <td>
            <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>개발도구</td>
        <td>
            <img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=Eclipse&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>데이터베이스</td>
        <td>
            <img src="https://img.shields.io/badge/Oracle 11g-F80000?style=for-the-badge&logo=Oracle&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>협업도구</td>
        <td>
            <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"/>
            <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"/>
        </td>
    </tr>
</table>

<br>

## 〰 서비스 흐름도
![다이어그램](https://github.com/2021-SMHRD-KDT-AI-17/pocketmon_catch/assets/157353975/cb2063a7-2b1a-4e0c-ab60-fac1481d8e1f)
<br>

## 💡 화면구성
* 첫화면<br>

![exe파일 첫화면](https://github.com/2021-SMHRD-KDT-AI-17/pocketmon_catch/assets/157354010/09a12e09-a145-4283-8c2a-91a8379cc53d)
<br>

------------------------------------------------------------------------------------------
<br>

* 게임시작<br>

![게임시작](https://github.com/2021-SMHRD-KDT-AI-17/pocketmon_catch/assets/157354010/b4d8f6da-e3b3-4a92-b529-4d16ea9f5551)
<br>

------------------------------------------------------------------------------------------
<br>

* 게임진행<br>

![게임진행](https://github.com/2021-SMHRD-KDT-AI-17/pocketmon_catch/assets/157354010/f9912607-2cb1-4a9c-8bef-eb21a542ae33) 
<br>

------------------------------------------------------------------------------------------
<br>

* 게임오버<br>

![게임오버](https://github.com/2021-SMHRD-KDT-AI-17/pocketmon_catch/assets/157354010/10dcae19-088f-4185-af2c-537762ae35ca)
<br>

------------------------------------------------------------------------------------------
<br>

* 닉네임 변경<br>

![닉네임 변경](https://github.com/2021-SMHRD-KDT-AI-17/pocketmon_catch/assets/157354010/322ca97f-6f5a-49a4-a6fd-510a054bd9e8)
<br>


<br>

## 👨‍👨‍👧‍👦 팀원역할
|  이름  | 역할 |
|--------|-------|
| 박상윤 | BGM 메서드 구현, 게임 구현, 주된 MAIN 클래스 구현 |
| 강민규 | POCKET 메서드 구현, POCKETBATTEL 구현주된 MAIN 클래스 구현 |
| 장지오 | USER 메서드구현, PLAY 메서드구현, 게임 구현, PPT 제작 |
| 조가현 |유스케이스 작성, 테이블 명세서 작성, 아스키아트 메서드 구현, 게임 구현, PPT 제작 |
<br>

## 🧨 트러블슈팅
*문제 1 <br>
GITHUB를 사용하는데 미숙하여 가끔씩 각각의 이클립스에서 오류가 생겨났으나 구글링과 팀원들의 소통을 통해 잘 해결해나갔다.
<br>
<br>
*문제 2 <br>
BGM이 다음 기능으로 넘어갈때 종료가 되어야하는데 노래가 중복이 되어 출력되었다
while문안에서 문제가 발생된 것을 발견하여 while문 밖으로 bgm을 출력되도록 변경하였더니 해결되었다.
<br>
<br>
*문제 3 <br>
닉네임 변경 완료가 되지않아서 확인해보니 로그인한 결과값이 들어가지 않았던 문제를 찾아서 변경하여
회원 테이블의 닉네임을 변경을 완료하였으나 랭킹 내 닉네임은 변경이 되지않아 dao 클래스에 spl문을 추가하여 수정하였더니 
랭킹 내 닉네임도 변경이 정상적으로 변경되었다.

