import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class java15 extends JFrame{
    JButton btn = new JButton("Calculate");
    JLabel label = new JLabel("계산 결과 출력");
    java15(){
        setTitle("다이얼로그 만들기");
        setDefaultCloseOperation(3);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(btn);
        c.add(label);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MyDialog dialog = new MyDialog();
                dialog.setVisible(true);
            }
        });
        setSize(300,300);
        setVisible(true);
    }

    class MyDialog extends JDialog{
        JTextField tf1 = new JTextField(10);
        JTextField tf2 = new JTextField(10);
        JButton addBtn = new JButton("Add");
        MyDialog(){
            setLayout(new FlowLayout());
            add(new JLabel("두 수를 더합니다"));
            add(tf1);
            add(tf2);
            add(addBtn);
            setSize(180,180);
            setTitle("Calculation Dialog");
            addBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int result = Integer.parseInt(tf1.getText()) + Integer.parseInt(tf2.getText());
                    label.setText(Integer.toString(result));
                    setVisible(false);
                }
            });
        }
    }

    public static void main(String[] args) {
        new java15();
    }
}
