import java.awt.*;
import javax.swing.*;

public class HomeGame extends JPanel {
    final int GAME_FRAME_WIDTH = 1000;
    final int GAME_FRAME_HEIGHT = 550;

    JButton exitButton;
    JButton soundOpen;
    JButton soundClose;

    JButton Three_Points;
    JButton Five_Points;
    JButton Ten_Points;

    int point;

    HomeGame() {
        setLayout(null); // เพื่อให้สามารถกำหนดตำแหน่งปุ่มเองได้

        ImageIcon backgroundImage = new ImageIcon("Homegame.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT); // บรรทัดที่ 23 ถามปัญญาประดิษฐ์ในการนำรุปภาพเข้าเป็นพื้นหลัง
        add(backgroundLabel);

        Three_Points = new JButton("Three Points");
        Three_Points.setFont(new Font("Consolas", Font.BOLD, 20));
        Three_Points.setBackground(Color.WHITE);
        Three_Points.setForeground(Color.BLACK);
        Three_Points.setBounds(390, 240, 200, 50);
        backgroundLabel.add(Three_Points);

        Five_Points = new JButton("Five Points");
        Five_Points.setFont(new Font("Consolas", Font.BOLD, 20));
        Five_Points.setBackground(Color.WHITE);
        Five_Points.setForeground(Color.BLACK);
        Five_Points.setBounds(390, 320, 200, 50);
        backgroundLabel.add(Five_Points);

        Ten_Points = new JButton("Ten Points");
        Ten_Points.setFont(new Font("Consolas", Font.BOLD, 20));
        Ten_Points.setBackground(Color.WHITE);
        Ten_Points.setForeground(Color.BLACK);
        Ten_Points.setBounds(390, 400, 200, 50);
        backgroundLabel.add(Ten_Points);

        exitButton = new JButton("Exit Game");
        exitButton.setFont(new Font("Consolas", Font.BOLD, 20));
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBounds(GAME_FRAME_WIDTH - 200, GAME_FRAME_HEIGHT / 2 + 170, 150, 30);
        backgroundLabel.add(exitButton);

        soundOpen = new JButton("Music");
        soundOpen.setFont(new Font("Consolas", Font.BOLD, 12));
        soundOpen.setBackground(Color.WHITE);
        soundOpen.setForeground(Color.BLACK);
        soundOpen.setBounds(70, GAME_FRAME_HEIGHT / 2 + 170, 110, 30);
        backgroundLabel.add(soundOpen);

        soundClose = new JButton("Not Music");
        soundClose.setFont(new Font("Consolas", Font.BOLD, 12));
        soundClose.setBackground(Color.WHITE);
        soundClose.setForeground(Color.BLACK);
        soundClose.setBounds(190, GAME_FRAME_HEIGHT / 2 + 170, 110, 30);
        backgroundLabel.add(soundClose);
        soundClose.setFocusable(false);

        this.setVisible(true);
    }
}
