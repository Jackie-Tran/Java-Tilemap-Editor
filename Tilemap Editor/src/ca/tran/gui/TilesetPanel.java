package ca.tran.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.List;
import java.awt.Button;

public class TilesetPanel extends JPanel {

	private MainWindow window;
	private TilemapChooser popup;
	
	public TilesetPanel(MainWindow window) {
		setBackground(new Color(0x4d648d));
		setBounds(1025, 0, 249, 576);
		setLayout(null);
		this.window = window;
		addContents(window);
		popup = new TilemapChooser(window, this);
	}
	
	public void addContents(MainWindow window) {
		JButton btnNewButton = new JButton("Choose Tileset");
		btnNewButton.setBounds(66, 525, 117, 25);
		btnNewButton.setToolTipText("Choose a tileset for the project");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setEnabled(false);
				popup.setVisible(true);
			}
		});
		JLabel lblTileset = new JLabel("Tileset");
		lblTileset.setHorizontalAlignment(SwingConstants.CENTER);
		lblTileset.setForeground(Color.WHITE);
		lblTileset.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTileset.setBounds(12, 13, 225, 39);
		
		add(lblTileset);
		add(btnNewButton);
	}
	
}
