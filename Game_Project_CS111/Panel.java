import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;


public class Panel extends JPanel implements KeyListener {
    static final int GAME_FRAME_WIDTH = 1000;
    static final int GAME_FRAME_HEIGHT = 510;
    static final int BOARD_WIDTH = 25;
    static final int BOARD_HEIGHT = 100;
    static final int BALL_DIAMETER = 20;

    Player board1;
    Player board2;
    Pingpongballs ball;
    int Player_score1=0,Player_score2=0; 
    int Win_score=0;
    JButton backButton;
    
    Frame frame;
   
	public boolean gameEnded;
    
	
	// โค้ดบรรทัดที่ 30-37 เป็นผลงานของ ช่องยุปทูป Bro code
	Panel(int points) {
	    newBoard();
	    frame = new Frame();
	    Win_score = points;
	    setBackground(Color.BLACK);
	    setFocusable(true);
	    addKeyListener(this);
	    newPingpongballs();
	    gameEnded = false; // กำหนดค่าให้กับตัวแปร gameEnded ที่ถูกสร้างในคลาส Panel
	    this.setBounds(0,0, GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
	    
	    // โค้ดบรรทัดที่ 41-54 เป็นผลงานของปัญญาประดิษฐ์เพื่อให้เกมสามารถเล่นได้
	    Timer timer = new Timer(10, new ActionListener() {    
	        public void actionPerformed(ActionEvent e) {
	            checkCollision(); // เรียกใช้เมท็อดเพื่อตรวจสอบการชนและอัปเดตคะแนน
	            ball.Move();
	            
	            if (gameEnded) {
	                // หยุดการทำงานของตัวจับเวลา
	                ((Timer) e.getSource()).stop();
	            }
	            repaint();
	        }
	    });
	    timer.start();
	    this.setVisible(true);
	    
	}
	// เมธอด newBoard เป็นผลงานของ ช่องยุปทูป Bro code
    public void newBoard() {
        board1 = new Player(5, ((GAME_FRAME_HEIGHT) / 2) - 45, BOARD_WIDTH, BOARD_HEIGHT, 1);
        board2 = new Player(955, ((GAME_FRAME_HEIGHT) / 2) - 45, BOARD_WIDTH, BOARD_HEIGHT, 2);
    }
   // เมธอด newPingpongballs เป็นผลงานของ ช่องยุปทูป Bro code
    public void newPingpongballs() {
        ball = new Pingpongballs(490, 265, BALL_DIAMETER, BALL_DIAMETER);
    }
    
    // เค้าโครงเมธอด paintComponent ปรับแก้มาจากผลงานของ ช่องยุปทูป Bro code
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Load background image
        ImageIcon backgroundImage = new ImageIcon("Panel.png");
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        
        board1.draw(g);
        board2.draw(g);
        
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 40));

        g.drawLine(GAME_FRAME_WIDTH / 2, 0, GAME_FRAME_WIDTH / 2, GAME_FRAME_HEIGHT);
        
        g.setColor(Color.BLACK);
		g.fillRect(405, 7, 190, 50);
		
		g.setColor(Color.white);
		g.drawLine(1000/2, 0, 1000/2, (int) (1000 * (0.5555)));
		g.drawString(String.valueOf(Player_score1/10)+String.valueOf(Player_score1%10), (1000/2)-75, 50);
		g.drawString(String.valueOf(Player_score2/10)+String.valueOf(Player_score2%10), (1000/2)+30, 50);
        
        ball.Draw(g);
    }
    public void checkCollision() {
        if (board1.WPressed) {
            board1.moveW();
        }
        if (board1.SPressed) {
            board1.moveS();
        }
        if (board2.UPPressed) {
            board2.moveUP();
        }
        if (board2.DOWNPressed) {
            board2.moveDOWN();
        }
        // โค้ดบรรทัดที่ 106-115 เป็นผลงานของ ช่องยุปทูป Bro code
        if (board1.y <= 0) //เช็คว่าบอร์ด 1 อยู่ที่ด้านบนสุดของหน้าจอหรือไม่
            board1.y = 0;
        if (board1.y >= (GAME_FRAME_HEIGHT - BOARD_HEIGHT)) //เช็คว่าบอร์ด 1 อยู่ที่ด้านล่างสุดของหน้าจอหรือไม่
            board1.y = GAME_FRAME_HEIGHT - BOARD_HEIGHT;
        
        if (board2.y <= 0) //เช็คว่าบอร์ด 2 อยู่ที่ด้านบนสุดของหน้าจอหรือไม่
            board2.y = 0;
        if (board2.y >= (GAME_FRAME_HEIGHT - BOARD_HEIGHT)) //เช็คว่าบอร์ด 2 อยู่ที่ด้านล่างสุดของหน้าจอหรือไม่
            board2.y = GAME_FRAME_HEIGHT - BOARD_HEIGHT;
        
        if (ball.y <= 0 || ball.y >= GAME_FRAME_HEIGHT-BALL_DIAMETER) {
        	ball.speedY= -ball.speedY;
        }
        // โค้ดบรรทัดที่ 120 - 127 เป็นผลงานของจากการสอบถามปัญญาประดิษฐ์ เพื่อแก้ปัญหาการเช็คของการเช็คลูกปิงปองกระเด็น 
        if (ball.x <= (board1.x + BOARD_WIDTH) && (ball.y >= board1.y && ball.y <= (board1.y + BOARD_HEIGHT))) {
            ball.x = board1.x + BOARD_WIDTH; // กำหนดให้ตำแหน่ง x ของลูกบอลอยู่ที่ขอบของบอร์ด
            ball.speedX = -ball.speedX; // สลับทิศทางการเคลื่อนที่ในแกน x
        }
        if ((ball.x + BALL_DIAMETER) >= board2.x && (ball.y >= board2.y && ball.y <= (board2.y + BOARD_HEIGHT))) {
            ball.x = board2.x - BALL_DIAMETER; // กำหนดให้ตำแหน่ง x ของลูกบอลอยู่ที่ขอบของบอร์ด
            ball.speedX = -ball.speedX; // สลับทิศทางการเคลื่อนที่ในแกน x
        }
     // โค้ดบรรทัดที่ 130-139 เป็นผลงานของ ช่องยุปทูป Bro code
		if (ball.x <= 0) {
            newBoard();
            newPingpongballs();
            Player_score2 += 1; // เพิ่มคะแนนสำหรับผู้เล่นที่ตีลูกบอลผ่านขอบฝั่งทางตรงข้าม
        }
        if (ball.x >= GAME_FRAME_WIDTH - BALL_DIAMETER) {
            newBoard();
            newPingpongballs();
            Player_score1 += 1; // เพิ่มคะแนนสำหรับผู้เล่นที่ตีลูกบอลผ่านขอบฝั่งทางตรงข้าม
        }
        if (Player_score1 == Win_score || Player_score2 == Win_score) {
            setgameEnded(true);
            JFrame f = new JFrame();
            f.setTitle("Game Over");
            f.setPreferredSize(new Dimension(400, 230));
            JLabel label;
            if (Player_score1 == Win_score) {
            	JLabel backgroundLabel = new JLabel(new ImageIcon("Bluewin.png"));
                f.add(backgroundLabel);
            } else {
            	JLabel backgroundLabel = new JLabel(new ImageIcon("Redwin.png"));
                f.add(backgroundLabel); 
            }
            f.pack(); // Pack the JFrame to fit its content
            f.setLocationRelativeTo(null); // Center the JFrame horizontally
            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // กำหนดไม่ให้ปิดหน้าต่างโดยอัตโนมัติ
            f.addWindowListener(new WindowAdapter() {
                @Override
                // โค้ดบรรทัดที่ 151 เป็นผลงานของปัญญาประดิษฐ์เพื่อเพิ่มการเช็คว่า หน้าจอชนะถูกปิด
                public void windowClosing(WindowEvent e) {
                    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                        f.dispose();
                    }
                }
            });
            f.setVisible(true);
            backButton = new JButton("Back to Home");
            backButton.setFont(new Font("Consolas", Font.BOLD, 16));
            backButton.setBackground(Color.WHITE);
            backButton.setForeground(Color.BLACK);
            backButton.setBounds(GAME_FRAME_WIDTH - 200, GAME_FRAME_HEIGHT/2 + 170, 150, 30);
            this.add(backButton);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // ตั้งค่า backButtonPressed เป็น true เมื่อปุ่มกลับถูกกด
                    frame.backhome();
                }
            });
        }
    }
    // โค้ดบรรทัดที่ 182 -184 ปรับแก้มาจากผลงานของ ช่องยุปทูป Bro code
    public void keyPressed(KeyEvent e) {
        board1.keyPressed(e);
        board2.keyPressed(e);
        if (!ball.Start) {
            ball.startMoving(); 
            ball.speedX=2;
            ball.speedY=2;
        }
        repaint();
    }
    
    public void setgameEnded(boolean display) {
    	 gameEnded = display;
	}
    
    public boolean getgameEnded() {
    	return gameEnded;
	}
   // โค้ดบรรทัดที่ 200 -203 ปรับแก้มาจากผลงานของ ช่องยุปทูป Bro code
    public void keyReleased(KeyEvent e) {
        board1.keyReleased(e);
        board2.keyReleased(e);
        repaint();
    }
    public void setWinscore(int point) {
    	Win_score = point;
	}
    public int getWinscore() {
    	return Win_score;
	}
    
    public void keyTyped(KeyEvent e) {
    }
}