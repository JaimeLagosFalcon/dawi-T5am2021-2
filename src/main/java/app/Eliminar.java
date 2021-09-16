package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Eliminar {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		Producto p=em.find(Producto.class,"P0034");
		
		if(p==null) {
			System.out.println("Producto NO encontrado !!");
		}else {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			System.out.println("Eliminado OK");
			em.close();
		}
	}

}
