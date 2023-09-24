package project;

import java.awt.*;
import java.awt.event.*;

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

//추상 클래스로 변경
public abstract class Airplane extends Frame implements ActionListener {
	//데이터 캡슐화를 위해 private으로 변경
	private Label lb1, lb2;
    private TextField tf;
    private CheckboxGroup cg;
    private Checkbox cb1, cb2;
    private Choice ch;
    private List li;
    private TextArea ta;
    private Button bt1, bt2;

    public Airplane() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        lb1 = new Label("이름");
        lb1.setFont(new Font("Arial", Font.PLAIN, 12));
        lb2 = new Label("성별");
        lb2.setFont(new Font("Arial", Font.PLAIN, 12));
        tf = new TextField(8);
        tf.setFont(new Font("Arial", Font.PLAIN, 12));
        cg = new CheckboxGroup();
        cb1 = new Checkbox("남", cg, false);
        cb1.setFont(new Font("Arial", Font.PLAIN, 12));
        cb2 = new Checkbox("여", cg, false);
        cb2.setFont(new Font("Arial", Font.PLAIN, 12));
        ch = new Choice();
        ch.add("KAL");
        ch.add("ASIANA");
        ch.add("USA");

        li = new List(4, false);
        li.add("SEOUL");
        li.add("TOKYO");
        li.add("NEWYORK");
        li.add("AFRICA");
        li.select(0);

        ta = new TextArea("", 50, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setEditable(false);

        bt1 = new Button("예약");
        bt1.setFont(new Font("Arial", Font.PLAIN, 12));
        bt2 = new Button("취소");
        bt2.setFont(new Font("Arial", Font.PLAIN, 12));
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        Panel pn1 = new Panel();
        pn1.add(lb1);
        pn1.add(tf);
        pn1.add(lb2);
        pn1.add(cb1);
        pn1.add(cb2);
        pn1.add(ch);
        pn1.add(li);

        Panel pn2 = new Panel();
        pn2.add(bt1);
        pn2.add(bt2);

        add("North", pn1);
        add("Center", ta);
        add("South", pn2);
    }

    //추상 메서드 정의
    protected abstract void handleReservation();

    protected CheckboxGroup getCheckboxGroup() {
        return cg;
    }

    protected Choice getChoice() {
        return ch;
    }

    protected List getList() {
        return li;
    }

    protected TextArea getTextArea() {
        return ta;
    }

    protected TextField getTextField() {
        return tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof Button) {
            Button clickedButton = (Button) obj;
            // 예약 버튼 클릭 시 처리 메서드 호출
            if (clickedButton.getLabel().equals("예약")) {
                handleReservation();
               // 취소 버튼 클릭 시 메시지 출력
            } else if (clickedButton.getLabel().equals("취소")) {
                ta.setText("다시 입력해주세요");
            }
        }
    }
    
    //사용자 정의 예외 클래스 정의
    protected static class ReservationException extends Exception {
        public ReservationException(String message) {
            super(message);
        }
    }
}
