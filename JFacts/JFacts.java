import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JFacts extends JFrame implements ActionListener {
    private final List<String> spaceFacts;
    private final List<JLabel> factLabels;
    private final JButton changeFactButton;

    public JFacts() {
        setTitle("Space Facts");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        
        spaceFacts = Arrays.asList(
                "The Sun is a massive ball of hot, glowing gas.",
                "The Milky Way is our home galaxy.",
                "Neptune is the eighth and farthest known planet from the Sun.",
                "A light-year is the distance light travels in one year.",
                "Astronauts experience 'weightlessness' in space.",
                "Jupiter has the largest number of moons among the planets in our solar system."
        );

        
        factLabels = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            factLabels.add(new JLabel(spaceFacts.get(i)));
            add(factLabels.get(i));
        }

        
        changeFactButton = new JButton("Change Fact");
        changeFactButton.addActionListener(this);
        add(changeFactButton);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Random random = new Random();
        int indexToRemove = random.nextInt(factLabels.size());
        factLabels.get(indexToRemove).setVisible(false);

        String newFact = getNewFact(indexToRemove);
        factLabels.get(indexToRemove).setText(newFact);
        factLabels.get(indexToRemove).setVisible(true);

        
        validate();
        repaint();
    }

    private String getNewFact(int currentIndex) {
        
        Random random = new Random();
        int newIndex;
        do {
            newIndex = random.nextInt(spaceFacts.size());
        } while (newIndex == currentIndex);

        return spaceFacts.get(newIndex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JFacts());
    }
}
