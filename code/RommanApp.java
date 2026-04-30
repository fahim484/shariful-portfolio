import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RommanApp implements ActionListener 
{

    JFrame frame;
    Container c;
    JButton convert, clear;
    JTextField tf1, tf2;
    JLabel lb1, lb2, lb3, lb4, lab5;
    JComboBox cb1, cb2;
    JPanel p;
    JButton btn[] = new JButton[12];

   RommanApp()
    {

        // Creating the frame
        frame = new JFrame("Temperature Converter");
        // frame position and size
        frame.setBounds(300, 100, 320, 520); 
        frame.setTitle("Temperature Converter");
        
        // returns the frames container
        c = frame.getContentPane();
        c.setLayout(null);
        // Set background color of container
        c.setBackground(Color.GRAY);
       
        // Creating (Convert) button
        convert = new JButton("Convert");
        convert.setBounds(10, 130, 130, 30);
        convert.addActionListener(this);
        convert.setBackground(Color.yellow);
        convert.setForeground(Color.BLACK);
        convert.setFont(new Font("Arial", Font.ITALIC, 18));

        // Creating (Clear) button
        clear = new JButton("Clear");
        clear.setBounds(160, 130, 130, 30);
        clear.addActionListener(this);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.ITALIC, 18));

        // Creating label (Temperature)
        lb1 = new JLabel("Temperature");
        lb1.setBounds(10, 10, 100, 20);
        lb1.setForeground(Color.GREEN);
        lb1.setFont(new Font("Arial", Font.BOLD, 13));

        // Creating first textfield
        tf1 = new JTextField();
        tf1.setBounds(10, 30, 150, 30);
        tf1.setForeground(Color.BLACK);
        tf1.setFont(new Font("Arial", Font.BOLD, 18));
        tf1.setBackground(Color.WHITE);

        // Creating label 2 Converted Value 
        lb2 = new JLabel("Converted Value");
        lb2.setBounds(10, 60, 120, 20);
        lb2.setForeground(Color.CYAN);
        lb2.setFont(new Font("Arial", Font.BOLD, 13));

        // Creating second textfield
        tf2 = new JTextField();
        tf2.setBounds(10, 80, 150, 30);
        tf2.setBackground(Color.GRAY);
        tf2.setFont(new Font("Arial", Font.BOLD, 18));
        tf2.setForeground(Color.WHITE);

        // Creating label 4 (From) 
        lb3 = new JLabel("From");
        lb3.setBounds(170, 10, 100, 20);
        lb3.setForeground(Color.GREEN);
        lb3.setFont(new Font("Arial", Font.BOLD, 15));

        // creating a drop-down option
        // Celsius, Fahrenheit, or Kelvin
        String[] s = {"Celsius", "Fahrenheit", "Kelvin"};
        cb1 = new JComboBox(s);
        cb1.setBounds(170, 30, 120, 30);
        cb1.setBackground(Color.LIGHT_GRAY);
        cb1.setForeground(Color.BLACK);
        cb1.setFont(new Font("Arial", Font.BOLD, 15));

        // Creating label 4 (To) 
        lb4 = new JLabel("To");
        lb4.setBounds(170, 60, 100, 20);
        lb4.setForeground(Color.CYAN);
        lb4.setFont(new Font("Arial", Font.BOLD, 15));

        // Creating drop-down cb2
        cb2 = new JComboBox(s);
        cb2.setBounds(170, 80, 120, 30);
        cb2.setBackground(Color.LIGHT_GRAY);
        cb2.setForeground(Color.BLACK);
        cb2.setFont(new Font("Arial", Font.BOLD, 15));

        // Creating panel for number buttons
        p = new JPanel();
        p.setBounds(10, 170, 280, 200);
        p.setLayout(new GridLayout(3, 4, 5, 5));
        p.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < btn.length; i++) 
        {
            btn[i] = new JButton();
            btn[i].addActionListener(this);
            btn[i].setBackground(Color.ORANGE);
            btn[i].setForeground(Color.black);

            if (i <= 8) 
            {
                btn[i].setText(Integer.toString(i + 1));
            }
            p.add(btn[i]);
        }

        btn[9].setText("0");
        btn[10].setText(".");
        btn[11].setText("+-");

        // Creating  label 5 ("Romman")
        lab5 = new JLabel("Romman", JLabel.CENTER);
        lab5.setFont(new Font("Arial", Font.ITALIC, 30));
        lab5.setBounds(10, 400, 280, 30);
        lab5.setForeground(Color.white);

        // Adding all components to container
        c.add(convert);
        c.add(clear);
        c.add(tf1);
        c.add(tf2);
        c.add(lb1);
        c.add(lb2);
        c.add(lb3);
        c.add(lb4);
        c.add(cb1);
        c.add(cb2);
        c.add(p);
        c.add(lab5);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();

        for (int i = 0; i <= 9; i++) 
        {
            if (src == btn[i]) 
            {
                tf1.setText(tf1.getText() + btn[i].getText());
                return;
            }
        }

        if (src == btn[10])
        {
            if (!tf1.getText().contains("."))
            {
                tf1.setText(tf1.getText() + ".");
            }
        }

        else if (src == btn[11]) 
        {
            if (tf1.getText().startsWith("-"))
            {
                tf1.setText(tf1.getText().substring(1));
            } 
            else 
            {
                tf1.setText("-" + tf1.getText());
            }
        }

        // Clear button
        else if (src == clear)
        {
            tf1.setText("");
            tf2.setText("");
        }

        // Convert button
        else if (src == convert) 
        {
            try 
            {
                double a = Double.parseDouble(tf1.getText());
                int from = cb1.getSelectedIndex();
                int to = cb2.getSelectedIndex();

                if (from == 0 && to == 1) 
                {
                    a = ((9 * a) / 5) + 32;
                } 
                else if (from == 0 && to == 2)
                {
                    a = a + 273.15;
                }
                else if (from == 1 && to == 0)
                {
                    a = ((a - 32) * 5) / 9;
                } 
                else if (from == 1 && to == 2)
                {
                    a = ((a - 32) * 5 / 9) + 273.15;
                } 
                else if (from == 2 && to == 0)
                {
                    a = a - 273.15;
                } 
                else if (from == 2 && to == 1) 
                {
                    a = ((a - 273.15) * 9 / 5) + 32;
                }

                tf2.setText(String.format("%.2f", a));
            } 
            catch (NumberFormatException ex)
            {
                tf2.setText("Invalid");
            }
        }
    }

    public static void main(String[] args)
    {
        RommanApp a = new RommanApp();
    }
}
