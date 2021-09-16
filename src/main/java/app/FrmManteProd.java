package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Usuario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDecripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
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
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 11, 89, 23);
		contentPane.add(btnRegistrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 8, 162, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Id. Producto :");
		lblNewLabel.setBounds(10, 11, 102, 14);
		contentPane.add(lblNewLabel);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 108, 126, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 112, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(10, 38, 102, 14);
		contentPane.add(lblNewLabel_1);

		txtDecripcion = new JTextField();
		txtDecripcion.setBounds(122, 30, 162, 20);
		contentPane.add(txtDecripcion);
		txtDecripcion.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(122, 53, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(122, 77, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(10, 56, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(10, 80, 46, 14);
		contentPane.add(lblNewLabel_3);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(324, 45, 89, 23);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(324, 76, 89, 23);
		contentPane.add(btnEliminar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(324, 108, 89, 23);
		contentPane.add(btnBuscar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(324, 137, 89, 23);
		contentPane.add(btnLimpiar);

		llenaCombo();
	}

	void llenaCombo() {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String sql = "select c from Categoria c";

		List<Categoria> lstCategoria = em.createQuery(sql, Categoria.class).getResultList();

		cboCategorias.addItem("Seleccione");

		for (Categoria c : lstCategoria) {
			cboCategorias.addItem(c.getDescripcion());
		}
	}

	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String sql = "select p from Producto p";

		List<Producto> lstProductos = em.createQuery(sql, Producto.class).getResultList();

		txtSalida.setText(">>>> LISTADO DE PRODUCTOS >>>> \n\n");
		for (Producto p : lstProductos) {
			txtSalida.append("Codigo     \t : " + p.getIdprod() + "\n");
			txtSalida.append("Descripcion\t : " + p.getDescripcion() + "\n");
			txtSalida.append("Stock      \t : " + p.getStock() + "\n");
			txtSalida.append("Precio     \t : " + p.getPrecio() + "\n");
			txtSalida.append("Categoria  \t : " + p.getIdcategoria() + "\n");
			txtSalida.append("Estado     \t : " + p.getEstado() + "\n");
			txtSalida.append("\n");

		}

	}

	void registrar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String idprod = txtCódigo.getText();
		String descripcion = txtDecripcion.getText();
		int stock = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		int idcategoria = cboCategorias.getSelectedIndex();

		Producto p = new Producto(idprod, descripcion, stock, precio, idcategoria, 1);

		if (p.getDescripcion().length() < 0 || p.getStock() == 0) {
			txtSalida.setText("Error en la inserción !! \n verifique los datos");
		} else {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			txtSalida.setText("Producto Insertado");
			em.close();
			limpiar();
		}

	}

	void limpiar() {
		txtCódigo.setText("");
		txtDecripcion.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
		cboCategorias.setSelectedItem(-1);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
	}

	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar2();
	}

	void limpiar2() {
		txtCódigo.setText("");
		txtDecripcion.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
		cboCategorias.setSelectedItem(-1);
		txtSalida.setText("");
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		Actualizar();
	}

	private void Actualizar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String idprod = txtCódigo.getText();
		String descripcion = txtDecripcion.getText();
		int stock = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		int idcategoria = cboCategorias.getSelectedIndex();

		Producto p = new Producto(idprod, descripcion, stock, precio, idcategoria, 1);

		if (p == null || p.getIdprod() == null || p.getDescripcion().length() == 0) {
			txtSalida.setText("Error en la actualización !! \n verifique los datos");
		} else {
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			txtSalida.setText("Producto Actualizado");
			em.close();
			limpiar();
		}

	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Eliminar();
	}

	void Eliminar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String idprod = txtCódigo.getText();

		Producto p = em.find(Producto.class, idprod);

		if (p == null) {
			txtSalida.setText("Error en la eliminación !! \n verifique los datos");
		} else {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			txtSalida.setText("Producto Eliminado");
			em.close();
			limpiar();
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		Buscar();
	}

	private void Buscar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		String idprod = txtCódigo.getText();

		String sql = "select p from Producto p where p.idprod=:xid";

		List<Producto> lstProductos = em.createQuery(sql, Producto.class).setParameter("xid", idprod).getResultList();

		if (lstProductos == null) {
			txtSalida.setText(">>>>> Producto NO encontrado !!");
		} else {
			txtSalida.setText(" >>>Producto Encontrado !! >>> \n\n");
			for (Producto p : lstProductos) {
				txtSalida.append("Codigo     \t : " + p.getIdprod() + "\n");
				txtSalida.append("Descripcion\t : " + p.getDescripcion() + "\n");
				txtSalida.append("Stock      \t : " + p.getStock() + "\n");
				txtSalida.append("Precio     \t : " + p.getPrecio() + "\n");
				txtSalida.append("Categoria  \t : " + p.getIdcategoria() + "\n");
				txtSalida.append("Estado     \t : " + p.getEstado() + "\n");
			}
		}

	}
}
