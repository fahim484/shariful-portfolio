import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorAp implements ActionListener 
{
    JFrame frame;
    Container c;
    JTextField tf1, tf2;
    JLabel lb1, lb2, lb3, lb4;
    JButton btn[] = new JButton[20];
    JPanel p;

    double num1 = 0, num2 = 0;
    String operator = "";
    boolean operatorClicked = false;

    CalculatorAp() 
    {
        frame = new JFrame("Calculator");
        frame.setBounds(300, 100, 320, 520);
        frame.setTitle("Calculator");

        c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        lb1 = new JLabel("Calculator", JLabel.CENTER);
        lb1.setFont(new Font("Arial Black", Font.ITALIC, 22));
        lb1.setForeground(Color.WHITE);
        lb1.setBounds(10, 0, 280, 30);
       

        lb2 = new JLabel("Input");
        lb2.setBounds(10, 30, 100, 20);
        lb2.setForeground(Color.BLACK);
        lb2.setFont(new Font("Arial", Font.BOLD, 13));

        tf1 = new JTextField();
        tf1.setBounds(10, 50, 280, 30);
        tf1.setForeground(Color.BLACK);
        tf1.setFont(new Font("Arial", Font.BOLD, 18));
        tf1.setBackground(Color.WHITE);

        lb3 = new JLabel("Result");
        lb3.setBounds(10, 80, 120, 20);
        lb3.setForeground(Color.GREEN);
        lb3.setFont(new Font("Arial", Font.BOLD, 13));

        tf2 = new JTextField();
        tf2.setBounds(10, 100, 280, 30);
        tf2.setBackground(Color.GRAY);
        tf2.setFont(new Font("Arial", Font.BOLD, 18));
        tf2.setForeground(Color.WHITE);
        tf2.setEditable(false);

        p = new JPanel();
        p.setBounds(10, 150, 280, 240);
        p.setLayout(new GridLayout(5, 4, 5, 5));
        p.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < btn.length; i++) 
        {
            btn[i] = new JButton();
            btn[i].addActionListener(this);
            btn[i].setBackground(Color.ORANGE);
            btn[i].setForeground(Color.BLACK);
            btn[i].setFont(new Font("Arial", Font.BOLD, 14));
            p.add(btn[i]);
        }

        btn[0].setText("Clear");
        btn[1].setText("Back"); 
        btn[2].setText("mod");
        btn[3].setText("/");

        btn[4].setText("1");
        btn[5].setText("2");
        btn[6].setText("3");
        btn[7].setText("+");

        btn[8].setText("4");
        btn[9].setText("5");
        btn[10].setText("6");
        btn[11].setText("-");

        btn[12].setText("7");
        btn[13].setText("8");
        btn[14].setText("9");
        btn[15].setText("x");

        btn[16].setText("0");
        btn[17].setText(".");
        btn[18].setText("sqrt");
        btn[19].setText("=");

        btn[0].setFont(new Font("Arial", Font.BOLD, 11));
        btn[0].setBackground(Color.RED);
        btn[0].setForeground(Color.WHITE);
        btn[1].setFont(new Font("Arial", Font.BOLD, 11));
        btn[1].setBackground(Color.RED);       
        btn[1].setForeground(Color.WHITE);

        btn[3].setBackground(Color.GREEN);
        btn[7].setBackground(Color.GREEN);
        btn[11].setBackground(Color.GREEN);
        btn[15].setBackground(Color.GREEN);

        btn[19].setBackground(Color.BLUE);
        btn[19].setForeground(Color.WHITE);

        lb4 = new JLabel("Romman", JLabel.CENTER);
        lb4.setFont(new Font("Arial", Font.ITALIC, 30));
        lb4.setBounds(10, 400, 280, 30);
        lb4.setForeground(Color.WHITE);

        c.add(tf1);
        c.add(tf2);
        c.add(lb1);
        c.add(lb2);
        c.add(lb3);
        c.add(p);
        c.add(lb4);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();

        try 
        {
            for (int i = 4; i <= 16; i++) 
            {
                if (src == btn[i])
                {
                    tf1.setText(tf1.getText() + btn[i].getText());
                    return;
                }
            }

            if (src == btn[17]) 
            {
                if (!tf1.getText().contains(".")) 
                {
                    tf1.setText(tf1.getText() + ".");
                }
            }
            else if (src == btn[0]) 
            {
                tf1.setText("");
                tf2.setText("");
                num1 = num2 = 0;
                operator = "";
                operatorClicked = false;
            }
            else if (src == btn[1]) 
            {
                String s = tf1.getText();
                if (!s.isEmpty()) 
                {
                    tf1.setText(s.substring(0, s.length() - 1));
                }
            } 
            else if (src == btn[7]) 
            {
                operator = "+";
                operatorClicked = true;
                tf1.setText(tf1.getText() + "+");
            } 
            else if (src == btn[11])
            {
                operator = "-";
                operatorClicked = true;
                tf1.setText(tf1.getText() + "-");
            } 
            else if (src == btn[15])
            {
                operator = "*";
                operatorClicked = true;
                tf1.setText(tf1.getText() + "*");
            }
            else if (src == btn[3]) 
            {
                operator = "/";
                operatorClicked = true;
                tf1.setText(tf1.getText() + "/");
            }
            else if (src == btn[2]) 
            {
                operator = "%";
                operatorClicked = true;
                tf1.setText(tf1.getText() + "%");
            } 
            else if (src == btn[18])
            {
                try
                {
                    double val = Double.parseDouble(tf1.getText());
                    if (val < 0) throw new ArithmeticException();
                    double result = Math.sqrt(val);
                    tf2.setText(String.format("%.2f", result));
                } 
                catch (Exception ex)
                {
                    tf2.setText("Invalid Input");
                }
            }
            else if (src == btn[19]) 
            {
                String input = tf1.getText();
                if (input.isEmpty()) return;

                int opIndex = -1;
                char op = ' ';
                if (input.contains("+"))
                {
                    opIndex = input.lastIndexOf("+");
                    op = '+';
                } 
                else if (input.contains("-"))
                {
                    opIndex = input.lastIndexOf("-");
                    op = '-';
                } 
                else if (input.contains("x"))
                {
                    opIndex = input.lastIndexOf("x");
                    op = '*';
                } 
                else if (input.contains("/"))
                {
                    opIndex = input.lastIndexOf("/");
                    op = '/';
                } 
                else if (input.contains("%")) 
                {
                    opIndex = input.lastIndexOf("%");
                    op = '%';
                }

                if (opIndex <= 0 || opIndex == input.length() - 1)
                {
                    tf2.setText("Invalid Expression");
                    return;
                }

                try 
                {
                    num1 = Double.parseDouble(input.substring(0, opIndex));
                    num2 = Double.parseDouble(input.substring(opIndex + 1));

                    double result = 0;
                    switch (op)
                    {
                        case '+': result = num1 + num2; break;
                        case '-': result = num1 - num2; break;
                        case '*': result = num1 * num2; break;
                        case '/':
                            if (num2 == 0) throw new ArithmeticException();
                            result = num1 / num2;
                            break;
                        case '%': result = num1 % num2; break;
                    }

                    tf2.setText(String.format("%.2f", result));
                }
                catch (ArithmeticException ex)
                {
                    JOptionPane.showMessageDialog(frame, "Can't divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex)
                {
                    tf2.setText("Invalid Input");
                }
            }
        } 
        catch (Exception ex) 
        {
            tf2.setText("Error");
        }
    }

    public static void main(String[] args) 
    {
        CalculatorAp Apk = new CalculatorAp();
    }
}
