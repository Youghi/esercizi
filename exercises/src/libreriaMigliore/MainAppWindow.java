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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
	private final JButton btnConferma = new JButton("conferma");

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
		frmLibreria.setLocationRelativeTo(null);
		;
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
		layeredPane.setLayout(null);

		JPanel addNewBook = new JPanel();
		addNewBook.setBounds(0, 0, 384, 461);
		layeredPane.add(addNewBook);

		addNewBook.setLayout(null);
		tfTitolo.setBounds(5, 48, 89, 19);

		addNewBook.add(tfTitolo);
		lblAnnoEd.setBounds(5, 115, 79, 14);

		addNewBook.add(lblAnnoEd);
		lblAutore.setBounds(10, 152, 62, 14);

		addNewBook.add(lblAutore);
		lblNomeAutore.setBounds(10, 300, 37, 14);
		lblTitolo.setBounds(5, 22, 89, 19);
		addNewBook.add(lblTitolo);
		addNewBook.add(choice);

		addNewBook.add(lblNomeAutore);
		addNewBook.add(tfNomeAutore);
		lblCognomeAutore.setBounds(10, 259, 62, 14);
		addNewBook.add(lblCognomeAutore);
		btnNewButton.setBounds(186, 427, 89, 23);

		addNewBook.add(btnNewButton);
		tfCognomeAutore.setBounds(20, 176, 86, 20);
		tfCognomeAutore.setColumns(10);
		addNewBook.add(tfCognomeAutore);
		
				layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(
						new Component[] { addNewBook, lblTitolo, tfTitolo, lblAnnoEd, tfAnnoEd, lblAutore, lblNomeAutore,
								tfNomeAutore, lblCognomeAutore, tfCognomeAutore, btnNewButton, btnConferma, choice }));
				frmLibreria.getContentPane().setFocusTraversalPolicy(
						new FocusTraversalOnArray(new Component[] { leftPanel, btnModify, btnAdd, btnDelete, btnVisualise,
								btnSerach, layeredPane, addNewBook, tfTitolo, lblAnnoEd, tfAnnoEd, lblAutore, tfNomeAutore,
								lblTitolo, lblNomeAutore, lblCognomeAutore, tfCognomeAutore, btnNewButton, btnConferma, choice }));
		btnConferma.setBounds(285, 427, 89, 23);
		addNewBook.add(btnConferma);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 461);
		layeredPane.add(panel, 1);

		
	}

	public void choiceFill() {
		for (Genre gen : Genre.values()) {
			choice.add(gen.toString());
		}
	}
}
