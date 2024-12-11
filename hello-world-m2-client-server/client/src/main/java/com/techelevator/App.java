package com.techelevator;

import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HelloService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HelloService helloService = new HelloService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printMessage(helloService.getHello());
    }

}
