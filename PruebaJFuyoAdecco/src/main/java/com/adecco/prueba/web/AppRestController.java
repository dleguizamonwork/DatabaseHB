package com.adecco.prueba.web;

import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adecco.prueba.config.DataBaseConfig;

/**
 * Controlador Rest del microservicio
 * 
 * @author Juan Carlos Fuyo
 *
 */
@RestController
public class AppRestController {
	
	//private final Logger logger = LogManager.getRootLogger();
	@Autowired	
	private DataBaseConfig dbConfig; 
		/**
	 * Obtiene todos los activos registrados
	 * 
	 * @return
	 */
	@GetMapping("/activos")
	public ResponseEntity<List<String>> getCustomers() {
		dbConfig.displayDbProperties();
		/*List<Activo> activos = activoService.getAllActivos();
		return new ResponseEntity<List<Activo>>(activos,
				((activos != null && !activos.isEmpty()) ? HttpStatus.OK : HttpStatus.NOT_FOUND));
	*/return null;
	}

	/**
	 * Obtiene un listado de Activos fijos con base en su Tipo
	 * 
	 * @param idTipo
	 * @return
	 */
/*	@GetMapping("/activosbytipo/{idTipo}")
	public ResponseEntity<List<Activo>> getActivosByTipo(@PathVariable("idTipo") int idTipo) {
		List<Activo> activos = activoService.getActivosByTipo(idTipo);
		return new ResponseEntity<List<Activo>>(activos,
				((activos != null && !activos.isEmpty()) ? HttpStatus.OK : HttpStatus.NOT_FOUND));
	}

	/**
	 * Obtiene un listado de Activos fijos con base en su Fecha de compra
	 * 
	 * @param fechaCompra
	 * @return
	 */
/*	@GetMapping("/activosbyfecha/{fechaCompra}")
	public ResponseEntity<List<Activo>> getActivosByFechaCompra(@PathVariable("fechaCompra") String fechaCompra) {
		List<Activo> activos = activoService.getActivosByFechaCompra(fechaCompra);
		return new ResponseEntity<List<Activo>>(activos,
				((activos != null && !activos.isEmpty()) ? HttpStatus.OK : HttpStatus.NOT_FOUND));
	}

	/**
	 * Obtiene un Activo fijo con base en su Serial
	 * 
	 * @param serial
	 * @return
	 */
/*	@GetMapping("/activobyserial/{serial}")
	public ResponseEntity<Activo> getActivosBySerial(@PathVariable("serial") String serial) {
		Activo activo = activoService.getActivosBySerial(serial);
		return new ResponseEntity<Activo>(activo,
				((activo != null && activo.getIdActivo() != 0) ? HttpStatus.OK : HttpStatus.NOT_FOUND));
	}

	/**
	 * Crea un Activo en sistema validando las condiciones del mismo
	 * 
	 * @param activo
	 * @return
	 */
/*	@PostMapping("/createactivo")
	public ResponseEntity<Response> createactivo(@Valid @RequestBody Activo activo) {
		activoService.createActivo(activo);
		String msg = "Activo fijo creado exitosamente con Id: " + activo.getIdActivo();
		logger.info(msg);
		return new ResponseEntity<Response>(Response.getIntance(msg), HttpStatus.CREATED);
	}

	/**
	 * Actualiza un Activo en sistema validando las condiciones del mismo
	 * 
	 * @param activo
	 * @return
	 */
/*	@PutMapping("/updateactivo")
	public ResponseEntity<Response> updateactivo(@Valid @RequestBody Activo activo) {
		activoService.modifyActivo(activo);
		String msg = "Activo fijo modificado exitosamente";
		logger.info(msg);
		return new ResponseEntity<Response>(Response.getIntance(msg), HttpStatus.CREATED);
	}

	/* ------------------ EXCEPTION HANDLERS ------------------ */

	/**
	 * Maneja las excepciones por validaciones de negocio y parseo de objetos
	 * 
	 * @param e
	 * @return
	 */
/*	@ExceptionHandler({ HttpMessageNotReadableException.class, DateTimeParseException.class,
			ValidateActivoException.class })
	public ResponseEntity<Response> validNumPodductsHandler(Exception e) {
		logError(e);
		return new ResponseEntity<Response>(Response.getIntance(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Maneja las excepciones por validaciones de objetos
	 * 
	 * @param e
	 * @return
	 */
/*	@ExceptionHandler({ BindException.class, MethodArgumentNotValidException.class,
			DataIntegrityViolationException.class, NullPointerException.class, NoSuchElementException.class })
	public ResponseEntity<Response> validationErrorHandler(Exception e) {
		logError(e);
		return new ResponseEntity<Response>(Response.getIntance(Response.VALIDATION_ERR_MSG), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Maneja las excepciones generales de la Api
	 * 
	 * @param e
	 * @return
	 */
/*	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> generalExceptionHandler(Exception e) {
		logError(e);
		return new ResponseEntity<Response>(Response.getIntance(Response.GENERAL_ERR_MSG),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private void logError(Exception e) {
		logger.error("Error en la solicitud: " + e.getMessage());
		logger.catching(e);		
	}*/
}
