package com.haulmont.testtask;
import com.haulmont.testtask.entities.PatientEntity;
import com.haulmont.testtask.service.PatientService;
import com.haulmont.testtask.views.PatientView;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class PatientForm extends FormLayout {

    private TextField name = new TextField("Имя");
    private TextField surname = new TextField("Фамилия");
    private TextField patronymic = new TextField("Отчество");
    private TextField phone = new TextField("Телефон");

  //  private NativeSelect<CustomerStatus> status = new NativeSelect<>("Status");
  //  private DateField birthdate = new DateField("Birthday");
    private Button save = new Button("Сохранить");
    private Button cancel = new Button("Отмена");

    private PatientService service = PatientService.getInstance();
    private PatientEntity patient;
    private PatientView patientView;
    private Binder<PatientEntity> binder = new Binder<>(PatientEntity.class);

    public PatientForm(PatientView patientView) {
        this.patientView = patientView;

        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, cancel);
        addComponents(name, surname,patronymic, phone, buttons);

        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(KeyCode.ENTER);

        binder.bindInstanceFields(this);

        save.addClickListener(e -> this.save());
        cancel.addClickListener(e -> this.cancel());
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
        binder.setBean(patient);
        name.selectAll();
    }

    private void cancel() {
//        service.delete(patient);
//        patientView.setPatientGrid();
        setVisible(false);
    }

    private void save() {
        service.saveOrUpdate(patient);
        patientView.setPatientGrid();
        setVisible(false);
    }

}
