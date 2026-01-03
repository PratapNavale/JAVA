package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_EventHandler extends JFrame implements ActionListener {
    JFrame jf;
    JPanel parentpanel;
    CardLayout cd;

    GUI_EventHandler() {
        jf = new JFrame("Sports");
        cd = new CardLayout();
        
        parentpanel = new JPanel();
        
        //creating 2 childs
        JPanel cp1 = new JPanel(); //for indoor
        JPanel cp2 = new JPanel(); //for outdoor
        JPanel def = new JPanel(); //for displaying blank
        
        Button b1 = new Button("Indoor");
        Button b2 = new Button("Outdoor");

        //indoor game
        Button b3 = new Button("Chess");
        Button b4 = new Button("Carrom");
        Button b5 = new Button("Ludo");

        cp1.add(b3);
        cp1.add(b4);
        cp1.add(b5);

        //outdoor game
        Button b6 = new Button("Cricket");
        Button b7 = new Button("Football");
        Button b8 = new Button("Formula-1");

        cp2.add(b6);
        cp2.add(b7);
        cp2.add(b8);

        parentpanel.setLayout(cd);

        parentpanel.add(def);
        parentpanel.add(cp1, "Indoor" );
        parentpanel.add(cp2, "Outdoor");

        b1.addActionListener(this);
        b2.addActionListener(this);

        jf.setLayout(new FlowLayout());

        jf.add(b1);
        jf.add(b2);

        jf.add(parentpanel);

        jf.setSize(300, 200);

        jf.setVisible(true);


        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Outdoor") {
            cd.show(parentpanel, "Outdoor");
        } else {
            cd.show(parentpanel, "Indoor");
        }
    }

    public static void main(String[] args) {
        new GUI_EventHandler();
    }
}
