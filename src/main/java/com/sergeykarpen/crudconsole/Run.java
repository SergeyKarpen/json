package com.sergeykarpen.crudconsole;

import com.sergeykarpen.crudconsole.view.View;


import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        View runner = new View();
        runner.showMenu();
    }
}
