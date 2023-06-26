package com.coderhouse.FacturacionEntregaFinalLetticugna.service;

import com.coderhouse.FacturacionEntregaFinalLetticugna.model.*;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.ClientRepository;
import com.coderhouse.FacturacionEntregaFinalLetticugna.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    private ClientService clientService;

   /* public InvoiceDTO postInvoice (InvoiceRequest requestInvoice) throws Exception {

        //Buscamos al cliente a través de su id
        Client clientExist = clientService.getClientById(requestInvoice.getClient_id());
        //Buscamos los productos
        List<Product> productList = productService.getProductsById(requestInvoice.getProduct_list());


        double total = 0;
        int i = 0;

            for (Product product :
                    productList) {

                System.out.println("iteracion: (" + i + ") | precio: " + product.getPrice() + " | Cantidad: " + requestInvoice.getProduct_list().get(i).getQuantity());
                total += product.getPrice() * requestInvoice.getProduct_list().get(i).getQuantity();


                i++;
            }




        //Instanciamos un objeto invoice
        Invoice invoiceCreated = new Invoice();

        //Setteamos la fecha del invoice
        invoiceCreated.setCreated_at(new Date().toString());

        //Setteamos al cliente dentro del invoice
        invoiceCreated.setClient(clientExist);

        invoiceCreated.setTotal(total);
        //Guardamos el invoice antes de guardar el detalle
        invoiceCreated = invoiceRepository.save(invoiceCreated);

        //Settamos los invoice_details y los guardamos
        i = 0;
        for (Product productForDetail:
                productList) {
            InvoiceDetail newInvoice = new InvoiceDetail();
            newInvoice.setPrice(productForDetail.getPrice());
            newInvoice.setInvoice(invoiceCreated);
            newInvoice.setProduct(productForDetail);
            newInvoice.setQuantity(requestInvoice.getProduct_list().get(i).getQuantity());
            invoiceDetailService.saveInvoiceDetail(newInvoice);
            i++;
        }

        //Por último retornamos el DTO
        return new InvoiceDTO(
                invoiceCreated.getId(),
                invoiceCreated.getCreated_at(),
                invoiceCreated.getTotal()
        );


    }*/


    public InvoiceDTO postInvoice(InvoiceRequest requestInvoice) throws Exception {

        //Buscamos al cliente a través de su id
        Client clientExist = clientService.getClientById(requestInvoice.getClient_id());

        //buscamos los productos existentes en la base
        List<Product> productListExistents = productService.getProductList();

        //Buscamos los productos que se quiere cargar
        List<Product> productList = productService.getProductsById(requestInvoice.getProduct_list());

        double total = 0;
        int i = 0;
        //Genero una lista map para agrupar todos los productos a cargar y sumar sus cantidades agrupados por ID
        Map<Integer, Integer> productMap = new HashMap<>();
        for (Product product : productList) {

            //Obtengo una lista de id y cantidad agrupado por id
            int productId = product.getId();
            int productQuantity = requestInvoice.getProduct_list().get(i).getQuantity();

            if (productMap.containsKey(productId)) {
                // Si el ID del producto ya está en el mapa, se suma la cantidad al valor existente
                int currentQuantity = productMap.get(productId);
                productMap.put(productId, currentQuantity + productQuantity);
            } else {
                // Si el ID del producto no está en el mapa, se agrega como una nueva entrada
                productMap.put(productId, productQuantity);
            }
            i++;
        }


        //comparo la cantidad por producto que vamos a cargar en la tabla con el stock en la tabla para no excedernos del mismo
        boolean flag = false;
        Product prodcutResult = new Product();
        for (Product productExistent :
                productListExistents) {
            int m = 0;
            for (Map.Entry<Integer, Integer> entry : productMap.entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                if (productId == productExistent.getId()) {
                    if (quantity > productExistent.getStock()) {
                        prodcutResult = productExistent;
                        flag = true;
                        break;
                    }
                }
                m++;
            }
        }

        //si la cantidad a cargar excede entonces salimos por throw
        if (flag) {
            throw new Exception("Se agoto el stock del producto: " + prodcutResult.getTitle());
        }


        //Tomamos la lista de productos que vamos a cargar en el invoice
        i = 0;
        List<Product> productListAux = new ArrayList<>();
        for (Product product : productList) {

            Product productAux = productService.getProductById(product.getId());
            productAux.setTitle(productAux.getTitle());
            productAux.setDescription(productAux.getDescription());
            productAux.setPrice(productAux.getPrice());
            productAux.setCode(productAux.getCode());
            productAux.setStock(productAux.getStock() - requestInvoice.getProduct_list().get(i).getQuantity());
            total += product.getPrice() * requestInvoice.getProduct_list().get(i).getQuantity();
            productListAux.add(productAux);
            productService.postProduct(productAux);
            i++;
        }


        //Instanciamos un objeto invoice
        Invoice invoiceCreated = new Invoice();

        //Setteamos la fecha del invoice
        invoiceCreated.setCreated_at(new Date().toString());

        //Setteamos al cliente dentro del invoice
        invoiceCreated.setClient(clientExist);

        invoiceCreated.setTotal(total);
        //Guardamos el invoice antes de guardar el detalle
        invoiceCreated = invoiceRepository.save(invoiceCreated);

        //Settamos los invoice_details y los guardamos
        i = 0;
        for (Product productForDetail :
                productList) {
            InvoiceDetail newInvoice = new InvoiceDetail();
            newInvoice.setPrice(productForDetail.getPrice());
            newInvoice.setInvoice(invoiceCreated);
            newInvoice.setProduct(productForDetail);
            newInvoice.setQuantity(requestInvoice.getProduct_list().get(i).getQuantity());
            invoiceDetailService.saveInvoiceDetail(newInvoice);
            i++;
        }

        //Por último retornamos el DTO
        return new InvoiceDTO(
                invoiceCreated.getId(),
                invoiceCreated.getCreated_at(),
                invoiceCreated.getTotal()
        );


    }

    public List<InvoiceDTO> getInvoicesByClientId(int id) throws Exception {
        System.out.println("Entro en getInvoicesByClientId: " + id);
        return invoiceRepository.getInvoicesByClientById(id);
    }

    public InvoiceWithDetailsDTO getInvoiceById(int invoice_id) throws Exception {
        Optional<Invoice> invoiceFound = invoiceRepository.findById(invoice_id);
        if (invoiceFound.isEmpty()) {
            throw new Exception("Invoice not found");
        }
        Client client = clientRepository.getClientIdByIDInvoice(invoice_id);
        List<InvoiceDetailDTO> invoice_details = invoiceDetailService.getInvoiceDetailsByInvoiceId(invoice_id);
        return new InvoiceWithDetailsDTO(
                client.getId(),
                invoiceFound.get().getId(),
                invoiceFound.get().getCreated_at(),
                invoiceFound.get().getTotal(),
                invoice_details
        );
    }

}
