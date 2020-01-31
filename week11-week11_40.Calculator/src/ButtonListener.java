
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ButtonListener implements ActionListener{
    private JButton plusButton, minusButton, zButton;
    private JTextField input, output; 
   
    public ButtonListener(JButton plusButton, JButton minusButton, JButton zButton, JTextField input ,JTextField output) {
        this.plusButton = plusButton;
        this.minusButton = minusButton;
        this.zButton = zButton;
        this.input = input;
        this.output = output;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(plusButton)) {
            try {
                int incrementValue = Integer.parseInt(input.getText());
                int currentValue = Integer.parseInt(output.getText());
                output.setText(Integer.toString(currentValue + incrementValue));
                zButton.setEnabled(true);
                input.setText("");
            } catch (Exception e1) {
                input.setText("");
            }
  
        }
        
        if(e.getSource().equals(minusButton)) {
            try {
               int decrementValue = Integer.parseInt(input.getText()); 
               int currentValue = Integer.parseInt(output.getText());
               output.setText(Integer.toString(currentValue - decrementValue));
               zButton.setEnabled(true);
               input.setText("");
          } catch (Exception e2) {
                input.setText("");
            }
            
        }
        
        if(e.getSource().equals(zButton)) {
            output.setText("0");
            zButton.setEnabled(false);
            input.setText("");
        }
    }
    
}
