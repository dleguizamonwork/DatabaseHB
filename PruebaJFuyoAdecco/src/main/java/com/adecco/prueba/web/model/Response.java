/**
 * 
 */
package com.adecco.prueba.web.model;

/**
 * Clase que modela una respuesta con un mensaje al cliente Rest
 * 
 * @author Juan Carlos Fuyo
 *
 */
public class Response {

	public static final String DATE_ERROR_MSG = "Una fecha de baja no puede ser superior a una fecha de compra";
	public static final String VALIDATION_ERR_MSG = "Error en la solicitud, no cumple con los campos obligatorios requeridos";
	public static final String GENERAL_ERR_MSG = "Error interno, intentelo mas tarde";
	
	private static Response instanceToReturn;
	private String responseMessage;

	/**
	 * Constructor privado para implementar el patron Singleton
	 * 
	 * @param responseMessage
	 */
	private Response(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * Metodo para obtener la unica instancia en memoria
	 * 
	 * @param msg
	 * @return
	 */
	public static Response getIntance(String msg) {
		if (instanceToReturn == null) {
			instanceToReturn = new Response(msg);
		} else {
			instanceToReturn.setResponseMessage(msg);
		}
		return instanceToReturn;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage
	 *            the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
