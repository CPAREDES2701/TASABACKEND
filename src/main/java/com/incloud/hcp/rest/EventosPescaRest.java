package com.incloud.hcp.rest;

import com.incloud.hcp.jco.maestro.dto.EventosPescaDto;
import com.incloud.hcp.jco.maestro.dto.EventosPescaImports;
import com.incloud.hcp.jco.maestro.service.JCOEventosPescaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/eventospesca")
public class EventosPescaRest {

    @Autowired
    private JCOEventosPescaService jcoEventosPescaService;

    @PostMapping(value = "/Listar/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EventosPescaDto> ListarEventosPesca(@RequestBody EventosPescaImports imports){

        try {
            return Optional.ofNullable(this.jcoEventosPescaService.ListarEventosPesca(imports))
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            //String error = Utils.obtieneMensajeErrorException(e);
            throw new RuntimeException(e.toString());
        }

    }
}
