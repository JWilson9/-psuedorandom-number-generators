package ie.dit.student.wilson.james;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.math.BigInteger;

import javax.swing.JTextPane;

public class GeneratorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField checkPrimeField, resultField1, resultField2,
			nextPrimeField, resultField4;
	private JTextField amountField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratorGUI frame = new GeneratorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});//
	}

	/**
	 * Create the frame.
	 */
	public GeneratorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("James Wilson's pseudorandom numbers Mersenne & LCG");
		setBounds(100, 100, 550, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlgorithm = new JLabel("Algorithm:");
		lblAlgorithm.setBounds(149, 11, 84, 14);
		contentPane.add(lblAlgorithm);

		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(208, 8, 102, 20);
		contentPane.add(comboBox);
		comboBox.addItem("LCG");
		comboBox.addItem("Mersenne Twister");
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String algorithm = comboBox.getSelectedItem().toString();
				if (algorithm.contentEquals("Mersenne Twister")) {
					resultField1.setText(""
							+ GenNumbers
									.singleMersenneTwisterNumber());
				}
				if (algorithm.contentEquals("LCG")) {
					resultField1.setText("" + LCGAlgorithm.lcgSingleNumber());
				}
			}
		});

		btnGenerate.setBounds(15, 41, 89, 23);
		contentPane.add(btnGenerate);

		// result from the algorithm generated
		resultField1 = new JTextField();
		resultField1.setBounds(114, 42, 141, 20);
		contentPane.add(resultField1);
		resultField1.setColumns(10);
		

		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = Integer.parseInt(resultField1.getText());
				resultField2.setForeground(Color.BLACK);
				resultField2.setText(GenNumbers.isPrime(x));
			}
		});
		btnNewButton.setBounds(260, 41, 89, 23);
		contentPane.add(btnNewButton);

		resultField2 = new JTextField();
		resultField2.setBounds(359, 42, 141, 20);
		contentPane.add(resultField2);
		resultField2.setColumns(10);

		nextPrimeField = new JTextField();
		nextPrimeField.setColumns(10);
		nextPrimeField.setBounds(20, 95, 157, 20);
		contentPane.add(nextPrimeField);

		JButton button = new JButton("Next Prime");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(nextPrimeField.getText());
				resultField4.setForeground(Color.BLACK);
				resultField4.setText("" + GenNumbers.nextPrimeNumber(x));
			}
		});
		button.setBounds(187, 94, 129, 23);
		contentPane.add(button);

		resultField4 = new JTextField();
		resultField4.setColumns(10);
		resultField4.setBounds(326, 95, 174, 20);
		contentPane.add(resultField4);

		final JTextArea textArea = new JTextArea();
		contentPane.add(textArea);

		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(20, 150, 480, 98);
		contentPane.add(sp);

		final JComboBox<Object> comboBox_2 = new JComboBox<Object>();
		comboBox_2.setBounds(15, 126, 240, 20);
		contentPane.add(comboBox_2);
		comboBox_2.addItem("Mersenne Twister");
		comboBox_2.addItem("LCG");

		

		JButton btnGenerateList = new JButton("Generate List");
		btnGenerateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int amount = 10;
				String algorithm = comboBox_2.getSelectedItem().toString();


				if (algorithm.contentEquals("Mersenne Twister")) {
					BigInteger[] array = GenNumbers
							.generateMersenneTwisterList(amount);
					textArea.setText("");
					for (BigInteger x : array) {
						textArea.append(x + "\n");
					}
				}
				if (algorithm.contentEquals("LCG")) {
					BigInteger[] array = LCGAlgorithm.lcgList(amount);
					for (BigInteger x : array) {
						textArea.append(x + "\n");
					}
				}
			}
		});
		btnGenerateList.setBounds(260, 126, 240, 23);
		contentPane.add(btnGenerateList);
		
		JLabel label = new JLabel("Enter number & check its next prime:");
		label.setBounds(15, 75, 189, 14);
		contentPane.add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(91, 36, 6, 20);
		contentPane.add(textPane);
		
		JLabel lblTheNumberEntered = new JLabel("The number entered next prime");
		lblTheNumberEntered.setBounds(324, 75, 210, 14);
		contentPane.add(lblTheNumberEntered);
	}
}
