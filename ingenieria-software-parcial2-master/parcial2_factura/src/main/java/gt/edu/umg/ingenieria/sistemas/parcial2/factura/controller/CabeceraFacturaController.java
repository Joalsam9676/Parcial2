package gt.edu.umg.ingenieria.sistemas.parcial2.factura.controller;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cabeceraFactura")
public class CabeceraFacturaController {

    @Autowired
    private FacturaService facturaService;
    
    @GetMapping("/buscarTodas")
    public List<CabeceraFacturaEntity> buscarTodas() {
        return this.facturaService.buscarTodasCabecerasFactura();
    }
    
    @PostMapping("/crearFactura")
    public CabeceraFacturaEntity crear(@RequestBody(required = true) CabeceraFacturaEntity nuevacabecera) throws Exception
    {
        if(!Nit(nuevacabecera.getNit()))
        throw new Exception("No cumple con lo necesario para guardar");
        
        return this.facturaService.Crearcabecera(nuevacabecera);
        
    }
    
    private Boolean Nit(String Nit){
        if(Nit.matches("[0-9]{1,10}"))
            return true;
        else
            return false;
    }
}
