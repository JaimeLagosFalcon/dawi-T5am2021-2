package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Actualizar {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		
		
		Producto p=em.find(Producto.class,"P0036");
		
		
		if(p==null) {
			System.out.println("Producto NO encontrado !!");
		}else {
			
			p.setIdprod("P0035");
			p.setDescripcion("Meloness");
			p.setStock(15);
			p.setPrecio(1.5);
			p.setIdcategoria(2);
			p.setEstado(1);
			
			
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			System.out.println("Actualizacion OK");
			em.close();
		}	
	}
}
