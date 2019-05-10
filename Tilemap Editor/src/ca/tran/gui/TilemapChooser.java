package ca.tran.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import ca.tran.editor.Map;
import javafx.scene.Parent;

public class TilemapChooser extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtfAlphaColour;
	private String path = "";

	/**
	 * Create the frame.
	 */
	public TilemapChooser(MainWindow window, TilesetPanel parent) {
		setResizable(false);
		setTitle("Add Tileset");
		setType(Type.POPUP);
		// Closing the window
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowListener listener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				window.setEnabled(true);
				setVisible(false);
				dispose();
			}
		};
		addWindowListener(listener);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFile = new JLabel("File:");
		lblFile.setToolTipText("Choose your tileset file.");
		lblFile.setBounds(39, 43, 32, 22);
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblFile);

		JButton btnChooseTileset = new JButton("Choose Tileset");
		btnChooseTileset.setToolTipText("No file chosen.");
		btnChooseTileset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open window chooser thing
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(window);
				path = fileChooser.getSelectedFile().getAbsolutePath();
				btnChooseTileset.setToolTipText(fileChooser.getSelectedFile().getName());

			}
		});
		btnChooseTileset.setBounds(135, 44, 123, 25);
		contentPane.add(btnChooseTileset);

		JLabel lblTileWidth = new JLabel("Tile Width:");
		lblTileWidth.setToolTipText("Choose the width of each tile.");
		lblTileWidth.setBounds(39, 96, 86, 22);
		lblTileWidth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblTileWidth);

		JLabel lblTileHeight = new JLabel("Tile Height:");
		lblTileHeight.setToolTipText("Choose the height of each tile.");
		lblTileHeight.setBounds(39, 159, 91, 22);
		lblTileHeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblTileHeight);

		JLabel lblTileAlpha = new JLabel("Tile Alpha:");
		lblTileAlpha.setToolTipText("If desired, choose a colour in HEX that will become transparent.");
		lblTileAlpha.setBounds(39, 217, 84, 22);
		lblTileAlpha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblTileAlpha);

		txtfAlphaColour = new JTextField();
		txtfAlphaColour.setBounds(135, 219, 123, 22);
		contentPane.add(txtfAlphaColour);
		txtfAlphaColour.setColumns(10);

		JSpinner spnTileWidth = new JSpinner();
		spnTileWidth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spnTileWidth.setModel(new SpinnerNumberModel(new Integer(32), new Integer(0), null, new Integer(1)));
		spnTileWidth.setBounds(135, 98, 123, 22);
		contentPane.add(spnTileWidth);

		JSpinner spnTileHeight = new JSpinner();
		spnTileHeight.setModel(new SpinnerNumberModel(new Integer(32), new Integer(0), null, new Integer(1)));
		spnTileHeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spnTileHeight.setBounds(135, 161, 123, 22);
		contentPane.add(spnTileHeight);

		JButton btnAddTileset = new JButton("Add Tileset");
		btnAddTileset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Updates values for tile sizes, image for tileset.
				window.setEnabled(true);
				// Getting new map data
				window.setTileWidth((int) spnTileWidth.getValue());
				window.setTileHeight((int) spnTileHeight.getValue());
				window.setTilesetPath(path);
				// Resetting the map
				Map tempMap = window.editor.getMap();
				tempMap.grabNewMapData();
				tempMap.createEmptyMap();

				// Adding tileset
				if (!path.isEmpty()) {
					try {
						window.setTileset(ImageIO.read(new File(path)));
						// Adding buttons dynamically
						createTilePalette(window, parent);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				setVisible(false);
				dispose();
			}
		});
		btnAddTileset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddTileset.setBounds(76, 295, 147, 25);
		contentPane.add(btnAddTileset);
		setLocationRelativeTo(null);
	}
	
	private void createTilePalette(MainWindow window, TilesetPanel parent) {
		BufferedImage tileset = window.getTileset();
		int imageWidth = tileset.getWidth();
		int imageHeight = tileset.getHeight();
		int tileWidth = window.getTileWidth();
		int tileHeight = window.getTileHeight();
		
		for (int j = 0; j < imageHeight/tileHeight; j++) {
			for (int i = 0; i < imageWidth/tileWidth; i++) {
				parent.getPnlTilePalette().add(new TileButton(null, 0));
			}
		}
		parent.revalidate();
		window.validate();
	}
}
