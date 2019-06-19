package ca.tran.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NewMapWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblTileHeight;
	private TilesetPanel tilesetPanel;

	/**
	 * Create the frame.
	 */
	public NewMapWindow(TilesetPanel tilesetPanel) {
		this.tilesetPanel = tilesetPanel;
		setTitle("Map Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTileWidth = new JLabel("Tile Width:");
		lblTileWidth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTileWidth.setHorizontalAlignment(SwingConstants.CENTER);
		lblTileWidth.setBounds(132, 58, 103, 35);
		contentPane.add(lblTileWidth);
		
		lblTileHeight = new JLabel("Tile Width:");
		lblTileHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblTileHeight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTileHeight.setBounds(132, 135, 103, 35);
		contentPane.add(lblTileHeight);
		
		JSpinner spnTileWidth = new JSpinner();
		spnTileWidth.setModel(new SpinnerNumberModel(new Integer(32), null, null, new Integer(1)));
		spnTileWidth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spnTileWidth.setBounds(258, 60, 214, 35);
		contentPane.add(spnTileWidth);
		
		JSpinner spnHeight = new JSpinner();
		spnHeight.setModel(new SpinnerNumberModel(new Integer(32), null, null, new Integer(1)));
		spnHeight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spnHeight.setBounds(258, 144, 214, 35);
		contentPane.add(spnHeight);
		
		JButton btnCreateMap = new JButton("Create Map");
		btnCreateMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Remove old tile palette
				tilesetPanel.getPnlTilePalette().removeAll();
				tilesetPanel.getPnlTilePalette().revalidate();
			}
		});
		btnCreateMap.setBounds(258, 211, 89, 23);
		contentPane.add(btnCreateMap);
	}
}
