package com.example.webapp;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.faces.context.FacesContext;
import jakarta.faces.application.FacesMessage;
import java.io.IOException;

@Named("loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void login() {
        System.out.println(username);
        System.out.println(password);
        FacesContext context = FacesContext.getCurrentInstance();

        // single validation
        if ("admin".equals(username) && "admin".equals(password)) {
            try {
                context.getExternalContext().redirect("index.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login failed", "Usuario o contraseña incorrectos"));
        }
    }
}