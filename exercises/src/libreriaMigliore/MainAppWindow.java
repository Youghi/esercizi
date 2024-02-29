package libreriaMigliore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import java.awt.Point;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

public class MainAppWindow {
	JFrame frmLibreria;
	JButton btnAdd = new JButton("Add");
	JButton btnModify = new JButton("Modify");
	JButton btnVisualise = new JButton("Visualise");
	JButton btnSerach = new JButton("Serach");
	JButton btnDelete = new JButton("Delete");
	JPanel leftPanel = new JPanel();
	Choice choice = new Choice();
	private final JLayeredPane layeredPane = new JLayeredPane();
	private final JTextField tfTitolo = new JTextField();
	private final JLabel lblAnnoEd = new JLabel("Anno Edizione");
	private final JTextField tfAnnoEd = new JTextField();
	private final JLabel lblAutore = new JLabel("Autore:");
	private final JTextField tfNomeAutore = new JTextField();
	private final JLabel lblTitolo = new JLabel("Titolo");
	private final JLabel lblNomeAutore = new JLabel("Nome");
	private final JLabel lblCognomeAutore = new JLabel("Cognome");
	private final JTextField tfCognomeAutore = new JTextField();
	private final JButton btnNewButton = new JButton("New button");
	private final JButton button = new JButton("New button");


	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppWindow window = new MainAppWindow();
					window.frmLibreria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("qualcosa non va con la finestra");
				}
			}
		});
	}

	public MainAppWindow() {
		initialize();
		choiceFill();
	}

	private void initialize() {
		frmLibreria = new JFrame();
		frmLibreria.setMinimumSize(new Dimension(500, 500));
		frmLibreria.getContentPane().setName("");
		frmLibreria.setTitle("Libreria");
		frmLibreria.setLocationRelativeTo(null);;
		frmLibreria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		leftPanel.setPreferredSize(new Dimension(100, 100));
		leftPanel.setLayout(new GridLayout(5, 0, 0, 0));

		leftPanel.add(btnAdd);
		leftPanel.add(btnModify);
		leftPanel.add(btnVisualise);
		leftPanel.add(btnSerach);
		leftPanel.add(btnDelete);
		
		

		frmLibreria.getContentPane().add(leftPanel, BorderLayout.WEST);
		
		frmLibreria.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel addNewBook = new JPanel();
		layeredPane.add(addNewBook);
		GridBagLayout gbl_addNewBook = new GridBagLayout();
		gbl_addNewBook.columnWidths = new int[] {30, 91, 91, 77};
		gbl_addNewBook.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0};
		gbl_addNewBook.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_addNewBook.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addNewBook.setLayout(gbl_addNewBook);
		
		GridBagConstraints gbc_lblTitolo = new GridBagConstraints();
		gbc_lblTitolo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitolo.gridx = 0;
		gbc_lblTitolo.gridy = 1;
		addNewBook.add(lblTitolo, gbc_lblTitolo);
		tfTitolo.setColumns(10);
		
		GridBagConstraints gbc_tfTitolo = new GridBagConstraints();
		gbc_tfTitolo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTitolo.insets = new Insets(0, 0, 5, 5);
		gbc_tfTitolo.gridx = 0;
		gbc_tfTitolo.gridy = 2;
		addNewBook.add(tfTitolo, gbc_tfTitolo);
		
		GridBagConstraints gbc_lblAnnoEd = new GridBagConstraints();
		gbc_lblAnnoEd.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnoEd.gridx = 0;
		gbc_lblAnnoEd.gridy = 3;
		addNewBook.add(lblAnnoEd, gbc_lblAnnoEd);
		tfAnnoEd.setColumns(10);
		
		GridBagConstraints gbc_tfAnnoEd = new GridBagConstraints();
		gbc_tfAnnoEd.insets = new Insets(0, 0, 5, 5);
		gbc_tfAnnoEd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAnnoEd.gridx = 0;
		gbc_tfAnnoEd.gridy = 4;
		addNewBook.add(tfAnnoEd, gbc_tfAnnoEd);
		
		GridBagConstraints gbc_lblAutore = new GridBagConstraints();
		gbc_lblAutore.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutore.gridx = 0;
		gbc_lblAutore.gridy = 9;
		addNewBook.add(lblAutore, gbc_lblAutore);
		
		GridBagConstraints gbc_lblNomeAutore = new GridBagConstraints();
		gbc_lblNomeAutore.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeAutore.gridx = 0;
		gbc_lblNomeAutore.gridy = 10;
		addNewBook.add(lblNomeAutore, gbc_lblNomeAutore);
		tfNomeAutore.setColumns(10);
		
		GridBagConstraints gbc_tfNomeAutore = new GridBagConstraints();
		gbc_tfNomeAutore.insets = new Insets(0, 0, 5, 5);
		gbc_tfNomeAutore.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNomeAutore.gridx = 1;
		gbc_tfNomeAutore.gridy = 10;
		addNewBook.add(tfNomeAutore, gbc_tfNomeAutore);
		
		GridBagConstraints gbc_lblCognomeAutore = new GridBagConstraints();
		gbc_lblCognomeAutore.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognomeAutore.gridx = 2;
		gbc_lblCognomeAutore.gridy = 10;
		addNewBook.add(lblCognomeAutore, gbc_lblCognomeAutore);
		tfCognomeAutore.setColumns(10);
		
		GridBagConstraints gbc_tfCognomeAutore = new GridBagConstraints();
		gbc_tfCognomeAutore.insets = new Insets(0, 0, 5, 0);
		gbc_tfCognomeAutore.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCognomeAutore.gridx = 3;
		gbc_tfCognomeAutore.gridy = 10;
		addNewBook.add(tfCognomeAutore, gbc_tfCognomeAutore);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 15;
		addNewBook.add(btnNewButton, gbc_btnNewButton);
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 15;
		addNewBook.add(button, gbc_button);
		layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{addNewBook, lblTitolo, tfTitolo, lblAnnoEd, tfAnnoEd, lblAutore, lblNomeAutore, tfNomeAutore, lblCognomeAutore, tfCognomeAutore, btnNewButton, button}));
		frmLibreria.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{leftPanel, btnModify, btnAdd, btnDelete, btnVisualise, btnSerach, layeredPane, addNewBook, tfTitolo, lblAnnoEd, tfAnnoEd, lblAutore, tfNomeAutore, lblTitolo, lblNomeAutore, lblCognomeAutore, tfCognomeAutore, btnNewButton, button}));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 461);
		layeredPane.add(panel,1);
		
		
		panel.add(choice);
	}
	public void choiceFill() {
		for (Genre gen : Genre.values()) {
			choice.add(gen.toString());
		}
	}
}
