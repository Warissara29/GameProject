import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

class Frame{
    static final int GAME_FRAME_WIDTH = 1000;
    static final int GAME_FRAME_HEIGHT = 540;
    static JFrame mainFrame; // เปลี่ยนเป็น static
    static HomeGame home;
    static Clip clip; 
  
    public static void main(String[] args) {
    	// โค้ดบรรทัดที่ 19-27 มาจากถามปัญญาประดิษฐ์ เพื่อแก้ปัญญาการนำเพลงเข้าแต่ไม่สามารถเปิดเพลงได้
    	try { 
            File file = new File("chipi.wav"); //เพิ่มไฟล์ chipi.wav เพื่อเล่นเพลง
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	
        mainFrame = new JFrame();
        mainFrame.setTitle("PingPong Game"); //ตั้งชื่อหน้าเกม
        mainFrame.setSize(GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
  
        
        home = new HomeGame();
        mainFrame.add(home);

        mainFrame.setVisible(true);

        home.exitButton.addActionListener(new ActionListener() { // การเช็คปุ่ม home.exitButton ถามปัญญาประดิษฐ์
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });

        home.soundOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	clip.start();
            }
        });

        home.soundClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 clip.stop();
            }
        });

        home.Three_Points.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll(); // ลบทุกองค์ประกอบออกจากเฟรม
                Panel panel = new Panel(3); // สร้าง Panel ใหม่ด้วยจำนวนคะแนนที่ต้องได้เพื่อชนะ
                mainFrame.add(panel); // เพิ่ม Panel ใหม่เข้าไปในเฟรม
                mainFrame.revalidate(); // เรียกใช้เพื่อทำการรวม Layout ใหม่
                mainFrame.repaint(); // เรียกใช้เพื่อทำการวาดภาพใหม่
                panel.requestFocusInWindow();  // โค้ดบรรทัดที่ 71 ถามปัญญาประดิษฐ์เพื่อแก้ปัญหาการรับข้อมูลจากแป้นพิมพ์ของผู้ใช้ไม่ได้
            }
        });

        home.Five_Points.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll(); // ลบทุกองค์ประกอบออกจากเฟรม
                Panel panel = new Panel(5); // สร้าง Panel ใหม่ด้วยจำนวนคะแนนที่ต้องได้เพื่อชนะ
                mainFrame.add(panel); // เพิ่ม Panel ใหม่เข้าไปในเฟรม
                mainFrame.revalidate(); // เรียกใช้เพื่อทำการรวม Layout ใหม่
                mainFrame.repaint(); // เรียกใช้เพื่อทำการวาดภาพใหม่m7
                panel.requestFocusInWindow();
            }
        });

        home.Ten_Points.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll(); // ลบทุกองค์ประกอบออกจากเฟรม
                Panel panel = new Panel(10); // สร้าง Panel ใหม่ด้วยจำนวนคะแนนที่ต้องได้เพื่อชนะ
                mainFrame.add(panel); // เพิ่ม Panel ใหม่เข้าไปในเฟรม
                mainFrame.revalidate(); // เรียกใช้เพื่อทำการรวม Layout ใหม่
                mainFrame.repaint(); // เรียกใช้เพื่อทำการวาดภาพใหม่
                panel.requestFocusInWindow();
            }
        });
    }

    public void backhome() {
        mainFrame.getContentPane().removeAll(); // ลบทุกองค์ประกอบออกจากเฟรม
        mainFrame.add(home); // เพิ่ม Panel ใหม่เข้าไปในเฟรม
        mainFrame.revalidate(); // เรียกใช้เพื่อทำการรวม Layout ใหม่
        mainFrame.repaint(); // เรียกใช้เพื่อทำการวาดภาพใหม่
    }
}
