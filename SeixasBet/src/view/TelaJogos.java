
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ApostaController;
import model.DAO.ApostaDAO;
import model.VO.ApostaVO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaJogos extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor1;
	private JTextField txtValor2;
	private JTextField txtValor3;
	private JTextField txtValor4;
	private JTextField txtRetorno4;
	private JTextField txtRetorno1;
	private JTextField txtRetorno2;
	private JTextField txtRetorno3;
	private JTextField textField_8;
	private JTextField valorDigitado;
	public static final Double valor1 = 1.78;
	public static final Double valor2 = 1.55;
	public static final Double valor3 = 2.22;
	public static final Double valor4 = 1.66;
	public static final Double valor5 = 3.44;
	public static final Double valor6 = 7.75;
	public static final Double valor7 = 4.03;
	public static final Double valor8 = 2.88;
	public static final Double valor9 = 2.09;
	public static final Double valor10 = 6.76;
	public static final Double valor11 = 3.78;
	public static final Double valor12 = 2.05;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogos frame = new TelaJogos();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaJogos() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage(TelaJogos.class.getResource("/icons/football.png")));

		setTitle("Futebol");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 838);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCorinthians = new JLabel("Corinthians");
		lblCorinthians.setBounds(26, 86, 72, 14);
		contentPane.add(lblCorinthians);

		JLabel lblSoPaulo = new JLabel("S\u00E3o Paulo");
		lblSoPaulo.setBounds(26, 111, 72, 14);
		contentPane.add(lblSoPaulo);

		JLabel lblSantos = new JLabel("Santos");
		lblSantos.setBounds(26, 228, 46, 14);
		contentPane.add(lblSantos);

		JLabel lblGias = new JLabel("G\u00F3ias");
		lblGias.setBounds(26, 253, 46, 14);
		contentPane.add(lblGias);

		JLabel lblCear = new JLabel("Cear\u00E1");
		lblCear.setBounds(10, 369, 46, 14);
		contentPane.add(lblCear);

		JLabel lblInternacional = new JLabel("Internacional");
		lblInternacional.setBounds(10, 394, 88, 14);
		contentPane.add(lblInternacional);

		JLabel lblCoritiba = new JLabel("Coritiba");
		lblCoritiba.setBounds(10, 528, 46, 14);
		contentPane.add(lblCoritiba);

		JLabel lblFlamengo = new JLabel("Flamengo");
		lblFlamengo.setBounds(10, 553, 61, 14);
		contentPane.add(lblFlamengo);

		JRadioButton rdbtnCorinthians = new JRadioButton("Corinthians");
		rdbtnCorinthians.setBounds(120, 121, 109, 23);
		contentPane.add(rdbtnCorinthians);

		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setBounds(233, 121, 83, 23);
		contentPane.add(rdbtnEmpate);

		JRadioButton rdbtnSaoPaulo = new JRadioButton("S\u00E3o Paulo");
		rdbtnSaoPaulo.setBounds(329, 121, 109, 23);
		contentPane.add(rdbtnSaoPaulo);

		JLabel label = new JLabel("1.78");
		label.setBounds(141, 98, 46, 14);
		contentPane.add(label);

		JLabel lblEmpate = new JLabel("1.55");
		lblEmpate.setBounds(248, 100, 46, 14);
		contentPane.add(lblEmpate);

		JLabel lblSaoPaulo = new JLabel("2.22");
		lblSaoPaulo.setBounds(352, 100, 46, 14);
		contentPane.add(lblSaoPaulo);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblValor.setBounds(179, 151, 46, 14);
		contentPane.add(lblValor);

		txtValor1 = new JTextField();
		txtValor1.setBounds(222, 149, 54, 20);
		contentPane.add(txtValor1);
		txtValor1.setColumns(10);

		JLabel label_3 = new JLabel("1.66");
		label_3.setBounds(120, 240, 46, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("3.44");
		label_4.setBounds(230, 240, 46, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("7.75");
		label_5.setBounds(329, 240, 46, 14);
		contentPane.add(label_5);

		JRadioButton rdbtnSantos = new JRadioButton("Santos");
		rdbtnSantos.setBounds(115, 274, 72, 23);
		contentPane.add(rdbtnSantos);

		JRadioButton rdbtnEmpate_1 = new JRadioButton("Empate");
		rdbtnEmpate_1.setBounds(215, 274, 83, 23);
		contentPane.add(rdbtnEmpate_1);

		JRadioButton rdbtnGoias = new JRadioButton("G\u00F3ias");
		rdbtnGoias.setBounds(329, 274, 69, 23);
		contentPane.add(rdbtnGoias);

		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(166, 304, 46, 14);
		contentPane.add(lblNewLabel);

		txtValor2 = new JTextField();
		txtValor2.setBounds(222, 304, 54, 20);
		contentPane.add(txtValor2);
		txtValor2.setColumns(10);

		JLabel label_6 = new JLabel("4.03");
		label_6.setBounds(120, 380, 46, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("2.88");
		label_7.setBounds(233, 380, 46, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("2.09");
		label_8.setBounds(352, 380, 46, 14);
		contentPane.add(label_8);

		JRadioButton rdbtnCeara = new JRadioButton("Cear\u00E1");
		rdbtnCeara.setBounds(99, 409, 67, 23);
		contentPane.add(rdbtnCeara);

		JRadioButton rdbtnEmpate_2 = new JRadioButton("Empate");
		rdbtnEmpate_2.setBounds(215, 409, 69, 23);
		contentPane.add(rdbtnEmpate_2);

		JRadioButton rdbtnInternacional = new JRadioButton("Internacional");
		rdbtnInternacional.setBounds(329, 409, 109, 23);
		contentPane.add(rdbtnInternacional);

		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblValor_1.setBounds(179, 439, 46, 14);
		contentPane.add(lblValor_1);

		txtValor3 = new JTextField();
		txtValor3.setBounds(233, 439, 46, 20);
		contentPane.add(txtValor3);
		txtValor3.setColumns(10);

		JLabel label_9 = new JLabel("6.76");
		label_9.setBounds(130, 524, 46, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("3.78");
		label_10.setBounds(233, 524, 46, 14);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("2.05");
		label_11.setBounds(352, 524, 46, 14);
		contentPane.add(label_11);

		JRadioButton rdbtnCoritiba = new JRadioButton("Coritiba");
		rdbtnCoritiba.setBounds(120, 549, 72, 23);
		contentPane.add(rdbtnCoritiba);

		JRadioButton rdbtnEmpate_3 = new JRadioButton("Empate");
		rdbtnEmpate_3.setBounds(222, 549, 79, 23);
		contentPane.add(rdbtnEmpate_3);

		JRadioButton rdbtnFlamengo = new JRadioButton("Flamengo");
		rdbtnFlamengo.setBounds(329, 549, 109, 23);
		contentPane.add(rdbtnFlamengo);

		JLabel lblValor_2 = new JLabel("Valor");
		lblValor_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblValor_2.setBounds(179, 579, 34, 14);
		contentPane.add(lblValor_2);

		txtValor4 = new JTextField();
		txtValor4.setBounds(230, 577, 46, 20);
		contentPane.add(txtValor4);
		txtValor4.setColumns(10);

		JLabel lblRetornoPossvel = new JLabel("Retorno Poss\u00EDvel");
		lblRetornoPossvel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRetornoPossvel.setBounds(179, 621, 111, 14);
		contentPane.add(lblRetornoPossvel);

		txtRetorno4 = new JTextField();
		txtRetorno4.setBounds(286, 619, 61, 20);
		contentPane.add(txtRetorno4);
		txtRetorno4.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		 btnSalvar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			
			 ApostaController aposta = new ApostaController();
			 String valorDigitado = txtValor1.getText();
			 
			 
			 Double val1,val2,val3,val4;
			 Double soma = 0.0;
             val1 = Double.parseDouble(txtValor1.getText());
             val2 = Double.parseDouble(txtValor2.getText());
             val3 = Double.parseDouble(txtValor3.getText());
             val4 = Double.parseDouble(txtValor4.getText());
             
             soma = aposta.subtotal(val1, val2, val3, val4);
             label.setText(String.valueOf(soma));
               
               
		 }

	
			});
		btnSalvar.setFont(new Font("Arial", Font.ITALIC, 15));
		btnSalvar.setBounds(258, 666, 89, 35);
		contentPane.add(btnSalvar);

		JLabel lblApostasFutebol = new JLabel("APOSTAS FUTEBOL");
		lblApostasFutebol.setFont(new Font("Arial", Font.PLAIN, 22));
		lblApostasFutebol.setBounds(151, 35, 247, 14);
		contentPane.add(lblApostasFutebol);

		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				double retornoMetodo = 0;

				ApostaController controller = new ApostaController();

				double valorTela = Double.parseDouble(valorDigitado.getText());

				if (rdbtnCorinthians.isSelected()) {

					retornoMetodo = multiCorinthians(valor1, valorTela);

				} else if (rdbtnEmpate.isSelected()) {
					retornoMetodo = multiEmpate(valor2, valorTela);
				} else if (rdbtnSaoPaulo.isSelected()) {
					retornoMetodo = multiSaoPaulo(valor3, valorTela);
				}

				txtRetorno1.setText(String.valueOf(retornoMetodo));

			}
		});

		btnNewButton_1.setBounds(286, 148, 61, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblRetornoPossvel_1 = new JLabel("Retorno Poss\u00EDvel");
		lblRetornoPossvel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRetornoPossvel_1.setBounds(179, 189, 96, 14);
		contentPane.add(lblRetornoPossvel_1);

		txtRetorno1 = new JTextField();
		txtRetorno1.setBounds(286, 187, 61, 20);
		contentPane.add(txtRetorno1);
		txtRetorno1.setColumns(10);

		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double retornoMetodo = 0;

				ApostaController controller = new ApostaController();

				double valorTela = Double.parseDouble(valorDigitado.getText());

				if (rdbtnSantos.isSelected()) {

					retornoMetodo = multiSantos(valor4, valorTela);

				} else if (rdbtnEmpate.isSelected()) {
					retornoMetodo = multiEmpate(valor5, valorTela);
				} else if (rdbtnGoias.isSelected()) {
					retornoMetodo = multiGoias(valor6, valorTela);
				}

				txtRetorno2.setText(String.valueOf(retornoMetodo));
			}

		});
		btnNewButton_2.setBounds(286, 304, 61, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblRetornoPossvel_2 = new JLabel("Retorno Poss\u00EDvel");
		lblRetornoPossvel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRetornoPossvel_2.setBounds(179, 355, 111, 14);
		contentPane.add(lblRetornoPossvel_2);

		txtRetorno2 = new JTextField();
		txtRetorno2.setBounds(286, 353, 61, 20);
		contentPane.add(txtRetorno2);
		txtRetorno2.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double retornoMetodo = 0;

				ApostaController controller = new ApostaController();

				double valorTela = Double.parseDouble(valorDigitado.getText());

				if (rdbtnCeara.isSelected()) {

					retornoMetodo = multiCeara(valor7, valorTela);

				} else if (rdbtnEmpate.isSelected()) {
					retornoMetodo = multiEmpate(valor8, valorTela);
				} else if (rdbtnInternacional.isSelected()) {
					retornoMetodo = multiInternacional(valor9, valorTela);
				}

				txtRetorno3.setText(String.valueOf(retornoMetodo));
			}

			private double multiInternacional(Double valor7, Double valorDigitado) {
				Double multi;

				multi = valor7 * valorDigitado;
				return multi;

			}

			private double multiEmpate(Double valor8, Double valorDigitado) {

				Double multi;

				multi = valor8 * valorDigitado;
				return multi;
			}

			private double multiCeara(Double valor9, Double valorDigitado) {
				Double multi;

				multi = valor9 * valorDigitado;
				return multi;
			}

		});
		btnOk.setBounds(293, 439, 54, 23);
		contentPane.add(btnOk);

		JLabel lblRetornoPossvel_3 = new JLabel("Retorno Poss\u00EDvel");
		lblRetornoPossvel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRetornoPossvel_3.setBounds(179, 482, 97, 14);
		contentPane.add(lblRetornoPossvel_3);

		txtRetorno3 = new JTextField();
		txtRetorno3.setBounds(293, 480, 54, 20);
		contentPane.add(txtRetorno3);
		txtRetorno3.setColumns(10);

		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double retornoMetodo = 0;

				ApostaController controller = new ApostaController();

				double valorTela = Double.parseDouble(valorDigitado.getText());

				if (rdbtnCoritiba.isSelected()) {

					retornoMetodo = multiCoritiba(valor10, valorTela);

				} else if (rdbtnEmpate.isSelected()) {
					retornoMetodo = multiEmpate(valor11, valorTela);
				} else if (rdbtnFlamengo.isSelected()) {
					retornoMetodo = multiFlamengo(valor12, valorTela);
				}

				txtRetorno4.setText(String.valueOf(retornoMetodo));

			}

			private double multiCoritiba(Double valor10, double valorDigitado) {
				Double multi;

				multi = valor10 * valorDigitado;
				return multi;
			}

			private double multiEmpate(Double valor11, double valorDigitado) {

				Double multi;

				multi = valor11 * valorDigitado;
				return multi;
			}

			private double multiFlamengo(Double valor12, double valorDigitado) {

				Double multi;

				multi = valor12 * valorDigitado;
				return multi;
			}
		});
		btnOk_1.setBounds(286, 576, 54, 23);
		contentPane.add(btnOk_1);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblSubtotal.setBounds(83, 675, 83, 14);
		contentPane.add(lblSubtotal);

		textField_8 = new JTextField();
		textField_8.setBounds(155, 674, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblSaldo = new JLabel("Saldo ");
		lblSaldo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSaldo.setBounds(422, 39, 46, 35);
		contentPane.add(lblSaldo);

		ApostaController apostaController = new ApostaController();
		JLabel lblSaldoAtualizado = new JLabel("New label");
		//lblSaldoAtualizado.setText(apostaController.atualizarValor());

		lblSaldoAtualizado.setBounds(478, 50, 46, 14);
		contentPane.add(lblSaldoAtualizado);
	}

	private double multiCorinthians(Double valor1, Double valorDigitado) {

		Double multi;

		multi = valor1 * valorDigitado;
		return multi;

	}

	private double multiEmpate(Double valor2, Double valorDigitado) {

		Double multi;

		multi = valor2 * valorDigitado;
		return multi;

	}

	private double multiSaoPaulo(Double valor3, Double valorDigitado) {

		Double multi;

		multi = valor3 * valorDigitado;
		return multi;

	}
	
	private double multiSantos(Double valor4, Double valorDigitado) {
		
		Double multi;

		multi = valor4 * valorDigitado;
		return multi;
	}
	private double multiEmpate1(Double valor5, Double valorDigitado) {

		Double multi;

		multi = valor5 * valorDigitado;
		return multi;

	}
	
	private double multiGoias(Double valor6, Double valorDigitado) {
		Double multi;

		multi = valor6 * valorDigitado;
		return multi;
	}
	

		}
	
		
