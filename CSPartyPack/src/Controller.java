import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {
    public static void main(String[] args) throws InterruptedException {
        JFrame RunFrame = new JFrame();
        MenuController MC = new MenuController();

        RunFrame.setBounds(0,0,1920,1080);
        RunFrame.setLayout(null);
        RunFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RunFrame.setVisible(true);
        RunFrame.setResizable(false);

        RunFrame.repaint();

        MenuController.MainMenu(RunFrame);

    }
}
