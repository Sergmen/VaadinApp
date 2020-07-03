package com.haulmont.testtask;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class Menu extends CustomComponent {

	public Menu() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(mainButton());
		layout.addComponent(doctorButton());
		layout.addComponent(patientButton());
		layout.setSizeUndefined();
		layout.setSpacing(true);
		setSizeUndefined();
		setCompositionRoot(layout);
	}
	
	private Button mainButton() {
		Button button = new Button("Main", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Router.MAINVIEW);
			}
		});
		return button;
	}
	
	private Button doctorButton() {
		Button button = new Button("Doctor", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Router.DOCTORVIEW);
			}
		});
		return button;
	}

	private Button patientButton() {
		Button button = new Button("Patient", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Router.PATIENTVIEW);
			}
		});
		return button;
	}


	private Button recipeButton() {
		Button button = new Button("Recipe", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(Router.RECIPEVIEW);
			}
		});
		return button;
	}


	


}
