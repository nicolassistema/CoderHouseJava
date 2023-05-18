package com.coderhouse.FacturacionPrimeraEntregaLetticugna;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository.ClientRepository;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository.InvoiceDetailRepository;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository.InvoiceRepository;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.coderhouse.FacturacionPrimeraEntregaLetticugna.model.*;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class FacturacionPrimeraEntregaLetticugnaApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;


	public static void main(String[] args) {
		SpringApplication.run(FacturacionPrimeraEntregaLetticugnaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");


		//Producto///////////////////////////////////////////
		//Armo el objeto y lo inserto en la basse
		Product taza = new Product();
		taza.setCode("1000");
		taza.setDescription("Tasa de ceramica");
		taza.setPrice(10);
		taza.setStock(100);
		this.productRepository.save(taza);//esto graba en la base de datos

		Product plato = new Product();
		plato.setCode("1001");
		plato.setDescription("Plato de ceramica");
		plato.setPrice(50);
		plato.setStock(100);
		this.productRepository.save(plato);//esto graba en la base de datos

		Product tenedor = new Product();
		tenedor.setCode("1002");
		tenedor.setDescription("Tenedor de metal con mango de madera");
		tenedor.setPrice(5);
		tenedor.setStock(100);
		this.productRepository.save(tenedor);//esto graba en la base de datos

		Product cuchillo = new Product();
		cuchillo.setCode("1003");
		cuchillo.setDescription("Cuchillo de metal con mango de madera");
		cuchillo.setPrice(8);
		cuchillo.setStock(100);
		this.productRepository.save(cuchillo);//esto graba en la base de datos

		Product cuchara = new Product();
		cuchara.setCode("1004");
		cuchara.setDescription("Cuchara de metal con mango de madera");
		cuchara.setPrice(8);
		cuchara.setStock(100);
		this.productRepository.save(cuchara);//esto graba en la base de datos
	/*
		//hago un select a la base de todos sus productos
		List<Product> listaProductos = this.productRepository.findAll();

		System.out.println("Lista de productos cargados en base");
		System.out.println("==================================");
		for (Product producto : listaProductos) {//recorro la lista de objetos obtenidos de la base
			System.out.println("Codigo: " + producto.getCode());
			System.out.println("Descripcion: " + producto.getDescription());
			System.out.println("Precio: $" + producto.getPrice());
			System.out.println("Stock: " + producto.getStock());
			System.out.println("----------------------------------");
		}
		System.out.println("Obtencion de un producto por su id");
		System.out.println("==================================");
		Optional<Product> productoObtenido = this.productRepository.findById(1);//obtengo el producto por su id
		if(productoObtenido.isPresent()) System.out.println("El producto de id :" + productoObtenido.get() + " Existe");
		else System.out.println("El producto no existe");*/


		//Cliente///////////////////////////////////////////
		//Armo el objeto y lo inserto en la basse
		Client clienteUno = new Client();
		clienteUno.setName("Juan");
		clienteUno.setLastName("Gomez");
		clienteUno.setDocNumber("33323232");
		this.clientRepository.save(clienteUno);//esto graba en la base de datos

		Client clienteDos = new Client();
		clienteDos.setName("Pedro");
		clienteDos.setLastName("Garcia");
		clienteDos.setDocNumber("32326699");
		this.clientRepository.save(clienteDos);//esto graba en la base de datos

		Client clienteTres = new Client();
		clienteTres.setName("Marcelo");
		clienteTres.setLastName("Fernandez");
		clienteTres.setDocNumber("33669999");
		this.clientRepository.save(clienteTres);//esto graba en la base de datos

		Client clienteCuatro = new Client();
		clienteCuatro.setName("Gustavo");
		clienteCuatro.setLastName("Perrota");
		clienteCuatro.setDocNumber("33665544");
		this.clientRepository.save(clienteCuatro);//esto graba en la base de datos

		Client clienteCinco = new Client();
		clienteCinco.setName("nicolas");
		clienteCinco.setLastName("letticugna");
		clienteCinco.setDocNumber("32320510");
		this.clientRepository.save(clienteCinco);//esto graba en la base de datos

		//Búsqueda con métodos customizados
		List<Client> clientes = this.clientRepository.findByNameLike("%a%");
		System.out.println(clientes.size());
		printClientes(clientes);

/*
		List<Client> clientes2 = this.clientRepository.getByNameOrderedByLastnameJPQL("Pedro");
		System.out.println(clientes2.size());
		printClientes(clientes2);*/

		List<Client> clientes3 = this.clientRepository.getByNameOrderedByLastnameNativeQuery("Pedro");
		System.out.println(clientes3.size());
		printClientes(clientes3);


		/*	//hago un select a la base de todos sus clientes
		List<Client> listaCliente = this.clientRepository.findAll();

		System.out.println("Lista de clientes cargados en base");
		System.out.println("==================================");
		for (Client cliente : listaCliente) {//recorro la lista de objetos obtenidos de la base
			System.out.println("Nombre: " + cliente.getName());
			System.out.println("Apellido: " + cliente.getLastName());
			System.out.println("Nro Documento: $" + cliente.getDocNumber());
			System.out.println("----------------------------------");
		}
		System.out.println("Obtencion de un producto por su id");
		System.out.println("==================================");
		Optional<Client> clienteObtenido = this.clientRepository.findById(1);//obtengo el cliente por su id
		if(clienteObtenido.isPresent()) System.out.println("El cliente de id :" + clienteObtenido.get() + " Existe");
		else System.out.println("El cliente no existe");*/

		System.out.println("Server listening on. http://localhost:8888/h2-console");

		////Paso 3: creación de facturas
		Optional<Client> client1 = this.clientRepository.findById(1); //consulto por el id 1 de la tabla cliente

		Invoice invoice1 = new Invoice();//instancio un invoice
		client1.ifPresent(invoice1::setClient);//si existe el client1, a la factura1 le asignamos el cliente 1, impactaria el id de de la tabla cliente en la de factura y esto pasa por que es Fk, las entidades entan relacionadas
		invoice1.setCreated_at("13-03");
		invoice1.setTotal(700);
		this.invoiceRepository.save(invoice1);

		Invoice invoice2 = new Invoice();
		client1.ifPresent(invoice2::setClient);
		invoice2.setCreated_at("15-03");
		invoice2.setTotal(700);
		this.invoiceRepository.save(invoice2);

		Optional<Client> client2 = this.clientRepository.findById(2);

		Invoice invoice3 = new Invoice();
		client2.ifPresent(invoice3::setClient);
		invoice3.setCreated_at("15-03");
		invoice3.setTotal(700);
		this.invoiceRepository.save(invoice3);

		client1 = this.clientRepository.findById(1);
		client2 = this.clientRepository.findById(2);
		System.out.println(client2.get().getInvoice());//es como un inner join



		////Paso 4: creación de detalles de factura
		Optional<Invoice> invoiceList = this.invoiceRepository.findById(1); //consulto por el id 1 de la tabla detalle de factura
		Optional<Product> productList = this.productRepository.findById(1); //consulto por el id 1 de la tabla detalle de factura


		InvoiceDetail invoiceDetail1 = new InvoiceDetail();//instancio un invoice detail
		invoiceList.ifPresent(invoiceDetail1::setInvoice);
		productList.ifPresent(invoiceDetail1::setProduct);
		invoiceDetail1.setAmount(8);
		invoiceDetail1.setPrice(50.25);
		this.invoiceDetailRepository.save(invoiceDetail1);

		InvoiceDetail invoiceDetail2 = new InvoiceDetail();//instancio un invoice detail
		invoiceList.ifPresent(invoiceDetail2::setInvoice);
		productList.ifPresent(invoiceDetail2::setProduct);
		invoiceDetail2.setAmount(20);
		invoiceDetail2.setPrice(1000.25);
		this.invoiceDetailRepository.save(invoiceDetail2);



		InvoiceDetail invoiceDetail3 = new InvoiceDetail();//instancio un invoice detail
		invoiceList.ifPresent(invoiceDetail3::setInvoice);
		productList.ifPresent(invoiceDetail3::setProduct);
		invoiceDetail3.setAmount(50);
		invoiceDetail3.setPrice(500.25);
		this.invoiceDetailRepository.save(invoiceDetail3);



	}

	private void printClientes(List<Client> listaCliente) {
		for (Client cliente: listaCliente
		) {
			System.out.println(cliente);
		}
	}


}

