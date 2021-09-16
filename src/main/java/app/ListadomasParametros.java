package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Producto;

public class ListadomasParametros {
	
public static void main(String[] args) {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		System.out.println("Listado de Productos x Tipo + Parametros");
		
		//p.idcategoria es el atributo el otro Colum=.. es el nombre del campo
		// parametro se coloca :(nombre de variable)
		//String sql="select p from Producto p where p.idcategoria=:xtipo and p.stock>100";
		
		//typequery permite guardar esta consulta
		TypedQuery<Producto> query=em.createNamedQuery("ProductomasParametros",Producto.class);
		
		//si tiene parametros lo puedo setear
		query.setParameter("xtipo",1);
		//parametro 2
		// parametro 3
		
		//ejecuto este query
		List<Producto> lstProductos=query.getResultList();
		
		
		
		for (Producto p : lstProductos) {
			System.out.println("Cantidad : "+p);
		}
		
		System.out.println("Cantidad de Productos : "+lstProductos.size());
	}

}
