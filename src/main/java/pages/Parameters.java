package pages;

public abstract class Parameters {
    private String nameProduct;
    private String costProduct;

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setCostProduct(String costProduct) {
        this.costProduct = costProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getCostProduct() {
        return costProduct;
    }

}
