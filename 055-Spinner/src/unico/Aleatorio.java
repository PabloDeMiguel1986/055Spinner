package unico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Aleatorio {

	private JFrame frmPrincipal;
	private JTextField txtInfo;
	private Integer valorIni;
	private Integer valorMax;
	private JLabel lblInfo;
	private Random aleatorio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aleatorio window = new Aleatorio();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aleatorio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Numero Random");
		frmPrincipal.setBounds(100, 100, 283, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JSpinner spnNumero1 = new JSpinner();
		spnNumero1.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		valorIni = 0;
		valorMax = 0;
		spnNumero1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				valorIni = (Integer) spnNumero1.getValue();
			}
		});
		spnNumero1.setBounds(124, 48, 79, 20);
		frmPrincipal.getContentPane().add(spnNumero1);
		
		JSpinner spnNumero2 = new JSpinner();
		spnNumero2.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spnNumero2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				valorMax = (Integer) spnNumero2.getValue();
			}
		});
		spnNumero2.setBounds(124, 105, 79, 20);
		frmPrincipal.getContentPane().add(spnNumero2);
		
		JLabel lblValor = new JLabel("Valor mínimo");
		lblValor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValor.setBounds(10, 48, 79, 20);
		frmPrincipal.getContentPane().add(lblValor);
		
		JLabel lblValor2 = new JLabel("Valor máximo");
		lblValor2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValor2.setBounds(10, 108, 79, 20);
		frmPrincipal.getContentPane().add(lblValor2);
		
		JButton btnAleatorio = new JButton("ALEATORIO");
		
		btnAleatorio.setBounds(66, 157, 137, 38);
		frmPrincipal.getContentPane().add(btnAleatorio);
		
		JLabel lblInfo = new JLabel("Numero aleatorio :");
		lblInfo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInfo.setBounds(10, 216, 111, 20);
		frmPrincipal.getContentPane().add(lblInfo);
		
		aleatorio = new Random();
				
		txtInfo = new JTextField();
		txtInfo.setEditable(false);
		txtInfo.setBounds(124, 216, 122, 20);
		frmPrincipal.getContentPane().add(txtInfo);
		txtInfo.setColumns(10);
		btnAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//ASí se consigue generar un numero aleatorio entre rangos
				txtInfo.setText(String.valueOf((int)(Math.random()*(valorMax-valorIni+1)+ valorIni)));
				
			}
		});
	}
}
