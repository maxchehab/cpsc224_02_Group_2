
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Game {

    static JFrame frame = new JFrame("Game");

    public static void main(String[] args) {

        StateManager.addState("home", new State(new Panel("home")));
        StateManager.addState("test", new State(new Panel("test")));

        StateManager.addStateChangedListener(new StateChangedListener() {
            @Override
            public void onChange(State newState, State oldState) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(newState.getPanel());
                frame.revalidate();
                frame.pack();
            }
        });

        StateManager.changeState("home");

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

class Panel extends JPanel {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    private JLabel label;

    public Panel(String labelName) {
        super();
        this.label = new JLabel(labelName);

        // create a new panel with GridBagLayout manager

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(label, constraints);

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                StateManager.changeState("test");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}