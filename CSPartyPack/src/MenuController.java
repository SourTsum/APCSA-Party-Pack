import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MenuController {

    private static String DIR = MenuController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    /*
    Selected Game Table:
    Quiplash : QuipLash
     */
    private static String SelectedGame = "QuipLash";


    private static void LerpYTo(int y, JComponent c,JFrame RunFrame) throws InterruptedException {
        int originY = c.getY();

        synchronized(RunFrame){
            for(int i = originY; i < y; i++){
                c.revalidate();
                RunFrame.wait(1);
                c.setBounds(c.getX(),i,c.getWidth(),c.getHeight());
            }
        }
    }


    private static JLabel[] GenerateHitBoxes(JFrame RunFrame, JLabel Selector) {
        JLabel[] res = new JLabel[5];
        res[0] = new JLabel("TESTTESTTESTTESTTEST"); res[0].setBounds(155,300,100,45); RunFrame.add(res[0]);
        res[0].addMouseListener(new MouseListener() {
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
                try {
                    LerpYTo(300,Selector,RunFrame);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        return res;
    }

    static void MainMenu(JFrame RunFrame) throws InterruptedException {
        KeyListener KL = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
        };



        RunFrame.setFocusable(true);
        RunFrame.addKeyListener(KL);
        RunFrame.setFocusTraversalKeysEnabled(false);
        DIR = DIR.substring(0, DIR.indexOf("CSPartyPack")) + "CSPartyPack/";

        Icon ICON_BG = new ImageIcon(DIR + "src/IMG/MainMenuBG.png");
        JLabel BG = new JLabel();
        BG.setIcon(ICON_BG);

        Icon ICON_GAMEBOX = new ImageIcon(DIR + "src/IMG/" + SelectedGame + "IMG.png");
        JLabel GameBox = new JLabel();
        GameBox.setIcon(ICON_GAMEBOX);

        Icon ICON_SELECTOR = new ImageIcon(DIR + "src/IMG/SelectorIMG.png");
        JLabel Selector = new JLabel();
        Selector.setIcon(ICON_SELECTOR);

        Selector.setBounds(88,150,45,45);
        GameBox.setBounds(1000, 100, 798, 824);
        BG.setBounds(0, 0, 1920, 1080);


        JLabel[] a = GenerateHitBoxes(RunFrame,Selector);



        RunFrame.add(Selector);
        RunFrame.add(GameBox);
        RunFrame.add(BG);
        RunFrame.repaint();


    }
}