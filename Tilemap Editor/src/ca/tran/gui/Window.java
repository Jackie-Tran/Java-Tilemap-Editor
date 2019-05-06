package ca.tran.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import ca.tran.editor.Editor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Window extends JFrame {

	private JPanel contentPane;
	private static Editor editor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Window frame = new Window();
					frame.setVisible(true);
					editor.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setTitle("Java Tilemap Editor");
		setResizable(false);
		setMinimumSize(new Dimension(1280, 800));
		setMaximumSize(new Dimension(1280, 800));
		setPreferredSize(new Dimension(1280, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		
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
		panelEditor.setBounds(0, 0, 1000, 800);
		GridBagLayout gbl_panelEditor = new GridBagLayout();
		gbl_panelEditor.columnWidths = new int[]{1000, 0};
		gbl_panelEditor.rowHeights = new int[]{800, 0};
		gbl_panelEditor.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelEditor.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelEditor.setLayout(gbl_panelEditor);
		contentPane.add(panelEditor);
		// Adding editor canvas
		editor = new Editor();
		editor.setPreferredSize(new Dimension(1000, 800));
		GridBagConstraints gbc_editor = new GridBagConstraints();
		gbc_editor.anchor = GridBagConstraints.NORTHWEST;
		gbc_editor.gridx = 0;
		gbc_editor.gridy = 0;
		panelEditor.add(editor, gbc_editor);
		this.pack();
		
		Panel panel = new Panel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(1000, 0, 275, 800);
		contentPane.add(panel);

		setLocationRelativeTo(null);
	}
}
