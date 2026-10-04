package passwordapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Window for the password strength app.
 */
public class PasswordFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	/** The main content panel of the window. */
	private JPanel contentPane;
	/** Text field where the user types. */
	private JTextField textField;
	/** Text area that shows the result. */
	private JTextArea textArea;

	/**
	 * Launch the application.
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordFrame frame = new PasswordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PasswordFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("CHECK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
				    PasswordChecker pc = new PasswordChecker(textField.getText());
				    textArea.setText(pc.getMessage());
				} catch (IllegalArgumentException ex) {
				    textArea.setText(ex.getMessage());
				}
			}
		});
		contentPane.add(btnNewButton);

		textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setColumns(30);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);

	}

}