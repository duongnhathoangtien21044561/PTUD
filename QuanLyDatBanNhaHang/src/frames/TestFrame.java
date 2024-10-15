package frames;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import forms.*;
import java.awt.*;
import javax.swing.*;
import menu.Menu;
import menu.MenuEvent;

public class TestFrame extends JFrame {

    //define
    Menu menu;
    JPanel pnlBase, pnlMenu, pnlBody;

    public TestFrame() {
        //JFrame settings
        setSize(1215, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //create
        menu = new Menu();
        pnlBase = new JPanel();
        pnlMenu = new JPanel();
        pnlBody = new JPanel();

        //modify
        pnlBase.setLayout(new BorderLayout());
        pnlMenu.setLayout(new BorderLayout());
        pnlBody.setLayout(new BorderLayout());
        pnlMenu.setPreferredSize(new Dimension(220, 700));
        pnlBody.setPreferredSize(new Dimension(980, 700));
        //add        
        add(pnlBase, BorderLayout.CENTER);
        pnlMenu.add(menu);
        pnlBase.add(pnlMenu, BorderLayout.WEST);
        pnlBase.add(pnlBody, BorderLayout.EAST);

        

        //events
        showForm(new HomeForm());
        menu.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    showForm(new HomeForm());
                    System.out.println(pnlBody.getWidth() + " " + pnlBody.getHeight());
                    System.out.println(menu.getWidth() + " " + menu.getHeight());
                }
                else if(index == 5){
                showForm(new ThemKHForm());
                System.out.println(pnlBody.getWidth() + " " + pnlBody.getHeight());
                System.out.println(menu.getWidth() + " " + menu.getHeight());
                }
                else if(index == 6){
                    showForm(new TKDTKHForm());
                    System.out.println(pnlBody.getWidth() + " " + pnlBody.getHeight());
                    System.out.println(menu.getWidth() + " " + menu.getHeight());
                }
            }

        });
        
    }

    private void showForm(Component com) {
        pnlBody.removeAll();
        pnlBody.add(com, BorderLayout.CENTER);
        pnlBody.repaint();
        pnlBody.revalidate();
    }

    public static void main(String args[]) {
        FlatLightFlatIJTheme.setup();
        new TestFrame().setVisible(true);
    }
}
