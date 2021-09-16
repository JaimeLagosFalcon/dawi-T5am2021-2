package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//ENTIDAD
//INDICO LA TABLA CON LA CUAL TRABAJARA
@Entity
@Table(name="tb_productos")
@NamedQuery(name="ProductomasParametros",query="select p from Producto p where p.idcategoria=:xtipo and p.stock>100")

//@getter esto solo va a crear los get
//@setter esto solo va a crear los set
//@tostring crea el metodo
//@allargsconstructor constructor con todos los campos
//@noargsconstructor constructor vacio

//@data genera los get set tostring pero el constructor si tengo que colocarlo

public class Producto {
	
	@Id
	private String idprod;
	private String descripcion;
	private int stock;
	private double precio;
	private int idcategoria;
	private int estado;
	
	
	
	@Override
	public String toString() {
		return "Producto [idprod=" + idprod + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio
				+ ", idcategoria=" + idcategoria + ", estado=" + estado + "]";
	}
	public Producto() {
		super();
	}
	public Producto(String idprod, String descripcion, int stock, double precio, int idcategoria, int estado) {
		super();
		this.idprod = idprod;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.idcategoria = idcategoria;
		this.estado = estado;
	}
	public String getIdprod() {
		return idprod;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

}
