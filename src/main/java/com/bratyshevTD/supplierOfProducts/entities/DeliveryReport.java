package com.bratyshevTD.supplierOfProducts.entities;

public class DeliveryReport {

    private Supplier supplierId;
    private Product productId;
    private long count;
    private long sum;

//    public DeliveryReport(Object[] objects) {
//        this.supplierId = (long) objects[0];
//        this.productId = (long) objects[1];
//        this.sum = (long) objects[2];
//        this.count = (long) objects[3];
//    }


    public DeliveryReport(Supplier supplierId, Product productId, long count, long sum) {
        this.supplierId = supplierId;
        this.productId = productId;
        this.count = count;
        this.sum = sum;
    }

    public DeliveryReport() {
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
