package com.coderhouse.FacturacionPrimeraEntregaLetticugna;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.model.Cliente;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.model.Producto;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository.ClientRepository;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class FacturacionPrimeraEntregaLetticugnaApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(FacturacionPrimeraEntregaLetticugnaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");

		//Producto///////////////////////////////////////////
		//Armo el objeto y lo inserto en la basse
		Producto taza = new Producto();
		taza.setCode("1000");
		taza.setDescription("Tasa de ceramica");
		taza.setPrice(10);
		taza.setStock(100);
		this.productRepository.save(taza);//esto graba en la base de datos

		Producto plato = new Producto();
		plato.setCode("1001");
		plato.setDescription("Plato de ceramica");
		plato.setPrice(50);
		plato.setStock(100);
		this.productRepository.save(plato);//esto graba en la base de datos

		Producto tenedor = new Producto();
		tenedor.setCode("1002");
		tenedor.setDescription("Tenedor de metal con mango de madera");
		tenedor.setPrice(5);
		tenedor.setStock(100);
		this.productRepository.save(tenedor);//esto graba en la base de datos

		Producto cuchillo = new Producto();
		cuchillo.setCode("1003");
		cuchillo.setDescription("Cuchillo de metal con mango de madera");
		cuchillo.setPrice(8);
		cuchillo.setStock(100);
		this.productRepository.save(cuchillo);//esto graba en la base de datos

		Producto cuchara = new Producto();
		cuchara.setCode("1004");
		cuchara.setDescription("Cuchara de metal con mango de madera");
		cuchara.setPrice(8);
		cuchara.setStock(100);
		this.productRepository.save(cuchara);//esto graba en la base de datos

		//hago un select a la base de todos sus productos
		List<Producto> listaProductos = this.productRepository.findAll();

		System.out.println("Lista de productos cargados en base");
		System.out.println("==================================");
		for (Producto producto : listaProductos) {//recorro la lista de objetos obtenidos de la base
			System.out.println("Codigo: " + producto.getCode());
			System.out.println("Descripcion: " + producto.getDescription());
			System.out.println("Precio: $" + producto.getPrice());
			System.out.println("Stock: " + producto.getStock());
			System.out.println("----------------------------------");
		}
		System.out.println("Obtencion de un producto por su id");
		System.out.println("==================================");
		Optional<Producto> productoObtenido = this.productRepository.findById(1);//obtengo el producto por su id
		if(productoObtenido.isPresent()) System.out.println("El producto de id :" + productoObtenido.get() + " Existe");
		else System.out.println("El producto no existe");

		//Cliente///////////////////////////////////////////
		//Armo el objeto y lo inserto en la basse
		Cliente clienteUno = new Cliente();
		clienteUno.setName("Juan");
		clienteUno.setLastName("Gomez");
		clienteUno.setDocNumber("33323232");
		this.clientRepository.save(clienteUno);//esto graba en la base de datos

		Cliente clienteDos = new Cliente();
		clienteDos.setName("Pedro");
		clienteDos.setLastName("Garcia");
		clienteDos.setDocNumber("32326699");
		this.clientRepository.save(clienteDos);//esto graba en la base de datos

		Cliente clienteTres = new Cliente();
		clienteTres.setName("Marcelo");
		clienteTres.setLastName("Fernandez");
		clienteTres.setDocNumber("33669999");
		this.clientRepository.save(clienteTres);//esto graba en la base de datos

		Cliente clienteCuatro = new Cliente();
		clienteCuatro.setName("Gustavo");
		clienteCuatro.setLastName("Perrota");
		clienteCuatro.setDocNumber("33665544");
		this.clientRepository.save(clienteCuatro);//esto graba en la base de datos

		Cliente clienteCinco = new Cliente();
		clienteCinco.setName("nicolas");
		clienteCinco.setLastName("letticugna");
		clienteCinco.setDocNumber("32320510");
		this.clientRepository.save(clienteCinco);//esto graba en la base de datos

		//hago un select a la base de todos sus clientes
		List<Cliente> listaCliente = this.clientRepository.findAll();

		System.out.println("Lista de clientes cargados en base");
		System.out.println("==================================");
		for (Cliente cliente : listaCliente) {//recorro la lista de objetos obtenidos de la base
			System.out.println("Nombre: " + cliente.getName());
			System.out.println("Apellido: " + cliente.getLastName());
			System.out.println("Nro Documento: $" + cliente.getDocNumber());
			System.out.println("----------------------------------");
		}
		System.out.println("Obtencion de un producto por su id");
		System.out.println("==================================");
		Optional<Cliente> clienteObtenido = this.clientRepository.findById(1);//obtengo el cliente por su id
		if(clienteObtenido.isPresent()) System.out.println("El cliente de id :" + clienteObtenido.get() + " Existe");
		else System.out.println("El cliente no existe");
	}
}
