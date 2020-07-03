package com.haulmont.testtask.views;

import com.haulmont.testtask.Menu;
import com.haulmont.testtask.PatientForm;
import com.haulmont.testtask.Router;
import com.haulmont.testtask.entities.PatientEntity;
import com.haulmont.testtask.service.PatientService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


public class PatientView extends VerticalLayout implements View {

    private PatientService patientService  = PatientService.getInstance();
    private PatientForm form = new PatientForm(this);
    private Grid<PatientEntity> patientGrid= new Grid<>(PatientEntity.class);

    public PatientView() {

        setSizeFull();
        setSpacing(true);
        addComponent(new Menu());

        HorizontalLayout main = new HorizontalLayout(patientGrid, form);
        main.setSizeFull();
        patientGrid.setSizeFull();
        main.setExpandRatio(patientGrid, 1);
        addComponent(main);

        form.setVisible(false);

        patientGrid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() == null) {
                form.setVisible(false);
            } else {
                form.setVisible(true);
                form.setPatient(event.getValue());
            }
        });


        addComponent(getToolbar());
        addComponent(headingLabel());
        setPatientGrid();





    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {}

    private Label headingLabel() {
        return new Label("Patient");
    }

    private HorizontalLayout getToolbar(){
        Button addButton = new Button("Добавить");
        addButton.addClickListener(e->{
            patientGrid.asSingleSelect().clear();
            form.setPatient(new PatientEntity());
        });
        Button editButton = new Button("Изменить");
        editButton.addClickListener(e->{

        });
        Button deliteButton = new Button("Удалить");
        deliteButton.addClickListener(e->{

        });

        HorizontalLayout toolbar = new HorizontalLayout(addButton, editButton, deliteButton);

        return toolbar;

    }



    public void setPatientGrid() {
        patientGrid.setItems(patientService.findAll());
    }



}
