package ca.tran.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import ca.tran.editor.Editor;

public class TilesetPanel extends JPanel {

	private MainWindow window;
	private JPanel pnlTilePalette;
	private TilemapChooser popup;
	private ArrayList<TileButton> tilePalette;
	
	public TilesetPanel(MainWindow window, Editor editor) {
		setBackground(new Color(0x4d648d));
		setBounds(1025, 0, 249, 576);
		setLayout(null);
		this.window = window;
		addContents(window);
		tilePalette = new ArrayList<TileButton>();
		popup = new TilemapChooser(window, editor, this);		
	}
	
	public void addContents(MainWindow window) {
		
		JLabel lblTileset = new JLabel("Tileset");
		lblTileset.setHorizontalAlignment(SwingConstants.CENTER);
		lblTileset.setForeground(Color.WHITE);
		lblTileset.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTileset.setBounds(12, 13, 225, 39);

		pnlTilePalette = new JPanel();
		ModifiedFlowLayout flowlayout = new ModifiedFlowLayout();
		flowlayout.setAlignment(FlowLayout.LEADING);
		pnlTilePalette.setLayout(flowlayout);
		pnlTilePalette.setBounds(22, 65, 204, 444);
		//add(pnlTilePalette);
		
		JScrollPane scrollPane = new JScrollPane(pnlTilePalette, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(22, 64, 204, 444);
		scrollPane.setPreferredSize(new Dimension(204, 444));
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollPane);

		JButton btnChooseTileset = new JButton("Choose Tileset");
		btnChooseTileset.setBounds(66, 525, 117, 25);
		btnChooseTileset.setToolTipText("Choose a tileset for the project");
		btnChooseTileset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open the tilemap chooser window
				window.setEnabled(false);
				popup.setVisible(true);
			}
		});
		add(lblTileset);
		add(btnChooseTileset);
	}
	
	public void clearPalette() {
		for (TileButton button : tilePalette) {
			remove(button);
			tilePalette.remove(button);
		}
	}

	public JPanel getPnlTilePalette() {
		return pnlTilePalette;
	}

	public void setPnlTilePalette(JPanel pnlTilePalette) {
		this.pnlTilePalette = pnlTilePalette;
	}

	public ArrayList<TileButton> getTilePalette() {
		return tilePalette;
	}
	
}
