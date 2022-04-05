//Copyright Martin Osborne and Ken Lambert 1998-2001
//All rights reserved

package war2.TurtleGraphics.TurtleGraphics;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 * The class GBDialog (short for Grid Bag Dialog) provides a high-level dialog window.
 * The window comes with a built in GridBagLayout.  A GBDialog is modal.  Its parent should be
 * an application (an instance of GBFrame), or an anonymous Frame when used with GBApplet
 * or another GBDialog.
 * Components are added
 * to the window by specifying their row position, column position, width (in columns),
 * and height (in rows)in the grid.  The window has a default size of (300, 300), which
 * the client can override with setSize.  A GBDialog is displayed by using the method
 * show() rather than setVisible(true).
 * <BR>
 * <BR>
 * Events of different types, such as button clicks and list item selections,
 * are handled by implementing the appropriate GBDialog methods in the application.
 * GBDialog supports the same functionality as GBFrame, with the exception that
 * pulldown menus are not supported, and with the addition of a dialog close indicator.
 * This attribute, which has the value "Cancel" by default, can be used to determine
 * how the user quit the dialog.
 * <BR>
 * <BR>
 */
 public class GBDialog extends JDialog{
   GridBagLayout gbl = new GridBagLayout();
   GridBagConstraints gbc = new GridBagConstraints();
   GBDialogWindowListener windowListener;

   private String dlgCloseIndicator = "Cancel";       //mo 6-25-98

   private JFrame theMainFrame;                        //mo 6-25-98
   private Container contentPane;

/**
 * Creates a GBDialog whose parent is the application mainFrame.
 */
    public GBDialog(JFrame theMainFrm){
      super (theMainFrm, true);
      theMainFrame = theMainFrm;

      setSize (300,300);

      contentPane = getContentPane();
      contentPane.setLayout(gbl);
      gbc.weightx = 100;
      gbc.weighty = 100;
      gbc.insets.bottom = 1;
      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 1;
      setTitle(" ");

      windowListener = new GBDialogWindowListener(this);
      addWindowListener(windowListener);
   }

   private void add( Component c,int y, int x, int w, int h){
      gbc.gridx = x-1;
      gbc.gridy = y-1;
      gbc.gridwidth = w;
      gbc.gridheight = h;
      gbl.setConstraints(c, gbc);
      contentPane.add(c);
   }

   /**
 * Adds a JButton with the specified name to the specified position, with the specified
 * width and height.
 * @param  text The name of the Button.
 * @param  row The beginning row (starting from 1) of the window's grid in which the Button is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the Button is displayed.
 * @param  width The number of columns of the window's grid occuppied by the Button.
 * @param  height The number of rows of the window's grid occuppied by the Button.
 * @return the button.
 * Example:
 * <pre>
 *    JButton okButton = addButton("OK", 1, 1, 1, 1);
 *    // Adds a button at position row 1, column 1,
 *    // with a width of 1 column and a height of one row.
 * </pre>
 */
    public JButton addButton (String text, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.NONE;
      gbc.anchor = GridBagConstraints.CENTER;
      JButton control = new JButton (text);
      control.addActionListener(new GBDialogButtonListener(this));
      add (control, row, col, width, height);
      return control;
   }

   /**
 * Adds a JCheckBox to the specified position, with the specified
 * width and height.
 * @param  row The beginning row (starting from 1) of the window's grid in which the JCheckBox is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the JCheckBox is displayed.
 * @param  width The number of columns of the window's grid occuppied by the JCheckBox.
 * @param  height The number of rows of the window's grid occuppied by the JCheckBox.
 * @return the JCheckBox.
 */
    public JCheckBox addCheckBox (String text, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      JCheckBox control = new JCheckBox (text);
      add (control, row, col, width, height);
      return control;
   }

/**
 * Adds a JComboBox (pull down list) to the specified position, with the specified
 * width and height.
 * @param  row The beginning row (starting from 1) of the window's grid in which the JComboBox is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the JComboBox is displayed.
 * @param  width The number of columns of the window's grid occuppied by the JComboBox.
 * @param  height The number of rows of the window's grid occuppied by the JComboBox.
 * @return the JComboBox.
 */
    public JComboBox addComboBox (int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.NONE;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      JComboBox control = new JComboBox();
      add (control, row, col, width, height);
      return control;
   }

/**
 * Adds a DoubleField containing the specified number to the specified position, with the specified
 * width and height.
 * @param  num The number to be displayed initially.
 * @param  row The beginning row (starting from 1) of the window's grid in which the DoubleField is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the DoubleField is displayed.
 * @param  width The number of columns of the window's grid occuppied by the DoubleField.
 * @param  height The number of rows of the window's grid occuppied by the DoubleField.
 * @returns the DoubleField.
 */
    public DoubleField addDoubleField (double num, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      DoubleField control = new DoubleField (num);
      add (control, row, col, width, height);
      return control;
   }

/**
 * Adds an IntegerField containing the specified integer to the specified position, with the specified
 * width and height.
 * @param  num The integer to be displayed initially.
 * @param  row The beginning row (starting from 1) of the window's grid in which the IntegerField is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the IntegerField is displayed.
 * @param  width The number of columns of the window's grid occuppied by the IntegerField.
 * @param  height The number of rows of the window's grid occuppied by the IntegerField.
 * @returns the IntegerField.
 */
    public IntegerField addIntegerField (int num, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      IntegerField control = new IntegerField (num);
      add (control, row, col, width, height);
      return control;
   }

   /**
 * Adds a label with the specified name to the specified position, with the specified
 * width and height.
 * @param  text The name of the label.
 * @param  row The beginning row (starting from 1) of the window's grid in which the label is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the label is displayed.
 * @param  width The number of columns of the window's grid occuppied by the label.
 * @param  height The number of rows of the window's grid occuppied by the label.
 * @return  the JLabel
 */
    public JLabel addLabel (String text, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.NONE;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      JLabel control = new JLabel (text);
      add (control, row, col, width, height);
      return control;
   }

   /**
 * Adds a JList (a scrolling list) to the specified position, with the specified
 * width and height.
 * @param  row The beginning row (starting from 1) of the window's grid in which the JList is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the JList is displayed.
 * @param  width The number of columns of the window's grid occuppied by the JList.
 * @param  height The number of rows of the window's grid occuppied by the JList.
 * @return the JList
 */
    public JList addList (int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      gbc.weightx = 500;
      gbc.weighty = 500;
      JList control = new JList (new DefaultListModel()); //height*2, false);
      control.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      control.addMouseListener(new GBDialogDCListener(control, this));
      add (new JScrollPane(control), row, col, width, height);
      gbc.weightx = 100;
      gbc.weighty = 100;
      return control;
   }

   /**
 * Adds a GBPanel to the specified position, with the specified
 * width and height.
 * @param  row The beginning row (starting from 1) of the window's grid in which the GBPanel is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the GBPanel is displayed.
 * @param  width The number of columns of the window's grid occuppied by the GBPanel.
 * @param  height The number of rows of the window's grid occuppied by the GBPanel.
 * @return the GBPanel.
 */
    public GBPanel addPanel(GBPanel panel, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      gbc.weightx = 500;
      gbc.weighty = 500;
      add (panel, row, col, width, height);
      gbc.weightx = 100;
      gbc.weighty = 100;
      return panel;
   }

/**
 * Adds a JRadioButton to the specified position, with the specified
 * width and height.
 * @param  row The beginning row (starting from 1) of the window's grid in which the JRadioButton is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the JRadioButton is displayed.
 * @param  width The number of columns of the window's grid occuppied by the JRadioButton.
 * @param  height The number of rows of the window's grid occuppied by the JRadioButton.
 * @return the JRadioButton.
 */
    public JRadioButton addRadioButton (String text, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      JRadioButton control = new JRadioButton (text);
      add (control, row, col, width, height);
      return control;
   }

   // Abstract event handlers for buttons and lists.

 /**
 * Adds a JTextArea containing the specified string to the specified position, with the specified
 * width and height.
 * @param  text The string to be displayed initially.
 * @param  row The beginning row (starting from 1) of the window's grid in which the JTextArea is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the JTextArea is displayed.
 * @param  width The number of columns of the window's grid occuppied by the JTextArea.
 * @param  height The number of rows of the window's grid occuppied by the JTextArea.
 * @return the TextArea.
 */
    public JTextArea addTextArea (String text, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.BOTH;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      gbc.weightx = 500;
      gbc.weighty = 500;
      JTextArea control = new JTextArea (text); //, height*2, width*15);
      add (new JScrollPane(control), row, col, width, height);
      gbc.weightx = 100;
      gbc.weighty = 100;
      control.setFont (new Font ("Courier", Font.PLAIN, 12));
      return control;
   }

/**
 * Adds a JTextField containing the specified string to the specified position, with the specified
 * width and height.
 * @param  text The string to be displayed initially.
 * @param  row The beginning row (starting from 1) of the window's grid in which the JTextField is displayed.
 * @param  col The beginning column (starting from 1) of the window's grid in which the JTextField is displayed.
 * @param  width The number of columns of the window's grid occuppied by the JTextField.
 * @param  height The number of rows of the window's grid occuppied by the JTextField.
 * @return the JTextField.
 */
   public JTextField addTextField (String text, int row, int col, int width, int height){
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.NORTHWEST;
      JTextField control = new JTextField (text);
      add (control, row, col, width, height);
      return control;
   }

/**
 * The application must implement this method in order to handle button clicks.
 * If no buttons are added to the window, this method need not be implemented.
 * @param  buttonObj The JButton in which the click occurred.
 * Example:
 * <pre>
 *    // Add the buttons to the window.
 *    JButton okButton = addButton("OK", 1, 1, 1, 1);
 *    JButton cancelButton = addButton("Cancel", 1, 2, 1, 1);
 *    // Handle the button selection.
 *    public void buttonClicked(JButton buttonObj){
 *       if (buttonObj == okButton)
 *          messageBox("OK selected");
 *       else
 *          messageBox("Cancel selected");
 *    }
 * </pre>
 */
   public void buttonClicked(JButton buttonObj){
      messageBox ("You need a 'buttonClicked' method");
   }

   // Methods to add window objects to the interface.  Listeners
   // are added for buttons and lists.

// mo 6-25-98
/**
 * Returns the current dialog close indicator.
 */
   public String getDlgCloseIndicator(){
      return dlgCloseIndicator;
   }

/**
 * The application must implement this method in order to handle a
 * double click on an item in a scrolling list.
 * If no double click is anticipated, this method need not be implemented.
 * @param  listObj The JList in which the double click occurred.
 * @param  itemClicked The string selected by the double click.
 */
   public void listDoubleClicked (JList listObj, String itemClicked){
      messageBox ("You need a 'listDoubleClicked' method");
   }

/**
 * The application must implement this method in order to handle a selection
 * (single click) on an item in a scrolling list.
 * If no event handling is desired, this method need not be implemented.
 * @param  listObj The JList in which the selection occurred.
 */
   public void listItemSelected (JList listObj){
   }

/**
 * Pops up a message box containing the number and an OK button.
 */
   public void messageBox (double num){
      MessageBox mb = new MessageBox (theMainFrame, "" + num);  //mo 6-25-98
      mb.show();
   }

public void messageBox (double num, int width, int height){
      MessageBox mb = new MessageBox (theMainFrame, "" + num);
      mb.setSize(width, height);
      mb.show();
   }

/**
 * Pops up a message box containing the string representation of the object and an OK button.
 */
   public void messageBox (Object msg){
      MessageBox mb = new MessageBox (theMainFrame, msg.toString()); //mo 6-25-98
      mb.show();
   }

public void messageBox (Object msg, int width, int height){
      MessageBox mb = new MessageBox (theMainFrame, msg.toString());
      mb.setSize(width, height);
      mb.show();
   }

/**
 * Pops up a message box containing the string and an OK button.
 */
   public void messageBox (String msg){
      MessageBox mb = new MessageBox (theMainFrame, msg);       //mo 6-25-98
      mb.show();
   }

public void messageBox (String msg, int width, int height){
      MessageBox mb = new MessageBox (theMainFrame, msg);
      mb.setSize(width, height);
      mb.show();
   }

// mo 6-25-98
/**
 * Allows the client to reset the dialog close indicator, which by
 * default is "Cancel".
 */
   public void setDlgCloseIndicator (String str){
      dlgCloseIndicator = str;
   }

/**
 * Allows the application to set the look and feel of the window
 * and all its subcomponents to a platform-specific look and feel.
 * If no event handling is desired, this method need not be implemented.
 * @param  type A String, either "METAL", "MOTIF", or "OTHER"
 */
    public void setLookAndFeel(String type){
      int value = 0;
      UIManager.LookAndFeelInfo[] looks;
      looks = UIManager.getInstalledLookAndFeels();
      if (type.equalsIgnoreCase("METAL")) {
		value = 0;
	} else if (type.equalsIgnoreCase("MOTIF")) {
		value = 1;
	} else {
		value = 2;
	}
      try{
         UIManager.setLookAndFeel(looks[value].getClassName());
         SwingUtilities.updateComponentTreeUI(this);
      }catch(Exception e){
         messageBox("Error: \n" + e.toString());
      }
   }

   @Override
public void setSize(int width, int height){
      super.setSize(width, height);
      //if (menuBar.getMenuCount() > 0)                mo 6-25-98
      //   setMenuBar (menuBar);                       mo 6-25-98
   }
}


