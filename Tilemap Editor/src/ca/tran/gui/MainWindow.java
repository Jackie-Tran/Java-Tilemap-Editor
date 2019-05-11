package ca.tran.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import ca.tran.editor.Editor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainWindow extends JFrame {

	// Panel sizes for all components of the window
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public final int EDITOR_WIDTH = 1024;
	public final int EDITOR_HEIGHT = 576;

	// GUI Elements
	private JPanel contentPane;
	public Editor editor;
	public TilesetPanel panelTileset;

	// Map Values
	private int tileWidth = 32, tileHeight = 32; // Default Values
	private int numTiles;
	private String tilesetPath;
	private BufferedImage tileset;
	
	// Editor Variables
	public int tileId;

	// Tile info
	private JLabel lblTileImg;
	private JLabel lblTileId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					frame.editor.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Java Tilemap Editor");
		setResizable(false);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);

		JMenuItem mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panelEditor = new Panel();
		panelEditor.setBackground(Color.MAGENTA);
		panelEditor.setBounds(0, 0, EDITOR_WIDTH, EDITOR_HEIGHT);
		GridBagLayout gbl_panelEditor = new GridBagLayout();
		gbl_panelEditor.columnWidths = new int[] { EDITOR_WIDTH, 0 };
		gbl_panelEditor.rowHeights = new int[] { EDITOR_HEIGHT, 0 };
		gbl_panelEditor.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelEditor.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelEditor.setLayout(gbl_panelEditor);
		contentPane.add(panelEditor);

		panelTileset = new TilesetPanel(this);
		contentPane.add(panelTileset);

		// Adding editor canvas
		editor = new Editor(EDITOR_WIDTH, EDITOR_HEIGHT, this);
		editor.setPreferredSize(new Dimension(EDITOR_WIDTH, EDITOR_HEIGHT));

		GridBagConstraints gbc_editor = new GridBagConstraints();
		gbc_editor.anchor = GridBagConstraints.NORTHWEST;
		gbc_editor.gridx = 0;
		gbc_editor.gridy = 0;
		panelEditor.add(editor, gbc_editor);

		JPanel panelData = new JPanel();
		panelData.setBackground(SystemColor.activeCaption);
		panelData.setBounds(0, 574, 1274, 95);
		contentPane.add(panelData);
		panelData.setLayout(null);
		
		lblTileImg = new JLabel();
		lblTileImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblTileImg.setBounds(31, 10, 64, 64);
		lblTileImg.setForeground(Color.WHITE);
		panelData.add(lblTileImg);
		
		lblTileId = new JLabel();
		lblTileId.setHorizontalAlignment(SwingConstants.LEFT);
		lblTileId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTileId.setForeground(Color.WHITE);
		lblTileId.setBounds(135, 8, 252, 64);
		panelData.add(lblTileId);
		this.pack();

		setLocationRelativeTo(null);
	}
	
	public void changeBrushInfo(BufferedImage tile, int id) {
		lblTileImg.setIcon(new ImageIcon(tile));
		tileId = id;
		lblTileId.setText("Tile ID: " + tileId);
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	public int getNumTiles() {
		return numTiles;
	}

	public void setNumTiles(int numTiles) {
		this.numTiles = numTiles;
	}

	public String getTilesetPath() {
		return tilesetPath;
	}

	public void setTilesetPath(String tilesetPath) {
		this.tilesetPath = tilesetPath;
	}

	public BufferedImage getTileset() {
		return tileset;
	}

	public void setTileset(BufferedImage tileset) {
		this.tileset = tileset;
	}
}
