package project;

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

        String reservationMessage = getTextField().getText() + "님은 " + gender + "자 이고, " + airsupport + "항공 " + getList().getSelectedItem() + " 편을 예약하셨습니다.";
        getTextArea().setText(reservationMessage);
    }

    public static void main(String[] args) {
        new AirplaneReservation();
    }
}
