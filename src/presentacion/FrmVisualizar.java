package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Persona;
import tabla.TablaVehiculo;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import java.awt.Toolkit;

public class FrmVisualizar extends JFrame {

	private JPanel contentPane;
	private FrmListado form;
	private Persona persona;
	private JLabel lblNacimiento;
	private JTable tblVehiculos;


	/**
	 * Create the frame.
	 * @param persona 
	 * @param frmListado 
	 */
	public FrmVisualizar(FrmListado frmListado, Persona persona) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmVisualizar.class.getResource("/imagenes/logo.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
		form=frmListado;
		this.persona=persona;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 909, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 34, 297, 248);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("ID");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_12 = new JLabel(":");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_12);
		
		JLabel lblId = new JLabel("1");
		panel.add(lblId);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre");
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_13 = new JLabel(":");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_13);
		
		JLabel lblNombre = new JLabel("Ale");
		panel.add(lblNombre);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_14 = new JLabel(":");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_14);
		
		JLabel lblApellido = new JLabel("Apellido");
		panel.add(lblApellido);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento");
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_15 = new JLabel(":");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_15);
		
		lblNacimiento = new JLabel("Nacimiento");
		panel.add(lblNacimiento);
		
		JLabel lblNewLabel_7 = new JLabel("Departamento");
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_16 = new JLabel(":");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_16);
		
		JLabel lblDepartamento = new JLabel("1");
		panel.add(lblDepartamento);
		
		JLabel lblNewLabel_10 = new JLabel("Cantidad de hijos");
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_17 = new JLabel(":");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_17);
		
		JLabel lblHijos = new JLabel("2");
		panel.add(lblHijos);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setBounds(502, 293, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarVehiculo();
			}
		});
		btnAgregar.setBounds(194, 293, 89, 23);
		contentPane.add(btnAgregar);
		lblNombre.setText(persona.getNombre());
		lblApellido.setText(persona.getApellido());
		lblDepartamento.setText(persona.getDeptoResidencia());
		lblHijos.setText(persona.getCantHijos()+"");
		lblId.setText(persona.getIdPersona()+"");
		lblNacimiento.setText(persona.getFechaNacimiento().toString());
		
		tblVehiculos = new JTable();
		tblVehiculos.setBounds(317, 34, 566, 248);
		contentPane.add(tblVehiculos);
		setTitle(persona.getNombre()+" "+persona.getApellido()+" - Dilbert Software");
		this.tblVehiculos.setModel(new TablaVehiculo(persona.getVehiculos()));
	}


	protected void agregarVehiculo() {
		new FrmAltaVehiculo(this,persona).setVisible(true);
		setEnabled(false);
	}

	public void listadoVehiculo()
	{
		this.tblVehiculos.setModel(new TablaVehiculo(persona.getVehiculos()));
		
	}

	protected void volver() {
		form.setEnabled(true);
		dispose();
		
	}
}
