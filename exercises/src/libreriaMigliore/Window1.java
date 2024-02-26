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

public class Window1 {

	private JFrame frmCiao;

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 window = new Window1();
					window.frmCiao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("aa");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCiao = new JFrame();
		frmCiao.getContentPane().setName("");
		frmCiao.setTitle("ciao");
		frmCiao.setBounds(500, 300, 650, 500);
		
		frmCiao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		frmCiao.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JTextPane txtpnAa = new JTextPane();
		panel.add(txtpnAa, "name_358529318982100");
		txtpnAa.setText("ciao");
		JButton btnNewButton_2 = new JButton("Premi Qua");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtpnAa.getText().isBlank()) {
					txtpnAa.setText("ciao ciao ciao");
				}else {
					txtpnAa.setText("");
				}
				System.out.println(txtpnAa.getText());
				
				
			}

		});

		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		
		frmCiao.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		frmCiao.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtpnAa, panel_1, btnNewButton_2, btnNewButton, btnNewButton_1, panel}));
		
		
	}
	
	public void setText() {
		
	}
	
}
