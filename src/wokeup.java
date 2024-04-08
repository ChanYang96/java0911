import javax.swing.*;

public class wokeup implements Runnable {
    private JPanel panel;
    private boolean flag = true;
    public wokeup(JPanel panel) {
        this.panel = panel;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    synchronized public void start() {
        flag = true;
        this.notify();
    }

    synchronized public void waiting() {
        if (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                waiting();
                panel.repaint();
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
