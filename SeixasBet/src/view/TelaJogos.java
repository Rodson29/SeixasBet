
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ApostaController;
import controller.ClienteController;
import model.DAO.ApostaDAO;
import model.VO.ApostaVO;
import model.VO.ClienteVO;

import javax.swing.ButtonGroup;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private JTextField txtSubTotal;
	private JLabel lblSaldoAtualizado;
	private Double SaldoAtualizado;
	
	
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

	ApostaController apostaController = new ApostaController();
	ClienteController clienteController = new ClienteController();
	
	ClienteVO usuarioVO = new ClienteVO();
	ApostaVO apostaVO = new ApostaVO();
	ApostaVO novaAposta = new ApostaVO();
	
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
//		 setIconImage(Toolkit.getDefaultToolkit().getImage(TelaJogos.class.getResource("/icons/football.png")));

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
//RADIO BUTTONS
		ButtonGroup grupo1 = new ButtonGroup();
		
		JRadioButton rdbtnCorinthians = new JRadioButton("Corinthians");
					 rdbtnCorinthians.setActionCommand("1.78");
		rdbtnCorinthians.setBounds(120, 121, 109, 23);
		contentPane.add(rdbtnCorinthians);

		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
					 rdbtnEmpate.setActionCommand("1.55");
					// rdbtnEmpate.setSelected(true);
		rdbtnEmpate.setBounds(233, 121, 83, 23);
		contentPane.add(rdbtnEmpate);

		JRadioButton rdbtnSaoPaulo = new JRadioButton("S\u00E3o Paulo");
					 rdbtnSaoPaulo.setActionCommand("2.22");
		rdbtnSaoPaulo.setBounds(329, 121, 109, 23);
		contentPane.add(rdbtnSaoPaulo);
		
		grupo1.add(rdbtnCorinthians);
		grupo1.add(rdbtnEmpate);
		grupo1.add(rdbtnSaoPaulo);
		
		
//RADIO BUTTONS
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
		txtValor1.setText("0.0");
		txtValor1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				calcularSubtotal();
				apostaVO.setValor1(Double.parseDouble(txtValor1.getText()));

			}
		});
		txtValor1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
				txtSubTotal.setText(txtValor1.getText());	
				}
			}
		});
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

		ButtonGroup grupo2 = new ButtonGroup();
		
		JRadioButton rdbtnSantos = new JRadioButton("Santos");
		             rdbtnSantos.setActionCommand("1.66");
		rdbtnSantos.setBounds(115, 274, 72, 23);
		contentPane.add(rdbtnSantos);

		JRadioButton rdbtnEmpate_1 = new JRadioButton("Empate");
		             rdbtnEmpate_1.setActionCommand("3.44");
		rdbtnEmpate_1.setBounds(215, 274, 83, 23);
		contentPane.add(rdbtnEmpate_1);

		JRadioButton rdbtnGoias = new JRadioButton("G\u00F3ias");
		             rdbtnGoias.setActionCommand("7.75");
		rdbtnGoias.setBounds(329, 274, 69, 23);
		contentPane.add(rdbtnGoias);
		
		grupo2.add(rdbtnSantos);
		grupo2.add(rdbtnEmpate_1);
		grupo2.add(rdbtnGoias);

		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(166, 304, 46, 14);
		contentPane.add(lblNewLabel);

		txtValor2 = new JTextField();
		txtValor2.setText("0.0");
		txtValor2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				apostaVO.setValor2(Double.parseDouble(txtValor2.getText()));
				calcularSubtotal();
			}
		});
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
		
         ButtonGroup grupo3 = new ButtonGroup();
		JRadioButton rdbtnCeara = new JRadioButton("Cear\u00E1");
		             rdbtnCeara.setActionCommand("4.03");
		rdbtnCeara.setBounds(99, 409, 67, 23);
		contentPane.add(rdbtnCeara);

		JRadioButton rdbtnEmpate_2 = new JRadioButton("Empate");
		             rdbtnEmpate_2.setActionCommand("2.88");
		rdbtnEmpate_2.setBounds(215, 409, 69, 23);
		contentPane.add(rdbtnEmpate_2);

		JRadioButton rdbtnInternacional = new JRadioButton("Internacional");
		             rdbtnInternacional.setActionCommand("2.09");
		rdbtnInternacional.setBounds(329, 409, 109, 23);
		contentPane.add(rdbtnInternacional);
		
		grupo3.add(rdbtnCeara);
		grupo3.add(rdbtnEmpate_2);
		grupo3.add(rdbtnInternacional);

		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblValor_1.setBounds(179, 439, 46, 14);
		contentPane.add(lblValor_1);

		txtValor3 = new JTextField();
		txtValor3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				apostaVO.setValor3(Double.parseDouble(txtValor3.getText()));
				calcularSubtotal();
			}
		});
		txtValor3.setText("0.0");
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
		
		
         ButtonGroup grupo4 = new ButtonGroup();
		JRadioButton rdbtnCoritiba = new JRadioButton("Coritiba");
		             rdbtnCoritiba.setActionCommand("6.76");
		rdbtnCoritiba.setBounds(120, 549, 72, 23);
		contentPane.add(rdbtnCoritiba);

		JRadioButton rdbtnEmpate_3 = new JRadioButton("Empate");
		             rdbtnEmpate_3.setActionCommand("3.78");
		rdbtnEmpate_3.setBounds(222, 549, 79, 23);
		contentPane.add(rdbtnEmpate_3);

		JRadioButton rdbtnFlamengo = new JRadioButton("Flamengo");
		             rdbtnFlamengo.setActionCommand("2.05");
		rdbtnFlamengo.setBounds(329, 549, 109, 23);
		contentPane.add(rdbtnFlamengo);
		
		grupo4.add(rdbtnCoritiba);
		grupo4.add(rdbtnEmpate_3);
		grupo4.add(rdbtnFlamengo);

		JLabel lblValor_2 = new JLabel("Valor");
		lblValor_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblValor_2.setBounds(179, 579, 34, 14);
		contentPane.add(lblValor_2);

		txtValor4 = new JTextField();
		txtValor4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				apostaVO.setValor4(Double.parseDouble(txtValor4.getText()));
				calcularSubtotal();
			}
		});
		txtValor4.setText("0.0");
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
			 
			 apostaVO.setUsuario(usuarioVO);
			 
			 

    
				String valorDigitado1 = txtValor1.getText();
				valorDigitado1 = valorDigitado1.replaceAll(",", ".");
				valorDigitado1 = valorDigitado1.replace("R$ ", "");
				Double valor = Double.parseDouble(valorDigitado1);
				
				String valorDigitado2 = txtValor2.getText();
				valorDigitado2 = valorDigitado2.replaceAll(",", ".");
				valorDigitado2 = valorDigitado2.replace("R$ ", "");
				Double valor1 = Double.parseDouble(valorDigitado2);
				
				String valorDigitado3 = txtValor3.getText();
				valorDigitado3 = valorDigitado3.replaceAll(",", ".");
				valorDigitado3 = valorDigitado3.replace("R$ ", "");
				Double valor2 = Double.parseDouble(valorDigitado3);
				
				String valorDigitado4 = txtValor4.getText();
				valorDigitado4 = valorDigitado4.replaceAll(",", ".");
				valorDigitado4 = valorDigitado4.replace("R$ ", "");
				Double valor3 = Double.parseDouble(valorDigitado4);

			
				String mensagem = "";
				String msg = "";

				mensagem = apostaController.validarCamposSalvar( valorDigitado1, valorDigitado2, valorDigitado3,  valorDigitado4);

				if (mensagem.isEmpty()) {
//					ApostaVO aposta = new ApostaVO();
					apostaController.cadastrarApostaController(apostaVO);
					msg = "Aposta Realizada com Sucesso!";
					JOptionPane.showMessageDialog(null, msg);

				
				} else {
					JOptionPane.showMessageDialog(null, mensagem, "Cadastrar aposta", JOptionPane.INFORMATION_MESSAGE);
				}
               
               
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
//				JOptionPane.showMessageDialog(null, grupo1.getSelection().getActionCommand());
				
				Double x = Double.parseDouble(txtValor1.getText());
				Double y = Double.parseDouble(grupo1.getSelection().getActionCommand());
				Double resultado = x * y;
				
				txtRetorno1.setText(resultado.toString());


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
				
