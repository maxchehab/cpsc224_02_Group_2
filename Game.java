
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
    public static void main(String[] args) {
        // set look and feel to the system look and feel
        // try {
        //     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // } catch (Exception ex) {
        //     ex.printStackTrace();
        // }

        StateManager.addState("home", new State(new Panel("home")));
        StateManager.addState("test", new State(new Panel("test")));

        StateManager.addStateChangedListener(new StateChangedListener() {
            @Override
            public void onChange(State newState, State oldState) {
                oldState.getFrame().setVisible(false);
                newState.getFrame().setVisible(true);
            }
        });

        StateManager.changeState("home");
    }
}

class Panel extends JFrame {
    static final long serialVersionUID = 0; // JFFrame requires a unique number.

    private JLabel label;

    public Panel(String labelName) {
        super(labelName);
        this.label = new JLabel(labelName);

        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(label, constraints);

        newPanel.addMouseListener(new MouseListener() {

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
        // add the panel to this frame
        add(newPanel);

        pack();
        setLocationRelativeTo(null);

    }
}