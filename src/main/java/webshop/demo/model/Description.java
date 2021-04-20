package webshop.demo.model;

import javax.persistence.*;

@Entity
public class Description {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long descriptionId;

    private String description;

    @OneToOne
    @JoinColumn(name = "descriptionId")
    private Product product;

    public Description() {
    }

    public long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(long descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
