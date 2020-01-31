package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setSize(new Dimension(400, 400));
        frame.setVisible(true);
        createComponents(frame.getContentPane());
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        JTextField textField = new JTextField();
        container.add(textField);
        
        JButton buttonCopy = new JButton("Copy!");
        container.add(buttonCopy);
        
        JLabel copiedText = new JLabel("I was copied here from JTextArea");
        container.add(copiedText);
        
        buttonCopy.addActionListener(new ActionEventListener(textField, copiedText));
        
    }
}
