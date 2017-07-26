package app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Sem on 24-Jul-17.
 */
public class RekenmachineWindow extends JFrame {
    RekenmachinePanel content = new RekenmachinePanel();

    public RekenmachineWindow()  {
        super();

        setSize(355, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(content);
        setResizable(false);

        setVisible(true);
    }


    class RekenmachinePanel extends JPanel {
        LayoutManager layout = new BoxLayout(this,  BoxLayout.Y_AXIS);
        JTextArea resultTextPanel = new JTextArea();
        JButton footer = new JButton();
        JButton[][] operationButtons = new JButton[4][4];
        ImageIcon businessImage = new ImageIcon(getClass().getResource("/app/resources/businessimage.png"));
        OperationBoard operationBoard = new OperationBoardFactory().createOperationBoard();

        public RekenmachinePanel() {
            super();

            setLayout(layout);
            setBorder(new EmptyBorder(20, 20, 20, 20));
            resultTextPanel.setPreferredSize(new Dimension(315, 50));
            resultTextPanel.setMaximumSize(new Dimension(315, 50));
            resultTextPanel.setFont(new Font("serif", Font.PLAIN, 36));
            resultTextPanel.setEditable(false);

            add(resultTextPanel);

            // Add border
            add(Box.createVerticalStrut(20));


            // Create operations button panel
            JPanel operationButtonPanel = new JPanel(new GridLayout(4,4,20,20));

            // Initialize operation buttons.
            for (int x = 0; x < 4; x ++) {
                for (int y = 0; y < 4; y ++) {
                    operationButtons[x][y] = new JButton();
                    app.actions.Action buttonAction = operationBoard.getAction()[x][y];
                    operationButtons[x][y].setText(buttonAction.getName());
                    operationButtons[x][y].setPreferredSize(new Dimension(60, 60));
                    operationButtons[x][y].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            try {
                                operationBoard.evaluateAction(buttonAction);
                                resultTextPanel.setText(operationBoard.getStringifiedExpression());
                                resultTextPanel.setForeground(Color.BLACK);
                            }
                            catch(IllegalStateException ex) {
                                resultTextPanel.setForeground(Color.RED);
                            }
                        }
                    });
                    operationButtonPanel.add(operationButtons[x][y]);
                }
            }
            add(operationButtonPanel);

            // Add border
            add(Box.createVerticalStrut(20));

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.setPreferredSize(new Dimension(315, 120));
            footer.setIcon(businessImage);
            panel.add(footer);
            footer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (Desktop.isDesktopSupported()){
                        try {
                            Desktop.getDesktop().browse(new URI(Main.persistenData.get("website")));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            add(panel);

            pack();
        }
    }
}


















