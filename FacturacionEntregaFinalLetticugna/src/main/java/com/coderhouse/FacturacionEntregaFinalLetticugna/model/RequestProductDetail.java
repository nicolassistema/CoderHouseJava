package com.coderhouse.FacturacionEntregaFinalLetticugna.model;

public class RequestProductDetail {
    private Integer productId;

    private Integer quantity;

    public RequestProductDetail(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }


}
