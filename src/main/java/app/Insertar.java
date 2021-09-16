package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Insertar {
	
	public static void main(String[] args) {
		
		//METODO REGISTRAR
		
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
	
		Producto p=new Producto();
		p.setIdprod("P0036");
		p.setDescripcion("");
		p.setStock(15);
		p.setPrecio(1.5);
		p.setIdcategoria(2);
		p.setEstado(1);
		
		if(p.getIdprod()==null || p.getIdprod().length()==0 || p.getDescripcion().length()==0 || p.getStock()==0) {
			System.out.println("Verifique los datos !!");
		}else {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("Registro OK");
			em.close();
		}
		
		
	
	}

}
