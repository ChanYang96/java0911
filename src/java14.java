import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class MyPanel extends JPanel{
    private int x, y, width, height;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        randomCircle();
        g.fillOval(this.x, this.y, this.width, this.height);
    }
    public void randomCircle(){
        this.x = (int)(Math.random()*this.getWidth());
        this.y = (int)(Math.random()*this.getHeight());
        this.width = (int)(Math.random()*(this.getWidth()/2));
        this.height = (int)(Math.random()*(this.getHeight()/2));
    }
}
public class java14 extends JFrame{
    private MyPanel panel;
    private wokeup runnable;
    Thread thread;
    public java14(){
        super("Make Drawing to Start");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyPanel();
        setContentPane(panel);
        MyMouseActionListener listener = new MyMouseActionListener();
        addMouseListener(listener);
        runnable = new wokeup(panel);
        thread = new Thread(runnable);
        thread.start();
        setSize(400, 400);
        setVisible(true);
    }
    class MyMouseActionListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            runnable.start();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            runnable.setFlag(false);
        }
    }
    public static void main(String[] args){
        new java14();
    }
}