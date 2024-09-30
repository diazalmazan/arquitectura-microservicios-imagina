package com.imagina.solid.lsp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
//@Component
public class LSPRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("===========================================");
        log.info("Ejecutando LSP Runner");

        List<Pajaro> pajaros = new ArrayList<>();
        pajaros.add(new Aguila());
        pajaros.add(new Pato());
        pajaros.add(new Pajaro());
        //pajaros.add(new Avestruz());
        queVuelenLosPajaros(pajaros);

        log.info("===========================================");
    }

    private static void queVuelenLosPajaros(List<Pajaro> pajaros) {
        pajaros.stream()
                .forEach(pajaro -> pajaro.volar());
    }
}
