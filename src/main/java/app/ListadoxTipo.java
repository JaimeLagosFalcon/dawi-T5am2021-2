package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ListadoxTipo {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		System.out.println("Listado de Productos x Tipo");
		
		//p.idcategoria es el atributo el otro Colum=.. es el nombre del campo
		// parametro se coloca :(nombre de variable)
		String sql="select p from Producto p where p.idcategoria=:xtipo";
		
		List<Producto> lstProductos=em.createQuery(sql,Producto.class).setParameter("xtipo",1).getResultList();
		
		
		
		for (Producto p : lstProductos) {
			System.out.println("Cantidad : "+p);
		}
		
		System.out.println("Cantidad de Productos : "+lstProductos.size());
	}

}
