package ca.tran.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import ca.tran.editor.Editor;
import ca.tran.image.ImageEditor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	// Panel sizes for all components of the window
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	// GUI Elements
	private JPanel contentPane;
	public Editor editor;
	public TilesetPanel panelTileset;

	// Map Values
	private String tilesetPath;
	private BufferedImage tileset;
	
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

		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!editor.getMap().isEmpty()) {
					// Ask if they want to save
					int n = JOptionPane.showConfirmDialog(null,
							"Map has been modified. Would you like to save changes?", "Save Map", JOptionPane.YES_NO_CANCEL_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						// Prompt to save file
					} else if (n == JOptionPane.NO_OPTION) {
						
					}
				} else {
					
				}
			}
		});
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
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!editor.getMap().isEmpty()) {
					// Ask if they want to save
					int n = JOptionPane.showConfirmDialog(null,
							"Map has been modified. Would you like to save changes?", "Save Map", JOptionPane.YES_NO_CANCEL_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						// Promt to save file
					} else if (n == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				} else {
					System.exit(0);
				}
			}
		});
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnEdit);

		JMenuItem mntmMapSize = new JMenuItem("Map Size");
		mnEdit.add(mntmMapSize);

		JMenuItem mntmClearMap = new JMenuItem("Clear Map");
		mnEdit.add(mntmClearMap);

		JMenu mnOptions = new JMenu("Options");
		mnOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnOptions);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panelEditor = new Panel();
		panelEditor.setBackground(Color.MAGENTA);
		panelEditor.setBounds(0, 0, Editor.WIDTH, Editor.HEIGHT);
		GridBagLayout gbl_panelEditor = new GridBagLayout();
		gbl_panelEditor.columnWidths = new int[] { Editor.WIDTH, 0 };
		gbl_panelEditor.rowHeights = new int[] { Editor.HEIGHT, 0 };
		gbl_panelEditor.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelEditor.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelEditor.setLayout(gbl_panelEditor);
		contentPane.add(panelEditor);

		// Adding editor canvas
		editor = new Editor(this);
		editor.setPreferredSize(new Dimension(Editor.WIDTH, Editor.HEIGHT));

		GridBagConstraints gbc_editor = new GridBagConstraints();
		gbc_editor.anchor = GridBagConstraints.NORTHWEST;
		gbc_editor.gridx = 0;
		gbc_editor.gridy = 0;
		panelEditor.add(editor, gbc_editor);

		panelTileset = new TilesetPanel(this, editor);
		contentPane.add(panelTileset);

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

	public void changeBrushInfo(BufferedImage tileImage, int id) {
		lblTileImg.setIcon(new ImageIcon(ImageEditor.scaleImage(tileImage, 64, 64)));
		// editor.setBrushImage(ImageEditor.changeOpacity(tileImage, 0.25));
		editor.setBrushImage(tileImage);
		editor.setBrushId(id);
		lblTileId.setText("Brush/Tile ID: " + editor.getBrushId());
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
