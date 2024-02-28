package br.com.fullstack.education.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @GetMapping
    public String get(Integer id) {
        return "GET /cursos com id (" + id + ")";
    }

    @GetMapping("{id}")
    public String getId(@PathVariable Integer id) {
        return "GET /cursos/" + id;
    }

    @PostMapping
    public String post() {
        return "POST /cursos IHUL ";
    }

}
