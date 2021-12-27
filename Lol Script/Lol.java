/*
 * Name: Barrett Williamson
 * Date: 12/24/2021
 * Email: williamsonbarrett@gmail.com
 * Java Remake of Jack's Lol Script
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

class Lol extends Frame implements ActionListener {
	private final static String TITLE = "The Better League Client";
	Label label1;
    Button button1,button2,button3;
    JPanel panels, paneln;
    public Lol() {
        label1 = new Label("Welcome to "+ TITLE);
        panels = new JPanel();
        paneln = new JPanel();
        button1 = new Button("League of Legends");
        button2 = new Button("LOL V2");
        button3 = new Button("Make League Better");
        setSize(400,400);
        //setResizable(false);
        setTitle("Jack's Lol Script");
        setLayout(new BorderLayout());
        paneln.add(label1);
        add(paneln,BorderLayout.NORTH);
        panels.add(button1);
        panels.add(button2);
        panels.add(button3);
        add(panels,BorderLayout.SOUTH);
        try {add(getPicture(),BorderLayout.CENTER);} catch (IOException e) {e.printStackTrace();}
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent we) {dispose();}}); //maybe System.exit(0);
    }
    public JLabel getPicture() throws IOException {
        URL url = new URL("https://i.ytimg.com/vi/EEWYsOFKFIM/hqdefault.jpg");
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream("temp1.jpg");
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {os.write(b, 0, length);}
        is.close();os.close();
        BufferedImage myPicture = ImageIO.read(new File("temp1.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        return picLabel;
    }
	public void actionPerformed(ActionEvent action) {
        Desktop desk = Desktop.getDesktop();
        if(action.getSource()==button1){
            if (Files.exists(Paths.get("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Riot Games\\League of Legends.lnk"))){
                try {Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Riot Games\\League of Legends.lnk");} catch (IOException e) {e.printStackTrace();}
            }else {JOptionPane.showMessageDialog(null, "The game needs to be installed in order to launch it...", "Idiot", JOptionPane.INFORMATION_MESSAGE);}
        }
        if(action.getSource()==button2){try {desk.browse(new URI("https://store.steampowered.com/app/1731720/FURRY_SEX_Cabaret/"));} catch (IOException | URISyntaxException e) {e.printStackTrace();}}
        if(action.getSource()==button3){try {Runtime.getRuntime().exec("taskkill /F /IM LeagueClientUx.exe");} catch (IOException e) {e.printStackTrace();}}
    }
    public static void main(String[] args) {
        Lol Window = new Lol();
        Window.setVisible(true);
        Window.setLocationRelativeTo(null);
    }
}