//				JOptionPane.showMessageDialog(null, grupo1.getSelection().getActionCommand());
				
				Double x = Double.parseDouble(txtValor2.getText());
				Double y = Double.parseDouble(grupo2.getSelection().getActionCommand());
				Double resultado = x * y;
				
				txtRetorno2.setText(resultado.toString());

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

//				JOptionPane.showMessageDialog(null, grupo1.getSelection().getActionCommand());
				
				Double x = Double.parseDouble(txtValor3.getText());
				Double y = Double.parseDouble(grupo3.getSelection().getActionCommand());
				Double resultado = x * y;
				
				txtRetorno3.setText(resultado.toString());
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
		//	JOptionPane.showMessageDialog(null, grupo1.getSelection().getActionCommand());
				
				Double x = Double.parseDouble(txtValor4.getText());
				Double y = Double.parseDouble(grupo4.getSelection().getActionCommand());
				Double resultado = x * y;
				
				txtRetorno4 .setText(resultado.toString());
				

			}

		});
		btnOk_1.setBounds(286, 576, 54, 23);
		contentPane.add(btnOk_1);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblSubtotal.setBounds(83, 675, 83, 14);
		contentPane.add(lblSubtotal);

		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(155, 674, 86, 20);
		contentPane.add(txtSubTotal);
		txtSubTotal.setColumns(10);

		JLabel lblSaldo = new JLabel("Saldo ");
		lblSaldo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSaldo.setBounds(422, 39, 46, 35);
		contentPane.add(lblSaldo);

		ApostaController apostaController = new ApostaController();
		
		usuarioVO = fazerLogin(1);
		

		lblSaldoAtualizado = new JLabel("");
		lblSaldoAtualizado.setText( String.valueOf(usuarioVO.getValor_depositado()));
	
		lblSaldoAtualizado.setBounds(478, 50, 65, 14);
		contentPane.add(lblSaldoAtualizado);
	
		SaldoAtualizado = Double.parseDouble( lblSaldoAtualizado.getText());
		
		JLabel lblSejaBemVindo = new JLabel("Seja Bem Vindo: ");
		
		lblSejaBemVindo.setText(lblSejaBemVindo.getText() + usuarioVO.getNome());
		lblSejaBemVindo.setBounds(10, 11, 156, 14);
		contentPane.add(lblSejaBemVindo);
	}

	private void calcularSubtotal() {
		Double x = Double.parseDouble(txtValor1.getText());
		Double y = Double.parseDouble(txtValor2.getText());
		Double z = Double.parseDouble(txtValor3.getText());
		Double w = Double.parseDouble(txtValor4.getText());
		Double resultado = x + y + z + w;
	
		txtSubTotal.setText(resultado.toString());
		atualizarSaldo();

	}
	
	private void atualizarSaldo() {
		

		Double subTotal = Double.parseDouble(txtSubTotal.getText());
		Double resultado = SaldoAtualizado - subTotal;
		
		lblSaldoAtualizado.setText(resultado.toString());

	}
	
	private ClienteVO fazerLogin(int pCodigo) {
		return clienteController.consultarPorId(pCodigo);
	}
	
}
		
