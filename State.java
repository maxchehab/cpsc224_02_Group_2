import javax.swing.JPanel;

public class State {
    private JPanel panel;

    public State(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}