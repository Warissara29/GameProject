import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{

	int PlayerID;
	int boardwidth, boardheigth;
	public boolean WPressed = false;
	public boolean SPressed = false;
	public boolean UPPressed = false;
	public boolean DOWNPressed = false;
	public boolean Player1_start = false;
	public boolean Player2_start = false;
	
	// บรรทัดที่ 16-21 เป็นผลงานของ ช่องยุปทูป Bro code
	Player(int x, int y, int boardwidth, int boardheigth , int id){
	    this.boardwidth = boardwidth;
	    this.boardheigth = boardheigth;
	    this.y = y;
	    this.x = x;
	    this.PlayerID = id;
	}
	// เค้าโครงของเมธอด keyPressed และ keyReleased  ปรับแก้โค้ด หลังจากทำการเรียนรู้จากผลงานของ ช่องยุปทูป Bro code
	public void keyPressed(KeyEvent e) {
        if (PlayerID == 1) {
        	if (e.getKeyCode() == KeyEvent.VK_W) {
            	WPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
            	SPressed = true;
            }
        }
        if (PlayerID ==2) {
        	if (e.getKeyCode() == KeyEvent.VK_UP) {
            	UPPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            	DOWNPressed = true;
            }
        }
	}

	public void keyReleased(KeyEvent e) {
		if (PlayerID == 1) {
        	if (e.getKeyCode() == KeyEvent.VK_W) {
            	WPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
            	SPressed = false;
            }
        }
        if (PlayerID ==2) {
        	if (e.getKeyCode() == KeyEvent.VK_UP) {
            	UPPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            	DOWNPressed = false;
            }
        }
	}
	public int moveW() {
		return this.y -= 5;
	}
	public int moveS() {
		return this.y += 5;
	}
	public int moveUP() {
		return this.y -= 5;
	}
	public int moveDOWN() {
		return this.y += 5;
	}
	// โค้ดบรรทัดที่ 78-82 เป็นผลงานของ ช่องยุปทูป Bro code
	public void draw(Graphics g) {
		if(PlayerID==1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(this.x,this.y, boardwidth, boardheigth);
	}
}