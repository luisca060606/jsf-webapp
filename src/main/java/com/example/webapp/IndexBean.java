package com.example.webapp;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

//@Named("indexBean") // nombre que usarás en tu xhtml
@Named
@RequestScoped // ciclo de vida corto (puede cambiar a @SessionScoped)
public class IndexBean implements Serializable {

    private String message = "¡Hola desde el bean!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Método de ejemplo para PrimeFaces
    public void showMessage() {
        System.out.println("Acción ejecutada en el bean");
    }
}
