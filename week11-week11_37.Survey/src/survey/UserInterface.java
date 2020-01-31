package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private JRadioButton radiobuttonNoReason, radioButtonBecauseItsFun;
    private JLabel labelAreYou, labelWhy;
    JCheckBox checkboxYes, checkBoxNo;
    JButton button;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(200,300));
        createComponets(frame.getContentPane());
    }


    public JFrame getFrame() {
        return frame;
    }
    private void createComponets(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        frame.setLayout(layout);
        
        labelAreYou = new JLabel("Are you?");
        labelAreYou.setVisible(true);
        container.add(labelAreYou);
        
        checkboxYes = new JCheckBox("Yes!");
        checkboxYes.setVisible(true);
        container.add(checkboxYes);
        
        checkBoxNo = new JCheckBox("No!");
        checkBoxNo.setVisible(true);
        container.add(checkBoxNo);
        
        labelWhy = new JLabel("Why?");
        labelWhy.setVisible(true);
        container.add(labelWhy);
        
        radiobuttonNoReason = new JRadioButton("No reason.");
        radiobuttonNoReason.setVisible(true);
        
        radioButtonBecauseItsFun = new JRadioButton("Because it is fun!");
        radioButtonBecauseItsFun.setVisible(true);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radiobuttonNoReason);
        group.add(radioButtonBecauseItsFun);
        
        container.add(radiobuttonNoReason);
        container.add(radioButtonBecauseItsFun);
        
        container.add(new JButton("Done!"));
    }
}
