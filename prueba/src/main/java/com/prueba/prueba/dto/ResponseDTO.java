/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credifamilia.auditoria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author jamunoz
 */
@Data
@ApiModel(description = "DTO que representa una respuesta")
@Builder
public class ResponseDTO {

    @ApiModelProperty(value = "Estado de la respuesta", example = "200")
    private Integer status;
    @ApiModelProperty(value = "descripcion de la respuesta", example = "Consulta exitosa")
    private String message;
    @ApiModelProperty(value = "Cuerpo de la respuesta", example = "{ \"resultado\": \"éxito\" }")
	private Object data;
}
