package src.Gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Jan 02 16:21:44 WIB 2024
 */

import src.Controller.Data;
import src.Controller.UserController;

/**
 * @author Reval
 */
public class main_menyu extends JFrame {
	public main_menyu() {
		initComponents();
	}

	private void battleMouseClicked(MouseEvent e) {
		// user.battle();
	}

	private void feedingMouseClicked(MouseEvent e) {
		// user.feeding();
	}

	private void userDeckMouseClicked(MouseEvent e) {
		// user.userDeck();
	}

	private void userZooMouseClicked(MouseEvent e) {
		// user.userZoo();
	}

	private void marketMouseClicked(MouseEvent e) {
		// user.market();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - haha
		battle = new JButton();
		feeding = new JButton();
		userDeck = new JButton();
		userZoo = new JButton();
		market = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();

		//======== this ========
		setVisible(true);
		setTitle("main menu");
		// setIconImage(new ImageIcon(getClass().getResource("/dungeons-and-dragons-jedd-chevrier-dungeons-and-dragons-curse-of-strahd-tabletop-role-playing-game-in-the-fantasy-genre-hd-wallpaper-preview.jpg")).getImage());
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		int interval = 500/5;


		//---- battle ----
		battle.setText("Battle");
		battle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				battleMouseClicked(e);
			}
		});
		contentPane.add(battle);
		battle.setBounds(15, 265, 75, 75);

		//---- userDeck ----
		userDeck.setText("Deck");
		userDeck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userDeckMouseClicked(e);
			}
		});
		contentPane.add(userDeck);
		userDeck.setBounds(interval+15, 265, 75, 75);

		//---- userZoo ----
		userZoo.setText("Zoo");
		userZoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userZooMouseClicked(e);
			}
		});
		contentPane.add(userZoo);
		userZoo.setBounds(interval*2+15, 265, 75, 75);

		//---- feeding ----
		feeding.setText("Feeding");
		feeding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				feedingMouseClicked(e);
			}
		});
		contentPane.add(feeding);
		feeding.setBounds(interval*3+15, 265, 75, 75);
		
		//---- market ----
		market.setText("Market");
		market.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				marketMouseClicked(e);
			}
		});
		contentPane.add(market);
		market.setBounds(interval*4+15, 265, 75, 75);

		//---- label1 ----
		label1.setText("Battle Of Dragon");
		label1.setFont(new Font("Javanese Text", label1.getFont().getStyle() | Font.ITALIC, 35));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label1);
		label1.setBounds(131, 110, 275, 105);

		//---- label2 ----
		label2.setText(Data.player.getPlayer().getNickname());
		contentPane.add(label2);
		label2.setBounds(20, 15, label2.getPreferredSize().width, 15);

		//---- label3 ----
		label3.setText("coins	: "+Data.player.getPlayer().getCoin());
		contentPane.add(label3);
		label3.setBounds(new Rectangle(new Point(20, 40), label3.getPreferredSize()));

		//---- label4 ----
		label4.setText("berries	: "+Data.player.getPlayer().getFood());
		contentPane.add(label4);
		label4.setBounds(new Rectangle(new Point(20, 60), label4.getPreferredSize()));

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - haha
	private JButton battle;
	private JButton feeding;
	private JButton userDeck;
	private JButton userZoo;
	private JButton market;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
