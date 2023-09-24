package project;

import java.awt.*;
import java.awt.event.*;

public class Airplane extends Frame implements ActionListener {
	Label lb1, lb2;
	TextField tf;
	CheckboxGroup cg;
	Checkbox cb1, cb2;
	Choice ch;
	List li;
	TextArea ta;
	Button bt1, bt2;
	
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
		cb2.setFont(new Font("AlternateGothic2 BT", Font.PLAIN, 12));
		ch = new Choice();
		ch.addItem("KAL");
		ch.addItem("ASIANA");
		ch.addItem("USA");
		
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
		pn2.add(bt1);
		pn2.add(bt2);
		add("North", pn1);
		add("Center", ta);
		add("South", pn2);
	}
	
	public static void main(String[] args) {
		Airplane f = new Airplane();
		f.setTitle("항공기 예약 프로그램");
		f.setSize(600, 300);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String gender = new String();
		String airsupport = new String();
		if((Button)obj == bt1) {
			if(cb1.getState()) gender = "남";
			if(cb2.getState()) gender = "여";
			if(ch.getSelectedItem() == "KAL") airsupport = "대한";
			if(ch.getSelectedItem() == "ASIANA") airsupport = "아시아나";
			if(ch.getSelectedItem() == "USA") airsupport = "미국";
			ta.setText(tf.getText() + "님은 " + gender + "자 이고, " + airsupport + "항공 " + li.getSelectedItem() + " 편을 예약하셨습니다.");
		}
		else {
			ta.setText("다시 입력해주세요");
		}
	}
}
