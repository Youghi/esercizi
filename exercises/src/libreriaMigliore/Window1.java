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
		frmCiao.setTitle("ciao");
		frmCiao.setBounds(100, 100, 844, 534);
		frmCiao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		frmCiao.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel1 = new JPanel();
		layeredPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel = new JLabel("aaa");
		lblNewLabel.setBounds(10, 11, 256, 23);
		panel1.add(lblNewLabel);

		JPanel panel = new JPanel();
		layeredPane.add(panel);

		JPanel panel2 = new JPanel();
		layeredPane.add(panel2);
		layeredPane.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { panel1, panel2, panel, lblNewLabel }));
	}
}
