package com.tunombre.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunombre.modelos.Canciones;
import com.tunombre.servicios.ServicioArtistas;
import com.tunombre.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {


	
	@Autowired
private ServicioCanciones servicioCanciones;

@Autowired
private ServicioArtistas servicioArtistas;

@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		servicioCanciones.obtenerTodasLasCanciones();
		modelo.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
		System.out.println("hola mundo");
		return "Canciones";
	}
	

	@GetMapping("/canciones/detalle/{id}")
	public String desplegarDetallesCancion(@PathVariable("id") Long id, Model modelo) {
		modelo.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(id));
		return "detalleCancion";
	}

	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute Canciones cancion, Model modelo) {
		modelo.addAttribute("cancion", new Canciones());
		modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
		return "agregarCancion";
		
	}
	@PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute Canciones cancion, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "agregarCancion";
        }
        servicioCanciones.agregarCanciones(cancion);
        return "redirect:/canciones";
}
	@GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Canciones cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion != null) {
            model.addAttribute("cancion", cancion);
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion";
        }
        return "redirect:/canciones";
    }


    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion,
                                        @Valid @ModelAttribute("cancion") Canciones cancion,
                                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editarCancion";
        }
        cancion.setId(idCancion);
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }
    
    @DeleteMapping("/canciones/eliminar/{idCancion}")
    
   public String ProcesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
    	this.servicioCanciones.eliminarCancion(idCancion);
    	
    	return "redirect:/canciones";
    }
}




	
