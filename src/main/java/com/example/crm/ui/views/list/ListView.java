package com.example.crm.ui.views.list;

import com.example.crm.backend.entity.Company;
import com.example.crm.backend.entity.Contact;
import com.example.crm.backend.service.CompanyService;
import com.example.crm.backend.service.ContactService;
import com.example.crm.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * @author satya
 */
@Route(value = "", layout = MainLayout.class)
@PageTitle("Contacts | Demo CRM")
public class ListView extends VerticalLayout {

    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField filterText=new TextField();
    private final ContactService contactService;
    private final CompanyService companyService;
    private final ContactForm contactForm;

    public ListView(ContactService contactService, CompanyService companyService) {
        this.contactService = contactService;
        this.companyService = companyService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        contactForm = new ContactForm(companyService.findAll());
        contactForm.addListener(ContactForm.SaveEvent.class,this::saveContact);
        contactForm.addListener(ContactForm.DeleteEvent.class,this::deleteContact);
        contactForm.addListener(ContactForm.CloseEvent.class, e -> closeContactEditor());


        Div content = new Div(grid,contactForm);
        content.addClassName("content");
        content.setSizeFull();

        add(configureToolBar(),content);
        updateList();
        closeContactEditor();

    }

    private void saveContact(ContactForm.SaveEvent evt) {
        contactService.save(evt.getContact());
        updateList();
        closeContactEditor();
    }

    private void deleteContact(ContactForm.DeleteEvent evt) {
        contactService.delete(evt.getContact());
        updateList();
        closeContactEditor();
    }

    private void closeContactEditor() {
        contactForm.setContact(null);
        contactForm.setVisible(false);
        removeClassName("editing");
    }

    private HorizontalLayout configureToolBar() {

        filterText.setPlaceholder("Filter by name..");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact", click -> addContact());

        HorizontalLayout toolbar = new HorizontalLayout(filterText,addContactButton);
        toolbar.addClassName("toolbar");

        return toolbar;

    }

    private void addContact() {
        grid.asSingleSelect().clear();
        editContact(new Contact());
    }

    private void updateList() {
        grid.setItems(contactService.findAll(filterText.getValue()));
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("company");
        grid.setColumns("firstName", "lastName", "email", "status");
        grid.addColumn(contact -> {
            Company company = contact.getCompany();
            return company == null ? "-" : company.getName();
        }).setHeader("Company");
        grid.getColumns().forEach(contactColumn -> contactColumn.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event -> editContact(event.getValue()));

    }

    private void editContact(Contact contact) {
        if (contact == null){
            closeContactEditor();
        }
        else
        {
            contactForm.setContact(contact);
            contactForm.setVisible(true);
            addClassName("editing");
        }
    }
}
