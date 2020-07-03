package com.haulmont.testtask;

import javax.servlet.annotation.WebServlet;

import com.haulmont.testtask.views.*;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class Router extends UI {


    Navigator navigator;
    public static final String MAINVIEW = "";
    public static final String PATIENTVIEW = "patient";
    public static final String DOCTORVIEW = "doctor";
    public static final String RECIPEVIEW = "recipe";
    public static final String PATIENTFORMVIEW = "patientForm";
    public static final String DOCTORFORMVIEW = "doctorForm";
    public static final String RECIPEFORMVIEW = "recipeForm";

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);

        Navigator.ComponentContainerViewDisplay viewDisplay = new Navigator.ComponentContainerViewDisplay(layout);
        navigator = new Navigator(UI.getCurrent(), viewDisplay);
        navigator.addView("", new MainView());
        navigator.addView(PATIENTVIEW, new PatientView());
        navigator.addView(DOCTORVIEW, new DoctorView());
        navigator.addView(RECIPEVIEW, new RecipeView());
        navigator.addView(PATIENTFORMVIEW, new PatientFromView());
        navigator.addView(DOCTORFORMVIEW, new DoctorFormView());
        navigator.addView(RECIPEFORMVIEW, new RecipeFormView());


    }



    @WebServlet(urlPatterns = "/*", name = "Router", asyncSupported = true)
    @VaadinServletConfiguration(ui = Router.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
