//Copyright Martin Osborne and Ken Lambert 1998-2001
//All rights reserved

package war2.TurtleGraphics.TurtleGraphics;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A MessageBox is a dialog that displays a message and waits for the user to select OK.
 */
public class MessageBox extends JDialog implements ActionListener, WindowListener {

/**
 * Creates a MessageBox.
 */
   public MessageBox (JFrame parent, String message){
      super(parent, "Message", true);
      Container c = getContentPane();
      JTextArea ta = new JTextArea (message);
      ta.setEditable(false);
      ta.setFont(new Font("Courier", Font.PLAIN, 12));
      c.add("Center", new JScrollPane(ta));
      JPanel p = new JPanel();
      JButton b = new JButton("OK");
      b.addActionListener(this);
      p.add (b);
      c.add ("South", p);
      addWindowListener(this);
      setSize(300, 150);
   }

   // Handles click of OK button by closing up.

   @Override
public void actionPerformed (ActionEvent evt) {
      dispose();
   }

   @Override
public void windowActivated (WindowEvent e){}

   @Override
public void windowClosed (WindowEvent e){}
   @Override
public void windowClosing (WindowEvent e){
      //System.exit(0);                           //mo 6-25-98
      dispose();                                  //mo 6-25-98
   }
   @Override
public void windowDeactivated (WindowEvent e){}
   @Override
public void windowDeiconified (WindowEvent e){}
   @Override
public void windowIconified (WindowEvent e){}
   @Override
public void windowOpened (WindowEvent e){}


}

