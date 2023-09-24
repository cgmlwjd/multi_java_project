package project;

import java.awt.*;
import java.awt.event.*;

public abstract class Airplane extends Frame implements ActionListener {
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
            if (clickedButton.getLabel().equals("예약")) {
                handleReservation();
            } else if (clickedButton.getLabel().equals("취소")) {
                ta.setText("다시 입력해주세요");
            }
        }
    }

    protected static class ReservationException extends Exception {
        public ReservationException(String message) {
            super(message);
        }
    }
}
