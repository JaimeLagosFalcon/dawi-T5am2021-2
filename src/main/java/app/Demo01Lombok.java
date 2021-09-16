package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.Producto2;


public class Demo01Lombok {
	
public static void main(String[] args) {
		
		//******** REGISTRAR
		
		//obtener la conexion ->segun la unidad de persistencia
		//ESTO ES COMO EL DAOFACTORY fabrica=..
		//1-fabrica de acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2-crear manejador de entidaddes
		//crea los dao usando la fabrica
		EntityManager em=fabrica.createEntityManager();
		
		//a partir de aca ya viene el proceso
		
		//proceso: registrar un nuevo usuario
		Producto2 p =new Producto2();
		p.setIdprod("P0037");
		p.setDescripcion("Pantene");
		p.setStock(15);
		p.setPrecio(1.5);
		p.setIdcategoria(2);
		p.setEstado(1);
		
		//de mi manejador de entidades llamo a em
		//para registrar,actualizar,eliminar -< utilizo transacciones
		//como es una transaccion se tiene que confirmar o commitear
		
		//1-empieza la transaccion
		em.getTransaction().begin();
		
		//2-si quiero regisstrar indico .persist() metodo para registrar
		em.persist(p); //para registrar
		
		//3-confirmo la transaccion
		em.getTransaction().commit();
		
		//5- para saber si se grabo lo muestro
		System.out.println("Registro OK");
		
		//4- cierro
		em.close();
		
		
		
	}

}
