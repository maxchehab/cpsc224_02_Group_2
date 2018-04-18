
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Game {

    static JFrame frame = new JFrame("Game");

    public static void main(String[] args) {

        StateManager.addState("HomePage", new State(new HomePage()));
        StateManager.addState("HelpPage", new State(new HelpPage()));

        StateManager.addStateChangedListener(new StateChangedListener() {
            @Override
            public void onChange(State newState, State oldState) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(newState.getPanel());
                frame.revalidate();
                frame.pack();
                frame.setSize(1200, 800);
            }
        });

        StateManager.changeState("HelpPage");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
