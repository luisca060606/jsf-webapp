package com.example.webapp.controller;

import com.example.webapp.model.entity.Product;
import com.example.webapp.service.IProductService;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
@Named(value = "productMB")
@ViewScoped
public class ProductController implements Serializable {
    @EJB
    private IProductService productService;
    private Product product;
    private List<Product> products;

    public void openNew() {
        product = new Product();
    }

    public List<Product> getProducts() {
//        return products = productService.listar();
        return products = productService.findAllName();
    }

    public void saveProduct() {
        if (product.getId() == null) {
            productService.save(product);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Product Saved", "Saved correctly"));;
        } else {
            productService.edit(product);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Product Edited", "Edited correctly"));
        }
        openNew();
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        productService.delete(product);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User " +
                "deleted"));
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
}
