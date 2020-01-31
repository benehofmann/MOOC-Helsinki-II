package greeter.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;
    private JTextField jTextField;
    private JLabel jLabel;


    @Override
    public void run() {
        frame = new JFrame("Swing on");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 300));
        createComponents(frame.getContentPane());
        
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        jLabel = new JLabel("Hi!");
        container.add(jLabel);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
