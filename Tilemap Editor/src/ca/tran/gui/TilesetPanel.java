package ca.tran.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TilesetPanel extends JPanel {

	private MainWindow window;
	private JPanel pnlTilePalette;
	private TilemapChooser popup;
	private LinkedList<TileButton> tileSwatches = new LinkedList<TileButton>();
	
	public TilesetPanel(MainWindow window) {
		setBackground(new Color(0x4d648d));
		setBounds(1025, 0, 249, 576);
		setLayout(null);
		this.window = window;
		addContents(window);
		popup = new TilemapChooser(window, this);		
	}
	
	public void addContents(MainWindow window) {
		
		JLabel lblTileset = new JLabel("Tileset");
		lblTileset.setHorizontalAlignment(SwingConstants.CENTER);
		lblTileset.setForeground(Color.WHITE);
		lblTileset.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTileset.setBounds(12, 13, 225, 39);

		pnlTilePalette = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlTilePalette.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		pnlTilePalette.setBounds(22, 65, 204, 444);
		add(pnlTilePalette);

		JButton btnNewButton = new JButton("Choose Tileset");
		btnNewButton.setBounds(66, 525, 117, 25);
		btnNewButton.setToolTipText("Choose a tileset for the project");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setEnabled(false);
				popup.setVisible(true);
			}
		});
		for (int i = 0; i < 60; i++) {
			 pnlTilePalette.add(new TileButton(null, 0));
		 }
		add(lblTileset);
		add(btnNewButton);
	}
	
	public void clearPalette() {
		tileSwatches.removeAll(tileSwatches);
	}

	public LinkedList<TileButton> getTileSwatches() {
		return tileSwatches;
	}

	public JPanel getPnlTilePalette() {
		return pnlTilePalette;
	}

	public void setPnlTilePalette(JPanel pnlTilePalette) {
		this.pnlTilePalette = pnlTilePalette;
	}
	
	
	
	
}
