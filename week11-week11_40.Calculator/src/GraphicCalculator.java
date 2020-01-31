
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        createComponents(frame.getContentPane());
        
        frame.setSize(new Dimension(350, 150));
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        frame.setLayout(layout);
        
        JTextField output = new JTextField("0");
        output.setEnabled(false);
        container.add(output);
        
        JTextField input = new JTextField("");
        container.add(input);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        
        JButton plusButton = new JButton("+");
        buttonPanel.add(plusButton);
        
        JButton minusButton = new JButton("-");
        buttonPanel.add(minusButton);
        
        JButton zButton = new JButton("Z");
        zButton.setEnabled(false);
        buttonPanel.add(zButton);
        
        container.add(buttonPanel);
        
        ButtonListener listener = new ButtonListener(plusButton, minusButton, zButton, input, output);
        
        plusButton.addActionListener(listener);
        minusButton.addActionListener(listener);
        zButton.addActionListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }
}
