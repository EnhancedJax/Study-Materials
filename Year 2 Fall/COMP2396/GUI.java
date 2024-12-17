import javax.swing.*;

class GUI {
"""
OVERVIEW:
- All components can hold other components.
- JFrame is the main window.
- JPanel is a container for other components.
"""
    JPanel panel; JButton button; JButton button2;
    JFrame frame; JLabel label;
    public static void main(String[] args) {
        frame = new JFrame("My Frame"); 
        // Window title as "My frame"

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // w,h
        frame.setVisible(true); // show window
        button = new JButton("Click me");
        button2 = new JButton("Click me");
"""
LAYOUT:
- JFrame by default uses BorderLayout.
- JPanel by default uses FlowLayout.
- We can change the layout manager by calling setLayout.

BorderLayout: 5 regions
NORTH, SOUTH will stretch horizontally, but use preferred height.
EAST, WEST will stretch vertically, but use preferred width.
CENTER will stretch both horizontally and vertically.
"""
        panel = new JPanel();
        frame.add(panel); // default CENTER in border layout
        frame.add(panel, BorderLayout.NORTH); // add to NORTH
"""
FlowLayout: left to right
BoxLayout: stack vertically (Y) or horizontally (X)
GridBagLayout: most flexible. Key idea: set the contraints before adding the component.
"""
        panel.setLayout(new FlowLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; // column
        c.gridy = 0; // row
        c.gridwidth = 1; // width
        c.gridheight = 1; // height
        c.weightx = 1; // stretch horizontally
        c.weighty = 1; // stretch vertically
        c.anchor = GridBagConstraints.CENTER; // center
        c.fill = GridBagConstraints.HORIZONTAL; // stretch horizontally
        c.insets = new Insets(0, 0, 0, 0); // padding (tlbr)
        c.ipadx = 0; // internal padding
        c.ipady = 0; // internal padding

        panel.add(button, c);
        c.gridx = 1;
        panel.add(button2, c); // add to cell (1,0)
"""
EVENT HANDLING:
- Event source: Calls event handlers with an event obj
- Event obj: Contains information about the event
- Event listener: Handles the event
"""
        // method 1 - implement ActionListener interface
        // inner class: can access outer class methods and variables
        class buttonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button clicked");
                e.getSource(); // get variable of event source (buttin)
            }
        }
        button.addActionListener(new buttonListener());
        // method 2 - lambda
        button.addActionListener(e -> System.out.println("Button clicked"));
"""
Drawing on JPanel:
- Override paintComponent method
"""
        class MyPanel extends JPanel {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(10, 10, 100, 100);
                Graphics2D g2d = (Graphics2D) g;
                int x = 150; int y = 150; int d = 100;
                GradientPaint gradient = new GradientPaint(x, y, Color.BLUE, x + d, y + d, Color.GREEN);
                g2d.setPaint(gradient);
                g2d.fillOval(x, y, d, d);
            }
        }
        panel.add(new MyPanel());
        frame.repaint(); // call all paintComponent
    }
}
class GUI extends JFrame {} // can also extend JPanel