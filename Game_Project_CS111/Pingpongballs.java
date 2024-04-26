import java.awt.*;
import java.util.Random;

public class Pingpongballs extends Rectangle {
    double speedX;
    double speedY;
    boolean Start;
    
    // บรรทัดที่ 10-13 ปรับแก้โค้ด หลังจากทำการเรียนรู้จากผลงานของ ช่องยุปทูป Bro code
    public Pingpongballs(int x, int y, int width, int height) {
        super(x, y, width, height);
        speedX = 2;
        speedY = 2;
        Start = false;
    }
   // บรรทัดที่ 17-21 ปรับแก้โค้ด หลังจากทำการเรียนรู้จากผลงานของ ช่องยุปทูป Bro code
    public void Move() {
        if (Start) {
            x += speedX*2;
            y += speedY*2;
        }
    }

    public void startMoving() {
        Start = true;
    }

    public void resetPosition() {
        x = 475;
        y = 265; 
        speedX = 1;
        speedY = 1;
        Start = false; 
    }
    // โค้ดบรรทัดที่ 36-39 เป็นผลงานของ ช่องยุปทูป Bro code
    public void Draw(Graphics g) {
        g.setColor(new Color(254, 138, 48));
        g.fillOval(x, y, height, width);
    }
}