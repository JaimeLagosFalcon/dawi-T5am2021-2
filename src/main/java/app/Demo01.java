package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
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
		Usuario u=new Usuario();
		u.setCodigo(10);
		u.setNombre("Jaime");
		u.setApellido("Lagos");
		u.setUsuario("jaime@hotmail.com");
		u.setClave("12345");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		//de mi manejador de entidades llamo a em
		//para registrar,actualizar,eliminar -< utilizo transacciones
		//como es una transaccion se tiene que confirmar o commitear
		
		//1-empieza la transaccion
		em.getTransaction().begin();
		
		//2-si quiero regisstrar indico .persist() metodo para registrar
		em.persist(u); //para registrar
		
		//3-confirmo la transaccion
		em.getTransaction().commit();
		
		//5- para saber si se grabo lo muestro
		System.out.println("Registro OK");
		
		//4- cierro
		em.close();
		
		
		
	}

}
