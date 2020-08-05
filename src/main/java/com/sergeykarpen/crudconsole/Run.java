package com.sergeykarpen.crudconsole;


import com.sergeykarpen.crudconsole.view.MainMenu;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        MainMenu runner = new MainMenu();
        runner.showMainMenu();
    }
}
