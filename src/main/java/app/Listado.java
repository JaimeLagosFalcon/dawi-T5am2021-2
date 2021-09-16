package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Listado {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		
		
		//se utilizan los nombres de las entidades NO de las tablas
		//si quiero datos especificos p.idprod ...
		String sql="select p from Producto p";
		
		
		
		if(sql!=null) {
			
				System.out.println("Listado de Productos !!");
				//el create query devuelve un typequery
				//getresultlist obtiene la consulta de tipo typequery y lo conbierte en un list de la clase Producto
				List<Producto> lstProducto=em.createQuery(sql,Producto.class).getResultList();
				
				
			
				for (Producto p : lstProducto) {
					System.out.println(p);
				}
				System.out.println("Cantidad de Productos : "+lstProducto.size());
		
		}else {
				System.out.println("Listado Vacio !!");
		
		}
		
	}

}