// Martin: here are the new controller classes.  I suppose we should
//         put the source code in separate .java files, but I was lazy.

// Controller class to handle window event closing.

class GBDialogButtonListener implements ActionListener{

   GBDialog myDialog;

   public GBDialogButtonListener(GBDialog dlg){
      myDialog = dlg;
   }

   @Override
public void actionPerformed(ActionEvent e){
      myDialog.buttonClicked((JButton) e.getSource());
   }
}

// Controller class to handle button events.

class GBDialogDCListener extends MouseAdapter{

   private JList list;
   private GBDialog dlg;

   public GBDialogDCListener(JList list, GBDialog dlg){
      this.list = list;
      this.dlg = dlg;
   }

   @Override
public void mouseClicked(MouseEvent e) {
      if (((DefaultListModel)list.getModel()).isEmpty()) {
		return;
	}
      if (e.getClickCount() == 2) {
         int index = list.locationToIndex(e.getPoint());
         String s = (String) ((DefaultListModel) list.getModel()).elementAt(index);
         dlg.listDoubleClicked(list, s);
      }
      else if (e.getClickCount() == 1) {
		dlg.listItemSelected(list);
	}
   }
}

// Controller class to handle list selection and double click events.

class GBDialogWindowListener extends WindowAdapter{

   GBDialog myDialog;

   public GBDialogWindowListener(GBDialog dlg){
      myDialog = dlg;
   }

   @Override
public void windowClosing(WindowEvent e){
      //System.exit(0);                        //mo 6-25-98
      myDialog.dispose();                      //mo 6-25-98
   }
}
