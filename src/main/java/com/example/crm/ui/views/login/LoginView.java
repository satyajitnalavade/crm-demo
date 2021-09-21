package com.example.crm.ui.views.login;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.internal.BeforeEnterHandler;

import java.util.Collections;

@Route("login")
@PageTitle("Login | Demo CRM")
public class LoginView extends VerticalLayout implements BeforeEnterHandler {

    LoginForm login = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        login.setAction("login");

        add(
                new H1("Demo CRM"),
                login

        );


    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(!beforeEnterEvent.getLocation()
            .getQueryParameters()
            .getParameters()
            .getOrDefault("error", Collections.emptyList())
            .isEmpty()) {
                login.setError(true);
        }
    }
}
