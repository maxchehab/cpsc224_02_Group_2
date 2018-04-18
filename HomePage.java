import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

class HomePage extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    public HomePage() {
        JLabel label = new JLabel("Home Page");

        setOpaque(false);
        setBackground(Color.RED);  
        label.setLocation(0, 0);
        label.setSize(300, 30);

        this.add(label);

        this.setLayout(null);
    }
}