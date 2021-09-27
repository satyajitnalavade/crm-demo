package com.example.crm.ui;

import com.example.crm.ui.views.dashboard.DashboardView;
import com.example.crm.ui.views.list.ListView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

/**
 * @author satya
 */

@PWA(
        name="Demo CRM",
        shortName = "CRM",
        enableInstallPrompt = false


)
@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {


    public MainLayout() {

        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("List", ListView.class);
            listLink.setHighlightCondition(HighlightConditions.sameLocation());
        RouterLink dashboard = new RouterLink("Dashboard", DashboardView.class);

        addToDrawer(
                new VerticalLayout(
                        listLink,
                        dashboard
                )
        );
    }

    private void createHeader() {
        H1 logo = new H1("Demo CRM");
        logo.addClassName("logo");

        Anchor log_out = new Anchor("/logout","Logout");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, log_out);
        header.addClassName("header");
        header.setWidth("100%");
        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }
}
