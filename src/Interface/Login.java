package src.Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.Controller.Data;
import src.Node.Data.Account;

public class Login  {

	private void loginClicked(MouseEvent e) {
		int userid = Data.playerList.searchAccount(Username.getText());
		Account account = Data.playerList.getAccount(userid);
		
		if (!Password.getPassword().equals(account.getPassword())) {
			Data.game.print("Password salah");
			return;
		}

		System.out.println(userid);
	}

	public void initComponents() {
		GUI = new JFrame();
		PassLabel = new JLabel();
		button1 = new JButton();
		UserLabel = new JLabel();
		Username = new JTextField();
		Password = new JPasswordField();

		{
			GUI.setTitle("Battle Of Dragon");
			GUI.setVisible(true);
			Container GUIContentPane = GUI.getContentPane();
			GUIContentPane.setLayout(null);

			PassLabel.setText("PASSWORD");
			GUIContentPane.add(PassLabel);
			PassLabel.setBounds(320, 235, 190, 16);

			button1.setText("LOGIN");
			button1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					loginClicked(e);
				}
			});
			GUIContentPane.add(button1);
			button1.setBounds(320, 315, 190, 37);

			UserLabel.setText("USERNAME");
			GUIContentPane.add(UserLabel);
			UserLabel.setBounds(320, 170, 190, UserLabel.getPreferredSize().height);
			GUIContentPane.add(Username);
			Username.setBounds(320, 195, 190, 30);
			GUIContentPane.add(Password);
			Password.setBounds(320, 260, 190, 30);

			{
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < GUIContentPane.getComponentCount(); i++) {
					Rectangle bounds = GUIContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = GUIContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				GUIContentPane.setMinimumSize(preferredSize);
				GUIContentPane.setPreferredSize(preferredSize);
			}
			GUI.setSize(800, 550);
			GUI.setLocationRelativeTo(null);
		}
	}

	private JFrame GUI;
	private JLabel PassLabel;
	private JButton button1;
	private JLabel UserLabel;
	private JTextField Username;
	private JPasswordField Password;
}
