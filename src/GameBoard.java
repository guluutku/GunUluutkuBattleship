import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {

    private JPanel board;
    private JButton[][] bdSports;
    private char[][] symbls;

   public GameBoard(){

       this.setLayout(new BorderLayout());
       this.setSize(500, 500);

       board = new JPanel(new GridLayout(8, 8));
       board.setVisible(true);
       bdSports = new JButton[8][8];
       symbls = new char[8][8];

       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8; j++) {
               bdSports[i][j] = new JButton(" ");
               bdSports[i][j].setEnabled(true);
               bdSports[i][j].setActionCommand(i + " " + j);
               bdSports[i][j].setVisible(true);
               board.add(bdSports[i][j]);
               symbls[i][j] = '.';
           }
       }

       this.add(board, BorderLayout.CENTER);
       setVisible(true);

   }

}
