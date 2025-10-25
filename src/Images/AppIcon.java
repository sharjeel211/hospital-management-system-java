/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Images;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author shada
 */
public class AppIcon {
    public static void setIcon(JFrame frame) {
        ImageIcon icon = new ImageIcon(AppIcon.class.getResource("icon.png"));
        frame.setIconImage(icon.getImage());
    }
}
