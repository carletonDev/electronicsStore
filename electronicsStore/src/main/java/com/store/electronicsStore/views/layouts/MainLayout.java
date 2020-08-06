package com.store.electronicsStore.views.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;

@Theme(value = Material.class, variant = Material.LIGHT)
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes")
@PWA(name = "Titan Apps E-Commerce", shortName = "E-Commerce Template")
public class MainLayout extends AppLayout {

  private static final long serialVersionUID = 1404642351390841699L;

  //todo nav bar and layout
  public MainLayout() {
  }
}
