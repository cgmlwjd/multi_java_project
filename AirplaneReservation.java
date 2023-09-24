package project;

/*
 * 작성자: 최희정
 * 작성일: 2023.09.24
 * 프로젝트명: java 프로젝트 개별과제 - 항공기 예약 프로그램
 * 사용자 : 이름, 성별, 항공사, 나라를 선택 후 예약 버튼을 누르면 밑의 tf에 작성이 됨
 * 만약 취소 버튼을 누를 경우 다시 입력하라는 문구가 뜸
 * tf는 따로 입력할 수 없게 설정해 둠
 * 제 노트북에서만 그런지 모르겠는데 실행을 할 시 한글이 깨지는 현상이 발생합니다. 최대한 수정해보려고 노력 중이나 원인을 잘 모르겠습니다.
 * (tf는 한글 깨짐 현상x)
 * */

public class AirplaneReservation extends Airplane {
    public AirplaneReservation() {
        setTitle("항공기 예약 프로그램");
        setSize(600, 300);
        setVisible(true);
    }

    @Override
    protected void handleReservation() {
        String gender = "";
        String airsupport = "";

        if (getCheckboxGroup().getSelectedCheckbox() != null) {
            gender = getCheckboxGroup().getSelectedCheckbox().getLabel();
        }

        if (getChoice().getSelectedItem().equals("KAL")) {
            airsupport = "대한";
        } else if (getChoice().getSelectedItem().equals("ASIANA")) {
            airsupport = "아시아나";
        } else if (getChoice().getSelectedItem().equals("USA")) {
            airsupport = "미국";
        }

        //예약 정보를 tf에 출력
        String reservationMessage = getTextField().getText() + "님은 " + gender + "자 이고, " + airsupport + "항공 " + getList().getSelectedItem() + " 편을 예약하셨습니다.";
        getTextArea().setText(reservationMessage);
    }

    public static void main(String[] args) {
        new AirplaneReservation();
    }
}
